package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemName.SULFURAS;
import static org.junit.jupiter.api.Assertions.*;

class SulfurasStrategyTest {

    @Test
    void testSulfurasQualityDoesNotChange() {
        Item[] items = new Item[]{new Item(SULFURAS, 10, 80)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(80, items[0].getQuality()); // Quality should remain the same
        assertEquals(10, items[0].getSellIn()); // SellIn should also remain the same
    }
}