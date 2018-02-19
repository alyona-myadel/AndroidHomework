package by.myadel.homework.hw4.task2;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import by.myadel.homework.R;


public class MainActivity4_3 extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw4_3_activity_main);
        Button button = findViewById(R.id.hw4_3_button_blink);
        imageView = findViewById(R.id.hw4_3_image_view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
                animationDrawable.stop();
                animationDrawable.start();
            }
        });
    }
}
