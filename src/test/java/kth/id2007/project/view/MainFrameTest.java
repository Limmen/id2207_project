package kth.id2007.project.view;

import kth.id2007.project.model.Roles;
import kth.id2007.project.model.User;
import org.fest.swing.fixture.FrameFixture;
import org.junit.Test;

/**
 * Test-suite for MainFrame class
 *
 * Created by kim on 2016-10-07.
 */
public class MainFrameTest {

    /**
     * Tests access roles
     */
    @Test
    public void accessRoles(){
        String username = "testUsername";
        String pw  = "testPw";
        //Admin
        FrameFixture mainFrame = new FrameFixture(new MainFrame(new GUI(), new User(username, pw, Roles.ADMINISTRATOR, Roles.NO_TEAM)));
        mainFrame.tabbedPane("container_pane").requireTabTitles("Home", "Event Applications", "Clients", "Employees", "HR Request", "Budget Issue", "Sub-team Tasks");
        mainFrame.cleanUp();
        //Department Manager
        mainFrame = new FrameFixture(new MainFrame(new GUI(), new User(username, pw, Roles.PRODUCTION_MANAGER, Roles.NO_TEAM)));
        mainFrame.tabbedPane("container_pane").requireTabTitles("Home", "Event Applications", "HR Request", "Budget Issue", "Sub-team Tasks");
        mainFrame.cleanUp();
        //Employee
        mainFrame = new FrameFixture(new MainFrame(new GUI(), new User(username, pw, Roles.EMPLOYEE, Roles.NO_TEAM)));
        mainFrame.tabbedPane("container_pane").requireTabTitles("Home");
        mainFrame.cleanUp();
        //Member of subteam
        mainFrame = new FrameFixture(new MainFrame(new GUI(), new User(username, pw, Roles.EMPLOYEE, Roles.DECORATING_TEAM)));
        mainFrame.tabbedPane("container_pane").requireTabTitles("Home", "Event Applications", "Sub-team Tasks");
        mainFrame.cleanUp();
        //Administration Manager
        mainFrame = new FrameFixture(new MainFrame(new GUI(), new User(username, pw, Roles.ADMINISTRATION_MANAGER, Roles.NO_TEAM)));
        mainFrame.tabbedPane("container_pane").requireTabTitles("Home", "Event Applications", "Employees");
        mainFrame.cleanUp();
        //Customer service officer
        mainFrame = new FrameFixture(new MainFrame(new GUI(), new User(username, pw, Roles.CUSTOMER_SERVICE_OFFICER, Roles.NO_TEAM)));
        mainFrame.tabbedPane("container_pane").requireTabTitles("Home");
        mainFrame.cleanUp();
        //Senior customer service officer
        mainFrame = new FrameFixture(new MainFrame(new GUI(), new User(username, pw, Roles.SENIOR_CUSTOMER_SERVICE_OFFICER, Roles.NO_TEAM)));
        mainFrame.tabbedPane("container_pane").requireTabTitles("Home", "Event Applications", "Clients");
        mainFrame.cleanUp();
        //Financial Manager
        mainFrame = new FrameFixture(new MainFrame(new GUI(), new User(username, pw, Roles.FINANCIAL_MANAGER, Roles.NO_TEAM)));
        mainFrame.tabbedPane("container_pane").requireTabTitles("Home", "Event Applications", "Clients", "Employees", "Budget Issue");
        mainFrame.cleanUp();
        //HR-Assistant
        mainFrame = new FrameFixture(new MainFrame(new GUI(), new User(username, pw, Roles.HR_ASSISTANT, Roles.NO_TEAM)));
        mainFrame.tabbedPane("container_pane").requireTabTitles("Home", "Employees", "HR Request");
        mainFrame.cleanUp();
        //Senior-HR-Manager
        mainFrame = new FrameFixture(new MainFrame(new GUI(), new User(username, pw, Roles.SENIOR_HR_MANAGER, Roles.NO_TEAM)));
        mainFrame.tabbedPane("container_pane").requireTabTitles("Home", "Employees", "HR Request");
        mainFrame.cleanUp();
        //Vice-President
        mainFrame = new FrameFixture(new MainFrame(new GUI(), new User(username, pw, Roles.VICE_PRESIDENT, Roles.NO_TEAM)));
        mainFrame.tabbedPane("container_pane").requireTabTitles("Home");
        mainFrame.cleanUp();

    }
    /**
     * Tests the home page of the main frame
     */
    @Test
    public void homePageTest() {
    	
        String username = "testUsername";
        String pw  = "testPw";
        System.out.println("asdf");
        FrameFixture mainFrame = new FrameFixture(new MainFrame(new GUI(), new User(username, pw, Roles.ADMINISTRATOR, Roles.NO_TEAM)));
        System.out.println("visi");
        mainFrame.requireVisible();
        System.out.println("???");
        mainFrame.tabbedPane("container_pane").requireVisible();
        System.out.println("test 2");
        mainFrame.tabbedPane("container_pane").requireTabTitles("Home", "Event Applications", "Clients", "Employees", "HR Request", "Budget Issue", "Sub-team Tasks");
        mainFrame.tabbedPane("container_pane").selectTab("Home");
        System.out.println("Testing");
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