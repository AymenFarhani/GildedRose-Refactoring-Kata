package com.gildedrose;

public class AgedBrieUpdateStrategy implements ItemUpdateStrategy {
    private final QualityAdjuster qualityAdjuster;
    private final SellInAdjuster sellInAdjuster;
    public AgedBrieUpdateStrategy(QualityAdjuster qualityAdjuster, SellInAdjuster sellInAdjuster) {
        this.qualityAdjuster = qualityAdjuster;
        this.sellInAdjuster = sellInAdjuster;
    }
    @Override
    public void updateQuality(Item item) {
        if (item.getQuality() < 50) {
            qualityAdjuster.increaseQuality(item);
        }
        sellInAdjuster.updateSellIn(item);

        if (item.getSellIn() < 0 && item.getQuality() < 50) {
            qualityAdjuster.increaseQuality(item);
        }
    }
}
