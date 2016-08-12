package io.github.fdayamani.hearts;

import java.util.List;
import java.util.stream.Collectors;

public class Hand {

    private final List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> orderCards() {
        return cards.stream()
                .sorted(Card.bySuit.thenComparing(Card.byRank))
                .collect(Collectors.toList());
    }
}
