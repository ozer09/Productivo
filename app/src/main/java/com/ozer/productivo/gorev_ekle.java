package com.ozer.productivo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class gorev_ekle extends AppCompatActivity {

    private EditText editTextGorev;
    private Button buttonGorevEkle;
    private ListView listViewGorevler;
    private ArrayList<String> gorevListesi;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorev_ekle);

        editTextGorev = findViewById(R.id.editTextGorev);
        buttonGorevEkle = findViewById(R.id.buttonGorevEkle);
        listViewGorevler = findViewById(R.id.listViewGorevler);

        gorevListesi = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, gorevListesi);
        listViewGorevler.setAdapter(adapter);

        buttonGorevEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yeniGorev = editTextGorev.getText().toString();
                if (!yeniGorev.isEmpty()) {
                    gorevListesi.add(yeniGorev);
                    adapter.notifyDataSetChanged();
                    editTextGorev.setText("");
                }
            }
        });

        Button Geri = findViewById(R.id.gorev_ekle_geri);
        Geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yapilacaklarIntent = new Intent(gorev_ekle.this, yapilacaklar.class);
                yapilacaklarIntent.putStringArrayListExtra("gorevListesi", gorevListesi);
                startActivity(yapilacaklarIntent);
            }
        });
    }
}
