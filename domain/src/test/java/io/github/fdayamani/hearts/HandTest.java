package io.github.fdayamani.hearts;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HandTest {
    @Test public void
    anOrderedHandOfAllHeartsIsReturnedAsIs() {
        Hand handOfAllHearts = new Hand("2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♥");

        String orderedHand = handOfAllHearts.orderCards();

        assertThat(orderedHand).isEqualTo("2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♥");
    }

    @Test public void
    anUnorderedHandOfAllHeartsIsOrderedByRank() {
        Hand handOfAllHearts = new Hand("A♥, 7♥, Q♥, 5♥, 6♥, 3♥, 10♥, 9♥, 8♥, J♥, 4♥, K♥, 2♥");

        String orderedHand = handOfAllHearts.orderCards();

        assertThat(orderedHand).isEqualTo("2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♥");
    }


    @Test public void
    aHandOfAllTwosIsOrderedBySuit() {
        Hand handOfAllTwos = new Hand("2♥, 2♠, 2♣, 2♦");

        String orderedHand = handOfAllTwos.orderCards();

        assertThat(orderedHand).isEqualTo("2♣, 2♦, 2♠, 2♥");
    }
}