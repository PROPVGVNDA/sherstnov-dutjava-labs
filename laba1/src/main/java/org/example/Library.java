package org.example;

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

    public void ListBooks()
    {
        if (books.isEmpty()) System.out.println("Library is empty");
        else {
          for (Book book : books) System.out.println(book.toString());
        }
    }

    private ArrayList<Book> books;
}
