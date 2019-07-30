package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class LibraryInventory {
    ArrayList<Book> availableBooks = new ArrayList();
    private PrintStream printStream;

    public LibraryInventory(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void addBook(int ref, String title, String author, int publicationDate) {
        Book book = new Book(ref, title, author, publicationDate);
        availableBooks.add(book);
    }

    public void printAvailableBooks() {
        ArrayList<String> bookInfoList = new ArrayList();
        availableBooks.forEach(book -> bookInfoList.add(book.getBookInfo()));
        String output = String.join("\n", bookInfoList);
        printStream.println(output);
    }
}