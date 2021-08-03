package com.roberherraiz.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    private int players;
    private int[] boxes;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* We start the boxes array to identify each box */

        boxes = new int[9];

        boxes[0] = R.id.a1;
        boxes[1] = R.id.a2;
        boxes[2] = R.id.a3;

        boxes[3] = R.id.b1;
        boxes[4] = R.id.b2;
        boxes[5] = R.id.b3;

        boxes[6] = R.id.c1;
        boxes[7] = R.id.c2;
        boxes[8] = R.id.c3;

    }

    public void playNow(View view) {
        ImageView blankBox;
        for (int box: boxes) {
            blankBox = findViewById(box);
            blankBox.setImageResource(R.drawable.box);
        }

        /* Number of players */

        players = 1;

        if(view.getId() == R.id.multiplayer) {
            players = 2;
        }

        /* Difficulty level */

        RadioGroup configDifficulty = findViewById(R.id.difficultyGroup);

        int id = configDifficulty.getCheckedRadioButtonId();

        int difficulty = 0;

        if (id == R.id.normal) {
            difficulty = 1;
        } else if (id == R.id.insane) {
            difficulty = 2;
        }

        game = new Game(difficulty);

        /* Deactivating the buttons */

        findViewById(R.id.singleplayer).setEnabled(false);
        findViewById(R.id.multiplayer).setEnabled(false);

        // findViewById(R.id.difficultyGroup).setAlpha(0);  // Así los ponemos todos en "desactivado"
        findViewById(R.id.easy).setEnabled(false);
        findViewById(R.id.normal).setEnabled(false);
        findViewById(R.id.insane).setEnabled(false);

    }

}

class Game {

    public final int difficulty;

    public Game(int difficulty) {

        this.difficulty = difficulty;

    }
}