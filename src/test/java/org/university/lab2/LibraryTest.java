package org.university.lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.university.lab2.Book;
import org.university.lab2.Library;
import org.university.lab2.Patron;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Book book;
    private Patron patron;
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
        book = new Book("Ttile", "Author");
        patron = new Patron("Patron");
    }

    @Test
    void addItem() {
        library.add(book);
        assertEquals(library.getItems().get(0), book);
    }

    @Test
    void removeItem() {
        library.add(book);
        library.remove(book);
        assertTrue(library.getItems().isEmpty());
    }

    @Test
    void registerPatron() {
        library.registerPatron(patron);
        assertEquals(library.getPatrons().get(0), patron);
    }

    @Test
    void lendItem() {
        library.add(book);
        library.registerPatron(patron);
        library.lendItem(patron, book);
        assertEquals(patron.getBorrowedItems().get(0), book);
        assertTrue(library.getItems().get(0).isBorrowed);
    }

    @Test
    void lendNonOwnedItem() {
        library.registerPatron(patron);
        assertThrows(RuntimeException.class, () -> library.lendItem(patron, book));
    }

    @Test
    void lendItemToNonRegisteredPatron() {
        library.add(book);
        assertThrows(RuntimeException.class, () -> library.lendItem(patron, book));
    }

    @Test
    void lendSameItem() {
        library.add(book);
        library.registerPatron(patron);
        library.lendItem(patron, book);
        assertThrows(RuntimeException.class, () -> library.lendItem(patron, book));
    }

    @Test
    void returnItem() {
        library.add(book);
        library.registerPatron(patron);
        library.lendItem(patron, book);
        library.returnItem(patron, book);
        assertFalse(library.getItems().get(0).isBorrowed);
    }

    @Test
    void returnNonOwnedItem() {
        library.registerPatron(patron);
        assertThrows(RuntimeException.class, () -> library.returnItem(patron, book));
    }

    @Test
    void returnItemToNonRegisteredPatron() {
        library.add(book);
        assertThrows(RuntimeException.class, () -> library.returnItem(patron, book));
    }

    @Test
    void returnSameItem() {
        library.add(book);
        library.registerPatron(patron);
        library.lendItem(patron, book);
        library.returnItem(patron, book);
        assertThrows(RuntimeException.class, () -> library.returnItem(patron, book));
    }
}