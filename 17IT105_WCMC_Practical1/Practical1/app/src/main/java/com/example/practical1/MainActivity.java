package com.example.practical1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tx;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx = findViewById(R.id.txt1);
        relativeLayout = findViewById(R.id.relativelayout);
        Intent in = getIntent();
        String st = in.getStringExtra("text");
        tx.setText(st);
        relativeLayout.setBackgroundColor(Color.YELLOW);

    }
}
