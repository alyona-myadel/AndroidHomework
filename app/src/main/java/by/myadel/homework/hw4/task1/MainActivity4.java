package by.myadel.homework.hw4.task1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import by.myadel.homework.R;

public class MainActivity4 extends AppCompatActivity {
    private String myUrl = "https://www.hastac.org/sites/default/files/upload/images/post/sdp-backpack-570e0205562454d2f13a84cc9d1842c5.png";
    private ImageView imageView1;
    private Button button_hw4_1;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hw4_1);
        imageView1 = findViewById(R.id.hw4_1_image_view);
        Glide.with(this).load(myUrl).into(imageView1);
        anim = AnimationUtils.loadAnimation(MainActivity4.this, R.anim.combo_animation);
        button_hw4_1 = findViewById(R.id.hw4_1_button_go_over);
        imageView1.startAnimation(anim);
        button_hw4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, Activity4_1.class);
                startActivity(intent);
                overridePendingTransition(R.anim.alpha_animation_increases, R.anim.alpha_animation_decreases);
            }
        });
    }
}
