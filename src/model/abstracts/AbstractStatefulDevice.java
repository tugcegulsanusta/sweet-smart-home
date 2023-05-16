package model.abstracts;

import model.enums.DeviceState;
import model.interfaces.StatefulInterface;

/**
 *  AbstractStateful class is created for all devices. Devices has DeviceState enums : OPENED, CLOSED, RUNNING, PAUSED.
 *  Paused only applicable for ProgramDevice: DishWasher, WashingMachine
 */

public abstract class AbstractStatefulDevice implements StatefulInterface {

	//sets initial state as CLOSED
	protected DeviceState currentState = DeviceState.CLOSED;

	@Override
	public DeviceState getCurrentState() {
		return currentState;
	}

	@Override
	public void setCurrentState(DeviceState deviceState) {
		this.currentState = deviceState;
	}
}
