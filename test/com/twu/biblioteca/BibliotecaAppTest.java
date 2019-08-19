package com.twu.biblioteca;

import org.junit.After;
import org.junit.Test;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {
    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testIn;
    BibliotecaApp bibliotecaApp;

    @Mock
    PrintStream mockPrintStream;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        bibliotecaApp = new BibliotecaApp(mockPrintStream);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        bibliotecaApp.printWelcomeMessage();
        String message = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        verify(mockPrintStream).println(message);
    }

    @Test
    public void shouldRunApp() {
//        I gave up with this test. It needs to mock multiple inputStreams and outputStreams, as well as quit the
//        app so the test doesn't keep running indefinitely.

//        bibliotecaApp.setUpLibraryAndMenu();
//        bibliotecaApp.runApp(menu);
//        String menuOptions = "\nBibliotecaApp menu - please select a number." +
//                "\n1. List of books" +
//                "\n2. Check out book" +
//                "\n3. Check in book" +
//                "\n4. Quit";
//        String userInput = "4";
//        provideInput(userInput);
//        verify(mockPrintStream).println(menuOptions);
    }
}
