package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class Match3 extends AppCompatActivity {
    int[] colors = {Color.RED, Color.CYAN, Color.YELLOW, Color.GREEN, Color.MAGENTA};
    int[][] btnStates = new int[5][5];
    int[][] btnColors = new int[5][5];

    Integer score;
    Button[][] buttons;
    TextView txtScore;
    Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match3);

        buttons = new Button[5][5];
        score = 0;
        txtScore = (TextView) findViewById(R.id.txtScore);
        txtScore.setText(String.valueOf(score));
        restart = (Button) findViewById(R.id.btnRestart);

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                btnStates[r][c] = 0;
            }
        }

        //get all ids daw ana si sir
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String idN = "pos " + i + j;
                buttons[i][j] = findViewById(this.getResources().getIdentifier(idN, "id", this.getPackageName()));
            }
        }

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        btnColors[i][j] = colors[new Random().nextInt(colors.length)];
                    }

                    score = 0;
                    txtScore.setText(String.valueOf(score));
                    changeColor();
                }
            }
        });

        //swap colors
        for (int i = 1; i<5; i++) {
            for(int j=0; j<5; j++){
                int prevColor = btnColors[i-1][j];
                int color;

                do{
                    color = new Random().nextInt(colors.length);
                }while(color == prevColor);
                    buttons[i][j].setBackgroundColor(colors[color]);
                    btnColors[i][j] = colors[color];
                }
            }
        for(int r= 0; r < 5; r++){
            for(int c= 0; c <5; c++){
                int finRow = r;
                int finCol = c;

                buttons[r][c].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btnStates[finRow][finCol] = 1;

                        if(finRow-1 >=0 && btnStates[finRow-1][finCol] == 1){
                            int pin = btnColors[finRow][finCol];
                            btnColors[finRow][finCol] = btnColors[finRow-1][finCol];
                            //did not swap at first code TT
                            btnColors[finRow-1][finCol] = pin;
                            btnStates[finRow][finCol] = 0;
                            btnStates[finRow-1][finCol] = 0;
                        } else if(finRow+1 < 5 && btnStates[finRow-1][finCol] == 1){
                            int pin = btnColors[finRow][finCol];
                            btnColors[finRow][finCol] = btnColors[finRow+1][finCol];
                            //did not swap at first code TT
                            btnColors[finRow+1][finCol] = pin;
                            btnStates[finRow][finCol] = 0;
                            btnStates[finRow+1][finCol] = 0;
                        } else if(finCol-1 >= 0 && btnStates[finRow][finCol-1] == 1){
                            int pin = btnColors[finRow][finCol];
                            btnColors[finRow][finCol] = btnColors[finRow][finCol-1];
                            btnColors[finRow][finCol-1] = pin;
                            btnStates[finRow][finCol] = 0;
                            btnStates[finRow][finCol-1] = 0;
                        } else if(finCol+1 < 5 && btnStates[finRow][finCol+1] == 1){
                            int pin = btnColors[finRow][finCol];
                            btnColors[finRow][finCol] = btnColors[finRow][finCol+1];
                            btnColors[finRow][finCol+1] = pin;
                            btnStates[finRow][finCol] = 0;
                            btnStates[finRow][finCol+1] = 0;
                        } else{
                            for(int r=0; r<5; r++){
                                for(int c=0; c<5; c++){
                                    btnStates[r][c] = 0;
                                }
                            }

                            btnStates[finRow][finCol] = 1;
                        }

                        //check if same colors in line
                        for(int i=0; i<5; i++){
                            for(int j=0; j<5; j++){
                                if(btnColors[i][j] == btnColors[i][j+1] && btnColors[i][j] == btnColors[i][j+2]){
                                    score++;

                                    //sadlfjlksadfjaslkdjfklasdflkasdjflaskdfjasdlfkjalsdfjlkasjdf
//                                    btnColors[i][j] = colors(new Random(colors.length));
                                }
                            }
                        }
                    }
                });
            }
        }
    }
    public void changeColor(){
        for(int r = 0; r < 5; r++){
            for(int c = 0; c<5; c++){
                buttons[r][c].setBackgroundColor((btnColors[r][c]));
            }
        }
    }

    public void checkColors(){

    }
}