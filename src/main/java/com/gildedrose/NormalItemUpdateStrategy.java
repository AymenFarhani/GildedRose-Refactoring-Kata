package com.gildedrose;

import static com.gildedrose.QualityAdjuster.decreaseQuality;
import static com.gildedrose.SellInAdjuster.updateSellIn;

public class NormalItemUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void updateQuality(Item item) {
        if (item.quality > 0) {
            decreaseQuality(item);
        }
        updateSellIn(item);

        if (item.sellIn < 0 && item.quality > 0) {
            decreaseQuality(item);
        }
    }

}
