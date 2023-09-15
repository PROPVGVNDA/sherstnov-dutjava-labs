package org.example;

public class Book extends Item {
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public void borrowItem() {
        if(this.isBorrowed) throw new RuntimeException("Attempt to borrow a borrowed book");
        System.out.printf("Book \"%s\" written by %s - borrowed(ID: %s)%n", this.title, this.author, this.uniqueID);
        this.isBorrowed = true;
    }

    @Override
    public void returnItem() {
        if(!this.isBorrowed) throw new RuntimeException("Attempt to return an unborrowed book");
        System.out.printf("Book \"%s\" written by %s - returned(ID: %s)%n", this.title, this.author, this.uniqueID);
        this.isBorrowed = false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", uniqueID='" + uniqueID + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}