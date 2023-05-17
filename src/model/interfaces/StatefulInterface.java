package model.interfaces;

import java.util.List;

import model.enums.DeviceState;
import model.enums.DeviceType;

public interface StatefulInterface {

	/**
	 * @return DeviceState-Enum as a list
	 * DeviceState is differs between devices - PAUSED only available for Programmable devices
	 */
	List<DeviceState> getAvailableStates();

	/**
	 * @return DeviceState-Enum
	 */
	DeviceState getCurrentState();

	/**
	 * @return DeviceType-Enum
	 */
	DeviceType getDeviceType();

	/**
	 * @param deviceState
	 * sets currentState as deviceState
	 */
	void setCurrentState(DeviceState deviceState);

}
