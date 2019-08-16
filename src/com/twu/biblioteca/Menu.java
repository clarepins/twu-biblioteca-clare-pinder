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
                menuAction = libraryInventory.getAvailableItems("book");
            break;
            case 2:
                int itemRef = receiveBookRef();
                menuAction = libraryInventory.checkOutItem("book", itemRef);
            break;
            case 3:
                itemRef = receiveBookRef();
                menuAction = libraryInventory.checkInBook(itemRef);
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