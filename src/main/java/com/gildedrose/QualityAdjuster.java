package com.gildedrose;

public class QualityAdjuster {

    void initializeQuality(Item item){
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
    void decreaseQuality(Item item) {
        item.quality--;
    }

    void increaseQuality(Item item) {
        item.quality++;
    }

    void decreaseQualityBy2(Item item) {
        item.quality -=2;
    }
}
