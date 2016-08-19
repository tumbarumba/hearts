package io.github.fdayamani.hearts.specifications;

import com.gargoylesoftware.htmlunit.StringWebResponse;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HTMLParser;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.collect.ImmutableMap;
import io.github.fdayamani.hearts.Card;
import io.github.fdayamani.hearts.Hand;
import io.github.fdayamani.hearts.Rank;
import io.github.fdayamani.hearts.Suit;
import io.github.fdayamani.hearts.testing.CardConverter;
import io.github.fdayamani.hearts.web.GamePage;
import org.apache.commons.collections.map.UnmodifiableMap;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;
import spark.template.mustache.MustacheTemplateEngine;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static io.github.fdayamani.hearts.specifications.LightweightTestEmbedder.aLightweightTestRunnerWithStepsFrom;
import static io.github.fdayamani.hearts.testing.CardConverter.buildCardFrom;
import static io.github.fdayamani.hearts.testing.CardConverter.buildCardsFrom;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HtmlDisplayStory {
    private final TemplateEngine templateEngine = new MustacheTemplateEngine();

    private final GamePage handler = new GamePage();
    private final Request request = mock(Request.class);
    private final Response response = mock(Response.class);
    private final Map<String, String> webToDisplay = new HashMap();

    private WebClient client = new WebClient();
    private Hand hand;
    private HtmlPage page;

    @Test
    public void verifyHtmlDisplayStory() throws Exception {
        aLightweightTestRunnerWithStepsFrom(this)
                .withStory("stories/HtmlDisplay.story")
                .run();
    }

    @Given("that the player's hand contains $cards")
    public void givenHandContains(String cards) {
        populateWebToDisplay();
    }

    @When("the playing area is displayed on the web page")
    public void cardsAreDisplayed() throws Exception {
        URL gameUrl = new URL("http://www.example.com/");

        when(request.params(":gameId")).thenReturn("1");
        String html = templateEngine.render(handler.handle(request, response));
        StringWebResponse webResponse = new StringWebResponse(html, gameUrl);

        page = HTMLParser.parseHtml(webResponse, client.getCurrentWindow());
        hand = playerHandFrom(page);
    }

    @Then("the hand is shown in the order $orderedCards")
    public void assertCardsAreOrderedCorrectly(String orderedCards) {
        assertThat(hand.orderCards()).isEqualTo(buildCardsFrom(orderedCards));
    }

    private void populateWebToDisplay() {
        webToDisplay.put("C", "♣");
        webToDisplay.put("D", "♦");
        webToDisplay.put("S", "♠");
        webToDisplay.put("H", "♥");
    }

    private Hand playerHandFrom(HtmlPage page) {
        DomElement player4 = page.getElementById("player-4");
        List<Card> cards = streamOfChildElements(player4)
                .filter(e -> classContains(e, "hand"))
                .flatMap(e -> streamOfChildElements(e))
                .filter(e -> classContains(e, "card"))
                .map(e -> cardFrom(e))
                .collect(Collectors.toList());
        return new Hand(cards);
    }

    private Card cardFrom(DomElement e) {
        String rank = e.getFirstChild().asText();
        String suit = e.getAttribute("class").split(" ")[2];
        return buildCardFrom(rank + webToDisplay.get(suit));
    }

    private boolean classContains(DomElement e, String card) {
        return e.getAttribute("class").contains(card);
    }

    private Stream<DomElement> streamOfChildElements(DomElement player4) {
        return StreamSupport.stream(player4.getChildElements().spliterator(), false);
    }
}
