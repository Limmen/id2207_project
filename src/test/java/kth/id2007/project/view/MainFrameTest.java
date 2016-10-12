package kth.id2007.project.view;

import kth.id2007.project.model.Roles;
import kth.id2007.project.model.User;
import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kim on 2016-10-07.
 */
public class MainFrameTest {
    GUI gui;
    FrameFixture mainFrame;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void adminMainPageTest() {
        String username = "testUsername";
        String pw  = "testPw";
        mainFrame = new FrameFixture(new MainFrame(new GUI(), new User(username, pw, Roles.ADMINISTRATOR, Roles.NO_TEAM)));
        mainFrame.requireVisible();
        mainFrame.tabbedPane("container_pane").requireVisible();
        mainFrame.tabbedPane("container_pane").requireTabTitles("Home", "Event Applications", "Clients", "Employees", "HR Request", "Budget Issue", "Sub-team Tasks");
        mainFrame.tabbedPane("container_pane").selectTab("Home");
        mainFrame.label("home_title").requireText("Home");
        mainFrame.label("user_label").requireText("User:");
        mainFrame.label("username").requireText(username);
        mainFrame.label("role_label").requireText("Role:");
        mainFrame.label("role").requireText(Roles.ADMINISTRATOR);
        mainFrame.label("team_label").requireText("Team:");
        mainFrame.label("team").requireText(Roles.NO_TEAM);
        mainFrame.cleanUp();
    }

}