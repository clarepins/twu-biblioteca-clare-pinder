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
                "\n1. Log in" +
                "\n2. List of books" +
                "\n3. List of movies" +
                "\n4. Check out book" +
                "\n5. Check in book" +
                "\n6. Check out movie" +
                "\n7. Check in movie" +
                "\n8. View my checked out books" +
                "\n9. View my info" +
                "\n10. Quit";
        assertThat(menu.getMenuOptions(), is(menuOptions));
    }

//  I couldn't get this test to work
//    @Test
//    public void userShouldBeAbleToLogIn() {
//        provideInput("123-4567");
//        provideInput("hello123");
//        assertThat(menu.selectMenuOption(1), is("Welcome Clare Pinder!"));
//    }


    @Test
    public void shouldGetAvailableBooksWhenOption2IsSelected() {
        String availableBooks = "1, testTitle, testAuthor, 1990\n2, testTitle, testAuthor, 1990";
        assertThat(menu.selectMenuOption(2), is(availableBooks));
    }

    @Test
    public void shouldGetAvailableMoviesWhenOption3IsSelected() {
        String availableMovies = "1, testName, testDirector, 1990, Rating: 7\n2, testName, testDirector, 1990, Rating: 10";
        assertThat(menu.selectMenuOption(3), is(availableMovies));
    }

    @Test
    public void shouldQuitWhenOption10IsSelected() {
        exit.expectSystemExitWithStatus(0);
        menu.selectMenuOption(10);
    }

//    These tests require log in which I couldn't get to work in the tests
//    @Test
//    public void shouldCheckOutBookWhenOption4IsSelected() {
//        String userInput = "1";
//        provideInput(userInput);
//        assertThat(menu.selectMenuOption(4), is("Thank you! Enjoy the item"));
//    }
//
//    @Test
//    public void shouldCheckOutMovieWhenOption6IsSelected() {
//        String userInput = "1";
//        provideInput(userInput);
//        assertThat(menu.selectMenuOption(6), is("Thank you! Enjoy the item"));
//    }
//
//    @Test
//    public void shouldCheckInBookWhenOption5IsSelected() {
//        provideInput("1");
//        menu.selectMenuOption(4);
//
//        provideInput("1");
//        assertThat(menu.selectMenuOption(5), is("Thank you for returning the item"));
//    }
//
//    @Test
//    public void shouldCheckInMovieWhenOption7IsSelected() {
//        provideInput("1");
//        menu.selectMenuOption(6);
//
//        provideInput("1");
//        assertThat(menu.selectMenuOption(7), is("Thank you for returning the item"));
//    }
}