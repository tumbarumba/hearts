package io.github.fdayamani.hearts;

public class Player {
    private Hand hand = new Hand();

    public void acceptCard(Card card) {
        hand.add(card);
    }

    public Hand getHand() {
        return hand;
    }
}
