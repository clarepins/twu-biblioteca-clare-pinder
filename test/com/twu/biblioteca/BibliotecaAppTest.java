package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    @Test
    public void shouldGetWelcomeMessage() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String message = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        assertThat(bibliotecaApp.getWelcomeMessage(), is(message));
    }
}
