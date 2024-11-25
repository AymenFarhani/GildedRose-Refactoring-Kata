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
        if (item.quality < 50) {
            qualityAdjuster.increaseQuality(item);
        }
        sellInAdjuster.updateSellIn(item);

        if (item.sellIn < 0 && item.quality < 50) {
            qualityAdjuster.increaseQuality(item);
        }
    }
}
