package com.gildedrose;

public class Item {

    public ItemName name;

    public int sellIn;

    public int quality;

    public Item(ItemName name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}