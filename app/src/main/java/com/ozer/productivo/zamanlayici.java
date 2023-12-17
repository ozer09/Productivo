package com.ozer.productivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class zamanlayici extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zamanlayici);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.menu_rutinler) {
                startActivity(new Intent(zamanlayici.this, rutinler.class));
                return true;
            }
            else if (itemId == R.id.menu_gunluk) {
                startActivity(new Intent(zamanlayici.this, gunluk.class));
                return true;
            }
            else if (itemId == R.id.menu_zamanlayici) {
                startActivity(new Intent(zamanlayici.this, zamanlayici.class));
                return true;
            }
            else if (itemId == R.id.menu_muzik) {
                startActivity(new Intent(zamanlayici.this,muzik.class));
                return true;
            }
            else if (itemId == R.id.menu_yapilacaklar) {
                startActivity(new Intent(zamanlayici.this,ana_sayfa.class));
                return true;
            }

            else
                return false;
        });
    }
}