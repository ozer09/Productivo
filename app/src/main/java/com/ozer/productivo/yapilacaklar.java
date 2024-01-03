package com.ozer.productivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class yapilacaklar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yapilacaklar);
        Button gorevEkleButton = findViewById(R.id.gorev_ekle);
        Button gorevSilButton =findViewById(R.id.gorev_sil);

        gorevEkleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gorevEkleIntent = new Intent(yapilacaklar.this, gorev_ekle.class);
                startActivity(gorevEkleIntent);
            }
        });
        gorevSilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gorevSilIntent = new Intent(yapilacaklar.this,gorev_sil.class);
            }
        });


    }
}