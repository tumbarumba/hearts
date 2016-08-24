package io.github.fdayamani.hearts;

import java.util.Stack;

public class Deck {
    private Stack<Card> deck = new Stack<>();

    public Deck() {
        create();
    }

    private void create() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck.push(new Card(Rank.values()[j], Suit.values()[i]));
            }
        }
    }

    public boolean hasNextCard() {
        return !deck.empty();
    }

    public Card nextCard() {
        return deck.pop();
    }

    public int size() {
        return deck.size();
    }
}
