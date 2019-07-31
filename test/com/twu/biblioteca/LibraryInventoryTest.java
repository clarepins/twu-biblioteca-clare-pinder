package com.twu.biblioteca;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryInventoryTest {

    @Test
    public void shouldAddBooksToInventoryAndPrint() {
        Book book = new Book(1, "title1", "author1", 1990);
        Book book2 = new Book(2, "title2", "author2", 1990);
        LibraryInventory libraryInventory = new LibraryInventory();
        libraryInventory.addBook(book);
        libraryInventory.addBook(book2);
        String bookList = "1, title1, author1, 1990\n2, title2, author2, 1990";
        assertThat(libraryInventory.getAvailableBooks(), is(bookList));
    }


}
