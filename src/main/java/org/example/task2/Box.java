package org.example.task2;

public class Box {

    // 1. Поля приватні
    private double length;
    private double width;
    private double height;

    // 2. Публічний конструктор
    public Box(double length, double width, double height) {
        // 3. Використання приватних сеттерів для валідації
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    // 4. Приватні сеттери з валідацією
    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Довжина не може бути нульовою або від'ємною.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Ширина не може бути нульовою або від'ємною.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Висота не може бути нульовою або від'ємною.");
        }
        this.height = height;
    }

    // 5. Публічні методи для розрахунків

    /**
     * Розраховує об'єм (l * w * h)
     */
    public double getVolume() {
        return this.length * this.width * this.height;
    }

    /**
     * Розраховує площу повної поверхні (2lw + 2lh + 2wh)
     */
    public double getSurfaceArea() {
        return 2 * (this.length * this.width +
                this.length * this.height +
                this.width * this.height);
    }

    /**
     * Розраховує площу бічної поверхні (2lh + 2wh)
     */
    public double getLateralSurfaceArea() {
        return 2 * (this.length * this.height + this.width * this.height);
    }

    // 6. Метод main() для демонстрації (згідно з умовою Завдання 1)
    public static void main(String[] args) {
        try {
            Box box = new Box(10, 5, 3);

            System.out.println("--- Параметри коробки (10x5x3) ---");
            System.out.println("Об'єм: " + box.getVolume()); // 150
            System.out.println("Площа поверхні: " + box.getSurfaceArea()); // 190
            System.out.println("Площа бічної поверхні: " + box.getLateralSurfaceArea()); // 90

            // Перевірка валідації (спровокує помилку)
            // Box invalidBox = new Box(10, -5, 3);

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка при створенні коробки: " + e.getMessage());
        }
    }
}