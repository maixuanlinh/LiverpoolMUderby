package com.myappcompany.rob.connect3game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    // 0: Liverpool, 1: Manchester United, 2: empty

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    int activePlayer = 0;

    boolean gameActive = true;

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameActive) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1500);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.liverpoolfc);
                MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.liversound);
                mediaPlayer.start();
                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.mufc);
                MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.musound);
                mediaPlayer.start();
                activePlayer = 0;

            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(500);

            for (int[] winningPosition : winningPositions) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {

                    // Somone has won!

                    gameActive = false;

                    if (activePlayer == 1) {

                        Intent intent = new Intent(getApplicationContext(), LiverpoolwinActivity.class);
                        startActivity(intent);

                    } else {
                        Intent intentMU = new Intent(getApplicationContext(), MuwinActivity.class);
                        startActivity(intentMU);

                    }

                    Button playAgainButton = (Button) findViewById(R.id.playAgainButton);

                    playAgainButton.setVisibility(View.VISIBLE);



                }

            }

            //test whether it is a draw
            int buff = 0;

            for ( int i = 0; i < gameState.length; i++) {
                if (gameState[i] == 2) {
                    buff += gameState[i];
                }
            }
            if (gameActive == true && buff == 0) {
                Toast.makeText(this, "Game drawn in Old Trafford", Toast.LENGTH_LONG);
                gameActive = false;
            }
        }
    }

    public void playAgain(View view) {

        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);



        playAgainButton.setVisibility(View.INVISIBLE);



        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for(int i=0; i<gridLayout.getChildCount(); i++) {

            ImageView counter = (ImageView) gridLayout.getChildAt(i);

            counter.setImageDrawable(null);

        }

        for (int i=0; i<gameState.length; i++) {

            gameState[i] = 2;

        }

        activePlayer = 0;

        gameActive = true;

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
}
