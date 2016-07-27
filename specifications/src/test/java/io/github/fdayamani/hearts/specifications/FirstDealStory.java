package io.github.fdayamani.hearts.specifications;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.junit.Test;

import static io.github.fdayamani.hearts.specifications.LightweightTestEmbedder.aLightweightTestRunnerWithStepsFrom;

public class FirstDealStory {
    @Test
    public void verifyFirstDealStory() throws Exception {
        aLightweightTestRunnerWithStepsFrom(this)
                .withStory("stories/FirstDeal.story")
                .run();
    }

    @Given("that the player has a hand containing $cards")
    public void givenHandContains(String cards) {
        System.out.println("Cards: " + cards);
    }

    @When("the cards are displayed")
    public void cardsAreDisplayed() {

    }

    @Then("the cards are shown in the order $orderedCards")
    public void assertCardsAreOrderedCorrectly(String orderedCards) {
        Assert.fail("You've not even done anything yet");
    }
}
