package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemName.BACKSTAGE_PASS;
import static org.junit.jupiter.api.Assertions.*;

class BackstagePassUpdateStrategyTest {

    @Test
    void testBackstagePassIncreaseQuality() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASS, 15, 20)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(21, items[0].getQuality()); // Quality should increase by 1
        assertEquals(14, items[0].getSellIn());
    }

    @Test
    void testBackstagePassQualityIncreaseCloseToConcert() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASS, 10, 20)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(22, items[0].getQuality()); // Quality should increase by 2
        assertEquals(9, items[0].getSellIn());

        items[0].setSellIn(5);// Update sellIn to check another condition
        gildedRose.updateQuality();
        assertEquals(25, items[0].getQuality()); // Quality should increase by another 2 (4 total)
        assertEquals(4, items[0].getSellIn());
    }

    @Test
    void testBackstagePassQualityDropsToZeroAfterConcert() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASS, 0, 20)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, items[0].getQuality()); // Quality drops to 0 after the concert
    }

    @Test
    void testExpiredBackstagePassQualityDropsToZero() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASS, -1, 20)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, items[0].getQuality()); // Quality should drop to 0 after the concert
        assertEquals(-2, items[0].getSellIn()); // SellIn should still decrease
    }
}