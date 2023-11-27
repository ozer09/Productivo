package com.ozer.productivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnkayit_ol;
    Button btngiris_yap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


// Kayıt Ol butonu eklendi
        Button kayitButton = findViewById(R.id.btnkayit_ol); // buton id'si kullanıldı

        kayitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kayitIntent = new Intent(MainActivity.this,kayit_ol.class); // "MainActivity" ve "KayitOlActivity" yerine yazıldı
                startActivity(kayitIntent);
            }
        });

// Giriş yap butonu eklendi
        Button gecisButonu = findViewById(R.id.btngiris_yap); // Buton yerine yazıldı

        gecisButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ana_sayfaIntent = new Intent(MainActivity.this, ana_sayfa.class); // "MainActivity" ve "AnaSayfaActivity" yerine yazıldı
                startActivity(ana_sayfaIntent);
            }
        });

    }
}
