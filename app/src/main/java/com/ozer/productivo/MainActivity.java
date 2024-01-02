package com.ozer.productivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        Button gecisButonu = findViewById(R.id.btngiris_yap);

        gecisButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kullanıcı adı ve şifreyi kontrol et
                EditText kullaniciAdiEditText = findViewById(R.id.kullaniciAdi);
                EditText sifreEditText = findViewById(R.id.sifre);

                String kullaniciAdi = kullaniciAdiEditText.getText().toString();
                String sifre = sifreEditText.getText().toString();

                if (kullaniciAdi.isEmpty() || sifre.isEmpty()) {
                    // Eğer kullanıcı adı veya şifre boşsa hata mesajını göster
                    Toast.makeText(MainActivity.this, "Kullanıcı adı ve şifre boş olamaz", Toast.LENGTH_SHORT).show();
                } else {
                    // Boş değilse yapılacak işlemleri buraya ekle
                    Intent girisIntent = new Intent(MainActivity.this, yapilacaklar.class);
                    startActivity(girisIntent);
                }
            }
        });
    }
}
