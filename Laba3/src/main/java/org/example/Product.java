package org.example;

public class Product {
    private int id;
    private String name;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) throw new IllegalArgumentException("Argument name cannot be empty");
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) throw new IllegalArgumentException("Argument price cannot be zero or less");
        this.price = price;
    }

    public Product(int id, String name, double price) {
        if (name.isEmpty()) throw new IllegalArgumentException("Argument name cannot be empty");
        if (price <= 0) throw new IllegalArgumentException("Argument price cannot be zero or less");
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
