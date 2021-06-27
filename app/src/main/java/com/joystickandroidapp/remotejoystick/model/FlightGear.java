package com.joystickandroidapp.remotejoystick.model;

import java.net.Socket;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import android.widget.Toast;
import java.io.IOException;
import java.net.InetSocketAddress;

public class FlightGear {
    Socket flightgearSocket = null;
    PrintWriter flightgearOut = null;


   /* those functions send to the simulator the new value of each category */
    public void sendRudderVal(String rudderVal) {
        if (flightgearOut != null) {
            try {
                flightgearOut.print("set /controls/flight/rudder " + rudderVal + " \r\n");
                flightgearOut.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    public void sendElevatorVal(String elevatorVal) {
        if (flightgearOut != null) {
            flightgearOut.print("set /controls/flight/elevator " + elevatorVal + "\n");
            flightgearOut.flush();
        }
    }
    public void openSocket(String ipAddress, int portNumber) throws Exception {
        this. flightgearSocket = new Socket();
         flightgearSocket.connect(new InetSocketAddress(ipAddress, portNumber), 6000);
        this.flightgearOut = new PrintWriter( flightgearSocket.getOutputStream(), true);
    }
    public void sendAileronVal(String aileronVal) {
        if (flightgearOut != null) {
            flightgearOut.print("set /controls/flight/aileron " + aileronVal + " \r\n");
            flightgearOut.flush();
        }
    }
    public void sendThrottleVal(String throttleVal) {
        if (flightgearOut != null) {
            try {
                flightgearOut.print("set /controls/engines/current-engine/throttle " + throttleVal + "\n");
                flightgearOut.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
