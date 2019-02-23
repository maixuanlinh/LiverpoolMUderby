package com.myappcompany.rob.connect3game;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Vibrator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.content.Context;
import android.os.VibrationEffect;

public class LiverpoolwinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liverpoolwin);
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(4000, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(4000);
        }

        ImageView imageView = findViewById(R.id.imageViewSalah);
        imageView.setTranslationY(-2000);
        imageView.animate().translationYBy(2000).rotationBy(3600).setDuration(2000);
        imageView.animate().alpha(500);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.footballcrowd);
        mediaPlayer.start();


    }


}
