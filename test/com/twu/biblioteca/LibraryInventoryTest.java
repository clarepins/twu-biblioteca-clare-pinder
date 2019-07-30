package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.PrintStream;
import static org.mockito.Mockito.*;
public class LibraryInventoryTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    PrintStream mockPrintStream;

    @Test
    public void shouldAddBooksToInventoryAndPrint() {
        LibraryInventory libraryInventory = new LibraryInventory(mockPrintStream);
        libraryInventory.addBook(1, "title1", "author1", 1990);
        libraryInventory.addBook(2, "title2", "author2", 1990);
        libraryInventory.printAvailableBooks();
        verify(mockPrintStream).println("1, title1, author1, 1990\n2, title2, author2, 1990");
    }


}
