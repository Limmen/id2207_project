package kth.id2007.project.view;

import kth.id2007.project.model.Roles;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Frame for login to the system
 */  
public class StartFrame extends JFrame
{
	private GUI gui;
	private final boolean DEBUG=false;

	/**
	 * Class constructor. Initializes the frame.
	 *
	 * @param gui controller
	 */
	public StartFrame(GUI gui){
		super("Login");
		this.gui = gui;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new MigLayout("wrap 2, insets 50 50 50 50"));

		JTextField userNameField=new JTextField(25);
		JPasswordField passwordField=new JPasswordField(25);
		JComboBox rolesList = new JComboBox(Roles.roles());
		rolesList.setName("roles_list");
		JComboBox teamsList = new JComboBox(Roles.teams());
		teamsList.setName("teams_list");
		JButton loginButton=new JButton("Log in");
		loginButton.setName("login_button");
		loginButton.addActionListener(gui. new LoginListener(userNameField, passwordField, rolesList, teamsList));

		JLabel lbl = new JLabel("Login");
		lbl.setName("login_title");
		add(lbl,"span 2, center");
		lbl = new JLabel("Username:");
		lbl.setName("username_label");
		add(lbl,"span 1");
		userNameField.setName("username_field");
		add(userNameField,"span 1");
		lbl = new JLabel("Password:");
		lbl.setName("password_label");
		add(lbl, "span 1");
		passwordField.setName("password_field");
		add(passwordField,"span 1");
		lbl = new JLabel("Role:");
		lbl.setName("role_label");
		add(lbl,"span 1");
		add(rolesList, "span 1");
		lbl = new JLabel("Team:");
		lbl.setName("team_label");
		add(lbl,"span 1");
		add(teamsList, "span 1");
		add(loginButton,"span 2, gaptop 20");
		//Debug
		if(DEBUG){
		userNameField.setText("test");
		passwordField.setText("test");
		rolesList.setSelectedIndex(12);
		}
		
		pack();
		setLocationRelativeTo(null); //center on screen
		setVisible(true);
		//Debug
		if(DEBUG)
			loginButton.doClick();
	}

}
