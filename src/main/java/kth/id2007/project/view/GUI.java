package kth.id2007.project.view;

import kth.id2007.project.model.ClientRecord;
import kth.id2007.project.model.EventApplication;
import kth.id2007.project.model.HrRequest;
import kth.id2007.project.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

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
        private JTextField toField;
        private JTextField fromField;
        private JTextField expectedAttendeesField;

        EventApplicationListener(JTextField budgetField, JTextField discountField, JTextField eventTypeField,
                                 JTextField preferencesField, JTextField descriptionField, JTextField toField,
                                 JTextField fromField, JTextField expectedAttendeesField) {
            this.budgetField = budgetField;
            this.discountField = discountField;
            this.eventTypeField = eventTypeField;
            this.preferencesField = preferencesField;
            this.descriptionField = descriptionField;
            this.toField = toField;
            this.fromField = fromField;
            this.expectedAttendeesField = expectedAttendeesField;
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
                        new Date(), new Date(),
                        Integer.parseInt(getField(expectedAttendeesField, "expected atendees"))));
                updateGUI();

            } catch (Exception e2) {
                invalidInput(errorStr);
            }


        }
    }

    class HrRequestListener implements ActionListener {
        private JComboBox contractTypeCoboBox;
        private JComboBox requestingDepartmentComboBox;
        private JTextField jobTitleField;
        private JTextField jobDescriptionField;

        public HrRequestListener(JComboBox contractTypeComboBox, JComboBox contractTypeComboBox2,
                                 JTextField jobTitleField, JTextField jobDescriptionField) {

            this.contractTypeCoboBox = contractTypeComboBox;
            this.requestingDepartmentComboBox = contractTypeComboBox2;
            this.jobTitleField = jobTitleField;
            this.jobDescriptionField = jobDescriptionField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            HrRequest hrRequest = new HrRequest(contractTypeCoboBox.getSelectedIndex(),
                    requestingDepartmentComboBox.getSelectedIndex(), jobTitleField.getText(), jobDescriptionField.getText());
            hrRequests.add(hrRequest);
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
}   
