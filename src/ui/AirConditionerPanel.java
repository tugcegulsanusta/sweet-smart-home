package ui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.devices.AirConditioner;

public class AirConditionerPanel extends AbstractDevicePanel {

	private final AirConditioner airConditioner;

	public AirConditionerPanel(AirConditioner airConditioner, SmartHomeMainFrame mainFrame) {
		super(mainFrame);
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

		add(deleteButton);
		setVisible(true);
	}
}
