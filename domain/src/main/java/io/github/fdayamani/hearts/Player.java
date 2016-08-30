package io.github.fdayamani.hearts;

public class Player {
    private Hand hand;

    public Player() {
        this.hand = new Hand();
    }

    public Player(Hand hand) {
        this.hand = hand;
    }

    public void acceptCard(Card card) {
        hand.add(card);
    }

    public Hand getHand() {
        return hand;
    }

    public boolean handContains(Card card) {
        return hand.contains(card);
    }

    public void play(Card card) {
        hand.remove(card);
    }
}
