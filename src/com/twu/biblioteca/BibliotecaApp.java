package com.twu.biblioteca;

public class BibliotecaApp {
    static String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        LibraryInventory libraryInventory = new LibraryInventory();
        Book book = new Book(1, "Coffee shop", "Stormzy", 1999);
        Book book2 = new Book (2, "Everything is everything", "Lauren Hill", 2001);
        Book book3 = new Book(3, "Glasshouses", "Maribou State", 2019);
        libraryInventory.addBook(book);
        libraryInventory.addBook(book2);
        libraryInventory.addBook(book3);
        Menu menu = new Menu(libraryInventory);
        System.out.println(bibliotecaApp.getWelcomeMessage());
        System.out.println(menu.getMenuOptions());
    }
}
