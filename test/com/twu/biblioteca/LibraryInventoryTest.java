package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryInventoryTest {
    Book book;
    Book book2;
    Movie movie;
    Movie movie2;
    LibraryInventory libraryInventory;

    @Before
        public void setUp() {
            book = new Book(1, "title1", "author1", 1990);
            book2 = new Book(2, "title2", "author2", 1990);
            movie = new Movie(1, "name1", "director1", 1990, 5);
            movie2 = new Movie(2, "name2", "director2", 1990, 8);
            libraryInventory = new LibraryInventory();
            libraryInventory.addItem("book", book);
            libraryInventory.addItem("book", book2);
            libraryInventory.addItem("movie", movie);
            libraryInventory.addItem("movie", movie2);
        }

    @Test
    public void shouldAddBooksItemsToInventory() {
        String bookList = "1, title1, author1, 1990\n2, title2, author2, 1990";
        assertThat(libraryInventory.getAvailableItems("book"), is(bookList));
    }

    @Test
    public void shouldCheckOutItem() {
        libraryInventory.checkOutBook(1);
        String bookList = "2, title2, author2, 1990";
        assertThat(libraryInventory.getAvailableItems("book"), is(bookList));
    }

    @Test
    public void shouldCheckInBook() {
        libraryInventory.checkOutBook(1);
        libraryInventory.checkInBook(1);
        String bookList = "2, title2, author2, 1990\n1, title1, author1, 1990";
        assertThat(libraryInventory.getAvailableItems("book"), is(bookList));
    }

    @Test
    public void shouldReturnMessageWhenCheckOutNonExistentBook() {
        String message = "Sorry, that book is not available";
        assertThat(libraryInventory.checkOutBook(3), is(message));
    }

    @Test
    public void shouldReturnMessageWhenCheckInNonExistentBook() {
        String message = "That is not a valid book to return";
        assertThat(libraryInventory.checkInBook(1), is(message));
    }

}
