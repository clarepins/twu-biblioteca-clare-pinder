package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {
    private LibraryInventory libraryInventory;

    static String menuOptions = "\nBibliotecaApp menu - please select a number." +
            "\n1. List of books" +
            "\n2. Check out book" +
            "\n3. Check in book" +
            "\n4. Quit";

    public Menu(LibraryInventory libraryInventory) {
        this.libraryInventory = libraryInventory;
    }

    public String getMenuOptions() {
        return menuOptions;
    }

    public String selectMenuOption(int menuChoice) {
        String menuAction = "";
        switch (menuChoice) {
            case 1:
                menuAction = libraryInventory.getAvailableBooks();
            break;
            case 2:
                int bookRef = receiveBookRef();
                menuAction = libraryInventory.checkOutBook(bookRef);
            break;
            case 3:
                bookRef = receiveBookRef();
                menuAction = libraryInventory.checkInBook(bookRef);
            break;
            case 4:
                System.exit(0);
            break;
            default:
                menuAction = "Please select a valid option!";
        }
        return menuAction;
    }

    private int receiveBookRef() {
        System.out.println("Pls type in the book reference e.g. 2");
        Scanner userInput = new Scanner(System.in);
        return userInput.nextInt();
    }
}