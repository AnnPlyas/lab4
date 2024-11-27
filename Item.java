package com.gildedrose;

public class Item {

    private final Name name;  // Тепер тип Name замість String
    private final SellIn sellIn;  // Інкапсуляція sellIn
    private final Quality quality;  // Інкапсуляція quality

    public Item(String name, int sellIn, int quality) {
        this.name = Name.fromName(name);  // Перетворюємо строку на відповідний тип Item
        this.sellIn = new SellIn(sellIn);  // Створюємо об'єкт SellIn
        this.quality = new Quality(quality);  // Створюємо об'єкт Quality
    }

    public Name getName() {
        return name;
    }

    public SellIn getSellIn() {
        return sellIn;
    }

    public Quality getQuality() {
        return quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + sellIn + ", " + quality;
    }
}

