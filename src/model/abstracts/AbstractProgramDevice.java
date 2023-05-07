package model.abstracts;

import model.enums.DeviceState;
import model.enums.DeviceType;
import model.interfaces.ProgramInterface;
import model.enums.ProgramType;

import java.util.Timer;
import java.util.TimerTask;

/** AbstractProgramDevice class is created for programmable devices,
 *  which extends AbstractStatefulDevices
 *  All device has a state, Programmable devices has state + programs.
 */
public abstract class AbstractProgramDevice extends AbstractStatefulDevice implements ProgramInterface {
    ProgramType currentProgram = null;

    /**
     * @param selectedProgram
     */
    @Override
    public void setProgram(ProgramType selectedProgram) {
        this.currentProgram= selectedProgram;

    }

    /**
     * @return ProgramType-Enum
     */
    public ProgramType getProgram(){return currentProgram; }
}
