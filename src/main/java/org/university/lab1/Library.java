package org.university.lab1;

import java.util.ArrayList;

public class Library
{
    public Library() {
        this.books = new ArrayList<>();
    }
    public Library(ArrayList<Book> books)
    {
        this.books = books;
    }

    public void AddBook(Book book)
    {
        books.add(book);
    }

    public boolean DeleteBookByIsbn(String isbn)
    {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    public Book FindBookByTitle(String title)
    {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public String ListBooks()
    {
        if (books.isEmpty()) return "Library is empty";
        StringBuilder bookList = new StringBuilder("########\n");
        for (Book book : books) {
            bookList.append(book.toString()).append("\n");
        }
        bookList.append("########");
        return bookList.toString();
    }

    private ArrayList<Book> books;
}
