package com.ozer.productivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ana_sayfa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.MENU_RUTINLER) {
                startActivity(new Intent(ana_sayfa.this, rutinler.class));
                return true;
            } /* else if (itemId == R.id.menu_gunluk) {
                startActivity(new Intent(MainActivity.this, GunlukActivity.class));
                return true;
            } else if (itemId == R.id.menu_yapilacaklar) {
                startActivity(new Intent(MainActivity.this, YapilacaklarActivity.class));
                return true;
            } else if (itemId == R.id.menu_zamanlayici) {
                startActivity(new Intent(MainActivity.this, ZamanlayiciActivity.class));
                return true;
            } else if (itemId == R.id.menu_muzik) {
                startActivity(new Intent(MainActivity.this, MuzikActivity.class));
                return true;
            } */

            return false;
        });


    }
}