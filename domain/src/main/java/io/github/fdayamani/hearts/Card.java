package io.github.fdayamani.hearts;

import java.util.Comparator;

public class Card {

    private final Rank rank;
    private final Suit suit;

    static Comparator<Card> byRank = (c1, c2) -> Integer.compare(
            c1.rank.getSortOrder(),
            c2.rank.getSortOrder()
    );

    static Comparator<Card> bySuit = (c1, c2) -> Integer.compare(
            c1.suit.getDisplayOrder(),
            c2.suit.getDisplayOrder()
    );

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank rank() {
        return rank;
    }

    public Suit suit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank.getDisplay() + suit.getDisplay();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (rank != card.rank) return false;
        return suit == card.suit;

    }

    @Override
    public int hashCode() {
        int result = rank != null ? rank.hashCode() : 0;
        result = 31 * result + (suit != null ? suit.hashCode() : 0);
        return result;
    }
}
