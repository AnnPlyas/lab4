package com.gildedrose;

class DaysUntilExpiration {
    private int value;

    public DaysUntilExpiration(int value) {
        this.value = validate(value); //перевірка значення
    }

    public int getValue() { //повертає кількість днів придатності
        return value;
    }

    public void decrease() {
        value = Math.max(0, value - 1);
    }

    public boolean isExpired() { // чи просрочений товар
        return value <= 0;
    }

    private int validate(int value) {
        return Math.max(0, value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}



