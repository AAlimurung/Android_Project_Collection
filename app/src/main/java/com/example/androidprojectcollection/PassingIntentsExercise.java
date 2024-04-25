package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class PassingIntentsExercise extends AppCompatActivity {
    Button submit, clear;
    EditText fname_cin, lname_cin, bday_cin, age_cin,
            emailAdd_cin, phoneNum_cin, studentID_cin, address_cin;
    RadioButton male, female, etc;
    RadioGroup gender_options;
    Spinner year_cin, course_cin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        //initialize
        //edit text
        fname_cin = (EditText) findViewById(R.id.f_name_cin);
        lname_cin = (EditText) findViewById(R.id.l_name_cin);
        bday_cin = (EditText) findViewById(R.id.bday_cin);
        age_cin = (EditText) findViewById(R.id.age_cin);
        emailAdd_cin = (EditText) findViewById(R.id.emailAdd_cin);
        phoneNum_cin = (EditText) findViewById(R.id.phoneNum_cin);
        studentID_cin = (EditText) findViewById(R.id.studentID_cin);
        address_cin = (EditText) findViewById(R.id.address_cin);

        //radio buttons
        gender_options = (RadioGroup) findViewById(R.id.genders);
        male = (RadioButton) findViewById(R.id.rbtnMale);
        female = (RadioButton) findViewById(R.id.rbtnFemale);
        etc = (RadioButton) findViewById(R.id.rbtnOthers);

        //spinners
        year_cin = (Spinner) findViewById(R.id.spinner_year);
        String[] years = new String[] {"Select Year", "1", "2", "3", "4", "5", "IRREGULAR"};
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, years);
        year_cin.setAdapter(adapt);

        course_cin = (Spinner) findViewById(R.id.spinner_course);
        String[] courses = new String[] {"Select Course", "BSCS", "BSIT","BSCpE","BMMA","BSN","BSARCH"};
        ArrayAdapter<String> adapt2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, courses);
        course_cin.setAdapter(adapt2);

        //buttons
        submit = (Button) findViewById(R.id.btnSubmit);
        clear = (Button) findViewById(R.id.btnClear);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = fname_cin.getText().toString();
                String lastName = lname_cin.getText().toString();

                String gender;
                if(male.isChecked())
                    gender = "Male";
                 else if (female.isChecked())
                    gender = "Female";
                 else if (etc.isChecked())
                    gender = "Others";
                 else
                    gender = "Unknown";

                String studID = studentID_cin.getText().toString();
                String year = year_cin.getSelectedItem().toString();
                String course = course_cin.getSelectedItem().toString();
                String birthday = bday_cin.getText().toString();
                String age = age_cin.getText().toString();
                String phoneNum = phoneNum_cin.getText().toString();
                String emailAdd = emailAdd_cin.getText().toString();
                String address = address_cin.getText().toString();

                if(fieldsNotSet()){
                    Toast.makeText(PassingIntentsExercise.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
                i.putExtra("fname", firstName); i.putExtra("lname", firstName); i.putExtra("gender-opt", gender);
                i.putExtra("bday", birthday); i.putExtra("age", age); i.putExtra("pnum", phoneNum);
                i.putExtra("email", emailAdd); i.putExtra("add", address); i.putExtra("studID", studID);
                i.putExtra("year", year); i.putExtra("course", course);
            }
        }); //end of action listener

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname_cin.setText("");
                lname_cin.setText("");
                gender_options.clearCheck();
                studentID_cin.setSelection(0);
                course_cin.setSelection(0);
                bday_cin.setText("");
                age_cin.setText("");
                phoneNum_cin.setText("");
                emailAdd_cin.setText("");
                address_cin.setText("");
            }
        });

    } //end of oncreate

    public boolean fieldsNotSet(){
        if(fname_cin.getText().toString().equals("") || lname_cin.getText().toString().equals("") ||
                bday_cin.getText().toString().equals("") ||age_cin.getText().toString().equals("") ||
                phoneNum_cin.getText().toString().equals("") || emailAdd_cin.getText().toString().equals("") ||
                address_cin.getText().toString().equals("")){
                return true;
        }

        return false;
    }
}