package com.gildedrose;

import java.util.regex.Pattern;

public enum ItemName {
    NORMAL(Pattern.compile("@.*@(.+)").toString()),
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASS("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    CONJURED("Conjured");

    private final String name;
    ItemName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}