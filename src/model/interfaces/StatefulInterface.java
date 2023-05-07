package model.interfaces;

import model.enums.DeviceState;
import model.enums.DeviceType;

import java.util.List;

public interface StatefulInterface {
    List <DeviceState> getAvailableStates();
    DeviceState getCurrentState();
    DeviceType getDeviceType();

    void setCurrentState(DeviceState deviceState);
}
