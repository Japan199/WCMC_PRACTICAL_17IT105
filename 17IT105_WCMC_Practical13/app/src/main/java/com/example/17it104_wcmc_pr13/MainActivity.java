package com.example.a17it003_wcmc_pr13;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Notification;
import android.app.PictureInPictureParams;
import android.drm.DrmStore;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.util.Rational;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button pipbtn;
    String path = "/storage/emulated/0/WhatsApp/Media/WhatsApp Video/VID-20191219-WA0000.mp4";
    ActionBar actionBar;
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        video = (VideoView)findViewById(R.id.video);
        actionBar = getActionBar();
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(video);
        video.setMediaController(mediaController);
        video.setVideoURI(Uri.parse(path));
        video.requestFocus();
        video.start();

        pipbtn = (Button)findViewById(R.id.pipbtn);


        pipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Display display = getWindowManager().getDefaultDisplay();
                Point point = new Point();
                display.getSize(point);
                int width = point.x;
                int height = point.y;

                Rational ratio = new Rational(width,height);
                PictureInPictureParams.Builder pip_builder = new PictureInPictureParams.Builder();
                pip_builder.setAspectRatio(ratio).build();
                pipbtn.setVisibility(View.INVISIBLE);
                enterPictureInPictureMode(pip_builder.build());

            }
        });

    }


}

