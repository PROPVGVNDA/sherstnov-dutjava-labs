package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Cart cart;
    private ArrayList<Product> products;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        products = new ArrayList<>();
        Product product1 = new Product(0, "Test0", 10);
        Product product2 = new Product(1, "Test1", 50.99);
        cart.addProduct(product1, product2);
        products.add(product1);
        products.add(product2);
    }

    @Test
    public void testGetOrderStatus() {
        Order order = new Order(1, products);
        assertEquals(Order.OrderStatus.CREATED, order.getStatus());

        order.PlaceOrder();
        assertEquals(Order.OrderStatus.PENDING, order.getStatus());

        order.ProcessOrder();
        assertEquals(Order.OrderStatus.PROCESSED, order.getStatus());
    }

    @Test
    public void createOrderWithArrayList() {
        Order order = new Order(1, products);
        assertEquals(1, order.getOrderId());
        assertEquals(Order.OrderStatus.CREATED, order.getStatus());
        assertEquals(products, order.getProducts());
    }

    @Test
    public void createOrderWithCart() {
        Order order = new Order(1, cart);
        assertEquals(1, order.getOrderId());
        assertEquals(Order.OrderStatus.CREATED, order.getStatus());
        assertEquals(cart.getProducts(), order.getProducts());
    }

    @Test
    public void placeOrder() {
        Order order = new Order(1, products);
        order.PlaceOrder();
        assertEquals(Order.OrderStatus.PENDING, order.getStatus());
    }

    @Test
    public void placeEmptyOrder() {
        Order order = new Order(1, new ArrayList<>());
        assertThrows(RuntimeException.class, order::PlaceOrder);
    }

    @Test
    public void processOrder() {
        Order order = new Order(1, products);
        order.PlaceOrder();
        order.ProcessOrder();
        assertEquals(Order.OrderStatus.PROCESSED, order.getStatus());
    }

    @Test
    public void processNonPlacedOrder() {
        Order order = new Order(1, products);
        assertThrows(RuntimeException.class, order::ProcessOrder);
    }

    @Test
    public void setProductsOnProcessedOrder() {
        Order order = new Order(1, products);
        order.PlaceOrder();
        order.ProcessOrder();
        assertThrows(RuntimeException.class, () -> order.setProducts(new ArrayList<>()));
    }
}