package io.github.fdayamani.hearts.web;

import com.google.common.collect.ImmutableMap;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateViewRoute;

public class GamePage implements TemplateViewRoute, Route {
    @Override
    public ModelAndView handle(Request request, Response response) throws Exception {
        ImmutableMap<String, String> gameData = ImmutableMap.of("gameId", request.params(":gameId"));
        return new ModelAndView(gameData, "game.mustache");
    }
}
