package com.example.dominika.ortogami;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class OrtogamiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ortogami);
    }

    //metoda uruchamiajaca zasoby zakladki "Zasady" z poziomu glownej aktywnosci "Ortogami"
    public void goToRules(View view) {
        Intent intent = new Intent(this, RulesActivity.class);
        startActivity(intent);
    }

    //metoda uruchamiajaca zasoby zakladki "Graj" z poziomu glownej aktywnosci "Ortogami"
    public void goToPlay(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }

    //metoda uruchamiajaca zasoby zakladki "Autor" z poziomu glownej aktywnosci "Ortogami"
    public void goToAuthor(View view) {
        Intent intent = new Intent(this, AuthorActivity.class);
        startActivity(intent);
    }

    //metoda uruchamiajaca zasoby zakladki "Ranking" z poziomu glownej aktywnosci "Ortogami"
    public void goToRanking(View view) {
        Intent intent = new Intent(this, RankingActivity.class);
        startActivity(intent);
    }
}
