package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        LibraryInventory libraryInventory = new LibraryInventory(System.out);
        libraryInventory.addBook(1, "Coffee shop", "Stormzy", 1999 );
        libraryInventory.addBook(2, "Everything is everything", "Lauren Hill", 2001 );
        libraryInventory.addBook(3, "Glasshouses", "Maribou State", 2019 );
        libraryInventory.printAvailableBooks();
        Menu menu = new Menu(libraryInventory, System.out);
        menu.printMenuOptions();
    }
}
