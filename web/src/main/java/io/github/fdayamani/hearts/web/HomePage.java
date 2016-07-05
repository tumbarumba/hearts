package io.github.fdayamani.hearts.web;

import com.google.common.collect.Maps;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class HomePage implements TemplateViewRoute {
    public ModelAndView handle(Request request, Response response) {
        return new ModelAndView(Maps.newHashMap(), "home.mustache");
    }
}
