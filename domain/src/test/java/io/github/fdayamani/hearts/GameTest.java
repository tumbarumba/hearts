package io.github.fdayamani.hearts;

import org.junit.Test;

import static io.github.fdayamani.hearts.Rank.*;
import static io.github.fdayamani.hearts.Suit.CLUBS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameTest {

    private Player player1 = new Player();
    private Player player2 = new Player();
    private Player player3 = new Player();
    private Player player4 = new Player();

    @Test public void
    fourPlayersAreAddedToAGame() {
        Game game = defaultNewGame();

        assertThat(game.hasPlayer(player1)).isTrue();
        assertThat(game.hasPlayer(player2)).isTrue();
        assertThat(game.hasPlayer(player3)).isTrue();
        assertThat(game.hasPlayer(player4)).isTrue();
    }

    @Test public void
    aPlayerReceives13Cards_In4PlayerGame() {
        Game game = new Game();

        Player player = mock(Player.class);
        game.add(player);
        game.add(player1);
        game.add(player2);
        game.add(player3);

        game.dealCards();

        verify(player, times(13)).acceptCard(any(Card.class));
    }

    @Test public void
    thePlayerWithThe2OfClubsIsTheNextPlayerWhenTheGameStarts() {
        Game game = defaultNewGame();

        game.dealCards();

        Player nextPlayer = game.nextPlayer();
        assertThat(nextPlayer.handContains(new Card(TWO, CLUBS))).isTrue();
    }

    @Test public void
    ifNoPlayerHasThe2OfClubs_TheNextPlayerIsTheOneWhoWonThePreviousTrick() {
        Game game = defaultNewGame();

        game.dealCards();

        player4.play(new Card(TWO, CLUBS));
        player3.play(new Card(THREE, CLUBS));
        player2.play(new Card(FOUR, CLUBS));
        player1.play(new Card(FIVE, CLUBS));

        assertThat(game.nextPlayer()).isEqualTo(player3);

    }

    private Game defaultNewGame() {
        Game game = new Game();

        game.add(player1);
        game.add(player2);
        game.add(player3);
        game.add(player4);

        return game;
    }
}
