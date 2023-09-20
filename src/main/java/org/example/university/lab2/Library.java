package org.example.university.lab2;

import java.util.ArrayList;
import java.util.List;

public class Library implements IManageable {
    private ArrayList<Item> items;
    private ArrayList<Patron> patrons;

    public List<Item> getItems() {
        return items;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public Library() {
        this.items = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public void listAvailable() {
        for (Item item : items)
        {
            if (!item.isBorrowed) System.out.println(item);
        }
    }

    @Override
    public void listBorrowed() {
        for (Item item : items)
        {
            if (item.isBorrowed) System.out.println(item);
        }
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        if (!items.contains(item)) throw new RuntimeException("Attempt to borrow an item not present in the library");
        if (!patrons.contains(patron)) throw new RuntimeException("Attempt to borrow an item from a non-registered patron");
        if (item.isBorrowed) throw new RuntimeException("Attempt to borrow a borrowed item");
        patron.borrowItem(item);
    }

    public void returnItem(Patron patron, Item item) {
        if (!items.contains(item)) throw new RuntimeException("Attempt to return an item not registered in the library");
        if (!patrons.contains(patron)) throw new RuntimeException("Attempt to return an item from a non-registered patron");
        if (!item.isBorrowed) throw new RuntimeException("Attempt to return a non-borrowed item");
        patron.returnItem(item);
    }
}

