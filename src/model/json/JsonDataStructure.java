package model.json;

import java.util.ArrayList;
import java.util.List;

import model.devices.AirConditioner;
import model.devices.DishWasher;
import model.devices.Fridge;
import model.devices.WashingMachine;
import model.interfaces.StatefulInterface;

public class JsonDataStructure {

	/**
	 * List of devices created for store the DeviceType
	 * Due to polymorphism data for the DeviceType couldn't reach directly with Gson
	 *
	 * You can check issue of Gson below:
	 * First class support for polymorphism (subclasses!)
	 * https://github.com/google/gson/issues/231
	 */
	private List<AirConditioner> airConditioners;
	private List<DishWasher> dishWashers;
	private List<Fridge> fridges;
	private List<WashingMachine> washingMachines;

	/**
	 * Initialize ArrayList for each deviceType
	 * to avoid null pointer exception
	 */
	public JsonDataStructure() {
		airConditioners = new ArrayList<>();
		dishWashers = new ArrayList<>();
		fridges = new ArrayList<>();
		washingMachines = new ArrayList<>();
	}

	/**
	 * @param si (Stateful Interface-si)
	 * switch between Devices and add to corresponding list
	 */
	public void add(StatefulInterface si) {
		switch (si.getDeviceType()) {
		case AirConditioner:
			airConditioners.add((AirConditioner) si);
			break;
		case Fridge:
			fridges.add((Fridge) si);
			break;
		case DishWasher:
			dishWashers.add((DishWasher) si);
			break;
		case WashingMachine:
			washingMachines.add((WashingMachine) si);
			break;
		}
	}

	public List<AirConditioner> getAirConditioners() {
		return this.airConditioners;
	}

	public void setAirConditioners(List<AirConditioner> airConditioners) {

		this.airConditioners = airConditioners;
	}
	public List<DishWasher> getDishWashers() {
		return this.dishWashers;
	}

	public void setDishWasher(List<DishWasher> dishWashers) {

		this.dishWashers = dishWashers;
	}

	public List<Fridge> getFridges() {
		return this.fridges;
	}

	public void setFridges(List<Fridge> fridges) {

		this.fridges = fridges;
	}

	public List<WashingMachine> getWashingMachines() {
		return this.washingMachines;
	}

	public void setWashingMachines(List<WashingMachine> washingMachines) {

		this.washingMachines = washingMachines;
	}
}
