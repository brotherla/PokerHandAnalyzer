package com.lwg.poker;

import javax.validation.constraints.NotNull;

import com.lwg.card.Card;
import com.lwg.card.Rank;
import com.lwg.card.Suit;

public final class HandCategoryAnalyzer {
    /**
     * Bitmask for royal flush.
     */
    private static final int ROYAL_FLUSH_MASK = straightMask(Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE);
    /**
     * BitMasks for all possible straights.
     */
    private static final int[] STRAIGHTS = new int[] { ROYAL_FLUSH_MASK,
            straightMask(Rank.NINE, Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING),
            straightMask(Rank.EIGHT, Rank.NINE, Rank.TEN, Rank.JACK, Rank.QUEEN),
            straightMask(Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN, Rank.JACK),
            straightMask(Rank.SIX, Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN),
            straightMask(Rank.FIVE, Rank.SIX, Rank.SEVEN, Rank.EIGHT, Rank.NINE),
            straightMask(Rank.FOUR, Rank.FIVE, Rank.SIX, Rank.SEVEN, Rank.EIGHT),
            straightMask(Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX, Rank.SEVEN),
            straightMask(Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX),
            straightMask(Rank.ACE, Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE) };

    /**
     * Constructor.
     */
    private HandCategoryAnalyzer() {
        throw new UnsupportedOperationException("HandCategoryAnalyzer cannot be instantiated");
    }

    /**
     * Calculates HandCategory for the given hand.
     *
     * @param hand hand
     * @return hand category
     */
    @NotNull
    public static HandCategory analyzeHand(final Card... hand) {
        final int suitCount = Suit.values().length;
        final int rankCount = Rank.values().length;

        final int[] ranks = new int[rankCount]; // Counts for cards of the same rank.
        final int[] suits = new int[suitCount]; // Counts for cards of the same suit.
        int handMask = 0; // Bitmask for all cards in hand without considering suits.
        final int[] suitMasks = new int[suitCount]; // BitMasks for cards of the same suit.

        // calculate rank/suit frequencies and bitmasks
        for (final Card card : hand) {
            final int rank = card.getRank().ordinal();
            final int suit = card.getSuit().ordinal();
            final int rankMask = 1 << rank;

            ranks[rank]++;
            suits[suit]++;
            handMask |= rankMask;
            suitMasks[suit] |= rankMask;
        }

        // calculates counts of 2 most occurred ranks
        int maxCount = 0;
        int maxCountSecond = 0;
        for (final int rank : ranks)
            if (rank > 0) {
                if (rank >= maxCount) {
                    maxCountSecond = maxCount;
                    maxCount = rank;
                } else if (rank > maxCountSecond)
                    maxCountSecond = rank;
            }

        // evaluate hand
        if (maxCount >= 5)
            return HandCategory.FIVE_KIND;
        else if (detectStraight(suitMasks, ROYAL_FLUSH_MASK))
            return HandCategory.ROYAL_FLUSH;
        else if (detectStraight(suitMasks, STRAIGHTS))
            return HandCategory.STRAIGHT_FLUSH;
        else if (maxCount == 4)
            return HandCategory.FOUR_KIND;
        else if ((maxCount == 3) && (maxCountSecond == 2))
            return HandCategory.FULL_HOUSE;
        else if (detectFlush(suits))
            return HandCategory.FLUSH;
        else if (detectStraight(handMask, STRAIGHTS))
            return HandCategory.STRAIGHT;
        else if (maxCount == 3)
            return HandCategory.THREE_KIND;
        else if (maxCount == 2)
            return (maxCountSecond == 2) ? HandCategory.TWO_PAIR : HandCategory.ONE_PAIR;
        return HandCategory.HIGH;
    }

    private static boolean detectStraight(@NotNull final int[] handMasks, @NotNull final int... straightMasks) {
        for (final int handMask : handMasks)
            if (detectStraight(handMask, straightMasks))
                return true;
        return false;
    }

    private static boolean detectStraight(final int handMask, @NotNull final int... straightMasks) {
        if (handMask >= 0b11111)
            for (final int straightMask : straightMasks)
                if ((handMask & straightMask) == straightMask)
                    return true;
        return false;
    }

    /**
     * Checks whether number of cards of the same suite
     *
     * @param suits counts for cards of the same suit
     * @return true if there are at least 5 cards of the same suit
     */
    private static boolean detectFlush(@NotNull final int[] suits) {
        for (final int suit : suits)
            if (suit >= 5)
                return true;
        return false;
    }

    /**
     * Calculates straight BitMask for the given ranks.
     *
     * @param ranks ranks
     * @return straight bitmask
     */
    private static int straightMask(@NotNull final Rank... ranks) {
        int mask = 0;
        for (final Rank rank : ranks)
            mask |= 1 << rank.ordinal();
        return mask;
    }
}
