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

    private final String actualRank;
    private final int relativeRank;

    Rank(String actualRank, int relativeRank) {
        this.actualRank = actualRank;
        this.relativeRank = relativeRank;
    }

    public static Rank getRank(String actualRank) {
        for (Rank rank : values()) {
            if (rank.actualRank.equals(actualRank)) {
                return rank;
            }
        }
        return null;
    }

    public String getActualRank() {
        return actualRank;
    }

    public int getRelativeRank() {
        return relativeRank;
    }
}
