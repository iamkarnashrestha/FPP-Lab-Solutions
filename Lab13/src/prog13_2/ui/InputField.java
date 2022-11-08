package prog13_2.ui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A general utility class to create a combo of label and text-field to be used
 * in forms in block layout.
 * 
 *
 *
 */
public class InputField {
	private final static int DEFAULT_FIELD_SIZE = 20;
	private JTextField field;
	private JLabel label;
	private JPanel blockPanel;

	public InputField(String label, int size) {
		this.field = new JTextField(size);
		this.label = new JLabel(label);

		blockPanel = new JPanel(new BorderLayout());
		blockPanel.add(this.label, BorderLayout.NORTH);
		blockPanel.add(this.field, BorderLayout.SOUTH);
	}
	
	public InputField(String label) {
		this(label, DEFAULT_FIELD_SIZE);
	}

	/**
	 * Getter for the container of the label-field combo
	 * 
	 * @return Container panel of label and field
	 */
	public JPanel getInputFieldPanel() {
		return this.blockPanel;
	}

	/**
	 * Sets the provided string value as the inner text of the field.
	 * 
	 * @param value
	 */
	public void setFieldValue(String value) {
		this.field.setText(value);
	}

	/**
	 * Getter for the field's inner text value
	 * 
	 * @return Field text value
	 */
	public String getFieldValue() {
		return this.field.getText();
	}
}
