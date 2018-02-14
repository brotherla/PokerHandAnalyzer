package com.lwg.deck;

import com.lwg.card.Card;

public abstract class Deck {
    protected final Card[] cards;

    protected Deck(final Card... cards) {
        this.cards = cards.clone();
    }
}
