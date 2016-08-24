package io.github.fdayamani.hearts;

import java.util.Stack;

import static java.util.Arrays.stream;

public class Deck {
    private Stack<Card> deck = new Stack<>();

    public Deck() {
        create();
    }

    private void create() {
        stream(Suit.values()).forEach(suit ->
                    stream(Rank.values()).forEach(rank ->
                            deck.push(new Card(rank, suit)))
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
