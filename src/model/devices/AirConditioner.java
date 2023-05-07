package model.devices;

import model.abstracts.AbstractTemperatureDevice;
import model.enums.DeviceState;
import model.enums.DeviceType;
import model.interfaces.TemperatureInterface;

import java.util.Arrays;
import java.util.List;

public class AirConditioner extends AbstractTemperatureDevice implements TemperatureInterface {


    @Override
    public List<DeviceState> getAvailableStates() {
        return Arrays.asList(DeviceState.OPENED, DeviceState.CLOSED, DeviceState.RUNNING);
    }

    @Override
    public DeviceType getDeviceType() {
        return DeviceType.AirConditioner;
    }

    @Override
    public int getUpperBound() {
        return 30;
    }

    @Override
    public int getLowerBound() {
        return 18;
    }
}
