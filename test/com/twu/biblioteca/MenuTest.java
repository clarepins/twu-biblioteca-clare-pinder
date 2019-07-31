package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {

    @Test
    public void shouldPrintMenuOptions() {
        LibraryInventory libraryInventory = new LibraryInventory();
        Menu menu = new Menu(libraryInventory);
        String menuOptions = "\nBibliotecaApp menu - please select a number.\n1. List of books";
        assertThat(menu.getMenuOptions(), is (menuOptions));

    }
}