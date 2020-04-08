package com.example.pr10_17it003_wcmc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

public class Insert extends AppCompatActivity {

    EditText name,rollno;
    Button insert;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        name = findViewById(R.id.editText);
        rollno = findViewById(R.id.editText2);
        insert = findViewById(R.id.button);



        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempname = name.getText().toString();
                String temproll = rollno.getText().toString();

                if (tempname.isEmpty() || temproll.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Please Enter Details...",Toast.LENGTH_LONG).show();

                }
                else {

                    Toast.makeText(getApplicationContext(),"INSERT SUCCESSFULL",Toast.LENGTH_LONG).show();

                    db = openOrCreateDatabase("student", MODE_PRIVATE, null);
                    db.execSQL("CREATE TABLE IF NOT EXISTS student(Name VARCHAR, RollNo VARCHAR);");

                    try {
                        db.execSQL("INSERT INTO student VALUES('"+tempname+"','"+temproll+"');");
                    }
                    catch (SQLException e){
                        Toast.makeText(getApplicationContext()," "+e,Toast.LENGTH_LONG).show();
                    }
                }

            }
        });


    }
}
