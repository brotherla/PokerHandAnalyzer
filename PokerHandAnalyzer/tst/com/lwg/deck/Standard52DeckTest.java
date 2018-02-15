package com.lwg.deck;

import org.junit.Assert;
import org.junit.Test;

public class Standard52DeckTest {
    @Test
    public void test() {
        final Deck deck = new Standard52Deck();
        Assert.assertEquals(52, deck.getCards().length);
    }
}
