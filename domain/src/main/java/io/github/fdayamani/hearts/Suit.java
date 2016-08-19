package io.github.fdayamani.hearts;

public enum Suit {
    CLUBS(   "♣", 1),
    DIAMONDS("♦", 2),
    SPADES(  "♠", 3),
    HEARTS(  "♥", 4);

    private final String display;
    private final int displayOrder;

    Suit(String display, int displayOrder) {
        this.display = display;
        this.displayOrder = displayOrder;
    }

    public static Suit lookupSuit(String displaySuit) {
        for (Suit suit : values()) {
            if (suit.display.equals(displaySuit)) {
                return suit;
            }
        }
        throw new IllegalArgumentException("Could not resolve Suit from " + displaySuit);
    }

    public String getDisplay() {
        return display;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }
}
