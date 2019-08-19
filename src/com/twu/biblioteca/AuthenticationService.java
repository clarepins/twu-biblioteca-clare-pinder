package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationService {
    public User currentUser;

    List<User> users = new ArrayList<>();
    {
        User user = new User();
        user.username = "123-4567";
        user.password = "hello123";
        User user2 = new User();
        user2.username = "101-0101";
        user2.password = "passw0rd";

        users.add(user);
        users.add(user2);
    }

    public void logIn(String username, String password) {
        User foundUser = null;
        for (User userInCollection : users) {
            if (userInCollection.username.equals(username) && userInCollection.password.equals(password)) {
                foundUser = userInCollection;
                break;
            }
        }
        currentUser = foundUser;
    }
}
