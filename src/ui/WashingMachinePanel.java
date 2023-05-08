package ui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import model.devices.WashingMachine;

public class WashingMachinePanel extends AbstractDevicePanel {
	private final WashingMachine washingMachine;

	public WashingMachinePanel(WashingMachine washingMachine, SmartHomeMainFrame mainFrame) {
		super(mainFrame);

		setBorder(new LineBorder(new Color(0, 64, 64), 5, true));
		System.out.println("washingMachine" + washingMachine);
		this.washingMachine = washingMachine;

		BufferedImage imageWashingMachine;
		try {
			imageWashingMachine = ImageIO.read(ClassLoader.getSystemResource("WashingMachine.png"));
			JLabel imageLabelWashingMachine = new JLabel(new ImageIcon(imageWashingMachine));
			imageLabelWashingMachine.setBounds(10, 10, imageWashingMachine.getWidth(), imageWashingMachine.getHeight());
			add(imageLabelWashingMachine);
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
