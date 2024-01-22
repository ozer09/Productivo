package com.ozer.productivo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class yapilacaklar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yapilacaklar);
        Button gorevEkleButton = findViewById(R.id.gorev_ekle);
        Button gorevSilButton = findViewById(R.id.gorev_sil);



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
                Intent gorevSilIntent = new Intent(yapilacaklar.this, gorev_sil.class);
                startActivity(gorevSilIntent);
            }
        });

        ListView gorev = findViewById(R.id.gorev);
        ArrayList<String> yapilacaklarListesi = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, yapilacaklarListesi);
        gorev.setAdapter(adapter);

        Intent intent = getIntent();
        if (intent.hasExtra("gorevListesi")) {
            ArrayList<String> yeniGorevler = intent.getStringArrayListExtra("gorevListesi");
            yapilacaklarListesi.addAll(yeniGorevler);
            adapter.notifyDataSetChanged();
        }

        }

    }
