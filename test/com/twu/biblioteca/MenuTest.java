package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuTest {
    LibraryInventory libraryInventory;

    @Before
    public void setUp() {
        libraryInventory = new LibraryInventory();
    }


    @Test
    public void shouldGetMenuOptions() {
        LibraryInventory libraryInventory = new LibraryInventory();
        Menu menu = new Menu(libraryInventory);
        String menuOptions = "\nBibliotecaApp menu - please select a number.\n1. List of books";
        assertThat(menu.getMenuOptions(), is (menuOptions));
    }

    @Test
    public void shouldGetAvailableBooksWhenOption1IsSelected() {
        Book book = new Book(1, "testTitle", "testAuthor", 1990);
        Book book2 = new Book(2, "testTitle", "testAuthor", 1990);
        libraryInventory.addBook(book);
        libraryInventory.addBook(book2);
        Menu menu = new Menu(libraryInventory);
        String availableBooks = "1, testTitle, testAuthor, 1990\n2, testTitle, testAuthor, 1990";
        String output = menu.selectMenuOption(1);
        assertThat(output, is(availableBooks));
    }
}