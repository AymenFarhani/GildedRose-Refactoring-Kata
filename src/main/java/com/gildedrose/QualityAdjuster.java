package com.gildedrose;

public class QualityAdjuster {

    public static final int QUALITY_MAX = 50;

    void initializeQuality(Item item) {
        if (item.getSellIn() < 0) {
            item.setQuality(0);
        }
    }

    void decreaseQuality(Item item, int quantityToRemove) {
        if (item.getQuality() <= quantityToRemove - 1) {
            item.setQuality(0);
        }
        else if (item.getQuality() > quantityToRemove - 1) {
            item.setQuality(item.getQuality() - quantityToRemove);
        }
    }

    void increaseQuality(Item item) {
        if (item.getQuality() < QUALITY_MAX) {
            item.setQuality(item.getQuality() + 1);
        }
    }

}
