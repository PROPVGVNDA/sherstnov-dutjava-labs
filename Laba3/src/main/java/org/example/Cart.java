package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Cart {
    private ArrayList<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product... products)
    {
        this.products.addAll(Arrays.asList(products));
    }

    public void removeProduct(Product product)
    {
        boolean result = products.remove(product);
        if (!result) throw new RuntimeException("Attempt to remove product not present in a cart");
    }
}
