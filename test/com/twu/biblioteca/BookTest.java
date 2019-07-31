package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookTest {
    private Book book;

    @Before
    public void setUp() {
        book = new Book(3, "Glasshouses", "Maribou State", 2019);
    }

    @Test
    public void ShouldReturnRef() {
        assertThat(book.getRef(), is(3));
    }

    @Test
    public void ShouldReturnBookInfo() {
        assertThat(book.getBookInfo(), is("3, Glasshouses, Maribou State, 2019"));
    }

}
