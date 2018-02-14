package com.lwg.poker;

import javax.validation.constraints.NotNull;

import com.lwg.card.Card;

public class Hand {
    @NotNull
    private final Card[] hand;

    public Hand(@NotNull final Card... hand) {
        this.hand = hand.clone();
    }

    public HandCategory getHandCategory() {
        return HandCategoryAnalyzer.evaluateHand(this.hand);
    }
}
