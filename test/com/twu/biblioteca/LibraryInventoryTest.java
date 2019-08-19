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
    public void shouldAddBooksToInventory() {
        String bookList = "1, title1, author1, 1990\n2, title2, author2, 1990";
        assertThat(libraryInventory.getAvailableItems("book"), is(bookList));
    }

    @Test
    public void shouldAddMoviesToInventory() {
        String movieList = "1, name1, director1, 1990, Rating: 5\n2, name2, director2, 1990, Rating: 8";
        assertThat(libraryInventory.getAvailableItems("movie"), is(movieList));
    }

    @Test
    public void shouldCheckOutBook() {
        libraryInventory.checkOutItem("book", 1);
        String bookList = "2, title2, author2, 1990";
        assertThat(libraryInventory.getAvailableItems("book"), is(bookList));
    }

    @Test
    public void shouldCheckOutMovie() {
        libraryInventory.checkOutItem("movie", 1);
        String movieList = "2, name2, director2, 1990, Rating: 8";
        assertThat(libraryInventory.getAvailableItems("movie"), is(movieList));
    }

    @Test
    public void shouldCheckInBook() {
        libraryInventory.checkOutItem("book", 1);
        libraryInventory.checkInItem("book", 1);
        String bookList = "2, title2, author2, 1990\n1, title1, author1, 1990";
        assertThat(libraryInventory.getAvailableItems("book"), is(bookList));
    }

    @Test
    public void shouldCheckInMovie() {
        libraryInventory.checkOutItem("movie", 1);
        libraryInventory.checkInItem("movie", 1);
        String bookList = "2, name2, director2, 1990, Rating: 8\n1, name1, director1, 1990, Rating: 5";
        assertThat(libraryInventory.getAvailableItems("movie"), is(bookList));
    }

    @Test
    public void shouldReturnMessageWhenCheckOutNonExistentBook() {
        String message = "Sorry, that item is not available";
        assertThat(libraryInventory.checkOutItem("book", 3), is(message));
    }

    @Test
    public void shouldReturnMessageWhenCheckInNonExistentBook() {
        String message = "That is not a valid item to return";
        assertThat(libraryInventory.checkInItem("movie", 1), is(message));
    }

}
