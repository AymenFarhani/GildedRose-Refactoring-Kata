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
        if (item.getQuality() > 0) {
            qualityAdjuster.decreaseQualityBy2(item);
        }
        sellInAdjuster.updateSellIn(item);

        if (item.getSellIn() < 0 && item.getQuality() > 0) {
            qualityAdjuster.decreaseQualityBy2(item);
        }
    }
}
