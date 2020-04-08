package com.example.pr10_17it003_wcmc;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {

    EditText name,rollno;
    Button delete;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        name=findViewById(R.id.editText);
        rollno=findViewById(R.id.editText2);
        delete=findViewById(R.id.button);

        db=openOrCreateDatabase("student", Context.MODE_PRIVATE,null);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().trim().length()==0 || rollno.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"Please Enter Details", Toast.LENGTH_SHORT).show();
                }

                Cursor c=db.rawQuery("SELECT * FROM student WHERE name='"+name.getText().toString()+"'", null);
                if(c.moveToFirst())
                {
                    db.execSQL("DELETE FROM student WHERE name='"+name.getText().toString()+"'");
                    Toast.makeText(getApplicationContext(),"Deleted Successfully",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Operation Not Successful",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
