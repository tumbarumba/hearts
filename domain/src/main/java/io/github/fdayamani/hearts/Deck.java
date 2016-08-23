package io.github.fdayamani.hearts;

public class Deck {
    private int remainingCards = 52;

    public boolean hasNextCard() {
        return remainingCards != 0;
    }

    public Card nextCard() {
        remainingCards--;
        return null;
    }
}
