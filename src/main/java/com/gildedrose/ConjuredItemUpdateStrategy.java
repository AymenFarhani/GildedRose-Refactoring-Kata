package com.gildedrose;

import static com.gildedrose.QualityAdjuster.decreaseQualityBy2;
import static com.gildedrose.SellInAdjuster.updateSellIn;

public class ConjuredItemUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void updateQuality(Item item) {
        if (item.quality > 0) {
            decreaseQualityBy2(item);
        }
        updateSellIn(item);

        if (item.sellIn < 0 && item.quality > 0) {
            decreaseQualityBy2(item);
        }
    }
}
