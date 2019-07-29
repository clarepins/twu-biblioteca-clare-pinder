package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testGetRefShouldReturnRef() {
        Book book = new Book (3, "Glasshouses", "Maribou State", 2019);
        assertEquals(book.getRef(), 3);
    }

    @Test
    public void testGetBookInfoShouldReturnBookInfo() {
        Book book = new Book (3, "Glasshouses", "Maribou State", 2019);
        assertEquals(book.getBookInfo(), "3, Glasshouses, Maribou State, 2019");
    }

}
