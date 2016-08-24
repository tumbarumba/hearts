package io.github.fdayamani.hearts;

import org.junit.Test;

import static io.github.fdayamani.hearts.Rank.ACE;
import static io.github.fdayamani.hearts.Rank.KING;
import static io.github.fdayamani.hearts.Suit.HEARTS;
import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {
    @Test public void
    deckContains52CardsWhenCreated() {
        Deck deck = new Deck();

        assertThat(deck.size()).isEqualTo(52);
    }

    @Test public void
    afterRemovingOneCard_DeckContains51Cards() {
        Deck deck = new Deck();

        deck.nextCard();

        assertThat(deck.size()).isEqualTo(51);
    }

    @Test public void
    theTopTwoCardsOfTheDeckAreTheAceAndKingOfHearts() {
        Deck deck = new Deck();

        Card topCard = deck.nextCard();
        Card nextTopCard = deck.nextCard();

        assertThat(topCard).isEqualTo(new Card(ACE, HEARTS));
        assertThat(nextTopCard).isEqualTo(new Card(KING, HEARTS));
    }

}