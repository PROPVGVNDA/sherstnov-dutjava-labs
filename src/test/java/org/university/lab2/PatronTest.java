package org.university.lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.university.lab2.Book;
import org.university.lab2.Patron;

import static org.junit.jupiter.api.Assertions.*;

class PatronTest {

    private Book book;
    private Patron patron;

    @BeforeEach
    void setUp() {
        book = new Book("Ttile", "Author");
        patron = new Patron("Patron");
    }

    @Test
    void borrowItem() {
        patron.borrowItem(book);
        assertEquals(patron.getBorrowedItems().get(0), book);
    }

    @Test
    void returnNonOwnedItem() {
        assertThrows(RuntimeException.class, () -> patron.returnItem(book));
    }

    @Test
    void returnItem() {
        patron.borrowItem(book);
        patron.returnItem(book);
        assertTrue(patron.getBorrowedItems().isEmpty());
    }
}
