package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    // 0: yellow and 1 : red  and 2: empty

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningState = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    int activePlayer = 0;
    boolean gameActive =true;


    public void playGame(View view){
        Button playButton = (Button) findViewById(R.id.playButton);
        TextView winnerText = (TextView) findViewById(R.id.winnerText);
        winnerText.setVisibility(view.INVISIBLE);
        playButton.setVisibility(view.INVISIBLE);


        androidx.gridlayout.widget.GridLayout gridLayout = (androidx.gridlayout.widget.GridLayout) findViewById(R.id.gridLayout);
        for(int i=0; i<gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }
        for (int i=0; i<gameState.length; i++) {
             gameState[i] = 2;
            }

             activePlayer = 0;
             gameActive =true;


    activePlayer = 0;

    gameActive = true;

}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        int clickedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[clickedCounter] == 2 && gameActive == true) {
            gameState[clickedCounter] = activePlayer;
            counter.setTranslationY(-1500);


            if (activePlayer == 0) {
                activePlayer = 1;
                counter.setImageResource(R.drawable.yellow);
//                Log.i("tag info", counter.getTag().toString());
            } else {
                activePlayer = 0;
                counter.setImageResource(R.drawable.red);

            }
            String winner="";
            counter.animate().translationYBy(1500).rotation(3600).setDuration(500);
            for (int[] winnerCheck : winningState) {
                if (gameState[winnerCheck[0]] == gameState[winnerCheck[1]] && gameState[winnerCheck[1]] == gameState[winnerCheck[2]] && gameState[winnerCheck[0]] != 2) {
                    gameActive = false;
                   // String winner="";
                    if (gameState[winnerCheck[0]] == 1) {
                        winner = "RED";

                    } else {
                        winner = "YELLOW";
                    }

                    Button playButton = (Button) findViewById(R.id.playButton);
                    TextView winnerText = (TextView) findViewById(R.id.winnerText);
                    winnerText.setText(winner + " HAS WON!");
                    winnerText.setVisibility(view.VISIBLE);
                    playButton.setVisibility(view.VISIBLE);


                }
            }
          int count = 0;
             for (int j=0;j<9 ; j++){
            if(gameState[j] != 2) {
                count = count + 1;
               }
               }

               if(count == 9 ) {
                   Log.i("info", Integer.toString(count));

                Button playButton = (Button) findViewById(R.id.playButton);
                TextView winnerText = (TextView) findViewById(R.id.winnerText);
                winnerText.setText("NO ONE HAS WON!");
                winnerText.setVisibility(view.VISIBLE);
                playButton.setVisibility(view.VISIBLE);

            }
        }
    }
}