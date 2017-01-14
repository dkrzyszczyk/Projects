package com.example.dominika.ortogami;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class OrtoActivity extends AppCompatActivity implements Runnable{

    private Button buttonH;
    private Button buttonCH;
    private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Button buttonD;
    private Handler handler;
    public TextView textWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orto);
        this.handler = new Handler();
        handler.post(this);
    }

   public void fallDownButtons()
    {
        this.buttonH = (Button) findViewById(R.id.buttonH);
        this.buttonCH = (Button) findViewById(R.id.buttonCH);
        this.buttonA = (Button) findViewById(R.id.buttonA);
        this.buttonB = (Button) findViewById(R.id.buttonB);
        this.buttonC = (Button) findViewById(R.id.buttonC);
        this.buttonD = (Button) findViewById(R.id.buttonD);

        buttonH.getY();
        buttonH.setY(buttonH.getY() + 50);
        buttonCH.getY();
        buttonCH.setY(buttonCH.getY() + 30);
        buttonA.getY();
        buttonA.setY(buttonA.getY() + 50);
        buttonB.getY();
        buttonB.setY(buttonB.getY() + 30);
        buttonC.getY();
        buttonC.setY(buttonC.getY() + 30);
        buttonD.getY();
        buttonD.setY(buttonD.getY() + 30);
        handler.postDelayed(this, 70);
    }

    public void randomWords()
    {
        for(int i=0; i<30; i++)
        {
            String[] array = getResources().getStringArray(R.array.words_base_orto);
            String randomStr = array[new Random().nextInt(array.length)];
            textWords.setText(randomStr);
            handler.postDelayed(this, 25);
        }
    }

    @Override
    public void run() {
        fallDownButtons();
        randomWords();
    }
}

