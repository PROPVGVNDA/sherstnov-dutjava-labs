package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("A Tale of Two Cities", "Charles Dickens", "9781853260391", 	1999);
        Book book2 = new Book("The Little Prince", "Antoine de Saint-Exupéry", "9781853261589", 	1998);
        Book book3 = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", "9781408855652", 	2014);
        Book book4 = new Book("And Then There Were None", "Agatha Christie", "9780008123208", 	2015);
        Book book5 = new Book("Dream of the Red Chamber (紅樓夢)", "Cao Xueqin", " 9780385093798", 	1958);
        Library library = new Library();
        library.ListBooks();
        library.AddBook(book1);
        library.AddBook(book2);
        library.AddBook(book3);
        library.ListBooks();
        library.DeleteBookByIsbn(book2.getIsbn());
        library.ListBooks();
    }
}