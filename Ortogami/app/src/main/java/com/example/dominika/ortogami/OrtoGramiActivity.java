package com.example.dominika.ortogami;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.DisplayMetrics;

public class OrtoGramiActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = OrtoGramiActivity.class.getSimpleName();

    private Button buttonH;
    private Button buttonCH;
    private Button buttonU;
    private Button buttonÓ;
    private Button buttonĘ;
    private Button buttonEN;
    private Button buttonĄ;
    private Button buttonON;
    private Button buttonRZ;
    private Button buttonŻ;

    private Handler fallDownButonsHandler;
    private Handler countDownHandler;
    private Runnable fallDownButtonsRunnable;
    private Runnable countTimeRunnable;

    private  TextView textWordsOG;
    private TextView textScorePOG;
    private TextView textScoreNOG;

    private int i;
    boolean answer = false;
    private int height;
    private int scorePOG = 0;
    private int scoreNOG = 0;
    int level = 0;
    String[] array;
    String[] letters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orto_grami);

        fallDownButonsHandler = new Handler();
        fallDownButtonsRunnable = new FallDownButtonsRunnable();
        fallDownButonsHandler.post(fallDownButtonsRunnable);

        countDownHandler = new Handler();
        countTimeRunnable = new CountTimeRunnable();
        countDownHandler.post(countTimeRunnable);

        //sprawdzaj wysokość ekranu tylko jeden raz przy uruchamianiu aplikacji
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        height = displaymetrics.heightPixels;

        this.buttonH = (Button) findViewById(R.id.buttonH);
        buttonH.setOnClickListener(this);
        this.buttonCH = (Button) findViewById(R.id.buttonCH);
        buttonCH.setOnClickListener(this);
        this.buttonU = (Button) findViewById(R.id.buttonU);
        buttonU.setOnClickListener(this);
        this.buttonÓ = (Button) findViewById(R.id.buttonÓ);
        buttonÓ.setOnClickListener(this);
        this.buttonĘ = (Button) findViewById(R.id.buttonĘ);
        buttonĘ.setOnClickListener(this);
        this.buttonEN = (Button) findViewById(R.id.buttonEN);
        buttonEN.setOnClickListener(this);
        this.buttonĄ = (Button) findViewById(R.id.buttonĄ);
        buttonĄ.setOnClickListener(this);
        this.buttonON = (Button) findViewById(R.id.buttonON);
        buttonON.setOnClickListener(this);
        this.buttonRZ = (Button) findViewById(R.id.buttonRZ);
        buttonRZ.setOnClickListener(this);
        this.buttonŻ = (Button) findViewById(R.id.buttonŻ);
        buttonŻ.setOnClickListener(this);
        this.textWordsOG = (TextView) findViewById(R.id.textWordsOG);
        this.textScorePOG = (TextView) findViewById(R.id.textScorePOG);
        this.textScoreNOG = (TextView) findViewById(R.id.textScoreNOG);
    }

    private class FallDownButtonsRunnable implements Runnable {

        @Override
        public void run() {
            fallDownButtons();
        }
    }

    private class CountTimeRunnable implements Runnable {

        @Override
        public void run() {
            countTime();
        }
    }

    public void fallDownButtons() {

        if (buttonH.getY() > height) {
            buttonH.setY(0);
        }
        if (buttonCH.getY() > height) {
            buttonCH.setY(0);
        }
        if (buttonÓ.getY() > height) {
            buttonÓ.setY(0);
        }
        if (buttonU.getY() > height) {
            buttonU.setY(0);
        }
        if (buttonĘ.getY() > height) {
            buttonĘ.setY(0);
        }
        if (buttonEN.getY() > height) {
            buttonEN.setY(0);
        }
        if (buttonĄ.getY() > height) {
            buttonĄ.setY(0);
        }
        if (buttonON.getY() > height) {
            buttonON.setY(0);
        }
        if (buttonRZ.getY() > height) {
            buttonRZ.setY(0);
        }
        if (buttonŻ.getY() > height) {
            buttonŻ.setY(0);
        }

        buttonH.getY();
        buttonH.setY(buttonH.getY() + 40);
        buttonCH.getY();
        buttonCH.setY(buttonCH.getY() + 40);
        buttonU.getY();
        buttonU.setY(buttonU.getY() + 40);
        buttonÓ.getY();
        buttonÓ.setY(buttonÓ.getY() + 30);
        buttonĘ.getY();
        buttonĘ.setY(buttonĘ.getY() + 30);
        buttonEN.getY();
        buttonEN.setY(buttonEN.getY() + 30);
        buttonĄ.getY();
        buttonĄ.setY(buttonĄ.getY() + 40);
        buttonON.getY();
        buttonON.setY(buttonON.getY() + 30);
        buttonRZ.getY();
        buttonRZ.setY(buttonRZ.getY() + 40);
        buttonŻ.getY();
        buttonŻ.setY(buttonŻ.getY() + 40);

        fallDownButonsHandler.postDelayed(fallDownButtonsRunnable, 120);

        Log.d(TAG, "fallDownButtons: " + System.currentTimeMillis());

    }

    public void countTime() {

        switch (level) {
            case 0:
                array = getResources().getStringArray(R.array.words_base_orto_grami);
                letters = getResources().getStringArray(R.array.letters_base_orto_grami);
                break;

            case 1:
                array = getResources().getStringArray(R.array.words_base_orto_grami_hard);
                letters = getResources().getStringArray(R.array.letters_base_orto_grami_hard);
                break;
        }

        if(!answer) {
//            String[] array = getResources().getStringArray(R.array.words_base_orto);
            textWordsOG.setText(array[i]);
            Log.d(TAG, "countTime: " + array[i]);
        }
        else
            i++;

        countDownHandler.postDelayed(countTimeRunnable, 15000);
        }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick: letter[i]=" + letters[i]);
        switch (view.getId()) {
            case R.id.buttonH:
                if (buttonH.getText().toString().equals(letters[i])) {
                    scorePOG++;
                    answer = true;
                } else {
                    answer = false;
                    scoreNOG++;
                }
                break;
            case R.id.buttonCH:
                if (buttonCH.getText().toString().equals(letters[i])) {
                    scorePOG++;
                    answer = true;
                } else {
                    answer = false;
                    scoreNOG++;
                }
                break;
            case R.id.buttonÓ:
                if (buttonÓ.getText().toString().equals(letters[i])) {
                    scorePOG++;
                    answer = true;
                } else {
                    answer = false;
                    scoreNOG++;
                }
                break;
            case R.id.buttonU:
                if (buttonU.getText().toString().equals(letters[i])) {
                    scorePOG++;
                    answer = true;
                } else {
                    answer = false;
                    scoreNOG++;
                }
                break;
            case R.id.buttonĘ:
                if (buttonĘ.getText().toString().equals(letters[i])) {
                    scorePOG++;
                    answer = true;
                } else {
                    answer = false;
                    scoreNOG++;
                }
                break;
            case R.id.buttonEN:
                if (buttonEN.getText().toString().equals(letters[i])) {
                    scorePOG++;
                    answer = true;
                } else {
                    answer = false;
                    scoreNOG++;
                }
                break;
            case R.id.buttonĄ:
                if (buttonĄ.getText().toString().equals(letters[i])) {
                    scorePOG++;
                    answer = true;
                } else {
                    answer = false;
                    scoreNOG++;
                }
                break;
            case R.id.buttonON:
                if (buttonON.getText().toString().equals(letters[i])) {
                    scorePOG++;
                    answer = true;
                } else {
                    answer = false;
                    scoreNOG++;
                }
                break;
            case R.id.buttonRZ:
                if (buttonRZ.getText().toString().equals(letters[i])) {
                    scorePOG++;
                    answer = true;
                } else {
                    answer = false;
                    scoreNOG++;
                }
                break;
            case R.id.buttonŻ:
                if (buttonŻ.getText().toString().equals(letters[i])) {
                    scorePOG++;
                    answer = true;
                } else {
                    answer = false;
                    scoreNOG++;
                }
                break;
        }

        switch (level) {
            case 0:
                array = getResources().getStringArray(R.array.words_base_orto_grami);
                letters = getResources().getStringArray(R.array.letters_base_orto_grami);
                break;

            case 1:
                array = getResources().getStringArray(R.array.words_base_orto_grami_hard);
                letters = getResources().getStringArray(R.array.letters_base_orto_grami_hard);
                break;
        }

        if (answer == true) {
            i++;
            textWordsOG.setText(array[i]);
            Log.d(TAG, "countTime: " + array[i]);
            textScorePOG.setText(scorePOG + " PUNKTÓW");
        } else
            textScoreNOG.setText(scoreNOG + " BŁĘDÓW");

        if (scorePOG == 4 && scoreNOG <= 1) {
            i = 0;
            level = 1;
            array = getResources().getStringArray(R.array.words_base_orto_grami_hard);
            textWordsOG.setText(array[i]);
            Log.d(TAG, "countTime: " + array[i]);
        } else if (scorePOG > 4 && scoreNOG <= 1) {
            level = 1;
            array = getResources().getStringArray(R.array.words_base_orto_grami_hard);
            textWordsOG.setText(array[i]);
            Log.d(TAG, "countTime: " + array[i]);
        }
    }
}
