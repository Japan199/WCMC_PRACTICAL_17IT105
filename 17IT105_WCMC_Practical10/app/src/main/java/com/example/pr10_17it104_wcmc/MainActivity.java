package com.example.pr10_17it003_wcmc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button insert,del,view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.button7);
        insert = findViewById(R.id.button5);
        del = findViewById(R.id.button6);
        SQLiteDatabase db = openOrCreateDatabase("student",MODE_PRIVATE,null);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent i1 = new Intent(MainActivity.this,Insert.class);
                startActivity(i1);

            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(MainActivity.this, Delete.class);
                startActivity(i3);

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this, View1.class);
                startActivity(i2);

            }
        });




    }


}