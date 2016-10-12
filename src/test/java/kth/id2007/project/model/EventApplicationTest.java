package kth.id2007.project.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EventApplicationTest {

    @Test
    public void createEventApplicationTest() {

        long budget = 1232342134;
        int discount = 123;
        String eventType = "Birthday party";
        String preferences = "Red tables";
        String description = "None.";
        String from = "2016-okt-19";
        String to = "2016-okt-21";
        String budgetComments = "This project is risky from a financial aspect / Alice, Financial Manager";
        String status = EventStatus.OPEN;
        String history = " ";

        int expectedAttendees = 75;

        EventApplication ev = new EventApplication(budget, discount,
                eventType, preferences, description, from, to,
                expectedAttendees, budgetComments, status, history);

        //Getters and setters test
        assertEquals("Budget", budget, ev.getBudget());
        assertEquals("discount", discount, ev.getDiscount());
        assertEquals("eventType", eventType, ev.getEventType());
        assertEquals("preferences", preferences, ev.getPreferences());
        assertEquals("description", description, ev.getDescription());
        assertEquals("from date", from, ev.getFrom());
        assertEquals("to date", to, ev.getTo());
        assertEquals("expectedAttendees", expectedAttendees, ev.getExpectedAttendees());
        assertEquals("budgetComments", budgetComments, ev.getBudgetComments());
        assertEquals("status", status, ev.getStatus());
        assertEquals("history", history, ev.getHistory());

        //Subteam add test
        ArrayList<SubTeamTask> subteams = new ArrayList();
        subteams.add(new SubTeamTask(0, "kjlkz", "aoisdfa", 41));
        subteams.add(new SubTeamTask(1, "z", "aklsdfa", 78));
        subteams.add(new SubTeamTask(2, "zlkö", "asdiifa", 8678));

        ev.addSubteamTasks(subteams.get(0));
        ev.addSubteamTasks(subteams.get(1));
        ev.addSubteamTasks(subteams.get(2));

        ArrayList<SubTeamTask> tasks = ev.getSubteamTasks();
        for (int i = 0; i < tasks.size(); i++) {
            assertEquals("Subteam itteration " + i, subteams.get(i), tasks.get(i));
        }


        //Id counter test
        assertEquals("id fail @ itteration " + 0, 0, ev.getProjectRefrenceId());
        for (int i = 1; i < 100; i++) {

            assertEquals("id fail @ itteration " + i, i, (new EventApplication(budget, discount,
                    eventType, preferences, description, from, to,
                    expectedAttendees, budgetComments, status, history)).getProjectRefrenceId());
        }


    }
}
