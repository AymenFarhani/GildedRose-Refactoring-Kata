package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemName.CONJURED;
import static org.junit.jupiter.api.Assertions.*;

class ConjuredItemUpdateStrategyTest {

    @Test
    void testConjuredDecreasesQuality() {
        Item[] items = new Item[]{new Item(CONJURED, 10, 50)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(48, items[0].getQuality()); // Quality should decrease by 2
        assertEquals(9, items[0].getSellIn());
    }

    @Test
    void testConjuredDecreasesQualityWhenItIsZero() {
        Item[] items = new Item[]{new Item(CONJURED, 10, 0)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, items[0].getQuality()); // Quality should remain 0
        assertEquals(9, items[0].getSellIn());
    }

    @Test
    void testConjuredDecreasesQualityBy4WhenSellInNegative() {
        Item[] items = new Item[]{new Item(CONJURED, -1, 10)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(6, items[0].getQuality()); // Quality should remain 0
        assertEquals(-2, items[0].getSellIn());
    }

}