package com.gildedrose;

import static com.gildedrose.QualityAdjuster.increaseQuality;
import static com.gildedrose.SellInAdjuster.updateSellIn;

public class BackstagePassUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void updateQuality(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
            if (item.sellIn < 11 && item.quality < 50) {
                increaseQuality(item);
            }
            if (item.sellIn < 6 && item.quality < 50) {
                increaseQuality(item);
            }
        }
        updateSellIn(item);

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
