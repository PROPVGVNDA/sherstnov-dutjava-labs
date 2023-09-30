package org.university.lab3;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(0, "Tea", 13.99);
        Product product2 = new Product(1, "Fish", 24.99);
        Product product3 = new Product(2, "Meat", 19.79);

        Cart cart = new Cart();
        cart.addProduct(product1, product2);
        Order order = new Order(0, cart);
        System.out.println(order.getStatus());
        order.PlaceOrder();
        System.out.println(order.getStatus());
        order.ProcessOrder();
        System.out.println(order.getStatus());
    }
}
