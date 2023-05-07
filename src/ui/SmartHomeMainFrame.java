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
import javax.swing.JPanel;

import model.devices.AirConditioner;
import model.devices.DishWasher;
import model.devices.Fridge;
import model.devices.WashingMachine;
import service.ProgramDeviceService;
import service.TemperatureDeviceService;

public class SmartHomeMainFrame {

	public List<JPanel> devicePanels = new ArrayList<>();
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
		frmSweetSmartHome.setBounds(100, 100, 1000, 700);
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
				AirConditioner airConditioner = TemperatureDeviceService.SINGLETON.addAirConditioner();
				AirConditionerPanel airConditionerPanel = new AirConditionerPanel(airConditioner);
				devicePanels.add(airConditionerPanel);
				centerPanel.add(airConditionerPanel);
				centerPanel.revalidate();
			}
		});
		leftPanel.add(airConditionerBtn);

		JButton addFridgeBtn = new JButton("Add Fridge");
		addFridgeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Fridge fridge = TemperatureDeviceService.SINGLETON.addFridge();
				FridgePanel fridgePanel = new FridgePanel(fridge);
				devicePanels.add(fridgePanel);
				centerPanel.add(fridgePanel);
				centerPanel.revalidate();
			}
		});
		leftPanel.add(addFridgeBtn);

		JButton addDishWasherBtn = new JButton("Add Dishwasher");
		addDishWasherBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DishWasher dishWasher = ProgramDeviceService.SINGLETON.addDishWasher();
				DishWasherPanel dishWasherPanel = new DishWasherPanel(dishWasher);
				devicePanels.add(dishWasherPanel);
				centerPanel.add(dishWasherPanel);
				centerPanel.revalidate();
			}
		});

		leftPanel.add(addDishWasherBtn);

		JButton addWashingMachineBtn = new JButton("Add Washing Machine");
		addWashingMachineBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WashingMachine washingMachine = ProgramDeviceService.SINGLETON.addWashingMachine();
				WashingMachinePanel washingMachinePanel = new WashingMachinePanel(washingMachine);
				devicePanels.add(washingMachinePanel);
				centerPanel.add(washingMachinePanel);
				centerPanel.revalidate();
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

}
