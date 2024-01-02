package com.ozer.productivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kayıt Ol butonu eklendi
        Button kayitButton = findViewById(R.id.btnkayit_ol);

        kayitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kayitIntent = new Intent(MainActivity.this, kayit_ol.class);
                startActivity(kayitIntent);
            }
        });

        // Giriş yap butonu eklendi
        Button gecisButonu = findViewById(R.id.btngiris_yap);

        gecisButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent girisIntent = new Intent(MainActivity.this, yapilacaklar.class);
                startActivity(girisIntent);
            }
        });
    }
}
