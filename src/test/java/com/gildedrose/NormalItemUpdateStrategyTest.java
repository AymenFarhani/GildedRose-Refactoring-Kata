package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemName.NORMAL;
import static org.junit.jupiter.api.Assertions.*;

class NormalItemUpdateStrategyTest {

    @Test
    void testNormalItemQualityDecreases() {
        Item[] items = new Item[]{new Item(NORMAL, 10, 20)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(19, items[0].getQuality());
        assertEquals(9, items[0].getSellIn());
    }

    @Test
    void testNormalItemQualityDoesNotGoNegative() {
        Item[] items = new Item[]{new Item(NORMAL, 10, 0)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, items[0].getQuality());
        assertEquals(9, items[0].getSellIn());
    }

    @Test
    void testExpiredNormalItemQualityDecreases() {
        Item[] items = new Item[]{new Item(NORMAL, -1, 5)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(3, items[0].getQuality()); // Quality decreases by 2 when expired
        assertEquals(-2, items[0].getSellIn()); // SellIn should still decrease
    }
}