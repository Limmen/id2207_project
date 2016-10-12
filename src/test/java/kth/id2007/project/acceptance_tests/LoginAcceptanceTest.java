package kth.id2007.project.acceptance_tests;

import kth.id2007.project.model.Roles;
import kth.id2007.project.view.GUI;
import kth.id2007.project.view.StartFrame;
import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.Robot;
import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.FrameFixture;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Acceptance test for the login user story
 *
 * Created by kim on 2016-10-06.
 */
public class LoginAcceptanceTest {
    GUI gui;
    FrameFixture login;

    @Before
    public void setUp() throws Exception {
        gui = new GUI();
        login = new FrameFixture(new StartFrame(gui));
    }

    /**
     * Acceptance test for logging into the system
     */
    @Test
    public void loginAcceptanceTest() {
        String username = "testUsername";
        String pw = "testPassword";
        login.textBox("username_field").enterText(username);
        login.textBox("password_field").enterText(pw);
        login.comboBox("roles_list").selectItem(Roles.EMPLOYEE);
        login.comboBox("teams_list").selectItem(Roles.COOKING_TEAM);
        login.button("login_button").click();
        assertTrue("New user should have been added", gui.getUsers().stream().anyMatch(user ->
                user.getUsername().equals(username) &&
                        user.getRole().equals(Roles.EMPLOYEE) &&
        user.getTeam().equals(Roles.COOKING_TEAM)));
        login.requireVisible();
        login.robot.cleanUpWithoutDisposingWindows();
        Robot robot = BasicRobot.robotWithCurrentAwtHierarchy();
        FrameFixture mainFrame = WindowFinder.findFrame("main_frame").using(robot);
        mainFrame.requireVisible();
        mainFrame.tabbedPane("container_pane").requireVisible();
        mainFrame.tabbedPane("container_pane").requireTabTitles("Home", "Event Applications", "Sub-team Tasks");
        mainFrame.tabbedPane("container_pane").selectTab("Home");
        mainFrame.label("home_title").requireText("Home");
        mainFrame.label("user_label").requireText("User:");
        mainFrame.label("username").requireText(username);
        mainFrame.label("role_label").requireText("Role:");
        mainFrame.label("role").requireText(Roles.EMPLOYEE);
        mainFrame.label("team_label").requireText("Team:");
        mainFrame.label("team").requireText(Roles.COOKING_TEAM);
        mainFrame.cleanUp();
    }

}
