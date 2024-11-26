package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemName.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

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
    void testConjuredDecreasesQuality() {
        Item[] items = new Item[]{new Item(CONJURED, 10, 50)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(48, items[0].getQuality()); // Quality should decrease by 2
        assertEquals(9, items[0].getSellIn());
    }


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
    void testSulfurasQualityDoesNotChange() {
        Item[] items = new Item[]{new Item(SULFURAS, 10, 80)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(80, items[0].getQuality()); // Quality should remain the same
        assertEquals(10, items[0].getSellIn()); // SellIn should also remain the same
    }

    @Test
    void testExpiredNormalItemQualityDecreases() {
        Item[] items = new Item[]{new Item(NORMAL, -1, 5)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(3, items[0].getQuality()); // Quality decreases by 2 when expired
        assertEquals(-2, items[0].getSellIn()); // SellIn should still decrease
    }

    @Test
    void testExpiredAgedBrieIncreasesQuality() {
        Item[] items = new Item[]{new Item(AGED_BRIE, -1, 48)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(50, items[0].getQuality()); // Quality should increase to 50, max cap
        assertEquals(-2, items[0].getSellIn()); // SellIn should still decrease
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