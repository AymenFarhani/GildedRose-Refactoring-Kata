package com.gildedrose;

class GildedRose{
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        QualityAdjuster qualityAdjuster = new QualityAdjuster();
        SellInAdjuster sellInAdjuster = new SellInAdjuster();
        for (Item item : items) {
            ItemUpdateStrategy strategy;
            switch (item.getName()) {
                case AGED_BRIE:
                    strategy = new AgedBrieUpdateStrategy(qualityAdjuster, sellInAdjuster);
                    break;
                case BACKSTAGE_PASS:
                    strategy = new BackstagePassUpdateStrategy(qualityAdjuster, sellInAdjuster);
                    break;
                case SULFURAS:
                    strategy = new SulfurasStrategy();
                    break;
                    case CONJURED:
                        strategy = new ConjuredItemUpdateStrategy(qualityAdjuster, sellInAdjuster);
                        break;
                default:
                    strategy = new NormalItemUpdateStrategy(qualityAdjuster, sellInAdjuster);
                    break;
            }

            strategy.updateQuality(item);
        }
    }
}