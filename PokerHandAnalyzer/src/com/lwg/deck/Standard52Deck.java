package com.lwg.deck;

import com.lwg.card.Standard52Card;

public class Standard52Deck extends Deck {
    public Standard52Deck() {
        super(Standard52Card.values());
    }
}
