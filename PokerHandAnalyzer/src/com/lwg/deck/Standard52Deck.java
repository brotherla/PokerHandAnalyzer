package com.lwg.deck;

import com.lwg.card.Card;
import com.lwg.card.Rank;
import com.lwg.card.Suit;

public class Standard52Deck extends Deck {
    public Standard52Deck() {
        super(generateDeck());
    }

    private static Card[] generateDeck() {
        final Card[] cards = new Card[52];

        int idx = 0;
        for (final Suit suit : Suit.values())
            for (final Rank rank : Rank.values())
                cards[idx++] = new Card(suit, rank);

        return cards;
    }
}
