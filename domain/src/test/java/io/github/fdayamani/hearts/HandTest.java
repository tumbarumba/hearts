package io.github.fdayamani.hearts;

import org.junit.Test;

import java.util.List;

import static io.github.fdayamani.hearts.testing.CardConverter.buildCardsFrom;
import static org.assertj.core.api.Assertions.assertThat;

public class HandTest {

    @Test public void
    anUnorderedHandOfAllHeartsIsOrderedByRank() {
        Hand handOfAllHearts = new Hand(buildCardsFrom("A♥, 7♥, Q♥, 5♥, 6♥, 3♥, 10♥, 9♥, 8♥, J♥, 4♥, K♥, 2♥"));

        List<Card> orderedHand = handOfAllHearts.orderCards();

        assertThat(orderedHand).isEqualTo(buildCardsFrom("2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♥"));
    }


    @Test public void
    aHandOfAllTwosIsOrderedBySuit() {
        Hand handOfAllTwos = new Hand(buildCardsFrom("2♥, 2♠, 2♣, 2♦"));

        List<Card> orderedHand = handOfAllTwos.orderCards();

        assertThat(orderedHand).isEqualTo(buildCardsFrom("2♣, 2♦, 2♠, 2♥"));
    }

    @Test public void
    anUnorderedHandIsOrdered() {
        Hand unorderedHand = new Hand(buildCardsFrom("Q♥, 5♣, 10♣, 4♦, 9♥, Q♣, 10♦, 10♠, J♥, Q♠, K♥, 9♦, 3♥"));

        List<Card> orderedHand = unorderedHand.orderCards();

        assertThat(orderedHand).isEqualTo(buildCardsFrom("5♣, 10♣, Q♣, 4♦, 9♦, 10♦, 10♠, Q♠, 3♥, 9♥, J♥, Q♥, K♥"));
    }
}