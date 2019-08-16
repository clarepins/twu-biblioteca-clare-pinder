package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie(3, "Psycho", "Alfred Hitchcock", 1960, 7);
    }

    @Test
    public void ShouldReturnRef() {
        assertThat(movie.getRef(), is(3));
    }

    @Test
    public void ShouldReturnMovieInfo() {
        assertThat(movie.getInfo(), is("3, Psycho, Alfred Hitchcock, 1960, Rating: 7"));
    }

}
