package kth.id2007.project.view;

import kth.id2007.project.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * GUI Controller, all calls from the view to the model goes through here.
 */
public class GUI {

    private GUI gui = this;
    private ArrayList<User> users = new ArrayList();

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
                new MainFrame(gui, user);
                startFrame.setVisible(false);
            } else invalidInput();

        }
    }

    //invalidInput dialog
    private void invalidInput() {
        SwingUtilities.invokeLater(() ->
                JOptionPane.showMessageDialog(null, "That is not valid input",
                        "Invalid input", JOptionPane.INFORMATION_MESSAGE)
        );
    }

    public ArrayList<User> getUsers(){
        return users;
    }

}   
