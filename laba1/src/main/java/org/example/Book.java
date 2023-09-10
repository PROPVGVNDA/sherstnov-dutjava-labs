package org.example;

public class Book {
    public Book(String title, String author, String isbn, Integer publicationYear)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public Integer getPublicationYear()
    {
        return publicationYear;
    }

    @Override
    public String toString()
    {
        return title + " by " + author + " published in " + publicationYear + ". ISBN:" + isbn;
    }
    private String title;

    private String author;
    private String isbn;
    private Integer publicationYear;
}
