package by.myadel.homework.hw3;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import by.myadel.homework.R;


public class MainActivity3 extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private SimpleDraweeView simpleDraweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main_hw3);
        editText = findViewById(R.id.hw3_image_url_edit_text);
        button = findViewById(R.id.hw3_download_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage();
            }
        });

        int overlayColor = getResources().getColor(R.color.colorBlack);
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(7f);
        simpleDraweeView = findViewById(R.id.my_image_view);
        simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(getResources())
                .setRoundingParams(roundingParams)
                .build());
    }

    private void showImage() {
        Uri uri = Uri.parse(editText.getText().toString());
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        draweeView.setImageURI(uri);
    }
}
