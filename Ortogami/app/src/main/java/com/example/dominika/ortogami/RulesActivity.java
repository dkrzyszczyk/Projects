package com.example.dominika.ortogami;

import android.icu.text.DisplayContext;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Typeface;

public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        /*
        zmiana fontu na Century Gothic (wczytany ttf w /src/main/assets/fonts)
        niestety po wczytaniu apka wypluwa "Instant Run applied code changes and restarted the app."
        TextView tv=(TextView)findViewById(R.id.textRules);
        String Century_Gothic_Font = "/gothic.ttf";
        Typeface face= Typeface.createFromAsset(getApplicationContext().getAssets(), Century_Gothic_Font);
        tv.setTypeface(face);
        */
        }
    }

