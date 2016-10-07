package kth.id2007.project.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test suite for User class
 *
 * Created by kim on 2016-10-05.
 */
public class UserTest {


    /**
     * Test for User initialization
     */
    @Test
    public void createUserTest(){
        String username = "testUsername";
        String password = "testPw";
        String role = Roles.EMPLOYEE;
        String team = Roles.AUDIO_TEAM;
        User instance = new User(username, password, role, team);

        assertEquals("User should be initialized with correct username", username, instance.getUsername());
        assertEquals("User should be initialized with correct password", password, instance.getPassword());
        assertEquals("User should be initialized with correct role", role, instance.getRole());
        assertEquals("User should be initialized with correct team", team, instance.getTeam());
    }

}