package kth.id2007.project.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kim on 2016-10-05.
 */
public class UserTest {


    @Test
    public void createUserTest(){
        String username = "testUsername";
        String password = "testPw";
        User instance = new User(username, password);

        assertEquals("User should be initialized with correct username", username, instance.getUsername());
        assertEquals("User should be initialized with correct password", password, instance.getPassword());
    }

}