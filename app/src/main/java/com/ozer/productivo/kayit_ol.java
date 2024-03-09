package com.ozer.productivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Base64;

public class kayit_ol extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);
        Button Button = findViewById(R.id.kayit_button);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gorevSilIntent = new Intent(kayit_ol.this, MainActivity.class);
                startActivity(gorevSilIntent);
            }
        });

    }
}