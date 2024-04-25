package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mainBtn1;
    Button mainBtn2;
    Button mainBtn3;
    Button mainBtn4;
    Button mainBtn5;
    Button mainBtn6;
    Button mainBtn7;
    Button mainBtn8;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBtn1 = (Button)findViewById(R.id.btnLayExercise);
        mainBtn2 = (Button)findViewById(R.id.btnButtonExercise);
        mainBtn3 = (Button) findViewById(R.id.btnCalculator);
        mainBtn4 = (Button) findViewById(R.id.btnTTT);
        mainBtn5 = (Button) findViewById(R.id.btnMatch);
        mainBtn6 = (Button)findViewById(R.id.btnPassInt);
        mainBtn7 = (Button)findViewById(R.id.btnFragment);
        mainBtn8 = (Button) findViewById(R.id.btnMenus);

        mainBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setContentView(R.layout.activity_layout_exercise);
                Intent intent1 = new Intent(
                   MainActivity.this, LayoutExercise.class
                );

                startActivity(intent1);
            }
        });

        mainBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(
                        MainActivity.this, ButtonExercise.class
                );
                startActivity(intent2);
            }
        });

        mainBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(
                        MainActivity.this, CalculatorExercise.class
                );
                startActivity(intent3);
            }
        });

        mainBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(
                        MainActivity.this, Excess.class
                );

                startActivity(intent4);
            }
        });

        mainBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(
                        MainActivity.this, Match3.class
                );

                startActivity(intent5);
            }
        });

        mainBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(
                        MainActivity.this, PassingIntentsExercise.class
                );
                startActivity(intent6);
            }
        });

        mainBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent8 = new Intent(
                        MainActivity.this, MenuExercise.class
                );
                startActivity(intent8);
            }
        });
    }
}