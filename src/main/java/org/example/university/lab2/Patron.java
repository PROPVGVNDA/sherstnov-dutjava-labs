package org.example.university.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Patron {
    private String name;
    private String ID;

    private List<Item> borrowedItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<Item> getBorrowedItems() {
        return borrowedItems;
    }

    public void setBorrowedItems(List<Item> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    public Patron(String name) {
        this.name = name;
        this.ID = UUID.randomUUID().toString();
        this.borrowedItems = new ArrayList<>();
    }

    public void borrowItem(Item item) {
        borrowedItems.add(item);
        item.borrowItem();
    }

    public void returnItem(Item item) {
        boolean result = borrowedItems.remove(item);
        if (!result) throw new RuntimeException("Attempt to return item which is not in patron's possession");
        item.returnItem();
    }
}
