package model.json;

import java.util.ArrayList;
import java.util.List;

import model.devices.AirConditioner;
import model.devices.DishWasher;
import model.devices.Fridge;
import model.devices.WashingMachine;
import model.interfaces.StatefulInterface;

public class JsonDataStructure {

	private List<AirConditioner> airConditioners;
	private List<DishWasher> dishWashers;
	private List<Fridge> fridges;
	private List<WashingMachine> washingMachines;

	public JsonDataStructure() {
		airConditioners = new ArrayList<>();
		dishWashers = new ArrayList<>();
		fridges = new ArrayList<>();
		washingMachines = new ArrayList<>();
	}

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
