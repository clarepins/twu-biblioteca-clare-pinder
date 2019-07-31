package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

import java.io.PrintStream;

public class MenuTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    PrintStream mockPrintStream;

    @Test
    public void shouldPrintMenuOptions() {
        LibraryInventory libraryInventory = new LibraryInventory(mockPrintStream);
        Menu menu = new Menu(libraryInventory, mockPrintStream);
        menu.printMenuOptions();
        String menuOptions = "\nBibliotecaApp menu - please select a number.\n1. List of books";
        verify(mockPrintStream).println(menuOptions);
    }
}