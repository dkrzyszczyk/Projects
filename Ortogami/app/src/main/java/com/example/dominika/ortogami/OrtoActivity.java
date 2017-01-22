package com.example.dominika.ortogami;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.DisplayMetrics;

import org.w3c.dom.Text;

import java.sql.Time;

import static android.R.id.message;

public class OrtoActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = OrtoActivity.class.getSimpleName();

    private Button buttonH;
    private Button buttonCH;
    private Button buttonU;
    private Button buttonRZ;
    private Button buttonÓ;
    private Button buttonŻ;

    private Handler fallDownButtonsHandler;
    private Handler countDownHandler;
    private Runnable fallDownButtonsRunnable;
    private Runnable countTimeRunnable;

    private TextView textWords;
    private TextView textScoreP;
    private TextView textScoreN;
    private TextView textLevel;

    private int i;
    private int r;
    boolean answer;
    private int height;
    private int scoreP = 0;
    private int scoreN = 0;
    int level = 0;
    String[] array;
    String[] letters;
    Integer[] ranking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orto);

        fallDownButtonsHandler = new Handler();
        fallDownButtonsRunnable = new FallDownButtonsRunnable();
        fallDownButtonsHandler.post(fallDownButtonsRunnable);

        countDownHandler = new Handler();
        countTimeRunnable = new CountTimeRunnable();
        countDownHandler.post(countTimeRunnable);

        //sprawdzaj wysokość ekranu tylko jeden raz przy uruchamianiu aplikacji
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        height = displaymetrics.heightPixels - 700;

        this.buttonH = (Button) findViewById(R.id.buttonH);
        buttonH.setOnClickListener(this);
        this.buttonCH = (Button) findViewById(R.id.buttonCH);
        buttonCH.setOnClickListener(this);
        this.buttonU = (Button) findViewById(R.id.buttonU);
        buttonU.setOnClickListener(this);
        this.buttonRZ = (Button) findViewById(R.id.buttonRZ);
        buttonRZ.setOnClickListener(this);
        this.buttonÓ = (Button) findViewById(R.id.buttonÓ);
        buttonÓ.setOnClickListener(this);
        this.buttonŻ = (Button) findViewById(R.id.buttonŻ);
        buttonŻ.setOnClickListener(this);
        this.textWords = (TextView) findViewById(R.id.textWords);
        this.textScoreP = (TextView) findViewById(R.id.textScoreP);
        this.textScoreN = (TextView) findViewById(R.id.textScoreN);
        this.textLevel = (TextView) findViewById(R.id.textLevel);
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
        if (buttonRZ.getY() > height) {
            buttonRZ.setY(0);
        }
        if (buttonŻ.getY() > height) {
            buttonŻ.setY(0);
        }

        buttonH.getY();
        buttonH.setY(buttonH.getY() + 40);
        buttonCH.getY();
        buttonCH.setY(buttonCH.getY() + 30);
        buttonU.getY();
        buttonU.setY(buttonU.getY() + 40);
        buttonRZ.getY();
        buttonRZ.setY(buttonRZ.getY() + 40);
        buttonÓ.getY();
        buttonÓ.setY(buttonÓ.getY() + 30);
        buttonŻ.getY();
        buttonŻ.setY(buttonŻ.getY() + 30);

        fallDownButtonsHandler.postDelayed(fallDownButtonsRunnable, 120);
        Log.d(TAG, "fallDownButtons: " + System.currentTimeMillis());

    }

    public void countTime() {

        switch (level) {
            case 0:
                array = getResources().getStringArray(R.array.words_base_orto);
                letters = getResources().getStringArray(R.array.letters_base_orto);
                break;

            case 1:
                array = getResources().getStringArray(R.array.words_base_orto_hard);
                letters = getResources().getStringArray(R.array.letters_base_orto_hard);
                break;
        }

        if (!answer) {
            textWords.setText(array[i]);
            Log.d(TAG, "countTime: " + array[i]);
        }

        countDownHandler.postDelayed(countTimeRunnable, 15000);
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick: letter[i]=" + letters[i]);
        switch (view.getId()) {
            case R.id.buttonH:
                if (buttonH.getText().toString().equals(letters[i])) {
                    scoreP++;
                    answer = true;
                    Log.d(TAG, "onClick: ");
                } else {
                    answer = false;
                    scoreN++;
                }
                break;
            case R.id.buttonCH:
                if (buttonCH.getText().toString().equals(letters[i])) {
                    scoreP++;
                    answer = true;
                } else {
                    answer = false;
                    scoreN++;
                }
                break;
            case R.id.buttonÓ:
                if (buttonÓ.getText().toString().equals(letters[i])) {
                    scoreP++;
                    answer = true;
                } else {
                    answer = false;
                    scoreN++;
                }
                break;
            case R.id.buttonU:
                if (buttonU.getText().toString().equals(letters[i])) {
                    scoreP++;
                    answer = true;
                } else {
                    answer = false;
                    scoreN++;
                }
                break;
            case R.id.buttonRZ:
                if (buttonRZ.getText().toString().equals(letters[i])) {
                    scoreP++;
                    answer = true;
                } else {
                    answer = false;
                    scoreN++;
                }
                break;
            case R.id.buttonŻ:
                if (buttonŻ.getText().toString().equals(letters[i])) {
                    scoreP++;
                    answer = true;
                } else {
                    answer = false;
                    scoreN++;
                }
                break;
        }

        if (scoreP == 4 && scoreN == 1 || scoreP == 5 && scoreN == 0) {
            textLevel.setText("POZIOM ZAAWANSOWANY");
            i = 0;
            level = 1;
            array = getResources().getStringArray(R.array.words_base_orto_hard);
            textWords.setText(array[i]);
            Log.d(TAG, "countTime: " + array[i]);
        } else if (level == 0) {
            i++;
            array = getResources().getStringArray(R.array.words_base_orto);
            textWords.setText(array[i]);
        } else if (level == 1) {
            i++;
            array = getResources().getStringArray(R.array.words_base_orto_hard);
            textWords.setText(array[i]);
        }

        switch (level) {
            case 0:
                array = getResources().getStringArray(R.array.words_base_orto);
                letters = getResources().getStringArray(R.array.letters_base_orto);
                break;

            case 1:
                array = getResources().getStringArray(R.array.words_base_orto_hard);
                letters = getResources().getStringArray(R.array.letters_base_orto_hard);
                break;
        }

        if (answer == true) {
            textWords.setText(array[i]);
            Log.d(TAG, "countTime: " + array[i]);
            textScoreP.setText(scoreP + " PUNKTÓW");
        } else {
            textScoreN.setText(scoreN + " BŁĘDÓW");
        }

        if(scoreN > 2)
        {
            AlertDialog alertDialog = new AlertDialog.Builder(OrtoActivity.this).create();
            alertDialog.setTitle("PRZYKRO MI :(");
            alertDialog.setMessage("Zrobiłeś więcej niż 2 błędy!\n\nAle poczekaj!\n\nZa chwilę będziesz miał możliwość spróbować swoich sił ponownie! :)");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Trzymam kciuki!",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            i = 0;
            level = 0;
            scoreN = 0;
            scoreP = 0;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    startActivity(new Intent(OrtoActivity.this, OrtoActivity.class));
                }
            }, 5000);
        }

        if (scoreN <= 2 && i == 10) {
            r = scoreP - scoreN;
            AlertDialog alertDialog = new AlertDialog.Builder(OrtoActivity.this).create();
            alertDialog.setTitle("GRATULUJĘ!");
            alertDialog.setMessage("Uzyskałeś " + r + " punktów!\n\n" + "Tym samym pokonałeś dwa poziomy w module ortograficznym.\n\nSpróbuj swoich sił w kolejnym, tym razem ortograficzno-gramatycznym :)");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Powodzenia!",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    startActivity(new Intent(OrtoActivity.this, PlayActivity.class));
                }
            }, 7000);


            Intent intent = new Intent(OrtoActivity.this, RankingActivity.class);
            intent.putExtra("Pierwsza pozycja: ", r);
        }
    }

}




