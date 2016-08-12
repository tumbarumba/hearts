package io.github.fdayamani.hearts.testing;

import io.github.fdayamani.hearts.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class CardConverter {

    public static List<Card> buildCardsFrom(String cards) {
        List<Card> cardList = new ArrayList<>();
        for (String card : cards.split(", ")) {
            cardList.add(new Card(card));
        }
        return cardList;
    }

    public static String buildStringFrom(List<Card> cardList) {
        return cardList.stream()
                .map(c -> c.toString())
                .collect(Collectors.joining(", "));
    }

}
