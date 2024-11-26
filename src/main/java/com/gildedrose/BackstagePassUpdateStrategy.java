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
        if (item.getQuality() < 50) {
            qualityAdjuster.increaseQuality(item);
            if (item.getSellIn() < 11 && item.getQuality() < 50) {
                qualityAdjuster.increaseQuality(item);
            }
            if (item.getSellIn() < 6 && item.getQuality() < 50) {
                qualityAdjuster.increaseQuality(item);
            }
        }
        sellInAdjuster.updateSellIn(item);
        qualityAdjuster.initializeQuality(item);
    }
}
