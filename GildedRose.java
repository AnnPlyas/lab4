package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() { //цикл у методі(щоб запобігти повторення)
        for (Item item : items) {
            updateQuality(item);
        }
    }

    private void updateQuality(Item item) {  //весь початковий код зібарний у окремий метод для зрозумілості логіки
        if (isSpecialItem(item)) {
            updateSpecialItem(item);
        }

        if (!isSpecialItem(item)) { //замінили else
            updateOrdinaryItem(item);
        }

        IfNotSulfurasDecreaseSellIn(item);
        updateOverdue(item);
    }

    private boolean isSpecialItem(Item item) {  //перевірка на особливі предмети
        return item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateSpecialItem(Item item) {  //оновлення даних для особоливих предметів
        if (item.quality < 50) {
            item.quality += 1;
        }

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateForBackstage(item);
        }
    }

    private void updateForBackstage(Item item) {  //оновлення для Backstage
        if (item.sellIn < 11 && item.quality < 50) {
            item.quality += 1;
        }
        if (item.sellIn < 6 && item.quality < 50) {
            item.quality += 1;
        }
    }

    private void updateOrdinaryItem(Item item) {  //оновлення для неособливих речей
        if (item.quality > 0 && !isSulfuras(item)) {
            decreaseQuality(item);
        }
    }

    private boolean isSulfuras(Item item) {  //перевірка на Sulfuras
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void IfNotSulfurasDecreaseSellIn(Item item) {  // Зменшення sellIn, якщо це не Sulfuras
        if (!isSulfuras(item)) {
            item.sellIn -= 1;
        }
    }

    private void updateOverdue(Item item) {  //оновлення для просрочених товарів
        if (item.sellIn >= 0) {
            return;  // Якщо не просрочено, виходимо
        }

        if (isSpecialItem(item)) {
            updateOverdueSpecialItem(item);
        }

        if (!isSpecialItem(item)) {
            updateOverdueOrdinaryItem(item);
        }
    }

    private void updateOverdueSpecialItem(Item item) {  // якщо просрочений товар особливий
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
            return; //завершуємо методУ
        }

        if (item.quality < 50) {
            increaseQuality(item);  // Збільшуємо якість для інших особливих предметів
        }
    }

    private void updateOverdueOrdinaryItem(Item item) {  //якщо просрочений товар не особливий
        if (item.quality > 0 && !isSulfuras(item)) {
            decreaseQuality(item);
        }
    }

    private void increaseQuality(Item item) { //метод для збільшення якості
        if (item.quality < 50) {  // Перевірка, щоб не перевищити 50
            item.quality += 1;
        }
    }

    private void decreaseQuality(Item item) {  //метод для зменшення якості
        if (item.quality > 0) {  // Перевірка, щоб не було від'ємне число
            item.quality -= 1;
        }
    }
}
