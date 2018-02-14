package com.lwg.poker;

import com.lwg.card.Card;
import com.lwg.card.Rank;
import com.lwg.card.Suit;

import javax.validation.constraints.NotNull;

public class Hand {
	@NotNull
	private final Card[] hand;

	public Hand(@NotNull final Card[] hand) {
		this.hand = hand.clone();
	}

	public HandCategory getHandCategory() {
		return HandCategoryAnalyzer.evaluateHand(this.hand);
	}
}
