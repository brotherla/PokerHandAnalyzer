package com.lwg.poker;

import org.junit.Assert;
import org.junit.Test;

import com.lwg.card.Card;
import com.lwg.poker.HandCategory;
import com.lwg.poker.HandCategoryAnalyzer;

public class HandCategoryAnalyzerTest {
    @Test
    public void testStraightFlush() {
        Assert.assertEquals(HandCategory.STRAIGHT_FLUSH,
                HandCategoryAnalyzer.evaluateHand(Card.CLUB_ACE,
                        Card.CLUB_TWO,
                        Card.CLUB_THREE,
                        Card.CLUB_FOUR,
                        Card.CLUB_FIVE,
                        Card.CLUB_SEVEN));
        Assert.assertEquals(HandCategory.STRAIGHT_FLUSH,
                HandCategoryAnalyzer.evaluateHand(Card.CLUB_ACE,
                        Card.CLUB_KING,
                        Card.CLUB_QUEEN,
                        Card.CLUB_JACK,
                        Card.CLUB_TEN,
                        Card.CLUB_SEVEN));
    }
}
