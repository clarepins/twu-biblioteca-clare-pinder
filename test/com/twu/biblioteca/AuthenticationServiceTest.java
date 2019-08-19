package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AuthenticationServiceTest {

    @Test
    public void testUserLoginWithCorrectCredentials() {
        String username = "123-4567";
        String password = "testPassword";
        AuthenticationService authenticationService = new AuthenticationService();
        authenticationService.logIn(username, password);
        assertThat(authenticationService.currentUser.username, is(username));
        assertThat(authenticationService.currentUser.password, is(password));
    }
}
