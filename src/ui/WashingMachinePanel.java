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

import model.devices.WashingMachine;
import model.enums.ProgramType;

public class WashingMachinePanel extends AbstractDevicePanel {

	private final WashingMachine washingMachine;
	protected final JLabel programLabel;
	private JComboBox programBox;

	public WashingMachinePanel(WashingMachine washingMachine, SmartHomeMainFrame mainFrame) {
		super(mainFrame, washingMachine);

		this.washingMachine = washingMachine;

		programLabel = new JLabel();
		programLabel.setForeground(new Color(64, 0, 128));
		refreshProgram();

		programLabel.setBounds(30, 175, 175, 50);
		add(programLabel);

		Object[] programs = washingMachine.getAvailablePrograms().stream().toArray();

		programBox = new JComboBox(programs);
		programBox.setBounds(180, 180, 150, 30);
		programBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ProgramType newProgram = (ProgramType) programBox.getSelectedItem();
				washingMachine.setProgram(newProgram);
				refreshProgram();
				WashingMachinePanel.this.revalidate();

			}

		});

		add(programBox);

		setBorder(new LineBorder(new Color(0, 64, 64), 5, true));
		System.out.println("washingMachine" + washingMachine);

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

		setVisible(true);

	}

	private void refreshProgram() {
		programLabel.setText("Program: " + getProgram());
	}

	protected String getProgram() {
		return washingMachine.getProgram().toString();
	}

}
