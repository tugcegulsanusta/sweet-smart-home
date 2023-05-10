package model.interfaces;

import java.util.List;

import model.enums.DeviceState;
import model.enums.DeviceType;

public interface StatefulInterface {

	List<DeviceState> getAvailableStates();

	DeviceState getCurrentState();

	DeviceType getDeviceType();

	void setCurrentState(DeviceState deviceState);

}
