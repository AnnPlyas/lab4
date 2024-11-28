package com.gildedrose;

class Quality {
    private int value;

    public Quality(int value) {
        this.value = validate(value);
    }

    public void increase() {
        value = validate(value + 1);
    }

    public void decrease() {
        value = validate(value - 1);
    }

    public void setValue(int value) {
        this.value = validate(value);
    }

    public int toInt() {
        return value;
    }

    private int validate(int newValue) {
        return Math.max(0, Math.min(50, newValue));
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

