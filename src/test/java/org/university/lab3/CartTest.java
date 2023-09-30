package org.university.lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.university.lab3.Cart;
import org.university.lab3.Product;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    @Test
    void addItems() {
        Product product1 = new Product(0, "Test0", 10);
        Product product2 = new Product(1, "Test1", 50.99);
        cart.addProduct(product1, product2);
        ArrayList<Product> productsInCart = cart.getProducts();
        assertTrue(productsInCart.contains(product1));
        assertTrue(productsInCart.contains(product2));
    }

    @Test
    void removeExistingItem() {
        Product product1 = new Product(0, "Test0", 10);
        cart.addProduct(product1);
        cart.removeProduct(product1);
        ArrayList<Product> productsInCart = cart.getProducts();
        assertFalse(productsInCart.contains(product1));
    }

    @Test
    void removeNonExistingItem() {
        Product product1 = new Product(0, "Test0", 10);
        assertThrows(RuntimeException.class, () -> cart.removeProduct(product1));
    }
}
