package org.example.task2;

public class Main {
    public static void main(String[] args) {

        // Конструктор Cart тепер приймає 'int capacity', а не масив
        Cart cart = new Cart(10);

        cart.add(new Item(1, "Samsung Galaxy S23", 27999));
        cart.add(new Item(2, "Lenovo IdeaPad 3", 19499));
        cart.add(new Item(3, "LG 55\" 4K Smart TV", 15999));
        cart.add(new Item(4, "Bosch Serie 6 Пральна машина", 14799));
        cart.add(new Item(5, "Samsung RB34 Холодильник", 22399));
        cart.add(new Item(6, "De'Longhi Magnifica S Кавоварка", 10599));
        cart.add(new Item(7, "Gorenje Електрична плита", 9999));
        cart.add(new Item(8, "Dyson V11 Пилосос", 16499));
        cart.add(new Item(9, "Samsung ME83K Мікрохвильова піч", 3199));
        cart.add(new Item(10, "Philips DryCare Фен", 1499));

        System.out.println("Кошик після додавання 10 товарів");
        System.out.println(cart);

        // Наш новий removeById(9) шукає товар з ID=9 (Мікрохвильова піч)
        cart.removeById(9);

        System.out.println("Кошик після видалення товару з ID 9");
        System.out.println(cart);

        // Перевірка рахунку
        Order order = new Order(1L, "John");
        String bill = order.formOrderBill(cart);
        System.out.println("\n--- Сформований Рахунок ---");
        System.out.println(bill);
    }
}