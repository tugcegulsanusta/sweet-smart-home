package model.abstracts;

import model.enums.DeviceState;
import model.enums.ProgramType;
import model.interfaces.StatefulInterface;

public abstract class AbstractStatefulDevice implements StatefulInterface {
	protected DeviceState currentState = DeviceState.CLOSED;

	protected ProgramType currentProgram = null;

	@Override
	public DeviceState getCurrentState() {
		return currentState;
	}

	@Override
	public void setCurrentState(DeviceState deviceState) {
		this.currentState = deviceState;
	}
}
