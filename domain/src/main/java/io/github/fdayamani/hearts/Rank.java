package io.github.fdayamani.hearts;

public enum Rank {
    TWO("2", 1),
    THREE("3", 2),
    FOUR("4", 3),
    FIVE("5", 4),
    SIX("6", 5),
    SEVEN("7", 6),
    EIGHT("8", 7),
    NINE("9", 8),
    TEN("10", 9),
    JACK("J", 10),
    QUEEN("Q", 11),
    KING("K", 12),
    ACE("A", 13);

    private final String display;
    private final int sortOrder;

    Rank(String display, int sortOrder) {
        this.display = display;
        this.sortOrder = sortOrder;
    }

    public static Rank lookupRank(String actualRank) {
        for (Rank rank : values()) {
            if (rank.display.equals(actualRank)) {
                return rank;
            }
        }
        throw new IllegalArgumentException("Could not resolve Rank from " + actualRank);
    }

    public String getDisplay() {
        return display;
    }

    public int getSortOrder() {
        return sortOrder;
    }
}
