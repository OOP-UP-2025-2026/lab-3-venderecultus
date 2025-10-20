package org.example.task2;

public class Order {

    // 1. Поля тепер приватні
    private long id;
    private String customer;

    // 2. Конструктор з 'this'
    public Order(long id, String customer) {
        this.id = id;
        this.customer = customer;
    }

    // 3. Публічні геттери
    public long getId() {
        return this.id;
    }

    public String getCustomer() {
        return this.customer;
    }

    // 4. Метод 'formOrderBill' тепер використовує публічні методи
    //    класів Cart та Item, не торкаючись їхніх приватних полів.
    public String formOrderBill(Cart cart) {

        StringBuilder builder = new StringBuilder();
        // Використовуємо 'this' для полів цього класу
        builder.append("Order number ").append(this.id);
        builder.append(" for customer ").append(this.customer);
        builder.append("\n------------------\n");

        double sum = 0.0;

        // 5. Отримуємо БЕЗПЕЧНУ копію товарів з кошика
        Item[] items = cart.getContents();

        // Ітеруємо по цій копії
        for (Item item : items) {

            // 6. Використовуємо геттери класу Item
            sum += item.getPrice();

            builder.append("Item id: ");
            builder.append(item.getId());
            builder.append(" name: ");
            builder.append(item.getName());
            builder.append(" price: ");
            builder.append(item.getPrice());
            builder.append("\n");
        }

        builder.append("------------------\n");
        builder.append("Total sum: ");
        builder.append(sum);

        return builder.toString();
    }
}