package kth.id2007.project.view;

import kth.id2007.project.model.*;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * GUI Controller, all calls from the view to the model goes through here.
 */
public class GUI {

    private GUI gui = this;
    private ArrayList<User> users = new ArrayList();
    private ArrayList<ClientRecord> clients = new ArrayList();
    private ArrayList<EventApplication> applications = new ArrayList();
    private ArrayList<HrRequest> hrRequests = new ArrayList();
    private ArrayList<MainFrame> mainFrames = new ArrayList();
    private ArrayList<BudgetIssueRequest> budgetIssues = new ArrayList<>();
    private ArrayList<SubTeamTask> tasks = new ArrayList();

    /**
     * Class constructor
     */
    public GUI() {
        new StartFrame(this);
    }


    private void clearFields(JTextField... fields) {
        for (JTextField t : fields) {
            t.setText("");
        }
    }

    private boolean fieldsContainText(JTextField... fields) {
        for (JTextField t : fields) {
            if (t.getText().length() == 0)
                return false;
        }
        return true;
    }

    /**
     * Main method, entry point of the program. Initializes the GUI.
     *
     * @param args
     */
    public static void main(String[] args) {
        new GUI();
    }

    private void updateGUI() {
        mainFrames.forEach((frame) -> frame.update());
    }

    // Action listener for login-button on the startframe.
    class LoginListener implements ActionListener {

        private final JTextField usernameField;
        private final JPasswordField passwordField;
        private final JComboBox rolesList;
        private final JComboBox teamsList;

        LoginListener(JTextField usernameField, JPasswordField passwordField, JComboBox rolesList,
                      JComboBox teamsList) {
            this.usernameField = usernameField;
            this.passwordField = passwordField;
            this.rolesList = rolesList;
            this.teamsList = teamsList;
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            if (usernameField.getText().length() > 0 && passwordField.getPassword().length > 0) {

                boolean userExists = true;
                for (User u : users)
                    if (u.getUsername().equals(usernameField.getText()))
                        userExists = false;
                if (userExists) {
                    User user = new User(usernameField.getText(), new String(passwordField.getPassword()),
                            (String) rolesList.getSelectedItem(), (String) teamsList.getSelectedItem());
                    users.add(user);
                    mainFrames.add(new MainFrame(gui, user));
                    usernameField.setText("");
                    passwordField.setText("");
                    updateGUI();
                } else {
                    errorMessage("User \"" + usernameField.getText() + "\" alredy exists!");
                }
            } else invalidInput("");

        }
    }

    //ActionListener for the create client record button on the client-record page on the main frame
    class ClientRecordListener implements ActionListener {
        private JTextField clientNameField;
        private JTextField clientEmailField;
        private JTextField clientPhoneNumberField;

        ClientRecordListener(JTextField clientNameField, JTextField clientEmailField, JTextField clientPhoneNumberField) {
            this.clientNameField = clientNameField;
            this.clientEmailField = clientEmailField;
            this.clientPhoneNumberField = clientPhoneNumberField;
        }

        public void actionPerformed(ActionEvent arg0) {

            if (clientNameField.getText().length() == 0 || clientEmailField.getText().length() == 0 || clientPhoneNumberField.getText().length() == 0) {
                invalidInput("");
            } else {
                ClientRecord clientRecord = new ClientRecord(clientNameField.getText(), clientEmailField.getText(),
                        clientPhoneNumberField.getText(), null);
                clients.add(clientRecord);
                clearFields(clientEmailField, clientNameField, clientPhoneNumberField);
                updateGUI();

                try {

                } catch (NumberFormatException e2) {
                    if (e2.getMessage() == "null")
                        invalidComboBoxValue();
                    else
                        invalidNumberInput();
                }

            }

        }
    }

    //ActionListener for the create event application button on the event application page on the main frame
    class EventApplicationListener implements ActionListener {
        private JTextField budgetField;
        private JTextField discountField;
        private JTextField eventTypeField;
        private JTextField preferencesField;
        private JTextField descriptionField;
        private JTextField expectedAttendeesField;
        private JTextField budgetCommentsField;
        private JComboBox statusField;
        private JDatePickerImpl fromDatePicker, toDatePicker;

        EventApplicationListener(JTextField budgetField, JTextField discountField, JTextField eventTypeField,
                                 JTextField preferencesField, JTextField descriptionField,
                                 JTextField expectedAttendeesField, JDatePickerImpl fromDatePicker, JDatePickerImpl toDatePicker,
                                 JTextField budgetCommentsField, JComboBox statusField) {
            this.budgetField = budgetField;
            this.discountField = discountField;
            this.eventTypeField = eventTypeField;
            this.preferencesField = preferencesField;
            this.descriptionField = descriptionField;
            this.expectedAttendeesField = expectedAttendeesField;
            this.budgetCommentsField = budgetCommentsField;
            this.statusField = statusField;
            this.fromDatePicker = fromDatePicker;
            this.toDatePicker = toDatePicker;
        }

        private String errorStr = "";

        private String getField(JTextField f, String desc) throws IllegalArgumentException {
            if (f.getText().length() > 0)
                return f.getText();
            else {
                errorStr += desc + "\n";
                throw new IllegalArgumentException();
            }
        }

        public void actionPerformed(ActionEvent e) {


            if (!fieldsContainText(budgetField, discountField, eventTypeField, preferencesField, descriptionField, expectedAttendeesField
                    , budgetCommentsField, fromDatePicker.getJFormattedTextField(), toDatePicker.getJFormattedTextField())) {
                invalidInput("");
            } else {

                try {
                    applications.add(new EventApplication(Long.parseLong(getField(budgetField, "budget")), Integer.parseInt(getField(discountField, "disscount")), getField(eventTypeField, "event type"),
                            getField(preferencesField, "preferences"), getField(descriptionField, "description"),
                            fromDatePicker.getJFormattedTextField().getText(), toDatePicker.getJFormattedTextField().getText(),
                            Integer.parseInt(getField(expectedAttendeesField, "expected atendees")), budgetCommentsField.getText(), (String) statusField.getSelectedItem(), ""));
                    clearFields(budgetField, discountField, eventTypeField, preferencesField, descriptionField, expectedAttendeesField
                            , budgetCommentsField, fromDatePicker.getJFormattedTextField(), toDatePicker.getJFormattedTextField());
                    updateGUI();
                } catch (NumberFormatException e2) {
                    if (e2.getMessage() == "null")
                        invalidComboBoxValue();
                    else
                        invalidNumberInput();
                }

            }


        }
    }

    //ActionListener for the create create HrRequest button on the HrRequest page on the main frame
    class HrRequestListener implements ActionListener {
        private JComboBox contractTypeCoboBox;
        private JComboBox requestingDepartmentComboBox, projectComboBox;
        private JTextField jobTitleField;
        private JTextField jobDescriptionField;

        HrRequestListener(JComboBox contractTypeComboBox, JComboBox requestingDepartmentComboBox,
                          JComboBox projectComboBox, JTextField jobTitleField,
                          JTextField jobDescriptionField) {

            this.contractTypeCoboBox = contractTypeComboBox;
            this.requestingDepartmentComboBox = requestingDepartmentComboBox;
            this.projectComboBox = projectComboBox;
            this.jobTitleField = jobTitleField;
            this.jobDescriptionField = jobDescriptionField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (jobTitleField.getText().length() == 0 || jobDescriptionField.getText().length() == 0) {
                invalidInput("");
            } else {

                try {
                    HrRequest hrRequest = new HrRequest(Long.parseLong((String) projectComboBox.getSelectedItem()),
                            contractTypeCoboBox.getSelectedIndex(),
                            requestingDepartmentComboBox.getSelectedIndex(), jobTitleField.getText(), jobDescriptionField.getText());
                    hrRequests.add(hrRequest);
                    clearFields(jobTitleField, jobDescriptionField);
                    updateGUI();
                } catch (NumberFormatException e2) {
                    if (e2.getMessage() == "null")
                        invalidComboBoxValue();
                    else
                        invalidNumberInput();
                }

            }

        }

    }

    //ActionListener for the create budgetIssue button on the budget-issue page on the main frame
    class BudgetIssueListener implements ActionListener {

        private JTextField amountField, reasonField;
        private JComboBox requestingDepartmentComboBox, projectComboBox;

        BudgetIssueListener(JTextField amountField, JTextField reasonField, JComboBox requestingDepartmentComboBox,
                            JComboBox projectComboBox) {

            this.amountField = amountField;
            this.reasonField = reasonField;
            this.requestingDepartmentComboBox = requestingDepartmentComboBox;
            this.projectComboBox = projectComboBox;

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (amountField.getText().length() == 0 || reasonField.getText().length() == 0) {
                invalidInput("");
            } else {
                try {
                    long projects[] = new long[gui.getApplications().size()];
                    for (int i = 0; i < gui.getApplications().size(); i++) {
                        projects[i] = gui.getApplications().get(i).getProjectReferenceId();
                    }

                    BudgetIssueRequest b = new BudgetIssueRequest(requestingDepartmentComboBox.getSelectedIndex(),
                            projects[projectComboBox.getSelectedIndex()], Integer.valueOf(amountField.getText()).intValue(), reasonField.getText());
                    budgetIssues.add(b);
                    clearFields(amountField, reasonField);
                    updateGUI();
                } catch (Exception e2) {
                    System.out.println("Exception catched, hrrequest: " + e2.getMessage());
                    if (e2.getMessage() == "null" || e2.getMessage().contains("-1"))
                        invalidComboBoxValue();
                    else
                        invalidNumberInput();
                }

            }


        }

    }

    //ActionListener for the create subtask button on the subtasks page on the main frame
    class SubTeamTasksListener implements ActionListener {

        private JTextField descriptionField, assignedToField, priorityField;
        private JComboBox projectComboBox;

        SubTeamTasksListener(JTextField descriptionField, JTextField assignedToField, JTextField priorityField, JComboBox projectComboBox) {
            this.descriptionField = descriptionField;
            this.assignedToField = assignedToField;
            this.priorityField = priorityField;
            this.projectComboBox = projectComboBox;
        }

        @Override
        public void actionPerformed(ActionEvent e) {


            if (descriptionField.getText().length() == 0 || assignedToField.getText().length() == 0 || priorityField.getText().length() == 0) {
                invalidInput("");
            } else {
                try {
                    SubTeamTask task = new SubTeamTask(Long.parseLong((String) projectComboBox.getSelectedItem()),
                            descriptionField.getText(), assignedToField.getText(), Integer.parseInt(priorityField.getText()));
                    tasks.add(task);
                    updateGUI();
                } catch (NumberFormatException e2) {
                    if (e2.getMessage() == "null")
                        invalidComboBoxValue();
                    else
                        invalidNumberInput();
                }
            }
        }
    }

    //errorMessage dialog
    private void errorMessage(String string) {
        SwingUtilities.invokeLater(() ->
                JOptionPane.showMessageDialog(null, string,
                        "Error", JOptionPane.INFORMATION_MESSAGE)
        );
    }

    //invalidInput dialog
    private void invalidInput(String errorStr) {
        SwingUtilities.invokeLater(() ->
                JOptionPane.showMessageDialog(null, "Please fill all fields" + errorStr,
                        "Invalid input", JOptionPane.INFORMATION_MESSAGE)
        );
    }

    //Invalid number dialog
    private void invalidNumberInput() {
        SwingUtilities.invokeLater(() ->
                JOptionPane.showMessageDialog(null, "There is text in number field(s)",
                        "Invalid input", JOptionPane.INFORMATION_MESSAGE)
        );
    }

    //Invalid combobox dialog
    private void invalidComboBoxValue() {
        SwingUtilities.invokeLater(() ->
                JOptionPane.showMessageDialog(null, "Invalid combobox selection",
                        "Invalid input", JOptionPane.INFORMATION_MESSAGE)
        );
    }

    //ActionListener for the save edits button on the EventApplication page on the main frame
    class EventEditListener implements ActionListener {
        private DefaultTableModel model;
        private User user;

        EventEditListener(DefaultTableModel model, User user) {
            this.model = model;
            this.user = user;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < model.getRowCount(); i++) {
                long projectReferenceId = Long.parseLong((String) model.getValueAt(i, 0));
                long budget = Long.parseLong((String) model.getValueAt(i, 1));
                int discount = Integer.parseInt((String) model.getValueAt(i, 2));
                String eventType = (String) model.getValueAt(i, 3);
                String preferences = (String) model.getValueAt(i, 4);
                String description = (String) model.getValueAt(i, 5);
                String from = (String) model.getValueAt(i, 6);
                String to = (String) model.getValueAt(i, 7);
                int expectedAttendees = Integer.parseInt((String) model.getValueAt(i, 8));
                String budgetComments = (String) model.getValueAt(i, 9);
                String status = (String) model.getValueAt(i, 10);
                applications.forEach((app) -> {
                    if (app.getProjectReferenceId() == projectReferenceId) {
                        boolean edited = (budget != app.getBudget() ||
                                discount != app.getDiscount() || !eventType.equals(app.getEventType()) ||
                                !preferences.equals(app.getPreferences()) || !description.equals(app.getDescription())
                                || !to.equals(app.getTo()) || !from.equals((app.getFrom())) || expectedAttendees != app.getExpectedAttendees()
                                || !budgetComments.equals(budgetComments) || !status.equals(app.getStatus()));
                        app.setBudget(budget);
                        app.setDiscount(discount);
                        app.setEventType(eventType);
                        app.setPreferences(preferences);
                        app.setDescription(description);
                        app.setTo(to);
                        app.setFrom(from);
                        app.setExpectedAttendees(expectedAttendees);
                        app.setBudgetComments(budgetComments);
                        app.setStatus(status);
                        if (edited)
                            app.setHistory(app.getHistory() + "\n" + user.getRole() + " " + user.getUsername() + " reviewed and edited");
                    }
                });
            }
            updateGUI();
        }
    }

    //ActionListener for the approve application button on the home page on the main frame
    class ApproveListener implements ActionListener {
        private DefaultTableModel model;
        private User user;

        public ApproveListener(DefaultTableModel model, User user) {
            this.model = model;
            this.user = user;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < model.getRowCount(); i++) {
                long projectReferenceId = Long.parseLong((String) model.getValueAt(i, 0));
                boolean approved = (Boolean) model.getValueAt(i, 1);
                applications.forEach((app) -> {
                    if (app.getProjectReferenceId() == projectReferenceId) {
                        if (!app.isApproved() && approved)
                            app.setHistory(app.getHistory() + "\n" + user.getRole() + " " + user.getUsername() + " " +
                                    " approved the application");
                        app.setApproved(approved);
                    }
                });
            }
            updateGUI();
        }
    }

    /**
     * getUsers
     *
     * @return List of all users
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * getClients
     *
     * @return list of all clients
     */
    public ArrayList<ClientRecord> getClients() {
        return clients;
    }

    /**
     * getApplications
     *
     * @return list of all applications
     */
    public ArrayList<EventApplication> getApplications() {
        return applications;
    }

    /**
     * Updates the list of applications
     *
     * @param applications new list of applications
     */
    public void setApplications(ArrayList<EventApplication> applications) {
        this.applications = applications;
    }

    /**
     * getHrRequests
     *
     * @return list of all HrRequests
     */
    public ArrayList<HrRequest> getHrRequests() {
        return hrRequests;
    }

    /**
     * getBudgetIssueRequests
     *
     * @return list of all BudgetIssueRequests
     */
    public ArrayList<BudgetIssueRequest> getBudgetIssueRequests() {
        return budgetIssues;
    }

    /**
     * getTasks
     *
     * @return list of all subteam-tasks
     */
    public ArrayList<SubTeamTask> getTasks() {
        return tasks;
    }

    /**
     * Removes a budget issue request with index n
     *
     * @param n index to be removed
     */
    public void removeBudgetIssueRequest(int n) {
        budgetIssues.remove(n);
        updateGUI();
    }

    /**
     * Removes HrRequest with index selectedRow
     *
     * @param selectedRow index to be removed
     */
    public void removeHrRequest(int selectedRow) {
        hrRequests.remove(selectedRow);
        updateGUI();

    }

    /**
     * Adds a Frame to the application
     *
     * @param frame
     */
    public void addFrame(MainFrame frame) {
        mainFrames.add(frame);
    }
}
