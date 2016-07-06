package io.github.fdayamani.hearts.web;

import spark.Spark;
import spark.TemplateEngine;
import spark.template.mustache.MustacheTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.post;

public class HeartsWeb {
    public static void main(String[] args) {
        TemplateEngine templateEngine = new MustacheTemplateEngine();

        Spark.staticFileLocation("/assets");
        get("/", new HomePage(), templateEngine);
        post("/games", (req, res) -> {res.redirect("/games/1"); return "";});
        get("/games/:gameId", new GamePage(), templateEngine);

    }
}
