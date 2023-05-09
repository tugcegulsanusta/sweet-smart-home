package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import model.devices.AirConditioner;
import model.devices.DishWasher;
import model.devices.Fridge;
import model.devices.WashingMachine;
import model.interfaces.StatefulInterface;

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

	public static void saveAll(List<StatefulInterface> devices, String jsonFilePath) {
		try (FileWriter writer = new FileWriter(jsonFilePath); BufferedWriter bw = new BufferedWriter(writer)) {
			Gson gson = new Gson();
			bw.write(gson.toJson(devices));

		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
	}

}
