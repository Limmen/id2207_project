package kth.id2007.project.view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * 
 * 
 */  
class StartFrame extends JFrame
{
	private MigLayout layout;
	private JTextField userNameField,passwordField;
	private JButton loginButton;
	private GUI gui;
	
	public StartFrame(GUI gui){
		super("Test");
		this.gui = gui;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		layout=new MigLayout("wrap 2");
		setLayout(layout);
	
		userNameField=new JTextField(25);
		passwordField=new JTextField(25);
		loginButton=new JButton("Log in");
		loginButton.addActionListener(gui. new LoginListener(userNameField, passwordField));
		
		add(new JLabel("Login"),"span 2");
		add(new JLabel("Username"),"span 1");
		add(userNameField,"span 1");
		add(new JLabel("Password"),"span 1");
		add(passwordField,"span 1");
		add(loginButton,"span 1");

		pack();
		setLocationRelativeTo(null); //center
		setVisible(true);

	}

}
