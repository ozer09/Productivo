package com.ozer.productivo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class gunluk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunluk);

        // Diğer kodlar...

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.menu_gunluk) {
                openActivity(gunluk.class);
                return true;
            } else if (itemId == R.id.menu_yapilacaklar) {
                openActivity(yapilacaklar.class);
                return true;
            } else if (itemId == R.id.menu_zamanlayici) {
                openActivity(zamanlayici.class);
                return true;
            } else if (itemId == R.id.menu_muzik) {
                openActivity(muzik.class);
                return true;
            }
            return false;
        });
    }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
