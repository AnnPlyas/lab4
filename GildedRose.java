package com.gildedrose;

//Виконані пункти 1,2
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
        if (item.getName().isAgedBrie() || item.getName().isBackstagePass()) {
            updateSpecialItem(item);
        }

        if (!item.getName().isLegendary()) {
            updateOrdinaryItem(item);
        }

        if (!item.getName().isLegendary()) {
            item.getSellIn().decrease();
        }

        updateOverdue(item);
    }

    private void updateSpecialItem(Item item) {
        if (item.getQuality().Int() < 50) {
            item.getQuality().increase();
        }

        if (item.getName().isBackstagePass()) {
            updateForBackstage(item);
        }
    }

    private void updateForBackstage(Item item) {
        if (item.getSellIn().getValue() < 11 && item.getQuality().Int() < 50) {
            item.getQuality().increase();
        }
        if (item.getSellIn().getValue() < 6 && item.getQuality().Int() < 50) {
            item.getQuality().increase();
        }
    }

    private void updateOrdinaryItem(Item item) {
        if (item.getQuality().Int() > 0 && !item.getName().isLegendary()) {
            item.getQuality().decrease();
        }
    }

    private void updateOverdue(Item item) {
        if (!item.getSellIn().isExpired()) {
            return;
        }

        if (item.getName().isBackstagePass()) {
            item.getQuality().setValue(0);
            return;
        }

        item.getQuality().decrease();
    }
}
