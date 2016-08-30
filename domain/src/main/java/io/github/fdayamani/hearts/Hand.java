package io.github.fdayamani.hearts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hand {

    private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> orderCards() {
        return cards.stream()
                .sorted(Card.bySuit.thenComparing(Card.byRank))
                .collect(Collectors.toList());
    }

    public void add(Card card) {
        cards.add(card);
    }

    public boolean contains(Card card) {
        return cards.contains(card);
    }

    public void remove(Card card) {
        if(!this.contains(card)) {
            throw new IllegalArgumentException("This hand does not contain " + card.toString());
        }
        cards.remove(card);
    }
}
