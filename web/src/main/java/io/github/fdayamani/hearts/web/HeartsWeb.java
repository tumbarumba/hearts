package io.github.fdayamani.hearts.web;

import io.github.fdayamani.hearts.Game;
import io.github.fdayamani.hearts.Player;
import spark.Spark;
import spark.TemplateEngine;
import spark.template.mustache.MustacheTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.post;

public class HeartsWeb {
    public static void main(String[] args) {
        TemplateEngine templateEngine = new MustacheTemplateEngine();

        Game game = setup();

        Spark.staticFileLocation("/assets");
        get("/", new HomePage(), templateEngine);
        post("/games", (req, res) -> {res.redirect("/games/1"); return "";});
        get("/games/:gameId", new GamePage(game), templateEngine);

    }

    private static Game setup() {
        Game game = new Game();
        game.add(new Player());
        game.add(new Player());
        game.add(new Player());
        game.add(new Player());
        game.dealCards();
        return game;
    }
}
