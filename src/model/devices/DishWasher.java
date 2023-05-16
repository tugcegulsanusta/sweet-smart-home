package model.devices;

import java.util.Arrays;
import java.util.List;

import model.abstracts.AbstractProgramDevice;
import model.enums.DeviceState;
import model.enums.DeviceType;
import model.enums.ProgramType;
import model.interfaces.ProgramInterface;

public class DishWasher extends AbstractProgramDevice implements ProgramInterface {

	//sets initial programType as eco50
	public DishWasher() {
		super(ProgramType.ECO50);
	}

	/**
	 * @return ProgramType-Enum
	 */
	@Override
	public List<ProgramType> getAvailablePrograms() {
		return Arrays.asList(ProgramType.DENSE70, ProgramType.NORMAL65, ProgramType.ECO50, ProgramType.GENTLE40,
				ProgramType.QUICK45);
	}

	/**
	 * @return DeviceState-Enum
	 */
	@Override
	public List<DeviceState> getAvailableStates() {
		return Arrays.asList(DeviceState.OPENED, DeviceState.CLOSED, DeviceState.PAUSED, DeviceState.RUNNING);
	}

	/**
	 * @return DeviceType-DishWasher-Enum
	 */
	@Override
	public DeviceType getDeviceType() {
		return DeviceType.DishWasher;
	}
}
