package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.devices.AirConditioner;
import model.devices.DishWasher;
import model.devices.Fridge;
import model.devices.WashingMachine;
import service.DeviceService;

public class SmartHomeMainFrame {

	public List<AbstractDevicePanel> devicePanels = new ArrayList<>();
	private JFrame frmSweetSmartHome;
	private JPanel leftPanel;
	private JPanel centerPanel;
	private JPanel northPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					SmartHomeMainFrame window = new SmartHomeMainFrame();
					window.frmSweetSmartHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SmartHomeMainFrame() {
		try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {
		frmSweetSmartHome = new JFrame();
		frmSweetSmartHome.setForeground(new Color(192, 192, 192));
		frmSweetSmartHome.setTitle("Sweet Smart Home");
		frmSweetSmartHome.setIconImage(ImageIO.read(ClassLoader.getSystemResource("logo.png")));
		frmSweetSmartHome.setBounds(100, 100, 1200, 900);
		frmSweetSmartHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSweetSmartHome.getContentPane().setLayout(new BorderLayout(0, 0));

		leftPanel = new JPanel();
		frmSweetSmartHome.getContentPane().add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new GridLayout(4, 1, 0, 0));

		centerPanel = new JPanel();
		frmSweetSmartHome.getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(2, 3, 0, 0));

		JButton airConditionerBtn = new JButton("Add Air Conditioner");
		airConditionerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AirConditioner airConditioner = DeviceService.SINGLETON.addAirConditioner();
				AirConditionerPanel airConditionerPanel = new AirConditionerPanel(airConditioner,
						SmartHomeMainFrame.this);
				addPanel(airConditionerPanel);
			}
		});
		leftPanel.add(airConditionerBtn);

		JButton addFridgeBtn = new JButton("Add Fridge");
		addFridgeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Fridge fridge = DeviceService.SINGLETON.addFridge();
				FridgePanel fridgePanel = new FridgePanel(fridge, SmartHomeMainFrame.this);
				addPanel(fridgePanel);
			}
		});
		leftPanel.add(addFridgeBtn);

		JButton addDishWasherBtn = new JButton("Add Dishwasher");
		addDishWasherBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DishWasher dishWasher = DeviceService.SINGLETON.addDishWasher();
				DishWasherPanel dishWasherPanel = new DishWasherPanel(dishWasher, SmartHomeMainFrame.this);
				addPanel(dishWasherPanel);
			}
		});

		leftPanel.add(addDishWasherBtn);

		JButton addWashingMachineBtn = new JButton("Add Washing Machine");
		addWashingMachineBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WashingMachine washingMachine = DeviceService.SINGLETON.addWashingMachine();
				WashingMachinePanel washingMachinePanel = new WashingMachinePanel(washingMachine,
						SmartHomeMainFrame.this);
				addPanel(washingMachinePanel);
			}
		});

		leftPanel.add(addWashingMachineBtn);

		northPanel = new JPanel();
		frmSweetSmartHome.getContentPane().add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnLoadButton = new JButton("Load");
		northPanel.add(btnLoadButton);

		JButton btnSaveButton_1 = new JButton("Save");
		northPanel.add(btnSaveButton_1);
	}

	public void removePanel(AbstractDevicePanel devicePanel) {
		devicePanels.remove(devicePanel);
		centerPanel.remove(devicePanel);
		centerPanel.revalidate();
		centerPanel.repaint();
	}

	public void addPanel(AbstractDevicePanel devicePanel) {
		if (devicePanels.size() < 6) {
			devicePanels.add(devicePanel);
			centerPanel.add(devicePanel);
			centerPanel.revalidate();
		} else {
			JOptionPane.showMessageDialog(centerPanel, "Device panels reached its limits!");
		}
	}

}
