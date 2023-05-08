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

import model.devices.AirConditioner;

public class AirConditionerPanel extends AbstractDevicePanel {
	protected final JLabel temperatureLabel;
	private JSlider temperatureSlider;
	private final AirConditioner airConditioner;

	public AirConditionerPanel(AirConditioner airConditioner, SmartHomeMainFrame mainFrame) {

		super(mainFrame, airConditioner);

		this.airConditioner = airConditioner;
		this.temperatureLabel = new JLabel();
		this.temperatureLabel.setBounds(15, 150, 150, 50);
		add(temperatureLabel);
		refreshTemperature();

		this.temperatureSlider = new JSlider(airConditioner.getLowerBound(), airConditioner.getUpperBound());

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
				airConditioner.setTemperature(newTemp);
				refreshTemperature();
				AirConditionerPanel.this.revalidate();

			}

		});

		BufferedImage image;
		try {
			image = ImageIO.read(ClassLoader.getSystemResource("AirConditioner1.png"));
			JLabel imageLabel = new JLabel(new ImageIcon(image));
			imageLabel.setBounds(10, 10, image.getWidth(), image.getHeight());
			add(imageLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}

		setForeground(new Color(0, 64, 64));
		setBorder(new LineBorder(new Color(0, 64, 64), 5, true));
		System.out.println("airConditioner" + airConditioner);

		setBackground(new Color(192, 192, 192));
		setSize(300, 300);
		setLayout(null);

		setVisible(true);

	}

	private void refreshTemperature() {
		temperatureLabel.setText("Temperature: " + getTemperature());
	}

	protected int getTemperature() {
		return airConditioner.getTemperature();
	}

}
