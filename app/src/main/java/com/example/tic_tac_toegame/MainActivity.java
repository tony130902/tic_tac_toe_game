package com.example.tic_tac_toegame;

import static android.os.Build.VERSION_CODES.O;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
//    X = 0
//    O = 1
    int activePlayer = 0;
    int count = 0;
    int [] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
//    states:
//    X = 0
//    O = 1
//    Null = 2
    int [][] winPositions = {{0,1,2} ,{3,4,5}, {6,7,8},
                             {0,3,6}, {1,4,7}, {2,5,8},
                             {0,4,8}, {2,4,6}};
//    boolean gameActive = true;
    public void playerTap(View view)
    {
        count += 1;
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
//        if (!gameActive)
//        {
//            gameReset(view);
//        }
        if (gameState[tappedImage] == 2)
        {
            gameState[tappedImage] = activePlayer;
            if (activePlayer == 0)
            {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's turn tap to play");
            }
            else
            {
                img.setImageResource(R.drawable.o2);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn tap to play");
            }

//            Winning position:
            for (int[] winPosition : winPositions)
            {
                if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                        gameState[winPosition[1]] == gameState[winPosition[2]] &&
                        gameState[winPosition[0]] != 2)
                {
                    String winnerStr;
//                    gameActive = false;
                    if(gameState[winPosition[0]] == 0)
                    {
                        winnerStr = "X has won";
                        gameReset(view);
                    }
                    else
                    {
                        winnerStr = "O has won";
                        gameReset(view);
                    }
                    TextView status = findViewById(R.id.status);
                    status.setText(winnerStr);
                }

                if (count == 9)
                {
                    String drawStr = " it's a Draw";
                    TextView status = findViewById(R.id.status);
                    status.setText(drawStr);
//                    gameActive = false;

                }


            }
        }
    }
    public void gameReset(View view)
    {
//        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++)
        {
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's turn tap to play");

        count = 0;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}