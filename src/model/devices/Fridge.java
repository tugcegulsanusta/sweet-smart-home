package model.devices;

import java.util.Arrays;
import java.util.List;

import model.abstracts.AbstractTemperatureDevice;
import model.enums.DeviceState;
import model.enums.DeviceType;
import model.interfaces.TemperatureInterface;

public class Fridge extends AbstractTemperatureDevice implements TemperatureInterface {

	/**
	 * @return DeviceState - Enum
	 */
	@Override
	public List<DeviceState> getAvailableStates() {
		return Arrays.asList(DeviceState.OPENED, DeviceState.CLOSED, DeviceState.RUNNING);
	}

	/**
	 * @return DeviceType-Fridge-Enum
	 */
	@Override
	public DeviceType getDeviceType() {
		return DeviceType.Fridge;
	}

	/**
	 * @return int upperBound for Fridge
	 */
	@Override
	public int getUpperBound() {
		return 4;
	}

	/**
	 * @return int lowerBound for Fridge
	 */
	@Override
	public int getLowerBound() {
		return -2;
	}

}
