package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryInventoryTest {
    Book book;
    Book book2;
    LibraryInventory libraryInventory;

    @Before
        public void setUp() {
            book = new Book(1, "title1", "author1", 1990);
            book2 = new Book(2, "title2", "author2", 1990);
            libraryInventory = new LibraryInventory();
            libraryInventory.addBook(book);
            libraryInventory.addBook(book2);
        }


    @Test
    public void shouldAddBooksToInventory() {
        String bookList = "1, title1, author1, 1990\n2, title2, author2, 1990";
        assertThat(libraryInventory.getAvailableBooks(), is(bookList));
    }

    @Test
    public void shouldCheckOutBook() {
        libraryInventory.checkOutBook(1);
        String bookList = "2, title2, author2, 1990";
        assertThat(libraryInventory.getAvailableBooks(), is(bookList));
    }

    @Test
    public void shouldCheckInBook() {
        libraryInventory.checkOutBook(1);
        libraryInventory.checkInBook(1);
        String bookList = "2, title2, author2, 1990\n1, title1, author1, 1990";
        assertThat(libraryInventory.getAvailableBooks(), is(bookList));


    }


}
