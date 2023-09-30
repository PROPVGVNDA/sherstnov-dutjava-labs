package org.university.lab2;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Poter", "J.K. Rowling");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("Kobzar", "Taras Shevchenko");

        DVD dvd1 = new DVD("Breaking Bad Ep.1", 3000);
        DVD dvd2 = new DVD("Avatar", 10000);
        DVD dvd3 = new DVD("Bullet Train", 8000);

        Library library = new Library();

        Patron patron1 = new Patron("Mykyta");
        Patron patron2 = new Patron("Roman");
        Patron patron3 = new Patron("Ruslan");

        library.registerPatron(patron1);
        library.registerPatron(patron2);
        library.registerPatron(patron3);

        library.add(book1);
        library.add(book2);
        library.add(book3);
        library.add(dvd1);
        library.add(dvd2);
        library.add(dvd3);

        ListAvailableAndBorrowed(library);

        library.lendItem(patron1, book1);
        library.lendItem(patron2, dvd1);
        library.lendItem(patron3, book3);

        ListAvailableAndBorrowed(library);
        library.returnItem(patron1, book1);
    }

    private static void ListAvailableAndBorrowed(IManageable manageable)
    {
        System.out.println("--------");
        System.out.println("Available:");
        manageable.listAvailable();
        System.out.println("Borrowed:");
        manageable.listBorrowed();
        System.out.println("--------");
    }
}
