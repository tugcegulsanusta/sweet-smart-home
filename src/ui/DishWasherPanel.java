package ui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import model.devices.DishWasher;

public class DishWasherPanel extends AbstractDevicePanel {

	private final DishWasher dishWasher;

	public DishWasherPanel(DishWasher dishWasher, SmartHomeMainFrame mainFrame) {
		super(mainFrame, dishWasher);

		setBorder(new LineBorder(new Color(0, 64, 64), 5, true));
		System.out.println("dishwasher" + dishWasher);
		this.dishWasher = dishWasher;

		BufferedImage imageDishWasher;
		try {
			imageDishWasher = ImageIO.read(ClassLoader.getSystemResource("DishWasher.png"));
			JLabel imageLabelDishWasher = new JLabel(new ImageIcon(imageDishWasher));
			imageLabelDishWasher.setBounds(10, 10, imageDishWasher.getWidth(), imageDishWasher.getHeight());
			add(imageLabelDishWasher);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setBackground(new Color(192, 192, 192));
		setSize(300, 300);
		setLayout(null);

		setVisible(true);

	}

}
