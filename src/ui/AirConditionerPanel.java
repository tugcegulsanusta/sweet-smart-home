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

import model.devices.AirConditioner;

public class AirConditionerPanel extends JPanel {

	private final AirConditioner airConditioner;

	public AirConditionerPanel(AirConditioner airConditioner) {
		System.out.println("airConditioner" + airConditioner);
		this.airConditioner = airConditioner;

		BufferedImage image;
		try {
			image = ImageIO.read(ClassLoader.getSystemResource("AirConditioner1.png"));
			JLabel imageLabel = new JLabel(new ImageIcon(image));
			imageLabel.setBounds(0, 0, image.getWidth(), image.getHeight());
			add(imageLabel);
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
			}
		});
		deleteButton.setBounds(201, 5, 89, 23);
		add(deleteButton);
		setVisible(true);
	}
}
