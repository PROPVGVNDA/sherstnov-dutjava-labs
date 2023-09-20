package org.example.university.lab1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

    private Book book;
    @BeforeEach
    public void setUp()
    {
        this.book = new Book("Test Book", "Test Author", "1234567890", 2023);
    }

    @Test
    void testGetTitle() {
        assertEquals("Test Book", book.getTitle());
    }

    @Test
    void testGetAuthor() {
        assertEquals("Test Author", book.getAuthor());
    }

    @Test
    void testGetIsbn() {
        assertEquals("1234567890", book.getIsbn());
    }

    @Test
    void testGetPublicationYear() {
        assertEquals(2023, book.getPublicationYear());
    }

    @Test
    void testToString() {
        assertEquals("Test Book by Test Author published in 2023. ISBN:1234567890", book.toString());
    }

    @Test
    void testInvalidPublicationYear() {
        // Attempt to create a Book with an invalid publication year (earlier than 868 CE)
        assertThrows(IllegalArgumentException.class, () -> new Book("Invalid Book", "Invalid Author", "0000000000", 500));
    }
}
