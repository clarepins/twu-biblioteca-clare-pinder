package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class LibraryInventory {
    ArrayList<Book> availableBooks = new ArrayList();
    ArrayList<Book> checkedOutBooks = new ArrayList();

    public LibraryInventory() {
    }

    public void addBook(Book book) {
        availableBooks.add(book);
    }

    public String getAvailableBooks() {
        ArrayList<String> bookInfoList = new ArrayList();
        availableBooks.forEach(book -> bookInfoList.add(book.getBookInfo()));
        return String.join("\n", bookInfoList);
    }

    public String checkOutBook(int bookRef) {
        String checkOutMessage = "";
        if (switchBookLists(bookRef, availableBooks, checkedOutBooks)) {
            checkOutMessage = "Thank you! Enjoy the book";
        }
        return checkOutMessage;
    }

    public String checkInBook(int bookRef) {
        String checkInMessage = "";
        if (switchBookLists(bookRef, checkedOutBooks, availableBooks)) {
            checkInMessage = "Thank you for returning the book";
        }
        return checkInMessage;
    }

    private Boolean switchBookLists(int bookRef, ArrayList<Book> leavingList, ArrayList<Book> joiningList) {
//        had to use weird Iterator syntax to avoid ConcurrentModificationException
        Iterator<Book> iterator = leavingList.iterator();
        Boolean successfulOperation = false;
        while (iterator.hasNext()) {
            Book book = iterator.next();

            if (book.getRef() == bookRef) {
                iterator.remove();
                joiningList.add(book);
                successfulOperation = true;
            }
        }
        return successfulOperation;
    }
}
