package com.gildedrose;

public class ConjuredItemUpdateStrategy implements ItemUpdateStrategy {
    private final QualityAdjuster qualityAdjuster;
    private final SellInAdjuster sellInAdjuster;
    public ConjuredItemUpdateStrategy(QualityAdjuster qualityAdjuster, SellInAdjuster sellInAdjuster) {
        this.qualityAdjuster = qualityAdjuster;
        this.sellInAdjuster = sellInAdjuster;
    }
    @Override
    public void updateQuality(Item item) {
        if (item.quality > 0) {
            qualityAdjuster.decreaseQualityBy2(item);
        }
        sellInAdjuster.updateSellIn(item);

        if (item.sellIn < 0 && item.quality > 0) {
            qualityAdjuster.decreaseQualityBy2(item);
        }
    }
}
