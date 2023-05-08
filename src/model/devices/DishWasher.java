package model.devices;

import model.abstracts.AbstractProgramDevice;
import model.enums.DeviceState;
import model.enums.DeviceType;
import model.enums.ProgramType;
import model.interfaces.ProgramInterface;

import java.util.Arrays;
import java.util.List;


public class DishWasher extends AbstractProgramDevice implements ProgramInterface {


    @Override
    public List<ProgramType> getAvailablePrograms() {
        return Arrays.asList(ProgramType.YOGUN70, ProgramType.NORMAL65, ProgramType.ECO50, ProgramType.HASSAS40, ProgramType.HIZLI45);
    }

    @Override
    public List<DeviceState> getAvailableStates() {
        return Arrays.asList(DeviceState.OPENED, DeviceState.CLOSED, DeviceState.PAUSED, DeviceState.RUNNING);
    }

    @Override
    public DeviceType getDeviceType() {return DeviceType.DishWasher;}
}