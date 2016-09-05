package io.github.fdayamani.hearts.web;

import io.github.fdayamani.hearts.AIPlayer;
import io.github.fdayamani.hearts.Game;
import io.github.fdayamani.hearts.HumanPlayer;
import spark.Spark;
import spark.TemplateEngine;
import spark.template.mustache.MustacheTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.post;

public class HeartsWeb {
    public static void main(String[] args) {
        new HeartsWeb().launch();

    }

    private void launch() {
        TemplateEngine templateEngine = new MustacheTemplateEngine();

        Game game = setup();

        Spark.staticFileLocation("/assets");
        get("/", new HomePage(), templateEngine);
        post("/games", (req, res) -> {res.redirect("/games/1"); return "";});
        get("/games/:gameId", new GamePage(game), templateEngine);
    }

    private Game setup() {
        Game game = new Game();
        game.add(new HumanPlayer());
        game.add(new AIPlayer());
        game.add(new AIPlayer());
        game.add(new AIPlayer());
        game.dealCards();
        return game;
    }
}
