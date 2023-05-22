package model.abstracts;

import model.interfaces.TemperatureInterface;

/**
 * AbstractTemperature class is created for temperature devices,
 * which extends AbstractStatefulDevices
 * All device has a state,
 * Temperature devices has state + temperature.
 */
public abstract class AbstractTemperatureDevice extends AbstractStatefulDevice implements TemperatureInterface {

	protected int currentTemp;

	/**
	 * @return currentTemp
	 */
	@Override
	public int getTemperature() {
		return currentTemp;
	}

	/**
	 * @param temperature
	 * sets the currentTemp as selected temperature
	 */
	@Override
	public void setTemperature(int temperature) {
		this.currentTemp = temperature;
	}
}
