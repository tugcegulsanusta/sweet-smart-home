package ui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.devices.Fridge;
import model.enums.DeviceState;

public class FridgePanel extends AbstractDevicePanel {
	protected final JLabel temperatureLabel;
	private JSlider temperatureSlider;
	private final Fridge fridge;

	public FridgePanel(Fridge fridge, SmartHomeMainFrame mainFrame) {
		super(mainFrame, fridge);

		this.fridge = fridge;
		this.temperatureLabel = new JLabel();
		this.temperatureLabel.setBounds(15, 150, 150, 50);
		add(temperatureLabel);
		refreshTemperature();

		this.temperatureSlider = new JSlider(fridge.getLowerBound(), fridge.getUpperBound());

		this.temperatureSlider.setPaintTrack(true);
		this.temperatureSlider.setPaintTicks(true);
		this.temperatureSlider.setPaintLabels(true);

		// set spacing
		this.temperatureSlider.setMajorTickSpacing(2);
		this.temperatureSlider.setBounds(180, 150, 150, 50);
		add(temperatureSlider);

		temperatureSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int newTemp = temperatureSlider.getValue();
				fridge.setTemperature(newTemp);
				refreshTemperature();
				fridge.setCurrentState(DeviceState.RUNNING);
				refreshStatus();
				FridgePanel.this.statusLabel.repaint();
				FridgePanel.this.revalidate();

			}

		});

		BufferedImage imageFridge;
		try {
			imageFridge = ImageIO.read(ClassLoader.getSystemResource("Fridge.png"));
			JLabel imageLabelFridge = new JLabel(new ImageIcon(imageFridge));
			imageLabelFridge.setBounds(10, 10, imageFridge.getWidth(), imageFridge.getHeight());
			add(imageLabelFridge);
		} catch (IOException e) {
			e.printStackTrace();

		}

		setForeground(new Color(128, 128, 128));
		setBorder(new LineBorder(new Color(0, 64, 64), 5, true));
		System.out.println("fridge" + fridge);

		setBackground(new Color(192, 192, 192));
		setSize(300, 300);
		setLayout(null);

		setVisible(true);
	}

	private void refreshTemperature() {
		temperatureLabel.setText("Temperature: " + getTemperature());
	}

	private void refreshStatus() {
		statusLabel.setText("Status: " + getCurrentState());
	}

	protected int getTemperature() {
		return fridge.getTemperature();
	}

}
