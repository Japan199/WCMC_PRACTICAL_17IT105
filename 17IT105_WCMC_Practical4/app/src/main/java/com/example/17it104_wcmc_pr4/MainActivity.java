package com.example.a17it003_wcmc_pr4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    TextView t1;
    Button celsius;
    Button fah;
    RadioGroup rg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        t1 = findViewById(R.id.t1);
        celsius = findViewById(R.id.celsius);
        fah = findViewById(R.id.fah);
        rg1 = findViewById(R.id.rg1);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i == 1){
                    //TO FAHRENHEIT
                    celsius.setVisibility(View.INVISIBLE);
                    fah.setVisibility(View.VISIBLE);


                    fah.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            String temp = et1.getText().toString();
                            Double t = Double.parseDouble(temp);
                            t = (Double)((Double) (t * (9.0/5.0))+32.0 );
                            t1.setText(""+t+" F");

                        }
                    });
                }
                else {
                    // TO CELSIUS
                    celsius.setVisibility(View.VISIBLE);
                    fah.setVisibility(View.INVISIBLE);

                    celsius.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            String temp = et1.getText().toString();
                            Double t = Double.parseDouble(temp);
                            t = (Double)((Double) (t - 32.0) * (5.0/9.0) );
                            t1.setText(""+t+" C");

                        }
                    });

                }

            }
        });

    }
}
