package io.github.fdayamani.hearts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();

    public void add(Player player) {
        players.add(player);
    }

    public void dealCards() {
        Deck deck = new Deck();
        while(deck.hasNextCard()) {
            players.forEach(player -> player.acceptCard(deck.nextCard()));
        }
    }

    public boolean hasPlayer(Player player) {
        return players.contains(player);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public Player nextPlayer() {
        return players.get(3);
    }
}
