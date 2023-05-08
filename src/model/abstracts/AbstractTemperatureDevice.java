package model.abstracts;

import model.interfaces.TemperatureInterface;

/**
 * AbstractTemperature class is created for temperature devices, which extends
 * AbstractStatefulDevices All device has a state, Temperature devices has state
 * + temperature.
 */
public abstract class AbstractTemperatureDevice extends AbstractStatefulDevice implements TemperatureInterface {

	protected int currentTemp;

	@Override
	public int getTemperature() {
		return currentTemp;
	}

	@Override
	public void setTemperature(int temperature) {
		if (getUpperBound() >= temperature && getLowerBound() <= temperature) {
			this.currentTemp = temperature;
		} else {
			System.err.println("Please provide a valid temprature for your " + getDeviceType());
		}

	}
}
