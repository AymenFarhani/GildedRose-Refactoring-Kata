package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemName.AGED_BRIE;
import static org.junit.jupiter.api.Assertions.*;

class AgedBrieUpdateStrategyTest {

    @Test
    void testAgedBrieIncreasesQuality() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 10, 20)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(21, items[0].getQuality());
        assertEquals(9, items[0].getSellIn());
    }

    @Test
    void testAgedBrieMaxQuality() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 10, 50)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(50, items[0].getQuality()); // Quality should not exceed 50
        assertEquals(9, items[0].getSellIn());
    }


    @Test
    void testExpiredAgedBrieIncreasesQuality() {
        Item[] items = new Item[]{new Item(AGED_BRIE, -1, 48)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(50, items[0].getQuality()); // Quality should increase to 50, max cap
        assertEquals(-2, items[0].getSellIn()); // SellIn should still decrease
    }
}