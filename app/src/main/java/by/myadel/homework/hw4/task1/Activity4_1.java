package by.myadel.homework.hw4.task1;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import by.myadel.homework.R;


public class Activity4_1 extends AppCompatActivity {
    private String myUrl = "http://blog.hostdime.com.co/wp-content/uploads/bug-github.png";
    private ImageView imageView1;
    private Button button_hw4_2;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw4_2_activity);
        imageView1 = findViewById(R.id.hw4_2_image_view);
        Glide.with(this).load(myUrl).into(imageView1);
        anim = AnimationUtils.loadAnimation(Activity4_1.this, R.anim.scale_animation);
        button_hw4_2 = findViewById(R.id.hw4_2_button_go_over);
        imageView1.startAnimation(anim);
        button_hw4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.alpha_animation_increases, R.anim.alpha_animation_decreases);
            }
        });
    }
}
