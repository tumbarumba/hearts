package io.github.fdayamani.hearts.web;

import io.github.fdayamani.hearts.Card;
import io.github.fdayamani.hearts.Hand;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateViewRoute;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class GamePage implements TemplateViewRoute, Route {
    private final Hand hand;
    public GamePage(List<Card> cards) {
        this.hand = new Hand(cards);
    }

    @Override
    public ModelAndView handle(Request request, Response response) throws Exception {
        String gameId = request.params(":gameId");
        PlayerModel player1 = new PlayerModel("Player 1", emptyList());
        PlayerModel player2 = new PlayerModel("Player 2", emptyList());
        PlayerModel player3 = new PlayerModel("Player 3", emptyList());
        PlayerModel player4 = new PlayerModel("You",
                hand.orderCards()
                        .stream()
                        .map(HtmlCard::new)
                        .collect(Collectors.toList()));

        GameModel gameData = new GameModel("Game", gameId, player1, player2, player3, player4);
        return new ModelAndView(gameData, "game.mustache");
    }

    public final class GameModel {
        public final String title;
        public final String gameId;
        public final PlayerModel player1;
        public final PlayerModel player2;
        public final PlayerModel player3;
        public final PlayerModel player4;

        public GameModel(
                String title,
                String gameId,
                PlayerModel player1,
                PlayerModel player2,
                PlayerModel player3,
                PlayerModel player4) {
            this.title = title;
            this.gameId = gameId;
            this.player1 = player1;
            this.player2 = player2;
            this.player3 = player3;
            this.player4 = player4;
        }
    }

    public final class PlayerModel {
        public final String name;
        public final List<HtmlCard> hand;

        public PlayerModel(
                String name,
                List<HtmlCard> hand) {
            this.name = name;
            this.hand = hand;
        }
    }

}
