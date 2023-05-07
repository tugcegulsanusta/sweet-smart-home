package service;

import model.devices.DishWasher;
import model.devices.WashingMachine;

public class ProgramDeviceService {

	public static final ProgramDeviceService SINGLETON = new ProgramDeviceService();

	private ProgramDeviceService() {

	}

	public DishWasher addDishWasher() {

		return new DishWasher();

	}

	public WashingMachine addWashingMachine() {

		return new WashingMachine();
	}
}
