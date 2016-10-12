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
        private StartFrame startFrame;

        public LoginListener(JTextField usernameField, JPasswordField passwordField, JComboBox rolesList,
                             JComboBox teamsList, StartFrame startFrame) {
            this.usernameField = usernameField;
            this.passwordField = passwordField;
            this.rolesList = rolesList;
            this.teamsList = teamsList;
            this.startFrame = startFrame;
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            if (usernameField.getText().length() > 0 && passwordField.getPassword().length > 0) {
                User user = new User(usernameField.getText(), new String(passwordField.getPassword()),
                        (String) rolesList.getSelectedItem(), (String) teamsList.getSelectedItem());
                users.add(user);
                mainFrames.add(new MainFrame(gui, user));
                //startFrame.setVisible(false);
                usernameField.setText("");
                passwordField.setText("");
                updateGUI();
            } else invalidInput("");

        }
    }


    class ClientRecordListener implements ActionListener {
        private JTextField clientNameField;
        private JTextField clientEmailField;
        private JTextField clientPhoneNumberField;

        public ClientRecordListener(JTextField clientNameField, JTextField clientEmailField, JTextField clientPhoneNumberField) {
            this.clientNameField = clientNameField;
            this.clientEmailField = clientEmailField;
            this.clientPhoneNumberField = clientPhoneNumberField;
        }

        public void actionPerformed(ActionEvent arg0) {
            if ((clientNameField.getText().length() > 0) &&
                    (clientEmailField.getText().length() > 0) &&
                    (clientPhoneNumberField.getText().length() > 0)) {
                ClientRecord clientRecord = new ClientRecord(clientNameField.getText(), clientEmailField.getText(),
                        clientPhoneNumberField.getText(), null);
                clients.add(clientRecord);
                updateGUI();
            } else {
                invalidInput("");
            }
        }
    }

    // Action listener for login-button on the startframe.
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

        /**
         * Invoked when an action occurs.
         *
         * @param e
         */
        public void actionPerformed(ActionEvent e) {

            try {
                applications.add(new EventApplication(Long.parseLong(getField(budgetField, "budget")), Integer.parseInt(getField(discountField, "disscount")), getField(eventTypeField, "event type"),
                        getField(preferencesField, "preferences"), getField(descriptionField, "description"),
                        fromDatePicker.getJFormattedTextField().getText(), toDatePicker.getJFormattedTextField().getText(),
                        Integer.parseInt(getField(expectedAttendeesField, "expected atendees")), budgetCommentsField.getText(), (String) statusField.getSelectedItem(), ""));
                updateGUI();

            } catch (Exception e2) {
                invalidInput(errorStr);
            }


        }
    }

    class HrRequestListener implements ActionListener {
        private JComboBox contractTypeCoboBox;
        private JComboBox requestingDepartmentComboBox, projectComboBox;
        private JTextField jobTitleField;
        private JTextField jobDescriptionField;

        public HrRequestListener(JComboBox contractTypeComboBox, JComboBox requestingDepartmentComboBox,
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
            HrRequest hrRequest = new HrRequest(Long.parseLong((String) projectComboBox.getSelectedItem()),
                    contractTypeCoboBox.getSelectedIndex(),
                    requestingDepartmentComboBox.getSelectedIndex(), jobTitleField.getText(), jobDescriptionField.getText());
            hrRequests.add(hrRequest);
            updateGUI();
        }

    }

    class BudgetIssueListener implements ActionListener {

        private JTextField amountField, reasonField;
        private JComboBox requestingDepartmentComboBox, projectComboBox;

        public BudgetIssueListener(JTextField amountField, JTextField reasonField, JComboBox requestingDepartmentComboBox,
                                   JComboBox projectComboBox) {

            this.amountField = amountField;
            this.reasonField = reasonField;
            this.requestingDepartmentComboBox = requestingDepartmentComboBox;
            this.projectComboBox = projectComboBox;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            long projects[] = new long[gui.getApplications().size()];
            for (int i = 0; i < gui.getApplications().size(); i++) {
                projects[i] = gui.getApplications().get(i).getProjectRefrenceId();
            }
            BudgetIssueRequest b = new BudgetIssueRequest(requestingDepartmentComboBox.getSelectedIndex(),
                    projects[projectComboBox.getSelectedIndex()], Integer.valueOf(amountField.getText()).intValue(), reasonField.getText());
            budgetIssues.add(b);
            updateGUI();
        }

    }

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

            SubTeamTask task = new SubTeamTask(Long.parseLong((String) projectComboBox.getSelectedItem()),
                    descriptionField.getText(), assignedToField.getText(), Integer.parseInt(priorityField.getText()));
            tasks.add(task);
            updateGUI();
        }
    }

    //invalidInput dialog
    private void invalidInput(String errorStr) {
        SwingUtilities.invokeLater(() ->
                JOptionPane.showMessageDialog(null, "These fields are empty! " + errorStr,
                        "Invalid input", JOptionPane.INFORMATION_MESSAGE)
        );
    }

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
                    if (app.getProjectRefrenceId() == projectReferenceId) {
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
                        app.setHistory(app.getHistory() + "\n" + user.getRole() + " " + user.getUsername() + " reviewed and edited");
                    }
                });
            }
            updateGUI();
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<ClientRecord> getClients() {
        return clients;
    }

    public ArrayList<EventApplication> getApplications() {
        return applications;
    }

    public ArrayList<HrRequest> getHrRequests() {
        return hrRequests;
    }

    public ArrayList<BudgetIssueRequest> getBudgetIssueRequests() {
        return budgetIssues;
    }

    public ArrayList<SubTeamTask> getTasks() {
        return tasks;
    }
}   
