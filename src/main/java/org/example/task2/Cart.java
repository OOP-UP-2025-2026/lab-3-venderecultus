package org.example.task2;

import java.util.Arrays;

public class Cart {

    // 1. Поля тепер приватні
    private Item[] contents;
    private int index;

    // 2. Конструктор створює свій внутрішній масив
    public Cart(int capacity) {
        this.contents = new Item[capacity];
        this.index = 0;
    }

    // 3. Публічний метод add
    public void add(Item item) {
        if (isCartFull()) {
            System.out.println("Кошик повний. Неможливо додати: " + item.getName());
            return;
        }

        this.contents[this.index] = item;
        this.index++;
    }

    // 4. Публічні методи видалення
    public boolean removeById(int idToRemove) {
        int foundIndex = this.findItemIndexById(idToRemove);

        if (foundIndex == -1) {
            return false;
        }
        return this.removeByIndex(foundIndex);
    }

    public boolean removeByIndex(int indexToRemove) {
        if (indexToRemove < 0 || indexToRemove >= this.index) {
            return false;
        }

        if (indexToRemove != this.index - 1) {
            // Зсуваємо масив, якщо це не останній елемент
            this.shiftArray(indexToRemove);
        }

        this.index--;
        // Очищуємо комірку, яка стала "останньою"
        this.contents[this.index] = null;
        return true;
    }

    // 5. Допоміжні методи тепер ПРИВАТНІ
    private void shiftArray(int indexToRemove) {
        for (int i = indexToRemove; i < this.index - 1; i++) {
            this.contents[i] = this.contents[i + 1];
        }
    }

    private int findItemIndexById(int idToFind) {
        for (int i = 0; i < this.index; i++) {
            // Припускаємо, що Item має getId()
            if (this.contents[i].getId() == idToFind) {
                return i;
            }
        }
        return -1;
    }

    // 6. Публічні геттери
    public boolean isCartFull() {
        return this.index == this.contents.length;
    }

    public int getSize() {
        return this.index;
    }

    /**
     * Повертає КОПІЮ масиву з товарами.
     * Це захищає оригінальний масив 'contents' від змін ззовні.
     */
    public Item[] getContents() {
        // Створюємо новий масив розміром з кількість елементів
        Item[] copy = new Item[this.index];
        System.arraycopy(this.contents, 0, copy, 0, this.index);
        return copy;
    }

    @Override
    public String toString() {
        // Використовуємо 'Arrays.copyOf' для друку тільки активних елементів
        return "Cart{" +
                "items=" + Arrays.toString(Arrays.copyOf(this.contents, this.index)) +
                ", size=" + this.index +
                ", capacity=" + this.contents.length +
                '}';
    }
}