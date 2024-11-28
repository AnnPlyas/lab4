package com.gildedrose;

class DaysUntilExpiration {
    private int value;

    public DaysUntilExpiration(int value) {
        this.value = validate(value);
    }

    public int getValue() {
        return value;
    }

    public void decrease() {
        value = Math.max(0, value - 1);
    }

    public boolean isExpired() {
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



