package com.twu.biblioteca;

import com.twu.biblioteca.LibraryInventory;

import java.io.PrintStream;

public class Menu {
    private LibraryInventory libraryInventory;
    private PrintStream printStream;

    static String menuOptions = "\nBibliotecaApp menu - please select a number.\n1. List of books";

    public Menu(LibraryInventory libraryInventory, PrintStream printStream) {
        this.libraryInventory = libraryInventory;
        this.printStream = printStream;
    }

    public void printMenuOptions() {
        printStream.println(menuOptions);
    }
}