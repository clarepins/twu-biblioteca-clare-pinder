package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LibraryItemTest {
    private LibraryItem libraryItem;

    @Before
    public void setUp() {
        libraryItem = new LibraryItem(3, "Glasshouses", "Maribou State", 2019);
    }

    @Test
    public void ShouldReturnRef() {
        assertThat(libraryItem.getRef(), is(3));
    }

    @Test
    public void ShouldReturnItemInfo() {
        assertThat(libraryItem.getInfo(), is("3, Glasshouses, Maribou State, 2019"));
    }

}
