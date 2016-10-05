package kth.id2007.project;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

/**
 * 
 * 
 */  
class StartFrame extends JFrame
{
	private MigLayout layout;
	private JTextField userNameField,passwordField;
	private JButton loginButton;
	
	public StartFrame(){
		super("Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		layout=new MigLayout("wrap 2");
		setLayout(layout);
	
		userNameField=new JTextField(25);
		passwordField=new JTextField(25);
		loginButton=new JButton("Log in");
		
		
		add(new JLabel("Login"),"span 2");
		add(new JLabel("Username"),"span 1");
		add(userNameField,"span 1");
		add(new JLabel("Password"),"span 1");
		add(passwordField,"span 1");
		add(loginButton,"span 1");
		
		pack();
		setVisible(true);
	}

}
