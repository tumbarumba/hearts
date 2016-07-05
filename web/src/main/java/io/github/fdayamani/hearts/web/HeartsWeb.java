package io.github.fdayamani.hearts.web;

import spark.Spark;
import spark.TemplateEngine;
import spark.template.mustache.MustacheTemplateEngine;

public class HeartsWeb {
    public static void main(String[] args) {
        TemplateEngine templateEngine = new MustacheTemplateEngine();

        Spark.staticFileLocation("/assets");
        Spark.get("/", new HomePage(), templateEngine);
    }
}
