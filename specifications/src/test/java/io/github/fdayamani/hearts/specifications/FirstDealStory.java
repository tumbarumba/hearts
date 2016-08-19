package io.github.fdayamani.hearts.specifications;

import io.github.fdayamani.hearts.Card;
import io.github.fdayamani.hearts.Hand;
import io.github.fdayamani.hearts.testing.CardConverter;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import java.util.List;

import static io.github.fdayamani.hearts.specifications.LightweightTestEmbedder.aLightweightTestRunnerWithStepsFrom;
import static io.github.fdayamani.hearts.testing.CardConverter.buildCardsFrom;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstDealStory {
    Hand hand;

    @Test
    public void verifyFirstDealStory() throws Exception {
        aLightweightTestRunnerWithStepsFrom(this)
                .withStory("stories/FirstDeal.story")
                .run();
    }

    @Given("that the player has a hand containing $cards")
    public void givenHandContains(String cards) {
        hand = new Hand(buildCardsFrom(cards));
    }

    @When("the cards are displayed")
    public void cardsAreDisplayed() {

    }

    @Then("the cards are shown in the order $orderedCards")
    public void assertCardsAreOrderedCorrectly(String orderedCards) {
        List<Card> orderedHand = hand.orderCards();
        List<Card> expectedOrder = buildCardsFrom(orderedCards);
        assertThat(orderedHand).isEqualTo(expectedOrder);
    }
}
