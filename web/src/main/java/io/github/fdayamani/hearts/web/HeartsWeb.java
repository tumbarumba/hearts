package io.github.fdayamani.hearts.web;

import spark.Spark;

public class HeartsWeb {
    public static void main(String[] args) {
        Spark.get("/", (request, response) -> "Hello, world");
    }
}
