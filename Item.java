package com.gildedrose;

public class Item {
    private final ItemType name;
    private final ItemAttributes attributes;

    public Item(String name, int sellIn, int quality) {
        this.name = ItemType.fromName(name);
        this.attributes = new ItemAttributes(sellIn, quality);
    }

    public void updateQuality() {
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
        if (attributes.getQuality().toInt() < 50) {
            attributes.getQuality().increase();
        }

        if (name.isBackstagePass()) {
            updateForBackstage();
        }
    }

    private void updateForBackstage() {
        if (attributes.getSellIn().getValue() < 11 && attributes.getQuality().toInt() < 50) {
            attributes.getQuality().increase();
        }
        if (attributes.getSellIn().getValue() < 6 && attributes.getQuality().toInt() < 50) {
            attributes.getQuality().increase();
        }
    }

    private void updateOrdinaryItem() {
        if (attributes.getQuality().toInt() > 0 && !name.isLegendary()) {
            attributes.getQuality().decrease();
        }
    }

    private void updateOverdue() {
        if (!attributes.isExpired()) {
            return;
        }

        if (name.isBackstagePass()) {
            attributes.getQuality().setValue(0);
            return;
        }

        attributes.getQuality().decrease();
    }

    public ItemType getName() {
        return name;
    }

    public ItemAttributes getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return name + ", " + attributes;
    }
}


