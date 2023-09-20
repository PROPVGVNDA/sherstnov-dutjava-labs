package org.example.university.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void createWithIllegalTitle() {
        assertThrows(IllegalArgumentException.class, () -> new Book("", "Author"));
    }

    @Test
    void createWithIllegalAuthor() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Title", ""));
    }

    @Test
    void setIllegalAuthor() {
        Book book = new Book("Title", "Author");
        assertThrows(IllegalArgumentException.class, () -> book.setAuthor(""));
    }
}
