package com.example.dominika.ortogami;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.DisplayMetrics;

public class OrtoActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = OrtoActivity.class.getSimpleName();

    private Button buttonH;
    private Button buttonCH;
    private Button buttonU;
    private Button buttonRZ;
    private Button buttonÓ;
    private Button buttonŻ;

    private Handler fallDownButonsHandler;
    private Handler countDownHandler;
    private Runnable fallDownButtonsRunnable;
    private Runnable countTimeRunnable;

    private  TextView textWords;

    private int i;
    private boolean answer = false;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orto);

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
        this.buttonRZ = (Button) findViewById(R.id.buttonRZ);
        buttonRZ.setOnClickListener(this);
        this.buttonÓ = (Button) findViewById(R.id.buttonÓ);
        buttonÓ.setOnClickListener(this);
        this.buttonŻ = (Button) findViewById(R.id.buttonŻ);
        buttonŻ.setOnClickListener(this);
        this.textWords = (TextView) findViewById(R.id.textWords);
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
        if (buttonRZ.getY() > height) {
            buttonRZ.setY(0);
        }
        if (buttonŻ.getY() > height) {
            buttonŻ.setY(0);
        }

        buttonH.getY();
        buttonH.setY(buttonH.getY() + 50);
        buttonCH.getY();
        buttonCH.setY(buttonCH.getY() + 30);
        buttonU.getY();
        buttonU.setY(buttonU.getY() + 50);
        buttonRZ.getY();
        buttonRZ.setY(buttonRZ.getY() + 30);
        buttonÓ.getY();
        buttonÓ.setY(buttonÓ.getY() + 30);
        buttonŻ.getY();
        buttonŻ.setY(buttonŻ.getY() + 30);

        fallDownButonsHandler.postDelayed(fallDownButtonsRunnable, 120);

        Log.d(TAG, "fallDownButtons: " + System.currentTimeMillis());

    }

    //wyswietlanie konkretnego wyrazu n sekund
    //podstawowy 5 wyrazow, 15sek
    //zaawandowany 15 wyrazow, 10sek
    public void countTime() {

        //TODO: dodaj jeszcze to sprawdzanie odpowiedzi.
        //masz tylko 5 elementów w tablicy, zatem żeby nie crashowało aplikacji
        //jak wszystkie zostaną przetworzone, to wtedy zaczyna się od nowa
        if(i == 4){
            i = 0;
        }

        String[] array = getResources().getStringArray(R.array.words_base_orto);
        textWords.setText(array[i]);
        Log.d(TAG, "countTime: " + array[i]);

        i++;
        //TODO: ustaw poniżej sobie wywoływanie co 15000
        //dalam 10x mniej do celów testowych
        countDownHandler.postDelayed(countTimeRunnable, 1500);

//            answer=false;
//        }


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
            case R.id.buttonRZ:
                if (buttonRZ.getText() == letters[i]) {
                    scoreP++;
                    answer = true;
                } else
                    scoreN++;
            case R.id.buttonŻ:
                if (buttonŻ.getText() == letters[i]) {
                    scoreP++;
                    answer = true;
                } else
                    scoreN++;
        }
    }
}

    /*public void iterationWord(View v) {
        int i = 0;
        int scoreP = 0;
        int scoreN = 0;
        long mainTime = System.currentTimeMillis();
        long end = mainTime + 7500;
        //View v= ;

        while (System.currentTimeMillis() < end) {
            long periodTime = System.currentTimeMillis();
            long period = periodTime + 1500;

                while (System.currentTimeMillis() < period) {
                    switch(v.getId())
                    {
                        case R.id.buttonH :
                            String[] letters = getResources().getStringArray(R.array.letters_base_orto);
                            CharSequence e = letters[0];
                            CharSequence buttonText = buttonH.getText();
                            //buttonText.equals(e) = true;
                            if (buttonText == e) {

                            }
                    }
                }

        }*/

//return scoreN;
// scoreP;
//buttonCheck(View v, int scoreP, int scoreN);


//public void buttonCheck(View v){


//}


        /*for (int i=0; i<3; i++)
        {
            String[] array = getResources().getStringArray(R.array.words_base_orto);
            textWords.setText(array[i]);
        }*/


    /*public void randomWords() {
        for (int i = 0; i < 30; i++) {
            String[] array = getResources().getStringArray(R.array.words_base_orto);
            String randomStr = array[new Random().nextInt(array.length)];
            textWords.setText(randomStr);
            fallDownButonsHandler.postDelayed(this, 25000);
        }
    }*/


