package io.github.fdayamani.hearts.specifications;

import com.gargoylesoftware.htmlunit.StringWebResponse;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HTMLParser;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.collect.ImmutableMap;
import io.github.fdayamani.hearts.*;
import io.github.fdayamani.hearts.web.GamePage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;
import spark.template.mustache.MustacheTemplateEngine;

import java.net.URL;
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

    private final Map<String, String> webToDisplay = ImmutableMap.of(
            "C", "♣",
            "D", "♦",
            "S", "♠",
            "H", "♥");

    private List<Card> givenCards;
    private List<Card> actualCards;

    @Test
    public void verifyHtmlDisplayStory() throws Exception {
        aLightweightTestRunnerWithStepsFrom(this)
                .withStory("stories/HtmlDisplay.story")
                .run();
    }

    @Given("that the player's hand contains $cards")
    public void givenHandContains(String cards) {
        givenCards = buildCardsFrom(cards);
    }

    @When("the playing area is displayed on the web page")
    public void cardsAreDisplayed() throws Exception {
        Game game = new Game();
        game.add(new AIPlayer());
        game.add(new AIPlayer());
        game.add(new AIPlayer());
        game.add(new HumanPlayer(new Hand(givenCards)));

        GamePage handler = new GamePage(game);
        Request request = mock(Request.class);
        Response response = mock(Response.class);
        URL gameUrl = new URL("http://www.example.com/");
        when(request.params(":gameId")).thenReturn("1");

        String html = templateEngine.render(handler.handle(request, response));

        StringWebResponse webResponse = new StringWebResponse(html, gameUrl);
        try(WebClient client = new WebClient()) {
            client.getOptions().setJavaScriptEnabled(false);
            client.getOptions().setCssEnabled(false);
            HtmlPage page = HTMLParser.parseHtml(webResponse, client.getCurrentWindow());
            actualCards = extractPlayerHandFrom(page);
        }
    }

    @Then("the hand is shown in the order $expectedCards")
    public void assertCardsAreOrderedCorrectly(String expectedCards) {
        assertThat(actualCards).isEqualTo(buildCardsFrom(expectedCards));
    }

    private List<Card> extractPlayerHandFrom(HtmlPage page) {
        DomElement player4 = page.getElementById("player-4");
        return streamOfChildElements(player4)
                .filter(e -> classContains(e, "hand"))
                .flatMap(e -> streamOfChildElements(e))
                .filter(e -> classContains(e, "card"))
                .map(e -> cardFrom(e))
                .collect(Collectors.toList());
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
