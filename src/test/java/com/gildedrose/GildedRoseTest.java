package com.gildedrose;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private Item[] items;
    private GildedRose gildedRose;

    @BeforeEach
    void setUp() {
        items = new Item[] {
                new Item(ItemName.AGED_BRIE, 2, 0), // Example item
                new Item(ItemName.BACKSTAGE_PASS, 15, 20),
                new Item(ItemName.SULFURAS, 0, 80),
                new Item(ItemName.NORMAL, 10, 20),
                new Item(ItemName.CONJURED, 5, 6)
        };
        gildedRose = new GildedRose(items);
    }

    @Test
    void testUpdateQualityAgedBrie() {
        gildedRose.updateQuality();
        assertEquals(1, items[0].getSellIn());
        assertEquals(1, items[0].getQuality()); // Quality of Aged Brie should increase
    }

    @Test
    void testUpdateQualityBackstagePasses() {
        gildedRose.updateQuality();
        assertEquals(14, items[1].getSellIn());
        assertEquals(21, items[1].getQuality()); // Quality of Backstage pass should increase
    }

    @Test
    void testUpdateQualitySulfuras() {
        gildedRose.updateQuality();
        assertEquals(0, items[2].getSellIn());
        assertEquals(80, items[2].getQuality()); // Quality of Sulfuras should not change
    }

    @Test
    void testUpdateQualityNormalItem() {
        gildedRose.updateQuality();
        assertEquals(9, items[3].getSellIn());
        assertEquals(19, items[3].getQuality()); // Quality of normal item should decrease
    }

    @Test
    void testUpdateQualityConjuredItem() {
        gildedRose.updateQuality();
        assertEquals(4, items[4].getSellIn());
        assertEquals(4, items[4].getQuality()); // Quality of conjured item should decrease by 2
    }

    @Test
    void testQualityNeverNegative() {
        items[3].setQuality(0); // Set quality of normal item to 0
        gildedRose.updateQuality();
        assertEquals(9, items[3].getSellIn());
        assertEquals(0, items[3].getQuality()); // Quality should not become negative
    }

}