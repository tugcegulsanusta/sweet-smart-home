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

import model.devices.DishWasher;

public class DishWasherPanel extends JPanel {

	private final DishWasher dishWasher;

	public DishWasherPanel(DishWasher dishWasher) {
		System.out.println("dishwasher" + dishWasher);
		this.dishWasher = dishWasher;

		BufferedImage imageDishWasher;
		try {
			imageDishWasher = ImageIO.read(ClassLoader.getSystemResource("DishWasher.png"));
			JLabel imageLabelDishWasher = new JLabel(new ImageIcon(imageDishWasher));
			imageLabelDishWasher.setBounds(0, 0, imageDishWasher.getWidth(), imageDishWasher.getHeight());
			add(imageLabelDishWasher);
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
