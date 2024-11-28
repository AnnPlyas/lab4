package com.gildedrose;

public enum ItemType { //перелік з назвами
    LEGENDARY("Sulfuras, Hand of Ragnaros"),
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASS("Backstage passes to a TAFKAL80ETC concert"),
    OTHER("Other");

    private final String name;

    ItemType(String name) {
        this.name = name;
    }

    public static ItemType fromName(String name) { //перевірка значення
        for (ItemType type : values()) {
            if (type.name.equals(name)) {
                return type;
            }
        }
        return OTHER;
    }

    public boolean isLegendary() {
        return this == LEGENDARY;
    }

    public boolean isAgedBrie() {
        return this == AGED_BRIE;
    }

    public boolean isBackstagePass() {
        return this == BACKSTAGE_PASS;
    }

    @Override
    public String toString() {
        return name;
    }
}


