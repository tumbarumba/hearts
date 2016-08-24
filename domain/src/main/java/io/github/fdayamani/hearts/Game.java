package io.github.fdayamani.hearts;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();

    public void add(Player player) {
        players.add(player);
    }

    public void dealCards() {
        Deck deck = new Deck();
        while(deck.hasNextCard()) {
            players.get(0).acceptCard(deck.nextCard());
            players.get(1).acceptCard(deck.nextCard());
            players.get(2).acceptCard(deck.nextCard());
            players.get(3).acceptCard(deck.nextCard());
        }
    }

    public boolean hasPlayer(Player player) {
        return players.contains(player);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
