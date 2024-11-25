package com.gildedrose;

public class BackstagePassUpdateStrategy implements ItemUpdateStrategy {
    private final QualityAdjuster qualityAdjuster;
    private final SellInAdjuster sellInAdjuster;
    public BackstagePassUpdateStrategy(QualityAdjuster qualityAdjuster, SellInAdjuster sellInAdjuster) {
        this.qualityAdjuster = qualityAdjuster;
        this.sellInAdjuster = sellInAdjuster;
    }
    @Override
    public void updateQuality(Item item) {
        if (item.quality < 50) {
            qualityAdjuster.increaseQuality(item);
            if (item.sellIn < 11 && item.quality < 50) {
                qualityAdjuster.increaseQuality(item);
            }
            if (item.sellIn < 6 && item.quality < 50) {
                qualityAdjuster.increaseQuality(item);
            }
        }
        sellInAdjuster.updateSellIn(item);
        qualityAdjuster.initializeQuality(item);
    }
}
