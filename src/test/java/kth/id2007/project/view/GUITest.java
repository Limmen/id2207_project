package kth.id2007.project.view;

import kth.id2007.project.model.*;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Test-suite for the GUI class
 * <p>
 * Created by kim on 2016-10-13.
 */
public class GUITest {
    @Mock
    private GUI instance = new GUI();


    /**
     * Test for removeBudgetIssueRequest method
     */
    @Test
    public void removeBudgetIssueRequest() {
        ArrayList<BudgetIssueRequest> budgetIssues = new ArrayList();
        budgetIssues.add(new BudgetIssueRequest(1, 2, 2, "insufficient funds"));
        Whitebox.setInternalState(instance, "budgetIssues", budgetIssues);
        assertEquals("Should contain one BudgetIssueRequest before removal", 1, instance.getBudgetIssueRequests().size());
        instance.removeBudgetIssueRequest(0);
        assertEquals("Should contain zero BudgetIssueRequest after removal", 0, instance.getBudgetIssueRequests().size());
    }

    /**
     * Test for removeHrRequest method
     */
    @Test
    public void removeHrRequest() {
        ArrayList<HrRequest> hrRequests = new ArrayList();
        hrRequests.add(new HrRequest(0, 0, 0, "intern", "dj"));
        Whitebox.setInternalState(instance, "hrRequests", hrRequests);
        assertEquals("Should contain one HrRequest before removal", 1, instance.getHrRequests().size());
        instance.removeHrRequest(0);
        assertEquals("Should contain zero HrRequest after removal", 0, instance.getHrRequests().size());
    }

    /**
     * Test for the inner class LoginListener
     */
    @Test
    public void loginListener() {
        JTextField usernameField = mock(JTextField.class);
        Mockito.when(usernameField.getText()).thenReturn("testUser");
        JPasswordField passwordField = mock(JPasswordField.class);
        Mockito.when(passwordField.getPassword()).thenReturn(new char[]{'t', 'e', 's', 't'});
        JComboBox rolesList = mock(JComboBox.class);
        Mockito.when(rolesList.getSelectedItem()).thenReturn("Administrator");
        JComboBox teamsList = mock(JComboBox.class);
        Mockito.when(teamsList.getSelectedItem()).thenReturn("No Team");
        GUI.LoginListener loginListener = instance.new LoginListener(usernameField, passwordField, rolesList, teamsList);
        ActionEvent event = mock(ActionEvent.class);
        assertEquals("user should not be added before the event", 0, instance.getUsers().size());
        loginListener.actionPerformed(event);
        assertEquals("new user should have been added", 1, instance.getUsers().size());
        User user = instance.getUsers().get(0);
        assertEquals("User should be initialized with correct username", "testUser", user.getUsername());
        assertEquals("User should be initialized with correct password", "test", user.getPassword());
        assertEquals("User should be initialized with correct role", "Administrator", user.getRole());
        assertEquals("User should be initialized with correct team", "No Team", user.getTeam());
    }

    /**
     * Test for the inner class ClientRecordListener
     */
    @Test
    public void clientRecordListener() {
        JTextField clientNameField = mock(JTextField.class);
        Mockito.when(clientNameField.getText()).thenReturn("testClient");
        JTextField clientEmailField = mock(JTextField.class);
        Mockito.when(clientEmailField.getText()).thenReturn("testEmail");
        JTextField clientPhoneNumberField = mock(JTextField.class);
        Mockito.when(clientPhoneNumberField.getText()).thenReturn("testPhoneNumber");
        GUI.ClientRecordListener clientRecordListener = instance.new ClientRecordListener(clientNameField, clientEmailField,
                clientPhoneNumberField);
        ActionEvent event = mock(ActionEvent.class);
        assertEquals("client should not be added before the event", 0, instance.getClients().size());
        clientRecordListener.actionPerformed(event);
        assertEquals("new client should have been added", 1, instance.getClients().size());
        ClientRecord client = instance.getClients().get(0);
        assertEquals("Client should be initialized with correct name", "testClient", client.getClientName());
        assertEquals("Client should be initialized with correct email", "testEmail", client.getClientEmail());
        assertEquals("Client should be initialized with correct phonenumber", "testPhoneNumber", client.getClientPhoneNumber());
    }

    /**
     * Test for the inner class EventApplicationListener
     */
    @Test
    public void eventApplicationListener() {
        JTextField budgetField = mock(JTextField.class);
        Mockito.when(budgetField.getText()).thenReturn("100");
        JTextField discountField = mock(JTextField.class);
        Mockito.when(discountField.getText()).thenReturn("0");
        JTextField eventTypeField = mock(JTextField.class);
        Mockito.when(eventTypeField.getText()).thenReturn("Birthday Party");
        JTextField preferencesField = mock(JTextField.class);
        Mockito.when(preferencesField.getText()).thenReturn("Only pandas allowed");
        JTextField descriptionField = mock(JTextField.class);
        Mockito.when(descriptionField.getText()).thenReturn("KungFu Panda's birthday");
        JTextField expectedAttendeesField = mock(JTextField.class);
        Mockito.when(expectedAttendeesField.getText()).thenReturn("100");
        JTextField budgetCommentsField = mock(JTextField.class);
        Mockito.when(budgetCommentsField.getText()).thenReturn("sufficient funds");
        JComboBox statusField = mock(JComboBox.class);
        Mockito.when(statusField.getSelectedItem()).thenReturn("CREATED");
        JDatePickerImpl fromDatePicker = Mockito.mock(JDatePickerImpl.class);
        JFormattedTextField fromDateField = Mockito.mock(JFormattedTextField.class);
        Mockito.when(fromDateField.getText()).thenReturn("2016-oct-10");
        Mockito.when(fromDatePicker.getJFormattedTextField()).thenReturn(fromDateField);
        JDatePickerImpl toDatePicker = Mockito.mock(JDatePickerImpl.class);
        JFormattedTextField toDateField = Mockito.mock(JFormattedTextField.class);
        Mockito.when(toDateField.getText()).thenReturn("2016-oct-19");
        Mockito.when(toDatePicker.getJFormattedTextField()).thenReturn(toDateField);
        GUI.EventApplicationListener eventApplicationListener = instance.new EventApplicationListener(budgetField,
                discountField, eventTypeField, preferencesField, descriptionField, expectedAttendeesField,
                fromDatePicker, toDatePicker, budgetCommentsField, statusField);
        ActionEvent event = mock(ActionEvent.class);
        assertEquals("application should not be added before the event", 0, instance.getApplications().size());
        eventApplicationListener.actionPerformed(event);
        assertEquals("new application should have been added", 1, instance.getApplications().size());
        EventApplication application = instance.getApplications().get(0);
        assertEquals("Application should be initialized with correct budget", 100 , application.getBudget());
        assertEquals("Application should be initialized with correct discount", 0 , application.getDiscount());
        assertEquals("Application should be initialized with correct event type", "Birthday Party" , application.getEventType());
        assertEquals("Application should be initialized with correct preferences", "Only pandas allowed" , application.getPreferences());
        assertEquals("Application should be initialized with correct description", "KungFu Panda's birthday" , application.getDescription());
        assertEquals("Application should be initialized with correct expectedAttendees", 100 , application.getExpectedAttendees());
        assertEquals("Application should be initialized with correct status", "CREATED" , application.getStatus());
        assertEquals("Application should be initialized with correct from-date", "2016-oct-10" , application.getFrom());
        assertEquals("Application should be initialized with correct to-date", "2016-oct-19" , application.getTo());
    }

    /**
     * Test for the inner class HrRequestListener
     */
    @Test
    public void hrRequestListener() {
        JComboBox contractTypeComboBox = Mockito.mock(JComboBox.class);
        Mockito.when(contractTypeComboBox.getSelectedItem()).thenReturn("Intern");
        JComboBox requestingDepartmentComboBox = Mockito.mock(JComboBox.class);
        Mockito.when(requestingDepartmentComboBox.getSelectedItem()).thenReturn("Service Department");
        JComboBox projectComboBox = Mockito.mock(JComboBox.class);
        Mockito.when(projectComboBox.getSelectedItem()).thenReturn("0");
        JTextField jobTitleField = mock(JTextField.class);
        Mockito.when(jobTitleField.getText()).thenReturn("Painter");
        JTextField jobDescriptionField = mock(JTextField.class);
        Mockito.when(jobDescriptionField.getText()).thenReturn("paint walls for a living");
        GUI.HrRequestListener hrRequestListener = instance.new HrRequestListener(contractTypeComboBox,
                requestingDepartmentComboBox, projectComboBox, jobTitleField, jobDescriptionField);
        ActionEvent event = mock(ActionEvent.class);
        assertEquals("request should not be added before the event", 0, instance.getHrRequests().size());
        hrRequestListener.actionPerformed(event);
        assertEquals("new request should have been added", 1, instance.getHrRequests().size());
        HrRequest hrRequest = instance.getHrRequests().get(0);
        assertEquals("HrRequest should be initialized with correct contract type", 0, hrRequest.getContractType());
        assertEquals("HrRequest should be initialized with correct department", 0, hrRequest.getRequestingDepartment());
        assertEquals("HrRequest should be initialized with correct project reference", 0, hrRequest.getProjectReferenceId());
        assertEquals("HrRequest should be initialized with correct job title", "Painter", hrRequest.getJobTitle());
        assertEquals("HrRequest should be initialized with correct job description", "paint walls for a living", hrRequest.getJobDescription());
    }

    /**
     * Test for the inner class BudgetIssueListener
     */
    @Test
    public void budgetIssueListener() {
        EventApplication eventApplication = Mockito.mock(EventApplication.class);
        Mockito.when(eventApplication.getProjectReferenceId()).thenReturn(Long.parseLong("0"));
        ArrayList<EventApplication> applications = new ArrayList();
        applications.add(eventApplication);
        Whitebox.setInternalState(instance, "applications", applications);
        JComboBox requestingDepartmentComboBox = Mockito.mock(JComboBox.class);
        Mockito.when(requestingDepartmentComboBox.getSelectedItem()).thenReturn("Service Department");
        JComboBox projectComboBox = Mockito.mock(JComboBox.class);
        Mockito.when(projectComboBox.getSelectedItem()).thenReturn("0");
        JTextField amountField = mock(JTextField.class);
        Mockito.when(amountField.getText()).thenReturn("100");
        JTextField reasonField = mock(JTextField.class);
        Mockito.when(reasonField.getText()).thenReturn("insufficient funds");
        GUI.BudgetIssueListener budgetIssueListener = instance.new BudgetIssueListener(amountField,
                reasonField, requestingDepartmentComboBox, projectComboBox);
        ActionEvent event = mock(ActionEvent.class);
        assertEquals("request should not be added before the event", 0, instance.getBudgetIssueRequests().size());
        budgetIssueListener.actionPerformed(event);
        assertEquals("new request should have been added", 1, instance.getBudgetIssueRequests().size());
        BudgetIssueRequest budgetIssueRequest = instance.getBudgetIssueRequests().get(0);
        assertEquals("BudgetIssueRequest should be initialized with correct department", 0, budgetIssueRequest.getRequestingDepartment());
        assertEquals("BudgetIssueRequest should be initialized with correct project reference", 0, budgetIssueRequest.getProjectReferenceId());
        assertEquals("BudgetIssueRequest should be initialized with correct amount", 100, budgetIssueRequest.getAmount());
        assertEquals("BudgetIssueRequest should be initialized with correct reason", "insufficient funds", budgetIssueRequest.getReason());
    }

    /**
     * Test for the inner class SubTeamTaskListener
     */
    @Test
    public void subTaskListener() {
        JComboBox projectComboBox = Mockito.mock(JComboBox.class);
        Mockito.when(projectComboBox.getSelectedItem()).thenReturn("0");
        JTextField descriptionField = mock(JTextField.class);
        Mockito.when(descriptionField.getText()).thenReturn("Bake a cake");
        JTextField assignedToField = mock(JTextField.class);
        Mockito.when(assignedToField.getText()).thenReturn("Chuck");
        JTextField priorityField = mock(JTextField.class);
        Mockito.when(priorityField.getText()).thenReturn("5");
        GUI.SubTeamTasksListener subTeamTasksListener = instance.new SubTeamTasksListener(descriptionField,
                assignedToField, priorityField, projectComboBox);
        ActionEvent event = mock(ActionEvent.class);
        assertEquals("task should not be added before the event", 0, instance.getTasks().size());
        subTeamTasksListener.actionPerformed(event);
        assertEquals("new task should have been added", 1, instance.getTasks().size());
        SubTeamTask task = instance.getTasks().get(0);
        assertEquals("SubTeamTask should be initialized with correct project reference", 0, task.getProjectReferenceId());
        assertEquals("SubTeamTask should be initialized with correct description", "Bake a cake", task.getDescription());
        assertEquals("SubTeamTask should be initialized with correct assigned to", "Chuck", task.getAssignedTo());
        assertEquals("SubTeamTask should be initialized with correct priority", 5, task.getPriority());
    }

    /**
     * Test for the inner class EventEditListener
     */
    @Test
    public void eventEditListener() {
        long id = EventApplication.staticReferenceCounter;
        EventApplication event = new EventApplication(0, 2,"","","","","",2,"","","");
        ArrayList<EventApplication> applications = new ArrayList();
        applications.add(event);
        Whitebox.setInternalState(instance, "applications", applications);
        User user = new User("Jack","g", Roles.PRODUCTION_MANAGER, "g");
        DefaultTableModel model = Mockito.mock(DefaultTableModel.class);
        Mockito.when(model.getRowCount()).thenReturn(1);
        Mockito.when(model.getValueAt(0,0)).thenReturn(Long.toString(id));
        Mockito.when(model.getValueAt(0,1)).thenReturn("10");
        Mockito.when(model.getValueAt(0,2)).thenReturn("9");
        Mockito.when(model.getValueAt(0,3)).thenReturn("party");
        Mockito.when(model.getValueAt(0,4)).thenReturn("no cheese cakes");
        Mockito.when(model.getValueAt(0,5)).thenReturn("graduation party for Alice");
        Mockito.when(model.getValueAt(0,6)).thenReturn("2016-10-okt");
        Mockito.when(model.getValueAt(0,7)).thenReturn("2016-11-okt");
        Mockito.when(model.getValueAt(0,8)).thenReturn("100");
        Mockito.when(model.getValueAt(0,9)).thenReturn("funded by Alice's dad");
        Mockito.when(model.getValueAt(0,10)).thenReturn("OPEN");
        GUI.EventEditListener eventEditListener = instance.new EventEditListener(model, user);
        ActionEvent event2 = mock(ActionEvent.class);
        eventEditListener.actionPerformed(event2);
        EventApplication editedEvent = instance.getApplications().get(0);
        assertEquals("event should have new edited budget", 10, editedEvent.getBudget());
        assertEquals("event should have new edited discount", 9, editedEvent.getDiscount());
        assertEquals("event should have new edited eventtype", "party", editedEvent.getEventType());
        assertEquals("event should have new edited preferences", "no cheese cakes", editedEvent.getPreferences());
        assertEquals("event should have new edited description", "graduation party for Alice", editedEvent.getDescription());
        assertEquals("event should have new edited from date", "2016-10-okt", editedEvent.getFrom());
        assertEquals("event should have new edited to date", "2016-11-okt", editedEvent.getTo());
        assertEquals("event should have new edited budget comments", "funded by Alice's dad", editedEvent.getBudgetComments());
        assertEquals("event should have new edited status", "OPEN", editedEvent.getStatus());
        assertEquals("event should have updated history after edit", "\n" + user.getRole() + " " + user.getUsername() + " reviewed and edited", editedEvent.getHistory());
    }

    /**
     * Test for the inner class approveListener
     */
    @Test
    public void approveListener () {
        long id = EventApplication.staticReferenceCounter;
        EventApplication event = new EventApplication(0, 2,"","","","","",2,"","","");
        ArrayList<EventApplication> applications = new ArrayList();
        applications.add(event);
        Whitebox.setInternalState(instance, "applications", applications);
        User user = new User("Jack","g", Roles.PRODUCTION_MANAGER, "g");
        DefaultTableModel model = Mockito.mock(DefaultTableModel.class);
        Mockito.when(model.getRowCount()).thenReturn(1);
        Mockito.when(model.getValueAt(0,0)).thenReturn(Long.toString(id));
        Mockito.when(model.getValueAt(0,1)).thenReturn(true);
        GUI.ApproveListener approveListener = instance.new ApproveListener(model, user);
        ActionEvent event2 = mock(ActionEvent.class);
        approveListener.actionPerformed(event2);
        EventApplication editedEvent = instance.getApplications().get(0);
        assertTrue(editedEvent.isApproved());
        assertEquals("event should have updated history after approval", "\n" + user.getRole() + " " + user.getUsername() + " " + " approved the application", editedEvent.getHistory());
    }
}