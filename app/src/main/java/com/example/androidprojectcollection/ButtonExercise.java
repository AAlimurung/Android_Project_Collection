package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ButtonExercise extends AppCompatActivity {
    ArrayList<Button> buttons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);

        final boolean[] swap = {false};
        ConstraintLayout cons = (ConstraintLayout) findViewById(R.id.conslay);
        Button close = (Button) findViewById(R.id.bbtnex1);
        Button toast = (Button) findViewById(R.id.bbtnex2);
        Button chbg = (Button) findViewById(R.id.bbtnex3);
        Button chbtnbg = (Button)findViewById(R.id.bbtnex4);
        Button disp = (Button) findViewById(R.id.bbtnex5);

        buttons.add(close); //0
        buttons.add(toast); //1
        buttons.add(chbg); //2
        buttons.add(chbtnbg); //3
        buttons.add(disp); //4

        buttons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent0 = new Intent(
                        ButtonExercise.this, Excess.class
                );
                startActivity(intent0);
            }
        });

        buttons.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonExercise.this, "omae wa mo shindeiru", Toast.LENGTH_SHORT).show();
            }
        });

        buttons.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!swap[0]){
                    cons.setBackgroundColor(Color.GREEN);
                    swap[0] = true;
                } else {
                    cons.setBackgroundColor(Color.MAGENTA);
                    swap[0] = false;
                }
            }
        });

        buttons.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!swap[0]){
                   buttons.get(0).setBackgroundColor(Color.CYAN);
                   buttons.get(1).setBackgroundColor(Color.CYAN);
                   buttons.get(2).setBackgroundColor(Color.CYAN);
                   buttons.get(3).setBackgroundColor(Color.CYAN);
                   buttons.get(4).setBackgroundColor(Color.CYAN);
                   swap[0] = true;
                } else {
                    buttons.get(0).setBackgroundColor(Color.DKGRAY);
                    buttons.get(1).setBackgroundColor(Color.DKGRAY);
                    buttons.get(2).setBackgroundColor(Color.DKGRAY);
                    buttons.get(3).setBackgroundColor(Color.DKGRAY);
                    buttons.get(4).setBackgroundColor(Color.DKGRAY);
                    swap[0] = false;
                }
            }
        });

        buttons.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disp.setVisibility(View.INVISIBLE);
            }
        });

    }

}