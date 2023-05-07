package ui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.devices.Fridge;

public class FridgePanel extends AbstractDevicePanel {

	private final Fridge fridge;

	public FridgePanel(Fridge fridge, SmartHomeMainFrame mainFrame) {
		super(mainFrame);
		System.out.println("fridge" + fridge);
		this.fridge = fridge;

		BufferedImage imageFridge;
		try {
			imageFridge = ImageIO.read(ClassLoader.getSystemResource("Fridge.png"));
			JLabel imageLabelFridge = new JLabel(new ImageIcon(imageFridge));
			imageLabelFridge.setBounds(0, 0, imageFridge.getWidth(), imageFridge.getHeight());
			add(imageLabelFridge);
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
