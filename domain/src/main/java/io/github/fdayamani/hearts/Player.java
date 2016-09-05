package io.github.fdayamani.hearts;

public interface Player {
    void acceptCard(Card card);

    Hand getHand();

    boolean handContains(Card card);

    void play(Card card);
}
