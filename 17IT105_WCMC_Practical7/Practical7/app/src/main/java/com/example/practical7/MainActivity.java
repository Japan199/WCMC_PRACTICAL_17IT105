package com.example.practical7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner color = (Spinner) findViewById(R.id.color);
        ArrayAdapter<CharSequence> main_adapter = ArrayAdapter.createFromResource(this,
                R.array.colors_array, android.R.layout.simple_spinner_item);
        main_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        color.setAdapter(main_adapter);
        color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color_selected = color.getSelectedItem().toString();
                if(color_selected.equals("Blue")){       getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.Blue));
                }
                else if(color_selected.equals("Green")){                    getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.Green));
                }
                else if(color_selected.equals("Red")){
                    getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.Red));
                }
                else if(color_selected.equals("Yellow")){
                    getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.Yellow));
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
