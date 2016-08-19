package io.github.fdayamani.hearts.web;

import com.google.common.collect.ImmutableMap;
import io.github.fdayamani.hearts.Card;
import io.github.fdayamani.hearts.Suit;

import java.util.Map;

import static io.github.fdayamani.hearts.Suit.CLUBS;
import static io.github.fdayamani.hearts.Suit.DIAMONDS;
import static io.github.fdayamani.hearts.Suit.HEARTS;
import static io.github.fdayamani.hearts.Suit.SPADES;

public class HtmlCard {
    private final Card card;
    private final Map<Suit, String> suitToClass = ImmutableMap.of(
            CLUBS, "C",
            DIAMONDS, "D",
            SPADES, "S",
            HEARTS, "H");
    private final Map<Suit, String> suitToEntity = ImmutableMap.of(
            CLUBS, "&clubsuit;",
            DIAMONDS, "&diamondsuit;",
            SPADES, "&spadesuit;",
            HEARTS, "&heartsuit;");

    public HtmlCard(Card card) {
        this.card = card;
    }

    public String rank() {
        return card.rank().getDisplay();
    }

    public String suitClass() {
        return suitToClass.get(card.suit());
    }

    public String suitEntity() {
        return suitToEntity.get(card.suit());
    }
}
