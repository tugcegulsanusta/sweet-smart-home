package model.interfaces;

public interface TemperatureInterface extends StatefulInterface {
	int getUpperBound();

	int getLowerBound();

	int getTemperature();

	void setTemperature(int temperature);

}
