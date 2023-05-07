package service;

import model.devices.AirConditioner;
import model.devices.Fridge;

public class TemperatureDeviceService {

	public static final TemperatureDeviceService SINGLETON = new TemperatureDeviceService();

	private TemperatureDeviceService() {

	}

	public AirConditioner addAirConditioner() {

		return new AirConditioner();
	}

	public Fridge addFridge() {

		return new Fridge();
	}

}
