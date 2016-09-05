package io.github.fdayamani.hearts;

public class HumanPlayer implements Player {
    private Hand hand;

    public HumanPlayer() {
        this.hand = new Hand();
    }

    public HumanPlayer(Hand hand) {
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
