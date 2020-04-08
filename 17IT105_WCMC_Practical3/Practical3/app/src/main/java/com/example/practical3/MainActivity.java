package com.example.practical3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Chronometer ch;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = -1;
        ch = findViewById(R.id.chronometer);
        ch.start();

        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                counter++;
                if(counter%5 == 0)
                    Toast.makeText(MainActivity.this, "Hello!!", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
