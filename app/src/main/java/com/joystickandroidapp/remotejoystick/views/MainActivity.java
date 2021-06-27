package com.joystickandroidapp.remotejoystick.views;

import androidx.appcompat.app.AppCompatActivity;
import com.joystickandroidapp.remotejoystick.R;
import com.joystickandroidapp.remotejoystick.model.FGPlayer;
import com.joystickandroidapp.remotejoystick.view_model.ViewModel;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainActivity extends AppCompatActivity {
    public ViewModel vm;
    private SeekBar rudBar;
    private SeekBar throtBar;
    public ExecutorService executorService;
    public boolean connectFlag = false;
    public FlightGear FlightGearPlayerModel = null;
    public Joystick joystick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FlightGearPlayerModel = new FlightGearPlayer();
        executorService = Executors.newSingleThreadExecutor();
        vm = new ViewModel(FGPlayerModel, executorService);
        joystick = (Joystick) findViewById(R.id.joystick);
        joystick.joystickListener = (x, y) -> {
            vm.setAileron(x);
            vm.setElevator(y);
        };
        /* initialize listeners */
        connectButtonListener();
        rudBarListener();
        throtBarListener();
    }

    /* define listener for the rudder bar */
    void rudBarListener() {
        rudBar = (SeekBar) findViewById(R.id.rudderBar);
        rudderBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double progValue = (((double) progress * 2) / 100) + -1;
                progValue = (int)(Math.round(progValue * 100)) / 100.0;
                double finalProgValue = progValue;
                vm.setRudder(finalProgValue);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    /* define listener for the throttle bar */
    void throtBarListener() {
        throttleBar = (SeekBar) findViewById(R.id.throttleBar);
        throttleBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double progValue = (((double) progress * 2) / 100) + -1;
                progValue = (int)(Math.round(progValue * 100)) / 100.0;
                double finalProgValue = progValue;
                vm.setThrottle(finalProgValue);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }


    /* define listener for the connect button */
    void connectButtonListener() {
        Button connect = findViewById(R.id.connectButton);
        EditText ip = findViewById(R.id.IPText);
        EditText port = findViewById(R.id.PORTText);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ipStr = ip.getText().toString();
                String portStr = port.getText().toString();
                Runnable taskConnect = () -> {
            }
        });
    }
}