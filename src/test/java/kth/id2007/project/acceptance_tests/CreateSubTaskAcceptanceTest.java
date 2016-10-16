package kth.id2007.project.acceptance_tests;

import kth.id2007.project.model.EventApplication;
import kth.id2007.project.model.Roles;
import kth.id2007.project.model.User;
import kth.id2007.project.view.GUI;
import kth.id2007.project.view.MainFrame;
import org.fest.swing.data.TableCell;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JTableCellFixture;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Acceptance test for CREATE_SUBTASK user story
 *
 * Created by kim on 2016-10-12.
 */
public class CreateSubTaskAcceptanceTest {
    private GUI gui;
    private FrameFixture mainFrame;

    /**
     * Acceptance test for creating a subtask
     */
    @Test
    public void CreateSubTaskAcceptanceTest() {
        long id = EventApplication.staticReferenceCounter;
        String username = "Jack";
        String pw = "testPw";
        EventApplication event = new EventApplication(1, 1, "type", "pref", "descr", "from", "to",
                1, "comments", "status", "history");
        ArrayList<EventApplication> events = new ArrayList();
        events.add(event);
        gui = new GUI();
        gui.setApplications(events);
        MainFrame frame = new MainFrame(gui, new User(username, pw, Roles.PRODUCTION_MANAGER, Roles.NO_TEAM));
        gui.addFrame(frame);
        mainFrame = new FrameFixture(frame);
        mainFrame.requireVisible();
        mainFrame.tabbedPane("container_pane").requireVisible();
        mainFrame.tabbedPane("container_pane").requireTabTitles("Home", "Event Applications", "HR Request", "Budget Issue", "Sub-team Tasks");
        mainFrame.tabbedPane("container_pane").selectTab("Sub-team Tasks");
        mainFrame.label("tasks_title").requireText("Sub-team tasks");
        mainFrame.panel("createsubtasks_panel").requireVisible();
        mainFrame.panel("viewsubtasks_panel").requireVisible();
        mainFrame.scrollPane("subtasks_scrollPane").requireVisible();
        mainFrame.label("project_reference_label").requireText("Project Reference");
        mainFrame.label("description_label").requireText("Description");
        mainFrame.label("assignedto_label").requireText("Assigned to");
        mainFrame.label("priority_label").requireText("Priority");
        mainFrame.textBox("description_field").requireVisible();
        mainFrame.textBox("assigned_field").requireVisible();
        mainFrame.textBox("priority_field").requireVisible();
        mainFrame.button("save_button").requireVisible();
        mainFrame.comboBox("project_combobox").requireVisible();

        mainFrame.comboBox("project_combobox").selectItem(0);
        mainFrame.textBox("description_field").enterText("Prepare a playlist");
        mainFrame.textBox("assigned_field").enterText("Audio Team");
        mainFrame.textBox("priority_field").enterText("10");
        mainFrame.button("save_button").click();
        mainFrame.table("subtasks_table").requireColumnCount(4);
        mainFrame.table("subtasks_table").requireRowCount(1);
        JTableCellFixture cell1 = mainFrame.table("subtasks_table").cell(TableCell.row(0).column(0));
        JTableCellFixture cell2 = mainFrame.table("subtasks_table").cell(TableCell.row(0).column(1));
        JTableCellFixture cell3 = mainFrame.table("subtasks_table").cell(TableCell.row(0).column(2));
        JTableCellFixture cell4 = mainFrame.table("subtasks_table").cell(TableCell.row(0).column(3));
        cell1.requireValue(Integer.toString((int) id));
        cell2.requireValue("Prepare a playlist");
        cell3.requireValue("Audio Team");
        cell4.requireValue("10");
        mainFrame.cleanUp();

    }
}

