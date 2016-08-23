package io.github.fdayamani.hearts;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameTest {
    private Game game = new Game();
    private Player player1 = new Player();
    private Player player2 = new Player();
    private Player player3 = new Player();
    private Player player4 = new Player();

    @Test public void
    fourPlayersAreAddedToAGame() {
        game.add(player1);
        game.add(player2);
        game.add(player3);
        game.add(player4);

        assertThat(game.hasPlayer(player1)).isTrue();
        assertThat(game.hasPlayer(player2)).isTrue();
        assertThat(game.hasPlayer(player3)).isTrue();
        assertThat(game.hasPlayer(player4)).isTrue();
    }

    @Test public void
    aPlayerReceives13Cards_In4PlayerGame() {
        Player player = mock(Player.class);
        game.add(player);
        game.add(player1);
        game.add(player2);
        game.add(player3);

        game.dealCards();

        verify(player, times(13)).acceptCard(any(Card.class));
    }
}
