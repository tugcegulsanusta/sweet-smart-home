package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.interfaces.StatefulInterface;

public abstract class AbstractDevicePanel extends JPanel {

	protected final SmartHomeMainFrame mainFrame;
	protected final StatefulInterface statefulInterface;
	protected final JButton deleteButton;
	private JTextField textField;
	protected final JLabel statusLabel;

	public AbstractDevicePanel(SmartHomeMainFrame mainFrame, StatefulInterface statefulInterface) {
		this.statefulInterface = statefulInterface;
		this.mainFrame = mainFrame;

		statusLabel = new JLabel("Status: " + getCurrentState());
		statusLabel.setForeground(new Color(64, 0, 128));

		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.removePanel(AbstractDevicePanel.this);
			}
		});
		deleteButton.setBounds(201, 5, 89, 23);
		add(deleteButton);

		statusLabel.setBounds(201, 50, 150, 50);
		add(statusLabel);

	}

	protected String getCurrentState() {
		return statefulInterface.getCurrentState().toString();
	}

}
