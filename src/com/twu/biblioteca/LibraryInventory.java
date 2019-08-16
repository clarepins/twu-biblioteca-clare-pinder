package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class LibraryInventory {
    private ArrayList<LibraryItem> availableBooks = new ArrayList();
    private ArrayList<LibraryItem> availableMovies = new ArrayList();
    private ArrayList<LibraryItem> checkedOutBooks = new ArrayList();

    public LibraryInventory() {
    }

    public void addItem(String itemType, LibraryItem libraryItem) {
        switch (itemType) {
            case "book":
                availableBooks.add(libraryItem);
            break;
            case "movie":
                availableMovies.add(libraryItem);
        }
    }

    public String getAvailableItems(String itemType) {
        ArrayList<String> infoList = new ArrayList();
        ArrayList<LibraryItem> availableItems = new ArrayList();
        switch (itemType) {
            case "book": availableItems = availableBooks; break;
            case "movie": availableItems = availableMovies;
        }
        availableItems.forEach(item -> infoList.add(item.getInfo()));
        return String.join("\n", infoList);
    }

    public String checkOutBook(int bookRef) {
        String checkOutMessage = "";
        if (switchBookLists(bookRef, availableBooks, checkedOutBooks)) {
            checkOutMessage = "Thank you! Enjoy the book";
        } else {
            checkOutMessage = "Sorry, that book is not available";
        }
        return checkOutMessage;
    }

    public String checkInBook(int bookRef) {
        String checkInMessage = "";
        if (switchBookLists(bookRef, checkedOutBooks, availableBooks)) {
            checkInMessage = "Thank you for returning the book";
        } else {
            checkInMessage = "That is not a valid book to return";
        }
        return checkInMessage;
    }

    private Boolean switchBookLists(int bookRef, ArrayList<LibraryItem> leavingList, ArrayList<LibraryItem> joiningList) {
//        had to use weird Iterator syntax to avoid ConcurrentModificationException
        Iterator<LibraryItem> iterator = leavingList.iterator();
        Boolean successfulOperation = false;
        while (iterator.hasNext()) {
            LibraryItem libraryItem = iterator.next();

            if (libraryItem.getRef() == bookRef) {
                iterator.remove();
                joiningList.add(libraryItem);
                successfulOperation = true;
            }
        }
        return successfulOperation;
    }

}
