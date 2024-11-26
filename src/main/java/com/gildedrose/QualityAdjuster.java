package com.gildedrose;

public class QualityAdjuster {

    void initializeQuality(Item item) {
        if (item.getSellIn() < 0) {
            item.setQuality(0);
        }
    }

    void decreaseQuality(Item item) {
        item.setQuality(item.getQuality() - 1);
    }

    void increaseQuality(Item item) {
        item.setQuality(item.getQuality() + 1);
    }

    void decreaseQualityBy2(Item item) {
        item.setQuality(item.getQuality() - 2);
    }
}
