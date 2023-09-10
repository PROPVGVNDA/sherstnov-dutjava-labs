package org.example;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // Initialize a new Library instance before each test
        library = new Library();
    }

    @org.junit.jupiter.api.Test
    void testAddBook() {
        Book book = new Book("Test Book", "Test Author", "1234567890", 2023);
        library.AddBook(book);
        assertNotNull(library.FindBookByTitle("Test Book"));
    }

    @org.junit.jupiter.api.Test
    void testDeleteBookByIsbn() {
        Book book = new Book("Test Book", "Test Author", "1234567890", 2023);
        library.AddBook(book);
        assertTrue(library.DeleteBookByIsbn("1234567890"));
        assertNull(library.FindBookByTitle("Test Book"));
    }

    @org.junit.jupiter.api.Test
    void testFindBookByTitle() {
        Book book1 = new Book("Test Book", "Test Author", "1234567890", 2023);
        library.AddBook(book1);
        assertEquals(book1, library.FindBookByTitle("Test Book"));
        assertNull(library.FindBookByTitle("Non-existent Book"));
    }

    @org.junit.jupiter.api.Test
    void testListBooksEmptyLibrary() {
        library.ListBooks();
        assertEquals("Library is empty", library.ListBooks());
    }

    @org.junit.jupiter.api.Test
    void testListBooksNonEmptyLibrary() {
        Book book1 = new Book("Test Book", "Test Author", "1234567890", 2023);
        library.AddBook(book1);
        library.ListBooks();
        assertEquals("########\nTest Book by Test Author published in 2023. ISBN:1234567890\n########",  library.ListBooks());
    }

    @org.junit.jupiter.api.Test
    void testDeleteNonExistentBook() {
        assertFalse(library.DeleteBookByIsbn("Non-existent ISBN"));
    }

    @org.junit.jupiter.api.Test
    void testEmptyLibrary() {
        assertFalse(library.DeleteBookByIsbn("1234567890"));
        assertNull(library.FindBookByTitle("Non-existent Book"));
    }
}