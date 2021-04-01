package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Spinner mySpinner;
    EditText myValue;
    TextView myText1;
    TextView myText_1;
    TextView myText2;
    TextView myText_2;
    TextView myText3;
    TextView myText_3;
    ImageButton ruler;
    ImageButton scale;
    ImageButton thermometer;
    private Object AdapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // gain widget on xml.
        mySpinner = findViewById(R.id.mySpinner);
        myValue = findViewById(R.id.myValue);
        myText1 = findViewById(R.id.myText1);
        myText_1 = findViewById(R.id.myText_1);
        myText2 = findViewById(R.id.myText2);
        myText_2 = findViewById(R.id.myText_2);
        myText3 = findViewById(R.id.myText3);
        myText_3 = findViewById(R.id.myText_3);
        ruler = findViewById(R.id.ruler);
        scale = findViewById(R.id.scale);
        thermometer = findViewById(R.id.thermometer);

        String[] arr = {"Metre", "Kilogram", "Celsius"};
        //create ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        //set adapter for Spinner
        mySpinner.setAdapter(adapter);

        //set on item select Listener for spinner
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String unit = arr[position];
                if (unit == "Metre") {
                    myText_1.setText("");
                    myText_2.setText("");
                    myText_3.setText("");
                    myText1.setText("Centimeter");
                    myText2.setText("Foot");
                    myText3.setText("Inch");

                    ruler.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            double numberMetre = Float.valueOf(myValue.getText().toString());
                            double numberMetreToCentimeter = numberMetre * 100.00;
                            double numberMetreToFoot = numberMetre * 3.28;
                            double numberMetreToInch = numberMetre * 39.40;

                            myText_1.setText(String.format("%.2f", numberMetreToCentimeter));
                            myText_2.setText(String.format("%.2f", numberMetreToFoot));
                            myText_3.setText(String.format("%.2f", numberMetreToInch));
                        }
                    });
                } else if (unit == "Celsius") {
                    myText_1.setText("");
                    myText_2.setText("");
                    myText_3.setText("");
                    myText1.setText("Fahrenheit");
                    myText2.setText("Kelvin");
                    myText3.setText("  ");

                    thermometer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            double numberCelsius = Float.valueOf(myValue.getText().toString());
                            double numberFah = numberCelsius / 1.8 + 32;
                            double numberKelvin = 273.15 + numberCelsius;

                            myText_1.setText(String.format("%.2f", numberFah));
                            myText_2.setText(String.format("%.2f", numberKelvin));
                            myText_3.setText(" ");
                        }
                    });
                } else if (unit == "Kilogram") {
                    myText_1.setText("");
                    myText_2.setText("");
                    myText_3.setText("");
                    myText1.setText("Gram");
                    myText2.setText("Ounce(Oz)");
                    myText3.setText("Pound(lb)");

                    scale.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            double numberKilogram = Float.valueOf(myValue.getText().toString());
                            double numberGram = numberKilogram * 1000;
                            double numberOz = numberKilogram * 35.273;
                            double numberLb = numberKilogram * 2.204;

                            myText_1.setText(String.format("%.2f", numberGram));
                            myText_2.setText(String.format("%.2f", numberOz));
                            myText_3.setText(String.format("%.2f", numberLb));
                        }
                    });
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}