package com.gildedrose;

public class SellInAdjuster {
    void updateSellIn(Item item) {
            item.setSellIn(item.getSellIn() - 1);
    }
}
