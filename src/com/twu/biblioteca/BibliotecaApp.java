package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        LibraryInventory libraryInventory = new LibraryInventory(System.out);
        libraryInventory.addBook(1, "Coffee shop", "Stormzy", 1999 );
        libraryInventory.printAvailableBooks();
    }
}
