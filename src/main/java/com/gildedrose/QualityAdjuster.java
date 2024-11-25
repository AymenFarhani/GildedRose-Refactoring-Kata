package com.gildedrose;

public class QualityAdjuster {

    static void decreaseQuality(Item item) {
        item.quality--;
    }

    static void increaseQuality(Item item) {
        item.quality++;
    }

    static void decreaseQualityBy2(Item item) {
        item.quality -=2;
    }
}
