package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        libraryInventory.addBook(book);
        libraryInventory.addBook(book2);
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }

    @Test
    public void shouldGetMenuOptions() {
        String menuOptions = "\nBibliotecaApp menu - please select a number." +
                "\n1. List of books" +
                "\n2. Check out book" +
                "\n4. Quit";
        assertThat(menu.getMenuOptions(), is(menuOptions));
    }

    @Test
    public void shouldGetAvailableBooksWhenOption1IsSelected() {
        String availableBooks = "1, testTitle, testAuthor, 1990\n2, testTitle, testAuthor, 1990";
        assertThat(menu.selectMenuOption(1), is(availableBooks));
    }

    @Test
    public void shouldQuitWhenOption4IsSelected() {
        exit.expectSystemExitWithStatus(0);
        menu.selectMenuOption(4);
    }

    @Test
    public void shouldCheckOutBookWhenOption2IsSelected() {
        String userInput = "1";
        testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        assertThat(menu.selectMenuOption(2), is("Thank you! Enjoy the book"));
    }
}