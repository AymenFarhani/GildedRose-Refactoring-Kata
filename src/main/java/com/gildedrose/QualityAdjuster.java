package com.gildedrose;

public class QualityAdjuster {

    public static final int QUALITY_MAX = 50;

    void initializeQuality(Item item) {
        if (item.getSellIn() < 0) {
            item.setQuality(0);
        }
    }

    void decreaseQuality(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    void increaseQuality(Item item) {
        if (item.getQuality() < QUALITY_MAX) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    void decreaseQualityBy2(Item item) {
        if(item.getQuality() <= 1 ) {
            item.setQuality(0);
        }
        else if (item.getQuality() > 1) {
            item.setQuality(item.getQuality() - 2);
        }
    }
}
