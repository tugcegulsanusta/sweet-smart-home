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
import model.interfaces.StatefulInterface;
import model.json.JsonDataStructure;
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
					SmartHomeMainFrame smartHomeMainFrame = new SmartHomeMainFrame();
					smartHomeMainFrame.frmSweetSmartHome.setVisible(true);
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
				addAirConditioner(DeviceService.SINGLETON.newAirConditioner());
			}
		});
		leftPanel.add(airConditionerBtn);

		JButton addFridgeBtn = new JButton("Add Fridge");
		addFridgeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addFridge(DeviceService.SINGLETON.newFridge());
			}
		});
		leftPanel.add(addFridgeBtn);

		JButton addDishWasherBtn = new JButton("Add Dishwasher");
		addDishWasherBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addDishWasher(DeviceService.SINGLETON.newDishWasher());

			}
		});

		leftPanel.add(addDishWasherBtn);

		JButton addWashingMachineBtn = new JButton("Add Washing Machine");
		addWashingMachineBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addWashingMachine(DeviceService.SINGLETON.newWashingMachine());
			}
		});

		leftPanel.add(addWashingMachineBtn);

		northPanel = new JPanel();
		frmSweetSmartHome.getContentPane().add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnLoadButton = new JButton("Load");
		northPanel.add(btnLoadButton);

		btnLoadButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				devicePanels.forEach(SmartHomeMainFrame.this::removePanel);
				String path = "C:\\Users\\eshan\\eclipse-workspace\\test.txt";
				JsonDataStructure jsonDataStructure = DeviceService.SINGLETON.load(path);
				jsonDataStructure.getAirConditioners().forEach(SmartHomeMainFrame.this::addAirConditioner);
				jsonDataStructure.getDishWashers().forEach(SmartHomeMainFrame.this::addDishWasher);
				jsonDataStructure.getFridges().forEach(SmartHomeMainFrame.this::addFridge);
				jsonDataStructure.getWashingMachines().forEach(SmartHomeMainFrame.this::addWashingMachine);

			}

		});

		JButton btnSaveButton = new JButton("Save");
		northPanel.add(btnSaveButton);

		btnSaveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<StatefulInterface> devices = devicePanels.stream().map(AbstractDevicePanel::getStatefulInterface)
						.toList();
				String path = "C:\\Users\\eshan\\eclipse-workspace\\test.txt";
				DeviceService.SINGLETON.saveAll(devices, path);

			}

		});
	}

	protected void addAirConditioner(AirConditioner airConditioner) {
		AirConditionerPanel airConditionerPanel = new AirConditionerPanel(airConditioner, SmartHomeMainFrame.this);
		addPanel(airConditionerPanel);
	}

	protected void addFridge(Fridge fridge) {
		FridgePanel fridgePanel = new FridgePanel(fridge, SmartHomeMainFrame.this);
		addPanel(fridgePanel);
	}

	protected void addDishWasher(DishWasher dishWasher) {
		DishWasherPanel dishWasherPanel = new DishWasherPanel(dishWasher, SmartHomeMainFrame.this);
		addPanel(dishWasherPanel);
	}

	protected void addWashingMachine(WashingMachine washingMachine) {

		WashingMachinePanel washingMachinePanel = new WashingMachinePanel(washingMachine, SmartHomeMainFrame.this);
		addPanel(washingMachinePanel);
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
