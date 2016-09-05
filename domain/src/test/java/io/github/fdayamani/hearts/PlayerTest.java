package io.github.fdayamani.hearts;

import org.junit.Test;

import static io.github.fdayamani.hearts.Rank.*;
import static io.github.fdayamani.hearts.Suit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test public void
    playingACard_RemovesItFromTheHand() {} {
        Player player = new HumanPlayer(defaultHand());

        Card card = new Card(TWO, CLUBS);
        player.play(card);

        assertThat(player.handContains(card)).isFalse();
    }

    @Test public void
    nonHumanPlayersPlayLowestRankOfLeadingSuitThatTheyHave() {

    }

    private Hand defaultHand() {
        Hand hand = new Hand();
        hand.add(new Card(TWO, CLUBS));
        hand.add(new Card(SIX, CLUBS));
        hand.add(new Card(TEN, CLUBS));
        hand.add(new Card(ACE, CLUBS));
        hand.add(new Card(FIVE, DIAMONDS));
        hand.add(new Card(NINE, DIAMONDS));
        hand.add(new Card(KING, DIAMONDS));
        hand.add(new Card(FOUR, SPADES));
        hand.add(new Card(EIGHT, SPADES));
        hand.add(new Card(QUEEN, SPADES));
        hand.add(new Card(THREE, HEARTS));
        hand.add(new Card(SEVEN, HEARTS));
        hand.add(new Card(JACK, HEARTS));
        return hand;
    }

}