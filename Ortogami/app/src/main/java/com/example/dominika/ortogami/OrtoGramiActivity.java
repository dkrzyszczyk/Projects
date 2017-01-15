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
    private Button buttonOM;

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
        this.buttonOM = (Button) findViewById(R.id.buttonOM);
        buttonOM.setOnClickListener(this);
        this.textWordsOG = (TextView) findViewById(R.id.textWordsOG);
        this.textScorePOG = (TextView) findViewById(R.id.textScorePOG);
        this.textScoreNOG = (TextView) findViewById(R.id.textScoreNOG);
    }

    private class FallDownButtonsRunnable implements Runnable {

        @Override
        public void run() {
            Log.d(TAG, "run: ");
            fallDownButtons();
        }
    }

    private class CountTimeRunnable implements Runnable {

        @Override
        public void run() {
            Log.d(TAG, "run: ");
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
        if (buttonOM.getY() > height) {
            buttonOM.setY(0);
        }

        buttonH.getY();
        buttonH.setY(buttonH.getY() + 50);
        buttonCH.getY();
        buttonCH.setY(buttonCH.getY() + 30);
        buttonU.getY();
        buttonU.setY(buttonU.getY() + 50);
        buttonÓ.getY();
        buttonÓ.setY(buttonÓ.getY() + 30);
        buttonĘ.getY();
        buttonĘ.setY(buttonĘ.getY() + 30);
        buttonEN.getY();
        buttonEN.setY(buttonEN.getY() + 50);
        buttonĄ.getY();
        buttonĄ.setY(buttonĄ.getY() + 30);
        buttonOM.getY();
        buttonOM.setY(buttonOM.getY() + 50);

        fallDownButonsHandler.postDelayed(fallDownButtonsRunnable, 120);

        Log.d(TAG, "fallDownButtons: " + System.currentTimeMillis());

    }

    public void countTime() {

        //TODO: dodaj jeszcze to sprawdzanie odpowiedzi.
        //masz tylko 5 elementów w tablicy, zatem żeby nie crashowało aplikacji
        //jak wszystkie zostaną przetworzone, to wtedy zaczyna się od nowa
        if(i == 4){
            i = 0;
        }

            String[] array = getResources().getStringArray(R.array.words_base_orto);
            textWordsOG.setText(array[i]);
            Log.d(TAG, "countTime: " + array[i]);

            i++;

        countDownHandler.postDelayed(countTimeRunnable, 15000);
        answer=false;

        //dopisac poziom zaawansowany uzalezniony od liczby uzyskanych punktow
    }

    @Override
    public void onClick(View view) {
        int scoreP = 0;
        int scoreN = 0;
        String[] letters = getResources().getStringArray(R.array.letters_base_orto);
        switch (view.getId()) {
            case R.id.buttonH:
                if (buttonH.getText() == letters[i]) {
                    scoreP++;
                    answer = true;
                    System.out.println("DUPADUPA DUPA DUPA");
                } else
                    scoreN++;
            case R.id.buttonCH:
                if (buttonCH.getText() == letters[i]) {
                    scoreP++;
                    answer = true;
                } else
                    scoreN++;
            case R.id.buttonÓ:
                if (buttonÓ.getText() == letters[i]) {
                    scoreP++;
                    answer = true;
                } else
                    scoreN++;
            case R.id.buttonU:
                if (buttonU.getText() == letters[i]) {
                    scoreP++;
                    answer = true;
                } else
                    scoreN++;
            case R.id.buttonĘ:
                if (buttonĘ.getText() == letters[i]) {
                    scoreP++;
                    answer = true;
                } else
                    scoreN++;
            case R.id.buttonEN:
                if (buttonEN.getText() == letters[i]) {
                    scoreP++;
                    answer = true;
                } else
                    scoreN++;
            case R.id.buttonĄ:
                if (buttonĄ.getText() == letters[i]) {
                    scoreP++;
                    answer = true;
                } else
                    scoreN++;
            case R.id.buttonOM:
                if (buttonOM.getText() == letters[i]) {
                    scoreP++;
                    answer = true;
                } else
                    scoreN++;
        }
            //textScorePOG.setText(scoreP + " PUNKTÓW");


    }
}

