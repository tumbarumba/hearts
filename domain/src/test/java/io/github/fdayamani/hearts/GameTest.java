package io.github.fdayamani.hearts;

import org.junit.Test;

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
    thePlayerWithThe2OfClubsIsTheNextPlayer() {
        Game game = defaultNewGame();

        game.dealCards();

        assertThat(game.nextPlayer()).isSameAs(player4);
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
