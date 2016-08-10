package io.github.fdayamani.hearts;

import java.util.Comparator;

public class Card {

    private static final int DESCENDING_ORDER = -1;
    private final Rank rank;
    private final String suit;

    static Comparator<Card> byRank = (c1, c2) -> DESCENDING_ORDER * Integer.compare(
            c1.rank.getRelativeRank(),
            c2.rank.getRelativeRank()
    );

    public Card(String card) {
        this.rank = Rank.getRank(card.substring(0, card.length() - 1));
        this.suit = card.substring(card.length() - 1);
    }

    @Override
    public String toString() {
        return rank.getActualRank() + suit;
    }

}
