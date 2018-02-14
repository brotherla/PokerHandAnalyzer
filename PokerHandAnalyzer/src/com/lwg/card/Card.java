package com.lwg.card;

public class Card {
    private final Suit suit;
    private final Rank rank;

    public static Card SPADE_ACE = new Card(Suit.SPADE, Rank.ACE);
    public static Card SPADE_TWO = new Card(Suit.SPADE, Rank.TWO);
    public static Card SPADE_THREE = new Card(Suit.SPADE, Rank.THREE);
    public static Card SPADE_FOUR = new Card(Suit.SPADE, Rank.FOUR);
    public static Card SPADE_FIVE = new Card(Suit.SPADE, Rank.FIVE);
    public static Card SPADE_SIX = new Card(Suit.SPADE, Rank.SIX);
    public static Card SPADE_SEVEN = new Card(Suit.SPADE, Rank.SEVEN);
    public static Card SPADE_EIGHT = new Card(Suit.SPADE, Rank.EIGHT);
    public static Card SPADE_NINE = new Card(Suit.SPADE, Rank.NINE);
    public static Card SPADE_TEN = new Card(Suit.SPADE, Rank.TEN);
    public static Card SPADE_JACK = new Card(Suit.SPADE, Rank.JACK);
    public static Card SPADE_QUEEN = new Card(Suit.SPADE, Rank.QUEEN);
    public static Card SPADE_KING = new Card(Suit.SPADE, Rank.KING);

    public static Card HEART_ACE = new Card(Suit.HEART, Rank.ACE);
    public static Card HEART_TWO = new Card(Suit.HEART, Rank.TWO);
    public static Card HEART_THREE = new Card(Suit.HEART, Rank.THREE);
    public static Card HEART_FOUR = new Card(Suit.HEART, Rank.FOUR);
    public static Card HEART_FIVE = new Card(Suit.HEART, Rank.FIVE);
    public static Card HEART_SIX = new Card(Suit.HEART, Rank.SIX);
    public static Card HEART_SEVEN = new Card(Suit.HEART, Rank.SEVEN);
    public static Card HEART_EIGHT = new Card(Suit.HEART, Rank.EIGHT);
    public static Card HEART_NINE = new Card(Suit.HEART, Rank.NINE);
    public static Card HEART_TEN = new Card(Suit.HEART, Rank.TEN);
    public static Card HEART_JACK = new Card(Suit.HEART, Rank.JACK);
    public static Card HEART_QUEEN = new Card(Suit.HEART, Rank.QUEEN);
    public static Card HEART_KING = new Card(Suit.HEART, Rank.KING);

    public static Card DIAMOND_ACE = new Card(Suit.DIAMOND, Rank.ACE);
    public static Card DIAMOND_TWO = new Card(Suit.DIAMOND, Rank.TWO);
    public static Card DIAMOND_THREE = new Card(Suit.DIAMOND, Rank.THREE);
    public static Card DIAMOND_FOUR = new Card(Suit.DIAMOND, Rank.FOUR);
    public static Card DIAMOND_FIVE = new Card(Suit.DIAMOND, Rank.FIVE);
    public static Card DIAMOND_SIX = new Card(Suit.DIAMOND, Rank.SIX);
    public static Card DIAMOND_SEVEN = new Card(Suit.DIAMOND, Rank.SEVEN);
    public static Card DIAMOND_EIGHT = new Card(Suit.DIAMOND, Rank.EIGHT);
    public static Card DIAMOND_NINE = new Card(Suit.DIAMOND, Rank.NINE);
    public static Card DIAMOND_TEN = new Card(Suit.DIAMOND, Rank.TEN);
    public static Card DIAMOND_JACK = new Card(Suit.DIAMOND, Rank.JACK);
    public static Card DIAMOND_QUEEN = new Card(Suit.DIAMOND, Rank.QUEEN);
    public static Card DIAMOND_KING = new Card(Suit.DIAMOND, Rank.KING);

    public static Card CLUB_ACE = new Card(Suit.CLUB, Rank.ACE);
    public static Card CLUB_TWO = new Card(Suit.CLUB, Rank.TWO);
    public static Card CLUB_THREE = new Card(Suit.CLUB, Rank.THREE);
    public static Card CLUB_FOUR = new Card(Suit.CLUB, Rank.FOUR);
    public static Card CLUB_FIVE = new Card(Suit.CLUB, Rank.FIVE);
    public static Card CLUB_SIX = new Card(Suit.CLUB, Rank.SIX);
    public static Card CLUB_SEVEN = new Card(Suit.CLUB, Rank.SEVEN);
    public static Card CLUB_EIGHT = new Card(Suit.CLUB, Rank.EIGHT);
    public static Card CLUB_NINE = new Card(Suit.CLUB, Rank.NINE);
    public static Card CLUB_TEN = new Card(Suit.CLUB, Rank.TEN);
    public static Card CLUB_JACK = new Card(Suit.CLUB, Rank.JACK);
    public static Card CLUB_QUEEN = new Card(Suit.CLUB, Rank.QUEEN);
    public static Card CLUB_KING = new Card(Suit.CLUB, Rank.KING);

    public Card(final Suit suit, final Rank rank) {
        /**
         * WILD card is represented as WILD, WILD, other combinations of WILD with non-WILD rank/suit are not allowed.
         */
        // assert (suit == Suit.WILD || rank == Rank.WILD) ? (suit == Suit.WILD && rank
        // == Rank.WILD) : true;

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
