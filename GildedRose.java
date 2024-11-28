package com.gildedrose;

class GildedRose {
    private final ItemCollection itemCollection;

    public GildedRose(Item[] items) {
        this.itemCollection = new ItemCollection(items);
    }

    public void updateQuality() {
        itemCollection.updateQuality();
    }

    public ItemCollection getItemCollection() {
        return itemCollection;
    }

    @Override
    public String toString() {
        return itemCollection.toString();
    }
}
