package org.example.task2;

import java.util.EmptyStackException;

/**
 * Реалізує стек цілих чисел (int) на базі масиву,
 * з дотриманням інкапсуляції та динамічним розширенням.
 */
public class IntStack {

    // 1. Поля (реалізація) повністю ПРИВАТНІ.
    // Зовнішній світ не знає про 'array' чи 'DEFAULT_CAPACITY'.
    private int[] array;
    private int size; // Кількість елементів у стеку
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Конструктор без параметрів.
     * Створює новий порожній стек.
     */
    public IntStack() {
        this.array = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // 2. Публічний "інтерфейс" класу (API)

    /**
     * Додає елемент на вершину стеку.
     * @param element елемент, що додається
     */
    public void push(int element) {
        // Якщо масив заповнений, збільшуємо його
        if (this.size == this.array.length) {
            this.resize();
        }
        this.array[this.size] = element;
        this.size++;
    }

    /**
     * Видаляє та повертає елемент з вершини стеку.
     * @return елемент з вершини стеку
     * @throws EmptyStackException якщо стек порожній
     */
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        this.size--; // Зменшуємо розмір
        int element = this.array[this.size]; // Отримуємо елемент
        // this.array[this.size] = 0; // (Опціонально) очистка
        return element;
    }

    /**
     * Повертає елемент з вершини стеку, не видаляючи його.
     * @return елемент з вершини стеку
     * @throws EmptyStackException якщо стек порожній
     */
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // Повертаємо елемент за індексом (size - 1)
        return this.array[this.size - 1];
    }

    /**
     * Повертає кількість елементів у стеку.
     * @return кількість елементів
     */
    public int size() {
        return this.size;
    }

    /**
     * Перевіряє, чи є стек порожнім.
     * @return true, якщо стек порожній, інакше false
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Повністю очищує стек.
     */
    public void clear() {
        // Просто скидаємо лічильник.
        // (Опціонально) можна перестворити масив, щоб зекономити пам'ять
        // this.array = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // 3. Приватний "допоміжний" метод (деталь реалізації)

    /**
     * Внутрішній метод для динамічного розширення масиву.
     * Створює новий масив (зазвичай вдвічі більший)
     * і копіює в нього старі елементи.
     */
    private void resize() {
        int newCapacity = this.array.length * 2;
        int[] newArray = new int[newCapacity];

        // Копіюємо всі елементи зі старого масиву в новий
        System.arraycopy(this.array, 0, newArray, 0, this.size);

        // Замінюємо старий масив новим
        this.array = newArray;
        // System.out.println("Stack resized to " + newCapacity); // для дебагу
    }

    // 4. Метод main() для демонстрації
    public static void main(String[] args) {
        IntStack stack = new IntStack();

        System.out.println("Стек порожній? " + stack.isEmpty()); // true
        System.out.println("Розмір: " + stack.size()); // 0

        System.out.println("\n--- Push 1, 2, 3 ---");
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Стек порожній? " + stack.isEmpty()); // false
        System.out.println("Розмір: " + stack.size()); // 3
        System.out.println("Peek (верхній): " + stack.peek()); // 3

        System.out.println("\n--- Pop ---");
        System.out.println("Дістали: " + stack.pop()); // 3
        System.out.println("Новий Peek (верхній): " + stack.peek()); // 2
        System.out.println("Розмір: " + stack.size()); // 2

        System.out.println("\n--- Push (тест на resize) ---");
        // Додаємо елементи, щоб заповнити (DEFAULT_CAPACITY = 10)
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11); // Тут має спрацювати resize
        System.out.println("Додали 11-й елемент.");
        System.out.println("Розмір: " + stack.size()); // 10
        System.out.println("Peek (верхній): " + stack.peek()); // 11

        System.out.println("\n--- Clear ---");
        stack.clear();
        System.out.println("Стек порожній? " + stack.isEmpty()); // true
        System.out.println("Розмір: " + stack.size()); // 0

        try {
            System.out.println("\n--- Спроба Pop з порожнього стеку ---");
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Помилка! Спроба 'pop' з порожнього стеку.");
        }
    }
}