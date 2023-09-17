package org.example;

import java.util.ArrayList;

public class Order {
    public enum OrderStatus {
        CREATED,
        PENDING,
        PROCESSED,
    }

    private final int orderId;
    private ArrayList<Product> products;
    private OrderStatus status;

    public Order(int orderId, ArrayList<Product> products)
    {
        this.orderId = orderId;
        this.products = products;
        this.status = OrderStatus.CREATED;
    }

    public Order(int orderId, Cart cart)
    {
        this.orderId = orderId;
        this.products = cart.getProducts();
        this.status = OrderStatus.CREATED;
    }

    public void PlaceOrder()
    {
        if (status == OrderStatus.PROCESSED) throw new RuntimeException("Attempt to place already processed order");
        if (products.isEmpty()) throw new RuntimeException("Attempt to place an order with no products");
        this.status = OrderStatus.PENDING;
    }

    public void ProcessOrder()
    {
        if (status != OrderStatus.PENDING) throw new RuntimeException("Attempt to process non-placed order");
        this.status = OrderStatus.PROCESSED;
    }

    public int getOrderId() {
        return orderId;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        if (status == OrderStatus.PROCESSED) throw new RuntimeException("Attempt to modify processed order");
        this.products = products;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
