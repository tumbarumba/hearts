package io.github.fdayamani.hearts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static io.github.fdayamani.hearts.Rank.TWO;
import static io.github.fdayamani.hearts.Suit.CLUBS;

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
        Optional<Player> playerWithTwoOfClubs = players.stream()
                .filter(player -> player.handContains(new Card(TWO, CLUBS)))
                .findFirst();
        return playerWithTwoOfClubs.orElse(players.get(2));
    }
}
