package com.gildedrose;

public class BackstagePassUpdateStrategy implements ItemUpdateStrategy {
    public static final int SELL_IN_FIRST_LEVEL = 11;
    public static final int SELL_IN_SECOND_LEVEL = 6;
    private final QualityAdjuster qualityAdjuster;
    private final SellInAdjuster sellInAdjuster;

    public BackstagePassUpdateStrategy(QualityAdjuster qualityAdjuster, SellInAdjuster sellInAdjuster) {
        this.qualityAdjuster = qualityAdjuster;
        this.sellInAdjuster = sellInAdjuster;
    }

    @Override
    public void updateQuality(Item item) {
        qualityAdjuster.increaseQuality(item);
        if (item.getSellIn() < SELL_IN_FIRST_LEVEL) {
            qualityAdjuster.increaseQuality(item);
        }
        if(item.getSellIn() < SELL_IN_SECOND_LEVEL) {
            qualityAdjuster.increaseQuality(item);
        }
        sellInAdjuster.updateSellIn(item);
        qualityAdjuster.initializeQuality(item);
    }
}
