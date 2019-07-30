package com.twu.biblioteca;

import org.junit.Test;
import java.io.PrintStream;
import static org.mockito.Mockito.*;
public class LibraryInventoryTest {

    @Test
    public void shouldAddBookToInventoryAndPrint() {
        PrintStream mockPrintStream = mock(PrintStream.class);
        LibraryInventory libraryInventory = new LibraryInventory(mockPrintStream);
        libraryInventory.addBook(1, "title1", "author1", 1990);
        libraryInventory.printAvailableBooks();
        verify(mockPrintStream).println("1, title1, author1, 1990");
    }
}
