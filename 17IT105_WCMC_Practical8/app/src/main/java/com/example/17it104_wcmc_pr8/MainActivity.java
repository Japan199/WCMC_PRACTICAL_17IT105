package com.example.a17it003_wcmc_pr8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment1();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment2();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment3();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment4();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment5();
            }
        });

    }

    private void addFragment1(){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentActivity fragmentActivity = new FragmentActivity();
        fragmentTransaction.add(R.id.frag1,fragmentActivity);
        fragmentTransaction.commit();


    }
    private void addFragment2(){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentActivity2 fragmentActivity2 = new FragmentActivity2();
        fragmentTransaction.add(R.id.frag1,fragmentActivity2);
        fragmentTransaction.commit();


    }
    private void addFragment3(){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentActivity3 fragmentActivity3 = new FragmentActivity3();
        fragmentTransaction.add(R.id.frag1,fragmentActivity3);
        fragmentTransaction.commit();


    }
    private void addFragment4(){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentActivity4 fragmentActivity4 = new FragmentActivity4();
        fragmentTransaction.add(R.id.frag1,fragmentActivity4);
        fragmentTransaction.commit();

    }
    private void addFragment5(){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentActivity5 fragmentActivity5 = new FragmentActivity5();
        fragmentTransaction.add(R.id.frag1,fragmentActivity5);
        fragmentTransaction.commit();

    }

}
