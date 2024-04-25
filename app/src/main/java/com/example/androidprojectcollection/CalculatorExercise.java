package com.example.androidprojectcollection;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Stack;

public class CalculatorExercise extends AppCompatActivity {
    ArrayList<Button> buttons;
    boolean ctr1;
    boolean ctr2;
    EditText input;
    TextView txtN;
    String temp = "";
    String toInt = "";
    Button eq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        buttons = new ArrayList<>();
        ctr1 = false; //dot
        ctr2 = true; //operator
//        toInt = String.valueOf(txtN.getText());
        Calculator calc = new Calculator(toInt);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator_exercise);

        input = (EditText) findViewById(R.id.editNumber);
        TextView txtN = (TextView) findViewById(R.id.calcTextView1);
        eq = (Button) findViewById(R.id.btnEqual);


        //equal sign
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ctr2 == true){
                    Toast.makeText(getApplicationContext(), "Index out of bounds.", Toast.LENGTH_SHORT).show();
                } else {
                    calc.calculateMDAS();
                }
            }
        });

        //type in buttons
        for (Button b: buttons) {
            if(b instanceof Button && b!=findViewById(R.id.btnEqual)){
                buttons.add((Button) b);

                if(String.valueOf(((Button)b).getText()).equals("*") || String.valueOf(((Button) b).getText()).equals("\\") || String.valueOf(((Button)b).getText()).equals("+") || String.valueOf(((Button)b).getText()).equals("-")){
                    if(String.valueOf(((Button)b).getText()).equals("-")){
                            b.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if(ctr2==false || String.valueOf(input.getText()).isEmpty()){
                                        input.append(((Button) b).getText());
                                        ctr2 = true;
                                    } else if (!String.valueOf(input.getText()).isEmpty()) {
                                        input.setText(input.getText().toString().substring(0, input.length()-1));
                                    }
                                }
                            });
                    }
                }

            }

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView txtN = (TextView) findViewById(R.id.calcTextView1);
                    String st = String.valueOf(b.getText());
                    //st+=b.getText();
                    ((TextView) findViewById(R.id.calcTextView1)).setText(txtN.getText()+st);

                    if(ctr2 == true){
                        Toast.makeText(getApplicationContext(), "Index out of bounds.", Toast.LENGTH_SHORT).show();
                    } else {
                        calc.calculateSequential();
                    }
                }
            });
        }

        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtN = (TextView) findViewById(R.id.calcTextView1);
                txtN.setText("");
            }
        });

    }
}
