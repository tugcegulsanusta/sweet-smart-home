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

	public static JsonDataStructure load(String jsonFilePath) {
		BufferedReader br;
		JsonDataStructure myData = null;
		try {
			br = new BufferedReader(new FileReader(jsonFilePath));
			myData = new Gson().fromJson(br, JsonDataStructure.class);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		System.err.println(myData);
		return myData;

	}

}
