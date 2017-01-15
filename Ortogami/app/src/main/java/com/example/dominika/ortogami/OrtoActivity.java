package com.example.dominika.ortogami;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.DisplayMetrics;

public class OrtoActivity extends AppCompatActivity implements Runnable, View.OnClickListener{

    private Button buttonH;
    private Button buttonCH;
    private Button buttonU;
    private Button buttonRZ;
    private Button buttonÓ;
    private Button buttonŻ;
    private Handler handler;
    public TextView textWords;
    int i;
    boolean answer=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orto);
        this.handler = new Handler();
        handler.post(this);

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

    public void fallDownButtons() {

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;

        if (buttonH.getY() > height)
        {
            buttonH.setY(0);
        }
        if (buttonCH.getY() > height)
        {
            buttonCH.setY(0);
        }
        if (buttonÓ.getY() > height)
        {
            buttonÓ.setY(0);
        }
        if (buttonU.getY() > height)
        {
            buttonU.setY(0);
        }
        if (buttonRZ.getY() > height)
        {
            buttonRZ.setY(0);
        }
        if (buttonŻ.getY() > height)
        {
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

        handler.postDelayed(this, 120);

    }

    //wyswietlanie konkretnego wyrazu n sekund
    //podstawowy 5 wyrazow, 15sek
    //zaawandowany 15 wyrazow, 10sek
    public void countTime() {
        long screenTimeBasicLevel = System.currentTimeMillis();
        long screenBasic = screenTimeBasicLevel + 15000;
        long screenTimeHardLevel = System.currentTimeMillis();
        long screenHard = screenTimeHardLevel + 10000;

        //poziom podstawowy, 5 iteracji po 15 sek.
        for(int j=0; j<5; j++)
        {
            while (System.currentTimeMillis() < screenBasic && answer==false)
            {
                String[] array = getResources().getStringArray(R.array.words_base_orto);
                textWords.setText(array[i]);
            }
            i++;
            screenBasic = screenBasic + 15000;
            answer=false;
        }

        //dopisac poziom zaawansowany uzalezniony od liczby uzyskanych punktow
    }

    @Override
    public void onClick(View view) {
        int scoreP=0;
        int scoreN=0;
        String[] letters = getResources().getStringArray(R.array.letters_base_orto);
        switch (view.getId()) {
            case R.id.buttonH:
                if (buttonH.getText() == letters[i]) {
                    scoreP++;
                    answer=true;
                }
                else
                    scoreN++;
            case R.id.buttonCH:
                if (buttonCH.getText() == letters[i]) {
                    scoreP++;
                    answer=true;
                }
                else
                    scoreN++;
            case R.id.buttonÓ:
                if (buttonÓ.getText() == letters[i]) {
                    scoreP++;
                    answer=true;
                }
                else
                    scoreN++;
            case R.id.buttonU:
                if (buttonU.getText() == letters[i]) {
                    scoreP++;
                    answer=true;
                }
                else
                    scoreN++;
            case R.id.buttonRZ:
                if (buttonRZ.getText() == letters[i]) {
                    scoreP++;
                    answer=true;
                }
                else
                    scoreN++;
            case R.id.buttonŻ:
                if (buttonŻ.getText() == letters[i]) {
                    scoreP++;
                    answer=true;
                }
                else
                    scoreN++;
        }
    }

    @Override
    public void run() {
        //randomWords();
        //iterationWord();
        fallDownButtons();
        countTime();
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
            handler.postDelayed(this, 25000);
        }
    }*/


