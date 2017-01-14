package com.example.dominika.ortogami;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }

    public void playOrto(View view) {
        Intent intent = new Intent(this, OrtoActivity.class);
        startActivity(intent);
    }

    public void playOrtoGrami(View view) {
        Intent intent = new Intent(this, OrtoGramiActivity.class);
        startActivity(intent);
    }
}
