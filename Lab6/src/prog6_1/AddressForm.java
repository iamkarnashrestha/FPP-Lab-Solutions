package prog6_1;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class AddressForm extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldStreet;
	private JTextField textFieldCity;
	private JTextField textFieldState;
	private JTextField textFieldZip;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressForm frame = new AddressForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AddressForm() {
		setTitle("Address Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelName = new JLabel("Name");
		labelName.setBounds(32, 11, 46, 14);
		contentPane.add(labelName);
		
		JLabel labelStreet = new JLabel("Street");
		labelStreet.setBounds(159, 11, 46, 14);
		contentPane.add(labelStreet);
		
		JLabel labelCity = new JLabel("City");
		labelCity.setBounds(292, 11, 46, 14);
		contentPane.add(labelCity);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(29, 27, 90, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldStreet = new JTextField();
		textFieldStreet.setColumns(10);
		textFieldStreet.setBounds(157, 27, 90, 20);
		contentPane.add(textFieldStreet);
		
		textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(288, 27, 90, 20);
		contentPane.add(textFieldCity);
		
		JLabel labelState = new JLabel("State");
		labelState.setBounds(85, 64, 46, 14);
		contentPane.add(labelState);
		
		textFieldState = new JTextField();
		textFieldState.setColumns(10);
		textFieldState.setBounds(82, 80, 90, 20);
		contentPane.add(textFieldState);
		
		JLabel labelZip = new JLabel("Zip");
		labelZip.setBounds(234, 64, 46, 14);
		contentPane.add(labelZip);
		
		textFieldZip = new JTextField();
		textFieldZip.setColumns(10);
		textFieldZip.setBounds(231, 80, 90, 20);
		contentPane.add(textFieldZip);
		
		JButton buttonSubmit = new JButton("Submit");
		buttonSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textFieldName.getText();
				String street = textFieldStreet.getText();
				String city = textFieldCity.getText();
				String state = textFieldState.getText();
				String zip = textFieldZip.getText();
				String output = name + "\n"+street+"\n"+city+", "+state+" "+zip;
				System.out.println(output);
			}
		});
		buttonSubmit.setBounds(158, 126, 89, 23);
		contentPane.add(buttonSubmit);
	}
}
