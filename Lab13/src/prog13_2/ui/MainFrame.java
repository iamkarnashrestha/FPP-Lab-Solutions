package prog13_2.ui;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private final static String INITIAL_TITLE = "Address Form";

	private AddressForm addressForm;

	public MainFrame() {
		initializeWindow();
		addressForm = new AddressForm(this);
		pack();
		setFramePositionToCenter();
		setResizable(false);
	}

	public void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(INITIAL_TITLE);
	}

	public void setFramePositionToCenter() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int screenW = toolkit.getScreenSize().width;
		int screenH = toolkit.getScreenSize().height;
		int frameX = (int) (screenW - this.getSize().width) / 2;
		int frameY = (int) (screenH - this.getSize().height) / 2;
		this.setLocation(frameX, frameY);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFrame mainFrame = new MainFrame();

				mainFrame.setVisible(true);
			}
		});
	}
}
