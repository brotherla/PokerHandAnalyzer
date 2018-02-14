package com.lwg.card;

public class Card {
	private final Suit suit;
	private final Rank rank;
	
	public Card(final Suit suit, final Rank rank) {
		/**
		 * WILD card is represented as WILD, WILD, other combinations of WILD with non-WILD rank/suit are not allowed.
		 */
		//assert (suit == Suit.WILD || rank == Rank.WILD) ? (suit == Suit.WILD && rank == Rank.WILD) : true;
		
		this.suit = suit;
		this.rank = rank;
	}
	
	public Suit getSuit() {
		return this.suit;
	}

	public Rank getRank() {
		return this.rank;
	}
}
