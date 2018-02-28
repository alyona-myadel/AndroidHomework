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
import by.myadel.homework.hw5.MainActivityHomework5_1;

public class MainMenuActivity extends AppCompatActivity {
    private Button buttonHomework1;
    private Button buttonHomework2;
    private Button buttonHomework3;
    private Button buttonHomework4_1;
    private Button buttonHomework4_2;
    private Button buttonHomework4_3;
    private Button buttonHomework5_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity_main);
        buttonHomework1 = findViewById(R.id.one_button);
        buttonHomework1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivity1.class));
            }
        });
        buttonHomework2 = findViewById(R.id.two_button);
        buttonHomework2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivity2.class));
            }
        });
        buttonHomework3 = findViewById(R.id.three_button);
        buttonHomework3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivity3.class));
            }
        });
        buttonHomework4_1 = findViewById(R.id.four_button);
        buttonHomework4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivity4.class));
            }
        });
        buttonHomework4_2 = findViewById(R.id.five_button);
        buttonHomework4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivity4_3.class));
            }
        });
        buttonHomework4_3 = findViewById(R.id.six_button);
        buttonHomework4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivity4_4.class));
            }
        });
        buttonHomework5_1 = findViewById(R.id.seven_button);
        buttonHomework5_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivityHomework5_1.class));
            }
        });
    }
}
