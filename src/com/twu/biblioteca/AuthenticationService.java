package com.twu.biblioteca;

public class AuthenticationService {
    public User currentUser;

    public void logIn(String username, String password) {
        User foundUser = new User();
        foundUser.username = username;
        foundUser.password = password;

        if(foundUser.username.equals(username) && foundUser.password.equals(password)) {
            currentUser = foundUser;
        }

    }

}
