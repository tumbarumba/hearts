package io.github.fdayamani.hearts;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards = new ArrayList<>();

    public Hand(String cards) {
        for (String card : cards.split(", ")) {
            this.cards.add(new Card(card));
        }
    }

    public String orderCards() {
        StringBuffer buffer = new StringBuffer();
        cards.stream()
                .sorted(Card.bySuit.thenComparing(Card.byRank))
                .forEach(c -> buffer.append(c.toString() + ", "));
        return buffer.delete(buffer.length() - 2, buffer.length()).toString();
    }
}
