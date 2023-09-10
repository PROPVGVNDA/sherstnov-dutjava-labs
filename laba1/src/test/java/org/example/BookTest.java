package org.example;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @org.junit.jupiter.api.Test
    void testGetTitle() {
        Book book = new Book("Test Book", "Test Author", "1234567890", 2023);
        assertEquals("Test Book", book.getTitle());
    }

    @org.junit.jupiter.api.Test
    void testGetAuthor() {
        Book book = new Book("Test Book", "Test Author", "1234567890", 2023);
        assertEquals("Test Author", book.getAuthor());
    }

    @org.junit.jupiter.api.Test
    void testGetIsbn() {
        Book book = new Book("Test Book", "Test Author", "1234567890", 2023);
        assertEquals("1234567890", book.getIsbn());
    }

    @org.junit.jupiter.api.Test
    void testGetPublicationYear() {
        Book book = new Book("Test Book", "Test Author", "1234567890", 2023);
        assertEquals(2023, book.getPublicationYear());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Book book = new Book("Test Book", "Test Author", "1234567890", 2023);
        assertEquals("Test Book by Test Author published in 2023. ISBN:1234567890", book.toString());
    }

    @org.junit.jupiter.api.Test
    void testInvalidPublicationYear() {
        // Attempt to create a Book with an invalid publication year (earlier than 868 CE)
        assertThrows(IllegalArgumentException.class, () -> new Book("Invalid Book", "Invalid Author", "0000000000", 500));
    }
}