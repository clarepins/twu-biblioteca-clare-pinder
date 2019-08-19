package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Scanner;

public class BibliotecaApp {
    private PrintStream printStream;
    static String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    public BibliotecaApp(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printWelcomeMessage() {
        printStream.println(welcomeMessage);
    }

    public Menu setUpLibraryAndMenu() {
//        This method is untested because to test it would require runApp which is also untested
        LibraryInventory libraryInventory = new LibraryInventory();
        Book book = new Book(1, "Coffee shop", "Stormzy", 1999);
        Book book2 = new Book (2, "Everything is everything", "Lauren Hill", 2001);
        Book book3 = new Book(3, "Glasshouses", "Maribou State", 2019);
        Movie movie = new Movie(1, "The Wizard of Oz", "Victor Fleming", 1939, 10);
        Movie movie2 = new Movie(2, "Some Like it Hot", "Billy Wilder", 1959, 3);
        Movie movie3 = new Movie(3, "Psycho", "Alfred Hitchcock", 1960, 7);
        libraryInventory.addItem("book", book);
        libraryInventory.addItem("book", book2);
        libraryInventory.addItem("book", book3);
        libraryInventory.addItem("movie", movie);
        libraryInventory.addItem("movie", movie2);
        libraryInventory.addItem("movie", movie3);
        Menu menu = new Menu(libraryInventory);
        return menu;
    }

    public void runApp(Menu menu) {
//        I haven't tested this method. 1. I was finding it difficult to test for the
//        second printStream. I could possibly inject 2 different mock printStreams but that
//        would get quite messy. 2. partly because of that, I couldn't manage to end the
//        while loop in the test (option 4) which meant it was continually running.
        while(true) {
            printStream.println(menu.getMenuOptions());
            int menuChoice = receiveMenuChoice();
            printStream.println(menu.selectMenuOption(menuChoice));
        }
    }

    private int receiveMenuChoice() {
        Scanner userInput = new Scanner(System.in);
        return userInput.nextInt();
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(System.out);
        bibliotecaApp.printWelcomeMessage();
        Menu menu = bibliotecaApp.setUpLibraryAndMenu();
        bibliotecaApp.runApp(menu);
    }
}
