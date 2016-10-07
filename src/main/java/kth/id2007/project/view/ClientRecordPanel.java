package kth.id2007.project.view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ClientRecordPanel extends JPanel {

	private GUI gui;
	private JTextField clientNameField;
	private MigLayout layout;
	private JButton saveButton;
	private JTextField clientEmailField;
	private JTextField clientPhoneNumberField;
	

	public ClientRecordPanel(GUI gui){
		this.gui = gui;
		
		layout=new MigLayout("wrap 2");
		setLayout(layout);
	
		clientNameField=new JTextField(25);
		clientEmailField=new JTextField(25);
		clientPhoneNumberField=new JTextField(25);
	
		saveButton=new JButton("Save Record");
		saveButton.addActionListener(gui.new ClientRecordListener(clientNameField,clientEmailField,clientPhoneNumberField));
		
		add(new JLabel("Client Name"),"span 1");
		add(clientNameField,"span 1");
	
		add(new JLabel("Email"),"span 1");
		add(clientEmailField,"span 1");
		
		add(new JLabel("Phone Number"),"span 1");
		add(clientPhoneNumberField,"span 1");
		
		add(saveButton,"span 1");
	}
}
