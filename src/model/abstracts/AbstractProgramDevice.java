package model.abstracts;

import model.enums.DeviceState;
import model.enums.ProgramType;
import model.interfaces.ProgramInterface;

/**
 * AbstractProgramDevice class is created for programmable devices, which
 * extends AbstractStatefulDevices all device has a state, Programmable devices has state + programs.
 */
public abstract class AbstractProgramDevice extends AbstractStatefulDevice implements ProgramInterface {
	protected ProgramType currentProgram;

	/**
	 * @param programType
	 * Constructor
	 */
	public AbstractProgramDevice(ProgramType programType) {
		this.currentProgram = programType;
	}

	/**
	 * @param selectedProgram
	 * sets the currentProgram as selectedProgram
	 */
	@Override
	public void setProgram(ProgramType selectedProgram) {
		this.currentProgram = selectedProgram;
		if (this.currentState == DeviceState.OPENED) {
			setCurrentState(DeviceState.RUNNING);
		}

	}

	/**
	 * @return ProgramType-Enum
	 */
	@Override
	public ProgramType getProgram() {
		return currentProgram;
	}
}
