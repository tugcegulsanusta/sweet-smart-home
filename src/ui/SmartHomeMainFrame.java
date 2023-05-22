package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
		// I have specifically used GridLayout to equally divide center panel
		// by the dynamic number of DevicePanels
		// 2 rows x 3 columns => 6 ( panel count limit )
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

			/**
			 * @param e the event to be processed to btnLoadButton
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				devicePanels.forEach(SmartHomeMainFrame.this::removePanel);

				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File file = chooser.getSelectedFile();
				String path = file.getAbsolutePath();
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

			/**
			 * @param e the event to be processed to btnSaveButton
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				List<StatefulInterface> devices = devicePanels.stream().map(AbstractDevicePanel::getStatefulInterface)
						.toList();

				/*
				List<StatefulInterface> devices = new ArrayList<>();
				for(AbstractDevicePanel adp: devicePanels ){
					StatefulInterface si = adp.getStatefulInterface();
					devices.add(si);
				}
				*/

				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File file = chooser.getSelectedFile();

				String path = file.getAbsolutePath();
				DeviceService.SINGLETON.saveAll(devices, path);

			}

		});
	}

	/**
	 * @param airConditioner
	 * add AirConditionerPanel to Frame
	 */
	protected void addAirConditioner(AirConditioner airConditioner) {
		AirConditionerPanel airConditionerPanel = new AirConditionerPanel(airConditioner, SmartHomeMainFrame.this);
		addPanel(airConditionerPanel);
	}

	/**
	 * @param fridge
	 * add FridgePanel to Frame
	 */
	protected void addFridge(Fridge fridge) {
		FridgePanel fridgePanel = new FridgePanel(fridge, SmartHomeMainFrame.this);
		addPanel(fridgePanel);
	}

	/**
	 * @param dishWasher
	 * add DishWasherPanel to Frame
	 */
	protected void addDishWasher(DishWasher dishWasher) {
		DishWasherPanel dishWasherPanel = new DishWasherPanel(dishWasher, SmartHomeMainFrame.this);
		addPanel(dishWasherPanel);
	}

	/**
	 * @param washingMachine
	 * add WashingMachinePanel to Frame
	 */
	protected void addWashingMachine(WashingMachine washingMachine) {

		WashingMachinePanel washingMachinePanel = new WashingMachinePanel(washingMachine, SmartHomeMainFrame.this);
		addPanel(washingMachinePanel);
	}

	/**
	 * @param devicePanel
	 * removes Panel with deleteButton Action
	 */
	public void removePanel(AbstractDevicePanel devicePanel) {
		devicePanels.remove(devicePanel);
		centerPanel.remove(devicePanel);
		centerPanel.revalidate();
		centerPanel.repaint();
	}

	/**
	 * @param devicePanel
	 * add panel to centerPanel
	 * throw PanelLimitException ( limit <=6 )
	 */
	public void addPanel(AbstractDevicePanel devicePanel) {
		try{
			if (devicePanels.size() < 6) {
				devicePanels.add(devicePanel);
				centerPanel.add(devicePanel);
				centerPanel.revalidate();
			}else {
				throw new PanelLimitException();
			}
		}catch (PanelLimitException e){
			JOptionPane.showMessageDialog(centerPanel, e.getMessage());
		}

	}

}
