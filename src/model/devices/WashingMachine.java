package model.devices;

import model.abstracts.AbstractProgramDevice;
import model.enums.DeviceState;
import model.enums.DeviceType;
import model.enums.ProgramType;
import model.interfaces.ProgramInterface;

import java.util.Arrays;
import java.util.List;

/**
 *
 */

public class WashingMachine extends AbstractProgramDevice implements ProgramInterface {

    @Override
    public List<ProgramType> getAvailablePrograms() {
        return Arrays.asList(ProgramType.PAMUKLULAR20, ProgramType.PAMUKLULAR40 , ProgramType.PAMUKLULAR60, ProgramType.PAMUKLULAR90,
                ProgramType.SENTETIKLER40, ProgramType.MIX40, ProgramType.HASSAS_IPEK30, ProgramType.YUNLULER30);
    }

    @Override
    public List<DeviceState> getAvailableStates() {
        return Arrays.asList(DeviceState.OPENED, DeviceState.CLOSED, DeviceState.PAUSED, DeviceState.RUNNING);
    }

    @Override
    public DeviceType getDeviceType() {return DeviceType.WashingMachine;}
}
