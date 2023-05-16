package model.devices;

import java.util.Arrays;
import java.util.List;

import model.abstracts.AbstractProgramDevice;
import model.enums.DeviceState;
import model.enums.DeviceType;
import model.enums.ProgramType;
import model.interfaces.ProgramInterface;


public class WashingMachine extends AbstractProgramDevice implements ProgramInterface {

	//sets initial programType as mix40
	public WashingMachine() {
		super(ProgramType.MIX40);
	}

	/**
	 * @return ProgramType-Enum
	 */
	@Override
	public List<ProgramType> getAvailablePrograms() {
		return Arrays.asList(ProgramType.PAMUKLULAR20, ProgramType.PAMUKLULAR40, ProgramType.PAMUKLULAR60,
				ProgramType.PAMUKLULAR90, ProgramType.SENTETIKLER40, ProgramType.MIX40, ProgramType.HASSAS_IPEK30,
				ProgramType.YUNLULER30);
	}

	/**
	 * @return DeviceState-Enum
	 */
	@Override
	public List<DeviceState> getAvailableStates() {
		return Arrays.asList(DeviceState.OPENED, DeviceState.CLOSED, DeviceState.PAUSED, DeviceState.RUNNING);
	}

	/**
	 * @return DeviceType-WashingMachine-Enum
	 */
	@Override
	public DeviceType getDeviceType() {
		return DeviceType.WashingMachine;
	}
}
