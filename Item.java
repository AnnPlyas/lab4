package com.gildedrose;

public class Item {
    private final ItemType name; //поле для визначення типу товару
    private final ItemAttributes attributes; //поле для визначення кількості днів до закінчення терміну придатності та якість

    public Item(String name, int sellIn, int quality) {
        this.name = ItemType.fromName(name);
        this.attributes = new ItemAttributes(sellIn, quality);
    }

    public void updateQuality() { //метод для оновлення інформації
        if (name.isAgedBrie() || name.isBackstagePass()) {
            updateSpecialItem();
        }

        if (!name.isLegendary()) {
            updateOrdinaryItem();
        }

        if (!name.isLegendary()) {
            attributes.decreaseSellIn();
        }

        updateOverdue();
    }

    private void updateSpecialItem() {
        if (attributes.qualityBelowMax()) {
            attributes.increaseQuality();
        }

        if (name.isBackstagePass()) {
            updateForBackstage();
        }
    }

    private void updateForBackstage() {
        if (attributes.sellInBelow(11) && attributes.qualityBelowMax()) {
            attributes.increaseQuality();
        }
        if (attributes.sellInBelow(6) && attributes.qualityBelowMax()) {
            attributes.increaseQuality();
        }
    }

    private void updateOrdinaryItem() {
        if (attributes.qualityAboveZero()) {
            attributes.decreaseQuality();
        }
    }

    private void updateOverdue() {
        if (!attributes.isExpired()) {
            return;
        }

        if (name.isBackstagePass()) {
            attributes.setQualityToZero();
            return;
        }

        attributes.decreaseQuality();
    }

    @Override
    public String toString() {
        return name + ", " + attributes;
    }
}