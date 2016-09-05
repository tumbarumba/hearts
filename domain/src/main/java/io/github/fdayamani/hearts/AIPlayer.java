package io.github.fdayamani.hearts;

public class AIPlayer implements Player {
    private Hand hand;

    public AIPlayer() {
        this.hand = new Hand();
    }

    public AIPlayer(Hand hand) {
        this.hand = hand;
    }

    @Override
    public void acceptCard(Card card) {
        hand.add(card);
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public boolean handContains(Card card) {
        return hand.contains(card);
    }

    @Override
    public void play(Card card) {
        hand.remove(card);
    }
}
