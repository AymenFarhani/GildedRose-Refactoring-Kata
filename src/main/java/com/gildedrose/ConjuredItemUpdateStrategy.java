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
        qualityAdjuster.decreaseQuality(item, 2);
        sellInAdjuster.updateSellIn(item);

        if (item.getSellIn() < 0) {
            qualityAdjuster.decreaseQuality(item, 2);
        }
    }
}
