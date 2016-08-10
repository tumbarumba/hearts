package io.github.fdayamani.hearts;

import java.util.Comparator;

public class Card {

    private final Rank rank;
    private final Suit suit;

    static Comparator<Card> byRank = (c1, c2) -> Integer.compare(
            c1.rank.getRelativeRank(),
            c2.rank.getRelativeRank()
    );

    static Comparator<Card> bySuit = (c1, c2) -> Integer.compare(
            c1.suit.getRelativeSuit(),
            c2.suit.getRelativeSuit()
    );

    public Card(String card) {
        this.rank = Rank.getRank(card.substring(0, card.length() - 1));
        this.suit = Suit.getSuit(card.substring(card.length() - 1));
    }

    @Override
    public String toString() {
        return rank.getActualRank() + suit.getActualSuit();
    }

}
