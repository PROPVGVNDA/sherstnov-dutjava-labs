package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library implements IManageable {
    private List<Item> items;
    private List<Patron> patrons;

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
        patron.borrowItem(item);
    }

    public void returnItem(Patron patron, Item item) {
        patron.returnItem(item);
    }
}

