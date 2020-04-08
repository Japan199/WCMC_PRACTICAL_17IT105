package com.example.a17it003_wcmc_pr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import java.security.Policy;

public class MainActivity extends AppCompatActivity {

    ToggleButton t1,t2;
    CameraManager cm;
    String cameraId;
    int counter = 0;
    Chronometer c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isFlashAvailabe = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        c1 = findViewById(R.id.c1);
        counter = 0;

        if (!isFlashAvailabe){
            showFlashError();
        }

        cm = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try{
            cameraId = cm.getCameraIdList()[0];
        }catch (CameraAccessException e){
            e.printStackTrace();
        }


        t2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                c1.start();
                chronometer(b);
            }
        });

        t1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                switchFlashLight(b);
            }
        });


    }

    void chronometer(boolean status) {

        if (status) {
            switchFlashLight(false);

            c1.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

                @Override
                public void onChronometerTick(Chronometer chronometer) {

                    counter++;

                    if (counter % 5 == 0) {

                        switchFlashLight(false);

                    } else {
                        switchFlashLight(true);
                    }
                }
            });
        }
        else {
            switchFlashLight(false);
            c1.stop();
        }
    }

    void switchFlashLight(boolean status){
        try{
            cm.setTorchMode(cameraId, status);
        }catch (CameraAccessException e){
            e.printStackTrace();
        }
    }


    void showFlashError(){

        System.out.println("No Flash Available ...");
    }
}
