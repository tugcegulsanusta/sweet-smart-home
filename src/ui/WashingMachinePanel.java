package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.devices.WashingMachine;

public class WashingMachinePanel extends JPanel {
	private final WashingMachine washingMachine;

	public WashingMachinePanel(WashingMachine washingMachine) {
		System.out.println("washingMachine" + washingMachine);
		this.washingMachine = washingMachine;

		BufferedImage imageWashingMachine;
		try {
			imageWashingMachine = ImageIO.read(ClassLoader.getSystemResource("WashingMachine.png"));
			JLabel imageLabelWashingMachine = new JLabel(new ImageIcon(imageWashingMachine));
			imageLabelWashingMachine.setBounds(0, 0, imageWashingMachine.getWidth(), imageWashingMachine.getHeight());
			add(imageLabelWashingMachine);
		} catch (IOException e) {
			e.printStackTrace();

		}
		setBackground(new Color(192, 192, 192));
		setSize(300, 300);
		setLayout(null);

		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == deleteButton) {

				}
			}
		});
		deleteButton.setBounds(201, 5, 89, 23);
		add(deleteButton);
		setVisible(true);

	}

}
