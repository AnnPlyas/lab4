package com.gildedrose;

public class Item {
    private final ItemType name;
    private final DaysUntilExpiration sellIn;
    private final Quality quality;

    public Item(String name, int sellIn, int quality) {
        this.name = ItemType.fromName(name);
        this.sellIn = new DaysUntilExpiration(sellIn);
        this.quality = new Quality(quality);
    }

    public void updateQuality() { //весь початковий код зібарний у окремий метод для зрозумілості логіки
        if (name.isAgedBrie() || name.isBackstagePass()) {
            updateSpecialItem();
        }

        if (!name.isLegendary()) {
            updateOrdinaryItem();
        }

        if (!name.isLegendary()) {
            sellIn.decrease();
        }

        updateOverdue();
    }

    private void updateSpecialItem() {
        if (quality.toInt() < 50) {
            quality.increase();
        }

        if (name.isBackstagePass()) {
            updateForBackstage();
        }
    }

    private void updateForBackstage() {
        if (sellIn.getValue() < 11 && quality.toInt() < 50) {
            quality.increase();
        }
        if (sellIn.getValue() < 6 && quality.toInt() < 50) {
            quality.increase();
        }
    }

    private void updateOrdinaryItem() {
        if (quality.toInt() > 0 && !name.isLegendary()) {
            quality.decrease();
        }
    }

    private void updateOverdue() {
        if (!sellIn.isExpired()) {
            return;
        }

        if (name.isBackstagePass()) {
            quality.setValue(0);
            return;
        }

        quality.decrease();
    }

    public ItemType getName() {
        return name;
    }

    public DaysUntilExpiration getSellIn() {
        return sellIn;
    }

    public Quality getQuality() {
        return quality;
    }

    @Override
    public String toString() {
        return name + ", " + sellIn + ", " + quality;
    }
}


