package by.myadel.homework;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import by.myadel.homework.hw1.MainActivity1;
import by.myadel.homework.hw2.MainActivity2;
import by.myadel.homework.hw3.MainActivity3;

public class MainMenuActivity extends AppCompatActivity {
    private Button buttonHomework1;
    private Button buttonHomework2;
    private Button buttonHomework3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);
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
    }
}
