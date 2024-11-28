package com.gildedrose;

import java.util.Arrays;

class ItemCollection {
    private final Item[] items;

    public ItemCollection(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.updateQuality();
        }
    }

    public Item[] getItems() {
        return items;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
