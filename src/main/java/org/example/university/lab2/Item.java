package org.example.university.lab2;

import java.util.UUID;
public abstract class Item {
    protected String title;
    protected String uniqueID;
    protected boolean isBorrowed;

    public Item(String title) {
        if (title.isEmpty()) throw new IllegalArgumentException("Title length cannot be 0");
        this.title = title;
        this.uniqueID = UUID.randomUUID().toString();
        this.isBorrowed = false;
    }

    public abstract void borrowItem();
    public abstract void returnItem();
}
