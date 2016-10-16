package kth.id2007.project.view;

import kth.id2007.project.model.Roles;
import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Unit test suite for the StartFrame class.
 * <p>
 * Created by kim on 2016-10-06.
 */
public class StartFrameTest {
    private GUI gui;
    private FrameFixture startFrame;

    /**
     * Ran before each test
     */
    @Before
    public void setUp(){
        gui = new GUI();
        startFrame = new FrameFixture(new StartFrame(gui));
    }

    /**
     * Ran after each test
     */
    @After
    public void cleanUp() {
        startFrame.cleanUp();
    }

    /**
     * Unit test for the StartFrame GUI
     */
    @Test
    public void test() {
        startFrame.label("login_title").requireText("Login");
        startFrame.label("username_label").requireText("Username:");
        startFrame.textBox("username_field").requireText("");
        startFrame.label("password_label").requireText("Password:");
        startFrame.textBox("password_field").requireText("");
        startFrame.label("role_label").requireText("Role:");
        startFrame.label("team_label").requireText("Team:");
        startFrame.button("login_button").requireText("Log in");
        assertArrayEquals("All roles should be listed", Roles.roles(), startFrame.comboBox("roles_list").contents());
        assertArrayEquals("All teams should be listed", Roles.teams(), startFrame.comboBox("teams_list").contents());
    }
}