package by.myadel.homework;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import by.myadel.homework.hw1.MainActivity1;
import by.myadel.homework.hw2.MainActivity2;
import by.myadel.homework.hw3.MainActivity3;
import by.myadel.homework.hw4.task1.MainActivity4;
import by.myadel.homework.hw4.task2.MainActivity4_3;
import by.myadel.homework.hw4.task3.MainActivity4_4;
import by.myadel.homework.hw5.MainActivityHomework5;
import by.myadel.homework.hw6.MainActivity6;
import by.myadel.homework.hw7.MainActivity7;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity_main);
        Button buttonHomework1 = findViewById(R.id.one_button);
        buttonHomework1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivity1.class));
            }
        });
        Button buttonHomework2 = findViewById(R.id.two_button);
        buttonHomework2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivity2.class));
            }
        });
        Button buttonHomework3 = findViewById(R.id.three_button);
        buttonHomework3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivity3.class));
            }
        });
        Button buttonHomework4_1 = findViewById(R.id.four_button);
        buttonHomework4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivity4.class));
            }
        });
        Button buttonHomework4_2 = findViewById(R.id.five_button);
        buttonHomework4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivity4_3.class));
            }
        });
        Button buttonHomework4_3 = findViewById(R.id.six_button);
        buttonHomework4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivity4_4.class));
            }
        });
        Button buttonHomework5 = findViewById(R.id.seven_button);
        buttonHomework5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivityHomework5.class));
            }
        });
        Button buttonHomework6 = findViewById(R.id.eight_button);
        buttonHomework6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivity6.class));
            }
        });
        Button buttonHomework7 = findViewById(R.id.nine_button);
        buttonHomework7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivity7.class));
            }
        });
    }
}
