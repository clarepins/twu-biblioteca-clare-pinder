package com.twu.biblioteca;

import java.util.ArrayList;

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
}
