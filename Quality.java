package com.gildedrose;

class Quality {
    private int value;

    public Quality(int value) {
        this.value = validate(value); //перевірка значення якості
    }

    public void increase() {
        value = validate(value + 1); //після збільшення переконуємося, що значення в правильних межах
    }

    public void decrease() {
        value = validate(value - 1); //після зменшення переконумося, що значеняння правильне
    }


    public void setValue(int value) {
        this.value = validate(value);
    }

    public int toInt() { //повертає у вигляді цілого числа
        return value;
    }

    private int validate(int newValue) { //перевірка меж
        return Math.max(0, Math.min(50, newValue));
    }

    @Override
    public String toString() { //переведення для виведення
        return String.valueOf(value);
    }
}

