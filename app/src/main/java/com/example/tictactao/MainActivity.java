package com.example.tictactao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.XMLFormatter;

public class MainActivity extends AppCompatActivity {
    boolean gameactive= true;
    boolean flag = true;
    String winnerStr;
    boolean gameDrawn=true;
    //Player representation
    // 0 - X
    // 1 -o
    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
//    State meaning
//    0-X
//    1-o
//    2- null
    int [][] winPositions = {{0,1,2}, {3,4,5},{6,7,8},
                             {0,3,6},{1,4,7},{2,5,8},
                              {0,4,8},{2,4,6}} ;
    public void playertap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            gameReset(view);
        }
        if(gameState[tappedImage]==2 && gameactive) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }

        //check if any Player has won
        for(int[] winningPosition: winPositions) {

            if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[2]] != 2) {
                //somebody has won!-

                if (gameState[winningPosition[0]] == 0) {
                    winnerStr = "X has won";
                   gameDrawn=false;
                    gameactive = false;
                } else{
                    winnerStr = "0 has won";
                   gameDrawn=false;
                    gameactive = false;
                }
                    //Update the status bar for winner position
                    TextView status = findViewById(R.id.status);
                    status.setText(winnerStr);

            }
        }
            for (int i = 0; i < gameState.length; i++) {
                if (gameState[i] == 2) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if (!flag && gameDrawn ) {
                winnerStr = "Game is Drawn";
                gameactive = false;
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);

        }
   }


   public void gameReset(View view){
        gameactive=true;
        gameDrawn=true;
        activePlayer=0;
        for(int i=0; i<gameState.length; i++){
            gameState[i]=2;
       }
       ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
   }
   public void Restart(View view){
       gameactive=true;
       gameDrawn=true;
       activePlayer=0;
       for(int i=0; i<gameState.length; i++){
           gameState[i]=2;
       }
       ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}