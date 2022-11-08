package prog6_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class StringUtility {

	private JFrame frame;
	private JTextField inputField;
	private JTextField outputField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StringUtility window = new StringUtility();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StringUtility() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton countButton = new JButton("Count Letters");
		countButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer inputLength=inputField.getText().length();
				outputField.setText(inputLength.toString());
			}
		});
		countButton.setBounds(48, 43, 151, 23);
		frame.getContentPane().add(countButton);
		
		JButton reverseButton = new JButton("Reverse Letters");
		reverseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputText=inputField.getText();
				String outputText="";
				for(int i=inputText.length()-1;i>=0;i--)
				{
					outputText+=inputText.charAt(i);
				}
				outputField.setText(outputText);
			}
		});
		reverseButton.setBounds(48, 86, 151, 23);
		frame.getContentPane().add(reverseButton);
		
		JButton removeDuplicateButton = new JButton("Remove Duplicates");
		removeDuplicateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputText = inputField.getText();
				String outputText = "";
				for(int i = 0;i<inputText.length();i++) {
					char charAtPosition = inputText.charAt(i);
					if(outputText.indexOf(charAtPosition)<0) {
						outputText+=charAtPosition;
					}
				}
				outputField.setText(outputText);
			}
		});
		removeDuplicateButton.setBounds(48, 126, 151, 23);
		frame.getContentPane().add(removeDuplicateButton);
		
		inputField = new JTextField();
		inputField.setBounds(232, 67, 151, 23);
		frame.getContentPane().add(inputField);
		inputField.setColumns(10);
		
		outputField = new JTextField();
		outputField.setColumns(10);
		outputField.setBounds(232, 112, 151, 23);
		frame.getContentPane().add(outputField);
		
		JLabel inputLabel = new JLabel("Input");
		inputLabel.setBounds(230, 47, 46, 14);
		frame.getContentPane().add(inputLabel);
		
		JLabel outputLabel = new JLabel("Output");
		outputLabel.setBounds(230, 95, 46, 14);
		frame.getContentPane().add(outputLabel);
	}
}
