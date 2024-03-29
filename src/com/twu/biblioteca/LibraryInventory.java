package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class LibraryInventory {
    private ArrayList<Book> availableBooks = new ArrayList();
    private ArrayList<Movie> availableMovies = new ArrayList();
    private ArrayList<Book> checkedOutBooks = new ArrayList();
    private ArrayList<Movie> checkedOutMovies = new ArrayList();

    public LibraryInventory() {
    }

    public void addItem(String itemType, LibraryItem libraryItem) {
        chooseAvailableList(itemType).add(libraryItem);
    }

    public String getAvailableItems(String itemType) {
        ArrayList<String> infoList = new ArrayList();
        ArrayList<LibraryItem> availableItems = chooseAvailableList(itemType);
        availableItems.forEach(item -> infoList.add(item.getInfo()));
        return String.join("\n", infoList);
    }

    public String checkOutItem(String itemType, int itemRef) {
        String checkOutMessage;
        ArrayList<LibraryItem> availableItems = chooseAvailableList(itemType);
        ArrayList<LibraryItem> checkedOutItems = chooseCheckedOutList(itemType);
        if (switchBookLists(itemRef, availableItems, checkedOutItems)) {
            checkOutMessage = "Thank you! Enjoy the item";
        } else {
            checkOutMessage = "Sorry, that item is not available";
        }
        return checkOutMessage;
    }

    public String checkInItem(String itemType, int itemRef) {
        String checkInMessage;
        ArrayList<LibraryItem> availableItems = chooseAvailableList(itemType);
        ArrayList<LibraryItem> checkedOutItems = chooseCheckedOutList(itemType);
        if (switchBookLists(itemRef, checkedOutItems, availableItems)) {
            checkInMessage = "Thank you for returning the item";
        } else {
            checkInMessage = "That is not a valid item to return";
        }
        return checkInMessage;
    }

    private Boolean switchBookLists(int itemRef, ArrayList<LibraryItem> leavingList, ArrayList<LibraryItem> joiningList) {
//        had to use weird Iterator syntax to avoid ConcurrentModificationException
        Iterator<LibraryItem> iterator = leavingList.iterator();
        Boolean successfulOperation = false;
        while (iterator.hasNext()) {
            LibraryItem libraryItem = iterator.next();

            if (libraryItem.getRef() == itemRef) {
                iterator.remove();
                joiningList.add(libraryItem);
                successfulOperation = true;
            }
        }
        return successfulOperation;
    }

    private ArrayList<LibraryItem> chooseAvailableList(String itemType) {
        ArrayList selectedArrayList = new ArrayList();
        switch (itemType) {
            case "book":
                selectedArrayList = availableBooks;
                break;
            case "movie":
                selectedArrayList = availableMovies;
        }
        return selectedArrayList;
    }

    private ArrayList<LibraryItem> chooseCheckedOutList(String itemType) {
        ArrayList selectedArrayList = new ArrayList();
        switch (itemType) {
            case "book":
                selectedArrayList = checkedOutBooks;
                break;
            case "movie":
                selectedArrayList = checkedOutMovies;
        }
        return selectedArrayList;
    }
}
