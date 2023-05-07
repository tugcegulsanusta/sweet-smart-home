package model.interfaces;

import model.interfaces.StatefulInterface;

public interface TemperatureInterface extends StatefulInterface {
    int getUpperBound();
    int getLowerBound();
    int getTemperature();
    void setTemperature(int temperature);

}
