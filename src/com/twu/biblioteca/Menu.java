package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {
    private LibraryInventory libraryInventory;

    static String menuOptions = "\nBibliotecaApp menu - please select a number." +
            "\n1. List of books" +
            "\n2. List of movies" +
            "\n3. Check out book" +
            "\n4. Check in book" +
            "\n5. Check out movie" +
            "\n6. Check in movie" +
            "\n7. Quit";

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
                menuAction = libraryInventory.getAvailableItems("movie");
            break;
            case 3:
                int itemRef = receiveBookRef();
                menuAction = libraryInventory.checkOutItem("book", itemRef);
            break;
            case 4:
                itemRef = receiveBookRef();
                menuAction = libraryInventory.checkInItem("book", itemRef);
            break;
            case 7:
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