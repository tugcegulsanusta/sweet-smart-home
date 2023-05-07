package model.interfaces;

import model.enums.DeviceState;

import java.util.Timer;
import java.util.TimerTask;

public interface ProgramStateInterface extends ProgramInterface{
    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("program has ended.");

            }
        };
        timer.schedule(task, 30000);
    }

}
