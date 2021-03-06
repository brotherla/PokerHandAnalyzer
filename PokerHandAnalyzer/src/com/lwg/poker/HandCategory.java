package com.lwg.poker;

/**
 * List of possible hand-ranking categories.
 */
public enum HandCategory {
    /**
     * High card.
     */
    HIGH(0),
    /**
     * One pair.
     */
    ONE_PAIR(1),
    /**
     * Two pair.
     */
    TWO_PAIR(2),
    /**
     * Three of a kind.
     */
    THREE_KIND(3),
    /**
     * Straight.
     */
    STRAIGHT(4),
    /**
     * Flush.
     */
    FLUSH(5),
    /**
     * Full house.
     */
    FULL_HOUSE(6),
    /**
     * Four of a kind.
     */
    FOUR_KIND(7),
    /**
     * Straight flush.
     */
    STRAIGHT_FLUSH(8),
    /**
     * Royal flush.
     */
    ROYAL_FLUSH(9),
    /**
     * Five of a kind.
     */
    FIVE_KIND(10);

    /**
     * rank.
     */
    private final int rank;

    /**
     * Constructor.
     * 
     * @param rank rank
     */
    private HandCategory(final int rank) {
        this.rank = rank;
    }

    /**
     * Rank value.
     * 
     * @return rank
     */
    public int getRank() {
        return this.rank;
    }
}
