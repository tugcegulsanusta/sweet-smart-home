package model.interfaces;

import model.enums.ProgramType;

import java.util.List;

public interface ProgramInterface extends StatefulInterface {

    /**
     * @param selectedProgram
     * sets the currentProgram
     */
    public void setProgram(ProgramType selectedProgram);

    /**
     * @return ProgramType-Enum
     */
    ProgramType getProgram();

    /**
     * @return ProgramType-Enum as a list
     */
    List <ProgramType> getAvailablePrograms();

}
