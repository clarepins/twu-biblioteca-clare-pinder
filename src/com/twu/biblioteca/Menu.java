package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {
    private LibraryInventory libraryInventory;

    static String menuOptions = "\nBibliotecaApp menu - please select a number." +
            "\n1. List of books" +
            "\n2. Check out book" +
            "\n4. Quit";

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
        } else if (menuChoice == 2) {
            System.out.println("Pls type in the book reference e.g. 2");
            Scanner userInput = new Scanner(System.in);
            int bookRef = userInput.nextInt();
            menuAction = libraryInventory.checkOutBook(bookRef);
        } else if (menuChoice == 4) {
            System.exit(0);
        }
        return menuAction;

    }
}