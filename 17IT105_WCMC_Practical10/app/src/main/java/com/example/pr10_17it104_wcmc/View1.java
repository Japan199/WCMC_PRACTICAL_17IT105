package com.example.pr10_17it003_wcmc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class View1 extends AppCompatActivity {


    TextView t1;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        t1=findViewById(R.id.textView4);

        db=openOrCreateDatabase("student",MODE_PRIVATE,null);

        Cursor c=db.rawQuery("SELECT * FROM student",null);
        if (c.getCount()==0){
            Toast.makeText(getApplicationContext(),"No Data Found",Toast.LENGTH_SHORT).show();
        }
        else{

        StringBuffer result=new StringBuffer();
        while (c.moveToNext()){
            result.append("Name:"+c.getString(0)+"\n");
            result.append("Roll No:"+c.getString(1)+"\n\n");
        }
        t1.setText(result.toString());


        }
    }
}