package supercoolbusinessapp.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import sjcnymobile.view.R;

/**
 * Created by AnthonyK on 11/29/2015.
 */
public class CameraActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Button mybutton_camera = (Button) findViewById(R.id.button_camera);
        mybutton_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takepicture();
            }
        });

    }

    void takepicture() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView myimage = (ImageView) findViewById(R.id.image_camera);

            myimage.setImageBitmap(imageBitmap);
        }
    }
}
