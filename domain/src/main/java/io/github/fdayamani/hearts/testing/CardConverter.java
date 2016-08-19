package io.github.fdayamani.hearts.testing;

import io.github.fdayamani.hearts.Card;
import io.github.fdayamani.hearts.Rank;
import io.github.fdayamani.hearts.Suit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardConverter {

    public static List<Card> buildCardsFrom(String cards) {
        List<Card> cardList = new ArrayList<>();
        for (String card : cards.split(", ")) {
            cardList.add(buildCardFrom(card));
        }
        return cardList;
    }

    public static String buildStringFrom(List<Card> cardList) {
        return cardList.stream()
                .map(c -> c.toString())
                .collect(Collectors.joining(", "));
    }

    public static Card buildCardFrom(String card) {
        Rank rank = Rank.lookupRank(card.substring(0, card.length() - 1));
        Suit suit = Suit.lookupSuit(card.substring(card.length() - 1));
        return new Card(rank, suit);
    }
}
