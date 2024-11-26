package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SellInAdjusterTest {
    private SellInAdjuster sellInAdjuster;
    private Item item;

    @BeforeEach
    public void setUp() {
        sellInAdjuster = new SellInAdjuster();
        item = new Item();
        item.setSellIn(10);// Initialize with a default sellIn value
    }

    @Test
    void testUpdateSellIn_DecreasesSellInBy1() {
        int initialSellIn = item.getSellIn();
        sellInAdjuster.updateSellIn(item);
        assertEquals(initialSellIn - 1, item.getSellIn());
    }

    @Test
    void testUpdateSellIn_SellInShouldNotBeNegative() {
        item.setSellIn(0);
        sellInAdjuster.updateSellIn(item);
        assertEquals(-1, item.getSellIn());
    }

    @Test
    void testUpdateSellIn_WithNegativeSellIn() {
        item.setSellIn(-5);
        sellInAdjuster.updateSellIn(item);
        assertEquals(-6, item.getSellIn());
    }

    @Test
    void testUpdateSellIn_InitialNegativeValue() {
        item.setSellIn(-10);
        sellInAdjuster.updateSellIn(item);
        assertEquals(-11, item.getSellIn());
    }
}