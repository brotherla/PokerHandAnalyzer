package com.lwg.poker;

import org.junit.Assert;
import org.junit.Test;

public class HandCategoryTest {
    @Test
    public void test() {
        Assert.assertTrue(HandCategory.FIVE_KIND.getRank() > HandCategory.ROYAL_FLUSH.getRank());
        Assert.assertTrue(HandCategory.ROYAL_FLUSH.getRank() > HandCategory.STRAIGHT_FLUSH.getRank());
        Assert.assertTrue(HandCategory.STRAIGHT_FLUSH.getRank() > HandCategory.FOUR_KIND.getRank());
        Assert.assertTrue(HandCategory.FOUR_KIND.getRank() > HandCategory.FULL_HOUSE.getRank());
        Assert.assertTrue(HandCategory.FULL_HOUSE.getRank() > HandCategory.FLUSH.getRank());
        Assert.assertTrue(HandCategory.FLUSH.getRank() > HandCategory.STRAIGHT.getRank());
        Assert.assertTrue(HandCategory.STRAIGHT.getRank() > HandCategory.THREE_KIND.getRank());
        Assert.assertTrue(HandCategory.THREE_KIND.getRank() > HandCategory.TWO_PAIR.getRank());
        Assert.assertTrue(HandCategory.TWO_PAIR.getRank() > HandCategory.ONE_PAIR.getRank());
        Assert.assertTrue(HandCategory.ONE_PAIR.getRank() > HandCategory.HIGH.getRank());
    }

}
