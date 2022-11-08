package prog13_2.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import prog13_2.db.Address;
import prog13_2.db.DBQuery;
import prog13_2.db.Person;
import prog13_2.db.RecordNotFoundException;


public class AddressForm {
	private static final String DEFAULT_INFO_LABEL = " ";

	private JPanel mainPanel;
	private JPanel firstRowPanel;
	private JPanel secondRowPanel;
	private JPanel thirdRowPanel;
	private JPanel fourthRowPanel;
	private InputField name;
	private InputField id;
	private InputField firstName;
	private InputField lastName;
	private InputField ssn;
	private InputField street;
	private InputField city;
	private InputField state;
	private InputField zip;
	private JLabel infoLabel;
	private JButton searchButton;
	private JButton saveButton;
	private JButton clearButton;

	public AddressForm(JFrame container) {
		buildComponents();
		buildFirstRowPanel();
		buildSecondRowPanel();
		buildThirdRowPanel();
		buildFourthRowPanel();
		buildMainPanel();
		container.getContentPane().add(mainPanel);
	}

	/**
	 * BUilds the components like fields and buttons.
	 */
	private void buildComponents() {
		id = new InputField("ID", 10);
		firstName = new InputField("First Name");
		lastName = new InputField("Last Name");
		ssn = new InputField("SSN");
		street = new InputField("Street");
		city = new InputField("City");
		state = new InputField("State");
		zip = new InputField("Zip");
		infoLabel = new JLabel(DEFAULT_INFO_LABEL);
		searchButton = new JButton("Search");
		saveButton = new JButton("Save");
		clearButton = new JButton("Clear");

		addSearchButtonEventListener();
		addSaveButtonEventListener();
		addClearButtonEventListener();
	}

	private void buildFirstRowPanel() {
		firstRowPanel = new JPanel();
		firstRowPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		firstRowPanel.add(id.getInputFieldPanel());
		firstRowPanel.add(firstName.getInputFieldPanel());
		firstRowPanel.add(lastName.getInputFieldPanel());
		firstRowPanel.add(ssn.getInputFieldPanel());
	}

	private void buildSecondRowPanel() {
		secondRowPanel = new JPanel();
		secondRowPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		secondRowPanel.add(street.getInputFieldPanel());
		secondRowPanel.add(city.getInputFieldPanel());
		secondRowPanel.add(state.getInputFieldPanel());
		secondRowPanel.add(zip.getInputFieldPanel());
	}

	private void buildThirdRowPanel() {
		thirdRowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		thirdRowPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		thirdRowPanel.add(infoLabel);
	}

	private void buildFourthRowPanel() {
		fourthRowPanel = new JPanel();
		fourthRowPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
		fourthRowPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		fourthRowPanel.add(searchButton);
		fourthRowPanel.add(saveButton);
		fourthRowPanel.add(clearButton);
	}

	private void buildMainPanel() {
		JPanel midPanel = new JPanel();

		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 30, 0, 30));
		mainPanel.setLayout(new BorderLayout(0, 10));
		midPanel.setLayout(new BorderLayout(0, 10));
		mainPanel.add(firstRowPanel, BorderLayout.NORTH);
		midPanel.add(secondRowPanel, BorderLayout.NORTH);
		midPanel.add(thirdRowPanel, BorderLayout.CENTER);
		mainPanel.add(midPanel, BorderLayout.CENTER);
		mainPanel.add(fourthRowPanel, BorderLayout.SOUTH);
	}

	private void clearFields(String[] fields) {
		if (fields == null || fields.length == 0)
			return;

		for (String field : fields) {
			switch (field) {
			case "id":
				id.setFieldValue("");
				break;
			case "firstName":
				firstName.setFieldValue("");
				break;
			case "lastName":
				lastName.setFieldValue("");
				break;
			case "ssn":
				ssn.setFieldValue("");
				break;
			case "street":
				street.setFieldValue("");
				break;
			case "city":
				city.setFieldValue("");
				break;
			case "state":
				state.setFieldValue("");
				break;
			case "zip":
				zip.setFieldValue("");
				break;
			case "infoLabel":
				infoLabel.setText(DEFAULT_INFO_LABEL);
				break;
			default:
				continue;
			}
		}
	}

	private void populateAddressFields(Address address) {
		Person person = address.getPerson();

		id.setFieldValue(person.getId());
		firstName.setFieldValue(person.getFirstName());
		lastName.setFieldValue(person.getLastName());
		ssn.setFieldValue(person.getSsn());

		street.setFieldValue(address.getStreet());
		city.setFieldValue(address.getCity());
		state.setFieldValue(address.getState());
		zip.setFieldValue(address.getZip());

		infoLabel.setText(DEFAULT_INFO_LABEL + "Record Found");
	}

	private void addSearchButtonEventListener() {
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] fieldsToClear = { "firstName", "lastName", "ssn", "street", "city", "state", "zip",
						"infoLabel" };
				clearFields(fieldsToClear);

				if (id.getFieldValue().equals("")) {
					infoLabel.setText(DEFAULT_INFO_LABEL + "Please enter an id to search for!");
					return;
				}

				try {
					Address address = DBQuery.readPersonAddress(id.getFieldValue());
					populateAddressFields(address);
				} catch (SQLException e1) {
					e1.printStackTrace();
					infoLabel.setText(DEFAULT_INFO_LABEL + "Failed to search the database!");
				} catch (RecordNotFoundException e2) {
					infoLabel.setText(DEFAULT_INFO_LABEL + e2.getMessage());
				} catch (Exception e3) {
					e3.printStackTrace();
					infoLabel.setText(DEFAULT_INFO_LABEL + "Internal Error");
				}
			}
		});
	}

	private void addSaveButtonEventListener() {
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Person person = new Person(id.getFieldValue(), firstName.getFieldValue(), lastName.getFieldValue(),
						ssn.getFieldValue());
				Address address = new Address("", person, street.getFieldValue(), city.getFieldValue(),
						state.getFieldValue(), zip.getFieldValue());
				
				try {
					DBQuery.savePersonAddress(address);
					if(person.getId().equals(""))
						infoLabel.setText(DEFAULT_INFO_LABEL+"Successfully saved the new record!");
					else 
						infoLabel.setText(DEFAULT_INFO_LABEL+"Successfully updated the record!");
				} catch (SQLException e1) {
					e1.printStackTrace();
					infoLabel.setText(DEFAULT_INFO_LABEL+"Failed to save the record!");
				}
				catch (RecordNotFoundException e2) {
					infoLabel.setText(DEFAULT_INFO_LABEL+e2.getMessage());
				}
				catch (Exception e3) {
					infoLabel.setText(DEFAULT_INFO_LABEL+e3.getMessage());
				}
			}
		});
	}

	private void addClearButtonEventListener() {
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] fieldsToClear = { "id", "firstName", "lastName", "ssn", "street", "city", "state", "zip",
						"infoLabel" };
				clearFields(fieldsToClear);
			}
		});
	}

	public InputField getStreetField() {
		return this.street;
	}

	public InputField getCityField() {
		return this.city;
	}

	public InputField getStateField() {
		return this.state;
	}

	public InputField getZipField() {
		return this.zip;
	}
}
