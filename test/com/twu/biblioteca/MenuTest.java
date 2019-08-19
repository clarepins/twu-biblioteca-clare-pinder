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
        libraryInventory.addItem("book", book);
        libraryInventory.addItem("book", book2);
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
                "\n2. Check out book" +
                "\n3. Check in book" +
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
        provideInput(userInput);
        assertThat(menu.selectMenuOption(2), is("Thank you! Enjoy the item"));
    }

    @Test
    public void shouldCheckInBookWhenOption3IsSelected() {
        String userInput = "1";
        provideInput(userInput);
        menu.selectMenuOption(2);

        String userInput2 = "1";
        provideInput(userInput2);
        assertThat(menu.selectMenuOption(3), is("Thank you for returning the item"));
    }
}