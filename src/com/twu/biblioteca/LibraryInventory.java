package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class LibraryInventory {
    ArrayList<Book> availableBooks = new ArrayList();

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

    public String checkOutBook(int bookRef) { // had to use weird Iterator syntax to avoid ConcurrentModificationException
        Iterator<Book> iterator = availableBooks.iterator();
        String checkOutMessage = "";
        while (iterator.hasNext()) {
            Book book = iterator.next();

            if (book.getRef() == bookRef) { // maybe build a method that takes listToAddTo and listToRemoveFrom
                iterator.remove();
                checkOutMessage = "Thank you! Enjoy the book";
            }
        }
        return checkOutMessage;
    }
}
