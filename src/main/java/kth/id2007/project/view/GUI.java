package kth.id2007.project.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private StartFrame startFrame;

    public GUI(){
        startFrame = new StartFrame(this);
       	new ClientRecordFrame(this);
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
            if(usernameField.getText().equals("test") && passwordField.getText().equals("test")){
                JOptionPane.showMessageDialog(null, "Login Success", "Login Success", JOptionPane.INFORMATION_MESSAGE);
            	
            }else
                JOptionPane.showMessageDialog(null, "Login Fail", "Login Fail", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    class ClientRecordListener implements ActionListener {
    	private JTextField clientNameField;
    	private JTextField clientEmailField;
    	private JTextField clientPhoneNumberField;
    	
    	public ClientRecordListener(JTextField clientNameField, JTextField clientEmailField, JTextField clientPhoneNumberField) {
			this.clientNameField=clientNameField;
			this.clientEmailField=clientEmailField;
			this.clientPhoneNumberField=clientPhoneNumberField;
		}

		public void actionPerformed(ActionEvent arg0) {
			if((clientNameField.getText().length()>0)&&
					(clientEmailField.getText().length()>0)&&
					(clientPhoneNumberField.getText().length()>0)){
				//Ok
				System.out.println("Client Name "+clientNameField.getText()+" Email "+clientEmailField.getText()+" Phone "+clientPhoneNumberField.getText());
				
			}else{
				
                JOptionPane.showMessageDialog(null, "All fields need to be filled out.","Error", JOptionPane.INFORMATION_MESSAGE);			
			}
    	}

    }




}   
