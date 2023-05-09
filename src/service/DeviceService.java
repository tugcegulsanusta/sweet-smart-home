package service;

import model.devices.AirConditioner;
import model.devices.DishWasher;
import model.devices.Fridge;
import model.devices.WashingMachine;

public class DeviceService {
	public static final DeviceService SINGLETON = new DeviceService();

	private DeviceService() {

	}

	public DishWasher addDishWasher() {

		return new DishWasher();

	}

	public WashingMachine addWashingMachine() {

		return new WashingMachine();
	}

	public AirConditioner addAirConditioner() {

		return new AirConditioner();
	}

	public Fridge addFridge() {

		return new Fridge();
	}

}
