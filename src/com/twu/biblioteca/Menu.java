package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {
    private LibraryInventory libraryInventory;

    static String menuOptions = "\nBibliotecaApp menu - please select a number." +
            "\n1. Log in" +
            "\n2. List of books" +
            "\n3. List of movies" +
            "\n4. Check out book" +
            "\n5. Check in book" +
            "\n6. Check out movie" +
            "\n7. Check in movie" +
            "\n8. View my checked out books" +
            "\n9. view my info" +
            "\n10. Quit";

    public Menu(LibraryInventory libraryInventory) {
        this.libraryInventory = libraryInventory;
    }

    public String getMenuOptions() {
        return menuOptions;
    }

    public String selectMenuOption(int menuChoice) {
        String menuAction = "";
        switch (menuChoice) {
            case 2:
                menuAction = libraryInventory.getAvailableItems("book");
            break;
            case 3:
                menuAction = libraryInventory.getAvailableItems("movie");
            break;
            case 4:
                int itemRef = receiveItemRef();
                menuAction = libraryInventory.checkOutItem("book", itemRef);
            break;
            case 5:
                itemRef = receiveItemRef();
                menuAction = libraryInventory.checkInItem("book", itemRef);
            break;
            case 6:
                itemRef = receiveItemRef();
                menuAction = libraryInventory.checkOutItem("movie", itemRef);
                break;
            case 7:
                itemRef = receiveItemRef();
                menuAction = libraryInventory.checkInItem("movie", itemRef);
                break;
            case 10:
                System.exit(0);
            break;
            default:
                menuAction = "Please select a valid option!";
        }
        return menuAction;
    }

    private int receiveItemRef() {
        System.out.println("Pls type in the item reference e.g. 2");
        Scanner userInput = new Scanner(System.in);
        return userInput.nextInt();
    }
}