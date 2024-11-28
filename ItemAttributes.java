package com.gildedrose;

public class ItemAttributes { //винесла в цей клас sellin, quality
    private final DaysUntilExpiration sellIn;
    private final Quality quality;

    public ItemAttributes(int sellIn, int quality) {
        this.sellIn = new DaysUntilExpiration(sellIn);
        this.quality = new Quality(quality);
    }

    public DaysUntilExpiration getSellIn() {
        return sellIn;
    }

    public Quality getQuality() {
        return quality;
    }

    public void decreaseSellIn() {
        sellIn.decrease();
    }

    public boolean isExpired() {
        return sellIn.isExpired();
    }

    @Override
    public String toString() {
        return sellIn + ", " + quality;
    }
}

