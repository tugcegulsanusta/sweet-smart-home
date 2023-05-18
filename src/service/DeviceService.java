package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import model.devices.AirConditioner;
import model.devices.DishWasher;
import model.devices.Fridge;
import model.devices.WashingMachine;
import model.interfaces.StatefulInterface;
import model.json.JsonDataStructure;

public class DeviceService {
	public static final DeviceService SINGLETON = new DeviceService();

	private DeviceService() {

	}

	/**
	 * newDeviceType convention
	 * @return object for each device
	 * used in SmartHomeMainFrame
	 */
	public DishWasher newDishWasher() {

		return new DishWasher();

	}

	public WashingMachine newWashingMachine() {

		return new WashingMachine();
	}

	public AirConditioner newAirConditioner() {

		return new AirConditioner();
	}

	public Fridge newFridge() {

		return new Fridge();
	}

	/**
	 * @param devices
	 * @param jsonFilePath
	 * saveAll function creates a file with Gson and FileWriter
	 * to save without losing data, JsonDataStructure object needs to be created
	 * used in SmartHomeMainFrame - btnSaveButton action connected with this function
	 */
	public void saveAll(List<StatefulInterface> devices, String jsonFilePath) {
		JsonDataStructure dataStructure = new JsonDataStructure();
		for (StatefulInterface si : devices) {
			dataStructure.add(si);
		}

		try (FileWriter writer = new FileWriter(jsonFilePath); BufferedWriter bw = new BufferedWriter(writer)) {
			Gson gson = new Gson();
			bw.write(gson.toJson(dataStructure));

		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
	}

	/**
	 * @param jsonFilePath
	 * @return JsonDataStructure
	 * load function reads a file via BufferedReader
	 * loads devices to the system in lexicographical order
	 * used in SmartHomeMainFrame - btnLoadButton action connected with this function
	 */
	public JsonDataStructure load(String jsonFilePath) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(jsonFilePath));
			return new Gson().fromJson(br, JsonDataStructure.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}

}
