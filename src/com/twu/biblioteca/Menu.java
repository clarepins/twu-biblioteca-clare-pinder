package com.twu.biblioteca;

public class Menu {
    private LibraryInventory libraryInventory;

    static String menuOptions = "\nBibliotecaApp menu - please select a number.\n1. List of books";

    public Menu(LibraryInventory libraryInventory) {
        this.libraryInventory = libraryInventory;
    }

    public String getMenuOptions() {
        return menuOptions;
    }

    public String selectMenuOption(int menuChoice) {
        String menuAction = "";
        if (menuChoice == 1) {
            menuAction = libraryInventory.getAvailableBooks();
        }
        return menuAction;

    }
}