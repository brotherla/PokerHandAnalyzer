package com.lwg.poker;

import com.lwg.card.Card;
import com.lwg.card.Rank;
import com.lwg.card.Suit;

public final class HandCategoryAnalyzer {
	/**
	 * BitMasks for all possible straights.
	 */
	private static final int STRAIGHTS[] = new int[] {
		straightMaks(Rank.ACE, Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE),
		straightMaks(Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX),
		straightMaks(Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX, Rank.SEVEN),
		straightMaks(Rank.FOUR, Rank.FIVE, Rank.SIX, Rank.SEVEN, Rank.EIGHT),
		straightMaks(Rank.FIVE, Rank.SIX, Rank.SEVEN, Rank.EIGHT, Rank.NINE),
		straightMaks(Rank.SIX, Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN),
		straightMaks(Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN, Rank.JACK),
		straightMaks(Rank.EIGHT, Rank.NINE, Rank.TEN, Rank.JACK, Rank.QUEEN),
		straightMaks(Rank.NINE, Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING),
		straightMaks(Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE)
	};
	
	/**
	 * Calculates HandCategory for the given hand.
	 * @param hand hand
	 * @return hand category
	 */
	public static HandCategory evaluateHand(final Card[] hand) {
		final int suits[] = new int[Suit.values().length];
		final int ranks[] = new int[Rank.values().length];
		final int suitMasks[] = new int[Suit.values().length];
		int handMask = 0;

		for (final Card card : hand) {
			final int suit = card.getSuit().ordinal();
			final int rank = card.getRank().ordinal();
			final int rankMask = 1 << rank;

			suits[suit]++;
			ranks[rank]++;
			suitMasks[suit] |= rankMask;
			handMask |= rankMask;
		}

		HandCategory category = HandCategory.HIGH;

		for (final int suitCount : suits) {
			if (suitCount == 5) {
				category = HandCategory.max(category, HandCategory.FLUSH); break;
			}
		}

		int maxCount = 0;
		int maxCountSecond = 0;
		for (final int rankCount : ranks) {
			switch (rankCount) {
			case 5: category = HandCategory.max(category, HandCategory.FIVE_KIND); break;
			case 4: category = HandCategory.max(category, HandCategory.FOUR_KIND); break;
			case 3: category = HandCategory.max(category, HandCategory.THREE_KIND); break;
			case 2: category = HandCategory.max(category, HandCategory.ONE_PAIR); break;
			}
			
			if (rankCount >= maxCount) {
				maxCountSecond = maxCount;
				maxCount = rankCount;
			}
		}
		
		if ((maxCount >= 2) && (maxCountSecond >= 2))
			category = HandCategory.max(category, HandCategory.TWO_PAIR);

		if ((maxCount >= 3) && (maxCountSecond >= 2))
			category = HandCategory.max(category, HandCategory.FULL_HOUSE);

		for (final int suitMaks: suitMasks) {
			for (final int straightMask: STRAIGHTS) {
				if ((suitMaks & straightMask) == straightMask) {
					category = HandCategory.max(category, HandCategory.STRAIGHT_FLUSH); break;
				}
			}
		}

		for (final int straightMask: STRAIGHTS) {
			if ((handMask & straightMask) == straightMask) {
				category = HandCategory.max(category, HandCategory.STRAIGHT); break;
			}
		}
		
		return category;
	}
	
	/**
	 * Calculates BitMask for the given ranks.
	 * @param ranks ranks
	 * @return bitmask
	 */
	private static int straightMaks(final Rank ... ranks) {
		int mask = 0;
		for (final Rank rank: ranks) {
			mask |= 1 << rank.ordinal();
		}
		return mask;
	}
}
