package model.devices;

import model.abstracts.AbstractTemperatureDevice;
import model.enums.DeviceState;
import model.enums.DeviceType;
import model.interfaces.TemperatureInterface;

import java.util.Arrays;
import java.util.List;

public class AirConditioner extends AbstractTemperatureDevice implements TemperatureInterface {


    /**
     * @return DeviceState-Enum
     */
    @Override
    public List<DeviceState> getAvailableStates() {
        return Arrays.asList(DeviceState.OPENED, DeviceState.CLOSED, DeviceState.RUNNING);
    }

    /**
     * @return DeviceType-AirConditioner-Enum
     */
    @Override
    public DeviceType getDeviceType() {
        return DeviceType.AirConditioner;
    }

    /**
     * @return upperBound for AirConditioner
     */
    @Override
    public int getUpperBound() {
        return 30;
    }

    /**
     * @return lowerBound for AirConditioner
     */
    @Override
    public int getLowerBound() {
        return 18;
    }
}
