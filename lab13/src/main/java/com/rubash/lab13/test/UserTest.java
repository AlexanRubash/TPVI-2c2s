package com.rubash.lab13.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.rubash.lab13.zad3.User;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;

public class UserTest {

    @Test
    public void testUserConstructorWithFourParameters() {
        int id = 10;
        String login = "user1";
        String password = "pass1";
        String role = "admin";
        User user = new User(id, login, password, role);

        Assertions.assertEquals(id, user.getId());
        Assertions.assertEquals(login, user.getLogin());
        Assertions.assertEquals(password, user.getPassword());
        Assertions.assertEquals(role, user.getRole());
    }

    @Test
    public void testUserConstructorWithThreeParameters() {
        String login = "user1";
        String password = "pass1";
        String role = "admin";
        User user = new User(login, password, role);

        Assertions.assertEquals(login, user.getLogin());
        Assertions.assertEquals(password, user.getPassword());
        Assertions.assertEquals(role, user.getRole());
    }

    @Test
    public void testGettersAndSetters() {
        int id = 12;
        String login = "user1";
        String password = "pass1";
        String role = "admin";
        User user = new User();

        user.setId(id);
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);

        Assertions.assertEquals(id, user.getId());
        Assertions.assertEquals(login, user.getLogin());
        Assertions.assertEquals(password, user.getPassword());
        Assertions.assertEquals(role, user.getRole());
    }
}
