package io.github.fdayamani.hearts.web;

import com.gargoylesoftware.htmlunit.StringWebResponse;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HTMLParser;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;
import spark.template.mustache.MustacheTemplateEngine;

import java.net.URL;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class HomePageShould {
    private final TemplateEngine templateEngine = new MustacheTemplateEngine();

    private final HomePage handler = new HomePage();
    private final Request request = mock(Request.class);
    private final Response response = mock(Response.class);

    @Test
    public void haveTitleAndHeading() throws Exception {
        URL gameUrl = new URL("http://www.example.com/");

        String html = templateEngine.render(handler.handle(request, response));
        StringWebResponse webResponse = new StringWebResponse(html, gameUrl);
        WebClient client = new WebClient();
        client.getOptions().setJavaScriptEnabled(false);
        client.getOptions().setCssEnabled(false);
        client.getOptions().setAppletEnabled(false);

        HtmlPage page = HTMLParser.parseHtml(webResponse, client.getCurrentWindow());

        assertThat(page.getTitleText(), equalTo("Hearts"));
        Optional<String> maybeH1 = page.getElementsByTagName("h1").stream().findFirst().map(DomElement::asText);
        assertThat(maybeH1, equalTo(Optional.of("Hearts")));
    }


}
