package kth.id2007.project.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private StartFrame startFrame;

    public GUI(){
        startFrame = new StartFrame(this);
    }

    public static void main(String[] args) {
        new GUI();
    }

    class LoginListener implements ActionListener{

        private final JTextField usernameField;
        private final JTextField passwordField;

        public LoginListener(JTextField usernameField, JTextField passwordField){

            this.usernameField = usernameField;
            this.passwordField = passwordField;
        }
        /**
         * Invoked when an action occurs.
         *
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            if(usernameField.getText().equals("test") && passwordField.getText().equals("test"))
                JOptionPane.showInputDialog(null, "Login Success", "Login Success", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showInputDialog(null, "Login Fail", "Login Fail", JOptionPane.INFORMATION_MESSAGE);
        }
    }


}   
