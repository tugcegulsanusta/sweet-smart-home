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

import model.devices.Fridge;

public class FridgePanel extends JPanel {

	private final Fridge fridge;

	public FridgePanel(Fridge fridge) {
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
