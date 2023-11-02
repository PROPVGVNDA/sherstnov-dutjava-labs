package org.university.lab7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testValidProductCreation() {
        Product product = new Product(1, "Phone", 500.0, 10);
        assertEquals(1, product.getId());
        assertEquals("Phone", product.getName());
        assertEquals(500.0, product.getPrice());
        assertEquals(10, product.getStock());
    }

    @Test
    void testSetNegativePrice() {
        Product product = new Product(1, "Phone", 500.0, 10);
        assertThrows(IllegalArgumentException.class, () -> product.setPrice(-50.0));
    }

    @Test
    void testSetNegativeStock() {
        Product product = new Product(1, "Phone", 500.0, 10);
        assertThrows(IllegalArgumentException.class, () -> product.setStock(-5));
    }

    @Test
    void testSetNullProductName() {
        Product product = new Product(1, "Phone", 500.0, 10);
        assertThrows(IllegalArgumentException.class, () -> product.setName(null));
    }
}
