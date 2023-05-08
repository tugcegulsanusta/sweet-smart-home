package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import model.devices.DishWasher;
import model.enums.ProgramType;

public class DishWasherPanel extends AbstractDevicePanel {

	private final DishWasher dishWasher;
	protected final JLabel programLabel;
	private JComboBox programBox;

	public DishWasherPanel(DishWasher dishWasher, SmartHomeMainFrame mainFrame) {
		super(mainFrame, dishWasher);

		this.dishWasher = dishWasher;

		programLabel = new JLabel();
		programLabel.setForeground(new Color(64, 0, 128));
		refreshProgram();

		programLabel.setBounds(30, 175, 175, 50);
		add(programLabel);

		Object[] programs = dishWasher.getAvailablePrograms().stream().toArray();

		programBox = new JComboBox(programs);
		programBox.setBounds(180, 180, 150, 30);
		programBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ProgramType newProgram = (ProgramType) programBox.getSelectedItem();
				dishWasher.setProgram(newProgram);
				refreshProgram();
				DishWasherPanel.this.revalidate();

			}

		});

		add(programBox);

		setBorder(new LineBorder(new Color(0, 64, 64), 5, true));
		System.out.println("dishwasher" + dishWasher);

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

	private void refreshProgram() {
		programLabel.setText("Program: " + getProgram());
	}

	protected String getProgram() {
		return dishWasher.getProgram().toString();
	}

}
