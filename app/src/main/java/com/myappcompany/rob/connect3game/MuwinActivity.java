package com.myappcompany.rob.connect3game;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MuwinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muwin);
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        v.vibrate(4000);


        ImageView imageView = findViewById(R.id.pogba);
        imageView.setTranslationY(-2000);
        imageView.animate().translationYBy(2000).rotationBy(3600).setDuration(2000);
        imageView.animate().alpha(500);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.footballcrowd);
        mediaPlayer.start();


    }
}
