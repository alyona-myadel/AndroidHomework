package by.myadel.homework.hw1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import by.myadel.homework.BuildConfig;
import by.myadel.homework.R;

public class MainActivity1 extends AppCompatActivity implements View.OnClickListener {
    private TextView firstTextView;
    private TextView secondTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw1_activity_main);
        firstTextView = findViewById(R.id.first_text_view);
        secondTextView = findViewById(R.id.second_text_view);
        firstTextView.setText(BuildConfig.INFOPMATION);
        Button swapButton = findViewById(R.id.swap_button);
        swapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapTexts();
            }
        });
        firstTextView.setOnClickListener(this);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapTexts();
            }
        };
        secondTextView.setOnClickListener(listener);
    }

    private void swapTexts() {
        CharSequence text = firstTextView.getText();
        firstTextView.setText(secondTextView.getText());
        secondTextView.setText(text);
    }

    @Override
    public void onClick(View v) {
        swapTexts();
    }
}
