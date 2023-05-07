package model.interfaces;

import model.enums.ProgramType;

import java.util.List;

public interface ProgramInterface extends StatefulInterface {

    public void setProgram(ProgramType selectedProgram);

    ProgramType getProgram();

    List <ProgramType> getAvailablePrograms();

}
