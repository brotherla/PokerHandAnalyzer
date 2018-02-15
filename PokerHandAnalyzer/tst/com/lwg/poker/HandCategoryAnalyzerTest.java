package com.lwg.poker;

import static com.lwg.card.Standard52Card.CLUB_ACE;
import static com.lwg.card.Standard52Card.CLUB_FIVE;
import static com.lwg.card.Standard52Card.CLUB_FOUR;
import static com.lwg.card.Standard52Card.CLUB_JACK;
import static com.lwg.card.Standard52Card.CLUB_KING;
import static com.lwg.card.Standard52Card.CLUB_QUEEN;
import static com.lwg.card.Standard52Card.CLUB_SEVEN;
import static com.lwg.card.Standard52Card.CLUB_TEN;
import static com.lwg.card.Standard52Card.CLUB_THREE;
import static com.lwg.card.Standard52Card.CLUB_TWO;
import static com.lwg.card.Standard52Card.DIAMOND_ACE;
import static com.lwg.card.Standard52Card.DIAMOND_QUEEN;
import static com.lwg.card.Standard52Card.DIAMOND_THREE;
import static com.lwg.card.Standard52Card.HEART_ACE;
import static com.lwg.card.Standard52Card.HEART_KING;
import static com.lwg.card.Standard52Card.HEART_TWO;
import static com.lwg.card.Standard52Card.SPADE_ACE;
import static com.lwg.poker.HandCategory.FIVE_KIND;
import static com.lwg.poker.HandCategory.FLUSH;
import static com.lwg.poker.HandCategory.FOUR_KIND;
import static com.lwg.poker.HandCategory.FULL_HOUSE;
import static com.lwg.poker.HandCategory.HIGH;
import static com.lwg.poker.HandCategory.ONE_PAIR;
import static com.lwg.poker.HandCategory.ROYAL_FLUSH;
import static com.lwg.poker.HandCategory.STRAIGHT;
import static com.lwg.poker.HandCategory.STRAIGHT_FLUSH;
import static com.lwg.poker.HandCategory.THREE_KIND;
import static com.lwg.poker.HandCategory.TWO_PAIR;
import static com.lwg.poker.HandCategoryAnalyzer.analyzeHand;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;;

public class HandCategoryAnalyzerTest {
    @Test
    public void testFiveKind() {
        assertEquals(FIVE_KIND, analyzeHand(CLUB_ACE, CLUB_ACE, CLUB_ACE, CLUB_ACE, CLUB_ACE, CLUB_SEVEN));
        assertEquals(FIVE_KIND, analyzeHand(SPADE_ACE, HEART_ACE, DIAMOND_ACE, CLUB_ACE, SPADE_ACE, CLUB_SEVEN));
    }

    @Test
    public void testRoyalStraightFlush() {
        assertEquals(ROYAL_FLUSH, analyzeHand(CLUB_ACE, CLUB_KING, CLUB_QUEEN, CLUB_JACK, CLUB_TEN, CLUB_SEVEN));
        assertEquals(STRAIGHT_FLUSH, analyzeHand(CLUB_ACE, CLUB_TWO, CLUB_THREE, CLUB_FOUR, CLUB_FIVE, CLUB_SEVEN));
        assertEquals(STRAIGHT, analyzeHand(SPADE_ACE, HEART_TWO, DIAMOND_THREE, CLUB_FOUR, CLUB_FIVE, CLUB_SEVEN));
    }

    @Test
    public void testFourKind() {
        assertEquals(FOUR_KIND,
                analyzeHand(CLUB_ACE,
                        CLUB_ACE,
                        CLUB_ACE,
                        HEART_KING,
                        HEART_KING,
                        DIAMOND_QUEEN,
                        DIAMOND_QUEEN,
                        DIAMOND_QUEEN,
                        DIAMOND_QUEEN));
    }

    @Test
    public void testFullHouse() {
        assertEquals(FULL_HOUSE,
                analyzeHand(SPADE_ACE, SPADE_ACE, SPADE_ACE, HEART_KING, HEART_KING, DIAMOND_QUEEN, DIAMOND_QUEEN));
        assertEquals(FULL_HOUSE,
                analyzeHand(SPADE_ACE, SPADE_ACE, HEART_KING, HEART_KING, DIAMOND_QUEEN, DIAMOND_QUEEN, DIAMOND_QUEEN));
        assertEquals(FULL_HOUSE,
                analyzeHand(SPADE_ACE, HEART_KING, HEART_KING, DIAMOND_QUEEN, DIAMOND_QUEEN, DIAMOND_QUEEN));
    }

    @Test
    public void testFlush() {
        assertEquals(FLUSH, analyzeHand(CLUB_ACE, CLUB_ACE, CLUB_ACE, CLUB_KING, CLUB_QUEEN));
    }

    @Test
    public void testThreeKind() {
        assertEquals(THREE_KIND,
                analyzeHand(CLUB_ACE,
                        CLUB_ACE,
                        CLUB_ACE,
                        HEART_KING,
                        HEART_KING,
                        DIAMOND_QUEEN,
                        DIAMOND_QUEEN,
                        DIAMOND_QUEEN));
    }

    @Test
    public void testTwoPair() {
        assertEquals(TWO_PAIR, analyzeHand(CLUB_ACE, CLUB_ACE, HEART_KING, HEART_KING, DIAMOND_QUEEN, DIAMOND_QUEEN));
    }

    @Test
    public void testOnePair() {
        assertEquals(ONE_PAIR, analyzeHand(CLUB_ACE, CLUB_ACE, HEART_KING, DIAMOND_QUEEN));
    }

    @Test
    public void testHighCard() {
        assertEquals(HIGH, analyzeHand(CLUB_ACE, HEART_KING, DIAMOND_QUEEN));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testConstructor() throws Throwable {
        try {
            final Constructor<HandCategoryAnalyzer> ctor = HandCategoryAnalyzer.class.getDeclaredConstructor();
            ctor.setAccessible(true);
            ctor.newInstance();
        } catch (final InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
