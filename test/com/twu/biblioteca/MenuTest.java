package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testIn;
    LibraryInventory libraryInventory;
    Menu menu;

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() {
        libraryInventory = new LibraryInventory();
        menu = new Menu(libraryInventory);
        Book book = new Book(1, "testTitle", "testAuthor", 1990);
        Book book2 = new Book(2, "testTitle", "testAuthor", 1990);
        Movie movie = new Movie(1, "testName", "testDirector", 1990, 7);
        Movie movie2 = new Movie(2, "testName", "testDirector", 1990, 10);
        libraryInventory.addItem("book", book);
        libraryInventory.addItem("book", book2);
        libraryInventory.addItem("movie", movie);
        libraryInventory.addItem("movie", movie2);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }

    @Test
    public void shouldGetMenuOptions() {
        String menuOptions = "\nBibliotecaApp menu - please select a number." +
                "\n1. List of books" +
                "\n2. List of movies" +
                "\n3. Check out book" +
                "\n4. Check in book" +
                "\n5. Check out movie" +
                "\n6. Check in movie" +
                "\n7. Quit";
        assertThat(menu.getMenuOptions(), is(menuOptions));
    }

    @Test
    public void shouldGetAvailableBooksWhenOption1IsSelected() {
        String availableBooks = "1, testTitle, testAuthor, 1990\n2, testTitle, testAuthor, 1990";
        assertThat(menu.selectMenuOption(1), is(availableBooks));
    }

    @Test
    public void shouldGetAvailableMoviesWhenOption2IsSelected() {
        String availableMovies = "1, testName, testDirector, 1990, Rating: 7\n2, testName, testDirector, 1990, Rating: 10";
        assertThat(menu.selectMenuOption(2), is(availableMovies));
    }

    @Test
    public void shouldQuitWhenOption7IsSelected() {
        exit.expectSystemExitWithStatus(0);
        menu.selectMenuOption(7);
    }

//    @Test
//    public void shouldCheckOutBookWhenOption2IsSelected() {
//        String userInput = "1";
//        provideInput(userInput);
//        assertThat(menu.selectMenuOption(2), is("Thank you! Enjoy the item"));
//    }
//
//    @Test
//    public void shouldCheckInBookWhenOption3IsSelected() {
//        String userInput = "1";
//        provideInput(userInput);
//        menu.selectMenuOption(2);
//
//        String userInput2 = "1";
//        provideInput(userInput2);
//        assertThat(menu.selectMenuOption(3), is("Thank you for returning the item"));
//    }
}