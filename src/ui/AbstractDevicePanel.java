package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.enums.DeviceState;
import model.interfaces.StatefulInterface;

/**
 * AbstractDevicePanel class created for devicePanels
 * All device has statusBox + statusLabel
 * All device could be deleted from the system via deleteButton
 * Imports StatefulInterface and DeviceState-Enum to access common methods
 */

public abstract class AbstractDevicePanel extends JPanel {
	protected final SmartHomeMainFrame mainFrame;
	protected final StatefulInterface statefulInterface;
	protected final JButton deleteButton;
	protected final JLabel statusLabel;
	private JComboBox statusBox;

	/**
	 * Constructor
	 * @param mainFrame
	 * @param statefulInterface
	 */
	public AbstractDevicePanel(SmartHomeMainFrame mainFrame, StatefulInterface statefulInterface) {
		this.statefulInterface = statefulInterface;
		this.mainFrame = mainFrame;

		statusLabel = new JLabel();

		statusLabel.setForeground(new Color(64, 0, 128));
		refreshStatus();

		//JButton for delete function
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.removePanel(AbstractDevicePanel.this);
			}
		});
		deleteButton.setBounds(201, 15, 89, 23);
		add(deleteButton);

		statusLabel.setBounds(201, 50, 150, 50);
		add(statusLabel);

		/**
		 * Creates object array for storing availableStates
		 */
		Object[] statuses = statefulInterface.getAvailableStates().stream().toArray();

		// create checkbox
		statusBox = new JComboBox(statuses);
		statusBox.setBounds(180, 100, 150, 30);
		statusBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DeviceState newState = (DeviceState) statusBox.getSelectedItem();
				statefulInterface.setCurrentState(newState);
				refreshStatus();
				AbstractDevicePanel.this.revalidate();

			}
		});
		add(statusBox);

	}

	/**
	 * method for refreshing the statusLabel
	 */
	private void refreshStatus() {
		statusLabel.setText("Status: " + getCurrentState());
	}

	/**
	 *
	 * @return String currentState
	 */
	protected String getCurrentState() {
		return statefulInterface.getCurrentState().toString();
	}

	public StatefulInterface getStatefulInterface() {
		return statefulInterface;
	}

}
