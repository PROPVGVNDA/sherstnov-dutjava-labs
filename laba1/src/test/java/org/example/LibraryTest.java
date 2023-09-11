package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryTest {
    private Library library;
    private Book book;

    @BeforeEach
    void setUp() {
        // Initialize a new Library instance before each test
        library = new Library();
        book = new Book("Test Book", "Test Author", "1234567890", 2023);
    }

    @Test
    void testAddBook() {
        library.AddBook(book);
        assertNotNull(library.FindBookByTitle("Test Book"));
    }

    @Test
    void testDeleteBookByIsbn() {
        library.AddBook(book);
        assertTrue(library.DeleteBookByIsbn("1234567890"));
        assertNull(library.FindBookByTitle("Test Book"));
    }

    @Test
    void testFindBookByTitle() {
        library.AddBook(book);
        assertEquals(book, library.FindBookByTitle("Test Book"));
        assertNull(library.FindBookByTitle("Non-existent Book"));
    }

    @Test
    void testListBooksEmptyLibrary() {
        library.ListBooks();
        assertEquals("Library is empty", library.ListBooks());
    }

    @Test
    void testListBooksNonEmptyLibrary() {
        library.AddBook(book);
        library.ListBooks();
        assertEquals("########\nTest Book by Test Author published in 2023. ISBN:1234567890\n########",  library.ListBooks());
    }

    @Test
    void testDeleteNonExistentBook() {
        assertFalse(library.DeleteBookByIsbn("Non-existent ISBN"));
    }

    @Test
    void testEmptyLibrary() {
        assertFalse(library.DeleteBookByIsbn("1234567890"));
        assertNull(library.FindBookByTitle("Non-existent Book"));
    }
}