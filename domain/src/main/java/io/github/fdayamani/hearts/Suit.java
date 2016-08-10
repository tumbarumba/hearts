package io.github.fdayamani.hearts;

public enum Suit {
    HEARTS("♥", 4),
    SPADES("♠", 3),
    DIAMONDS("♦", 2),
    CLUBS("♣", 1);

    private final String actualSuit;

    private final int relativeSuit;
    Suit(String actualSuit, int relativeSuit) {
        this.actualSuit = actualSuit;
        this.relativeSuit = relativeSuit;
    }

    public static Suit getSuit(String actualSuit) {
        for (Suit suit : values()) {
            if (suit.actualSuit.equals(actualSuit)) {
                return suit;
            }
        }
        return null;
    }

    public String getActualSuit() {
        return actualSuit;
    }

    public int getRelativeSuit() {
        return relativeSuit;
    }
}
