package org.university.lab7;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Product product = new Product(1, "Phone", 500.0, 10);
    Map<Product, Integer> orderDetails = new HashMap<>() {{
        put(product, 2);
    }};

    @Test
    void testValidOrderCreation() {
        Order order = new Order(1, 1, orderDetails);
        assertEquals(1, order.getId());
        assertEquals(1, order.getUserId());
        assertEquals(1000.0, order.getTotalPrice(), 0.001);
    }

    @Test
    void testOrderWithNullDetails() {
        assertThrows(IllegalArgumentException.class, () -> new Order(1, 1, null));
    }

    @Test
    void testOrderWithEmptyDetails() {
        assertThrows(IllegalArgumentException.class, () -> new Order(1, 1, new HashMap<>()));
    }

    @Test
    void testOrderWithNegativeProductQuantity() {
        Map<Product, Integer> wrongOrderDetails = new HashMap<>() {{
            put(product, -5);
        }};
        assertThrows(IllegalArgumentException.class, () -> new Order(1, 1, wrongOrderDetails));
    }

    @Test
    void testSetNullOrderId() {
        Order order = new Order(1, 1, orderDetails);
        assertThrows(IllegalArgumentException.class, () -> order.setId(null));
    }

    @Test
    void testSetNullUserId() {
        Order order = new Order(1, 1, orderDetails);
        assertThrows(IllegalArgumentException.class, () -> order.setUserId(null));
    }
}
