package model.interfaces;

public interface TemperatureInterface extends StatefulInterface {
	/**
	 * @return int
	 * upperBound of temperature
	 */
	int getUpperBound();

	/**
	 * @return int
	 * lowerBound of temperature
	 */
	int getLowerBound();

	/**
	 * @return int currentTemp
	 */
	int getTemperature();

	/**
	 * @param temperature
	 * sets the currentTemp as temperature
	 */
	void setTemperature(int temperature);

}
