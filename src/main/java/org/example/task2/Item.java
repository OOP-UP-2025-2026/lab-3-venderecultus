package org.example.task2;

public class Item {

    // 1. Поля тепер приватні
    private long id;
    private String name;
    private double price;

    // 2. Використовуємо 'this' у конструкторі
    public Item(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // 3. Публічні геттери для доступу до приватних полів
    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    // Сеттери (setPrice, setName) можна додати за потреби,
    // але для ID сеттер зазвичай не потрібен.

    @Override
    public String toString() {
        // Використовуємо геттери або прямий доступ (оскільки це той самий клас)
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}