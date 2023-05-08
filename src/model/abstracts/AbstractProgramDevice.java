package model.abstracts;

import model.enums.ProgramType;
import model.interfaces.ProgramInterface;

/**
 * AbstractProgramDevice class is created for programmable devices, which
 * extends AbstractStatefulDevices All device has a state, Programmable devices
 * has state + programs.
 */
public abstract class AbstractProgramDevice extends AbstractStatefulDevice implements ProgramInterface {
	ProgramType currentProgram = ProgramType.generateRandomProgram();

	/**
	 * @param selectedProgram
	 */
	@Override
	public void setProgram(ProgramType selectedProgram) {
		this.currentProgram = selectedProgram;

	}

	/**
	 * @return ProgramType-Enum
	 */
	@Override
	public ProgramType getProgram() {
		return currentProgram;
	}
}
