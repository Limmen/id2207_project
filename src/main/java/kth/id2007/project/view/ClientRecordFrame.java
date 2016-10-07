package kth.id2007.project.view;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class ClientRecordFrame extends JFrame {

	private GUI gui;
	private JTextField clientNameField;
	private MigLayout layout;
	private JButton saveButton;
	private JTextField clientEmailField;
	private JTextField clientPhoneNumberField;
	

	public ClientRecordFrame(GUI gui){
		super("Client Record");
		this.gui = gui;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		pack();
		setLocationRelativeTo(null); //center
		setVisible(true);

	}
}
