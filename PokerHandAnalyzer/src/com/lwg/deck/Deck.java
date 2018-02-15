package com.lwg.deck;

import javax.validation.constraints.NotNull;

import com.lwg.card.Card;

public abstract class Deck {
    @NotNull
    private final Card[] cards;

    public Deck(@NotNull final Card... cards) {
        this.cards = cards;
    }

    @NotNull
    public Card[] getCards() {
        return this.cards;
    }
}
