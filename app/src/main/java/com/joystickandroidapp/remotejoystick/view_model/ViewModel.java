package com.joystickandroidapp.remotejoystick.view_model;

import com.joystickandroidapp.remotejoystick.model.FGPlayer;

import java.util.concurrent.ExecutorService;

public class ViewModel {
    public String ip;
    public int port;
    public FlightGear FGPlayerModel;
    public ExecutorService executorService;

    /* constructor */
    public ViewModel(FlightGearPlayer FGPlayerModel, ExecutorService executorService) {
        this.FGPlayerModel = FGPlayerModel;
        this.executorService = executorService;
    }

    /* sending the new values to server from each category */
    public void setRudder(double rudderVal) {
        Runnable taskRudder = () -> {
            FlightGearPlayerModel.sendRudderValue(Double.toString(rudderVal));
        };
        executorService.execute(taskRudder);
    }

   public void setAileron(double aileronVal) {
        Runnable taskAileron = () -> {
            double  normalizedAileronVal = (((aileronVal + 800) * 2) / 1600) -1;
            FGPlayerModel.sendAileronValue(Double.toString(normalizedAileronVal));
        };
        executorService.execute(taskAileron);
    }
    public void setThrottle(double  throttleVal) {
        Runnable taskThrottle = () -> {
            FlightGearPlayerModel.sendThrottleValue(Double.toString(throttleVal));
        };
        executorService.execute(taskThrottle);
    }

   public void setElevator(float elevatorVal) {
        Runnable taskElevator = () -> {
            double normalizedElevatorVal = (((elevatorVal + 800) * 2) / 1600) -1;
            FlightGearPlayerModel.sendElevatorValue(Double.toString(normalizedElevatorVal * -1));
        };
        executorService.execute(taskElevator);
    }

}
