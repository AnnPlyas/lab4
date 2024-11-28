package com.gildedrose;

public class ItemAttributes {
    private final DaysUntilExpiration sellIn; //поле терміну придатності
    private final Quality quality; // поле якості

    public ItemAttributes(int sellIn, int quality) {
        this.sellIn = new DaysUntilExpiration(sellIn);
        this.quality = new Quality(quality);
    }

    public void decreaseSellIn() {
        sellIn.decrease();
    }

    public void increaseQuality() {
        quality.increase();
    }

    public void decreaseQuality() {
        quality.decrease();
    }

    public void setQualityToZero() {
        quality.setValue(0);
    }

    public boolean qualityBelowMax() {
        return quality.toInt() < 50;
    }

    public boolean qualityAboveZero() {
        return quality.toInt() > 0;
    }

    public boolean sellInBelow(int value) {
        return sellIn.getValue() < value;
    }

    public boolean isExpired() {
        return sellIn.isExpired();
    }

    @Override
    public String toString() {
        return sellIn + ", " + quality;
    }
}


