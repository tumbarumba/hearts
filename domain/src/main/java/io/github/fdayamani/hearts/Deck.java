package io.github.fdayamani.hearts;

import java.util.Arrays;
import java.util.Stack;

public class Deck {
    private Stack<Card> deck = new Stack<>();

    public Deck() {
        create();
    }

    private void create() {
        Arrays.stream(Suit.values()).forEach(suit ->
                    Arrays.stream(Rank.values())
                            .forEach(rank -> deck.push(new Card(rank, suit)))
        );
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
