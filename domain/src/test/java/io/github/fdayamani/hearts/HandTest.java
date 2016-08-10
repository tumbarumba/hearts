package io.github.fdayamani.hearts;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HandTest {
    @Test public void
    anOrderedHandOfAllHeartsIsReturnedAsIs() {
        Hand handOfAllHearts = new Hand("A♥, K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥");

        String orderedHand = handOfAllHearts.orderCards();

        assertThat(orderedHand).isEqualTo("A♥, K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥");
    }

    @Test public void
    anUnorderedHandOfAllHeartsIsOrderedByRank() {
        Hand handOfAllHearts = new Hand("A♥, 7♥, Q♥, 5♥, 6♥, 3♥, 10♥, 9♥, 8♥, J♥, 4♥, K♥, 2♥");

        String orderedHand = handOfAllHearts.orderCards();

        assertThat(orderedHand).isEqualTo("A♥, K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥");
    }
}