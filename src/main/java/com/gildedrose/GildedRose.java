package com.gildedrose;

class GildedRose{
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdateStrategy strategy;
            switch (item.name) {
                case AGED_BRIE:
                    strategy = new AgedBrieUpdateStrategy();
                    break;
                case BACKSTAGE_PASS:
                    strategy = new BackstagePassUpdateStrategy();
                    break;
                case SULFURAS:
                    strategy = new SulfurasStrategy();
                    break;
                    case CONJURED:
                        strategy = new ConjuredItemUpdateStrategy();
                        break;
                default:
                    strategy = new NormalItemUpdateStrategy();
                    break;
            }

            strategy.updateQuality(item);
        }
    }
}