package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MenuExercise extends AppCompatActivity {

    Button btnChanger;
    //TextView test;
//    Button btnSecondChanger;
//    Button btnThirdChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        //test = (TextView) findViewById(R.id.test);
        btnChanger = (Button) findViewById(R.id.btnChanger);
        defunct();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menuexercise, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.miChange){
            Toast.makeText(this, "Edit object item is clicked", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.miBgColor){
            Toast.makeText(this, "Changed button's background color", Toast.LENGTH_SHORT).show();
            Random ana = new Random();
            btnChanger.setBackgroundColor(Color.rgb(ana.nextInt(256), ana.nextInt(256), ana.nextInt(256)));
            ObjectAnimator animator = ObjectAnimator.ofFloat(btnChanger, "rotation", 0f, 3600f);
            animator.setDuration(1000);
            animator.start();
        } else if (item.getItemId() == R.id.miText) {
            Toast.makeText(this, "Changed text", Toast.LENGTH_SHORT).show();
            btnChanger.setText("PSYCHO PASS");
            ObjectAnimator animator = ObjectAnimator.ofFloat(btnChanger, "translationX", 0f, -300f);
            animator.setDuration(1000);
            animator.start();
        } else if (item.getItemId() == R.id.miTextColor) {
            Toast.makeText(this, "Changed text color", Toast.LENGTH_SHORT).show();
            Random ana = new Random();
            btnChanger.setTextColor(Color.rgb(ana.nextInt(256), ana.nextInt(256), ana.nextInt(256)));
            ObjectAnimator animator = ObjectAnimator.ofFloat(btnChanger, "translationX", -300f, 300f);
            animator.setDuration(1000);
            animator.start();
        } else if (item.getItemId() == R.id.miTextSize) {
            Toast.makeText(this, "Changed text size", Toast.LENGTH_SHORT).show();
            btnChanger.setTextSize(80);
        } else if (item.getItemId() == R.id.miTextVisible){
            //supposed to be ang text ra unta ang ma-change, but idk how to set it to visible while inside the button
            if(btnChanger.getVisibility() == View.VISIBLE){
                Toast.makeText(this, "Made invisible", Toast.LENGTH_SHORT).show();
                btnChanger.setVisibility(View.GONE);
            } else if (btnChanger.getVisibility() == View.GONE) {
                Toast.makeText(this, "Made visible...again", Toast.LENGTH_SHORT).show();
                btnChanger.setVisibility(View.VISIBLE);
            }
        } else if (item.getItemId() == R.id.miReset) {
            Toast.makeText(this, "Reset object item is clicked", Toast.LENGTH_SHORT).show();
            defunct();
        } else if (item.getItemId() == R.id.miExit) {
            Toast.makeText(this, "Exited", Toast.LENGTH_SHORT).show();
            finish();
        }

        return true;
    }

    public void defunct(){
        btnChanger.setText("PERSONA");
        btnChanger.setTextSize(20);
        btnChanger.setTextColor(Color.CYAN);
        btnChanger.setBackgroundColor(Color.BLACK);
        ObjectAnimator animator = ObjectAnimator.ofFloat(btnChanger, "translationX", 0f, 0f);
        animator.setDuration(1000);
        animator.start();
    }
}