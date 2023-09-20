package org.example.university.lab2;

import java.util.ArrayList;

public interface IManageable {
    void add(Item item);
    void remove(Item item);
    void listAvailable();
    void listBorrowed();
}