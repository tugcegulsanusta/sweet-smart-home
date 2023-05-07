package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class AbstractDevicePanel extends JPanel {

	protected final SmartHomeMainFrame mainFrame;
	protected final JButton deleteButton;

	public AbstractDevicePanel(SmartHomeMainFrame mainFrame) {
		this.mainFrame = mainFrame;

		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.removePanel(AbstractDevicePanel.this);
			}
		});
		deleteButton.setBounds(201, 5, 89, 23);
	}

}
