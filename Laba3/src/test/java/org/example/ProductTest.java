package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class ProductTest {
    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product(0, "Test", 10.0);
    }


    @Test
    void productWithIllegalName() {
        assertThrows(IllegalArgumentException.class, () -> new Product(0, "", 30.0));
        assertThrows(IllegalArgumentException.class, () -> product.setName(""));
    }

    @Test
    void productWithIllegalPrice() {
        assertThrows(IllegalArgumentException.class, () -> new Product(0, "Test", 0));
        assertThrows(IllegalArgumentException.class, () -> new Product(0, "Test", -5));
        assertThrows(IllegalArgumentException.class, () -> product.setPrice(0));
        assertThrows(IllegalArgumentException.class, () -> product.setPrice(-5));
    }
}