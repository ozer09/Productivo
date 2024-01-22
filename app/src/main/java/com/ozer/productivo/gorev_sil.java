package com.ozer.productivo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class gorev_sil extends AppCompatActivity {

    private ArrayList<String> gorevSil;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorev_sil);

        ListView listViewGorevler = findViewById(R.id.listViewGorevler);
        Button buttonGorevSil = findViewById(R.id.buttonGorevSil);

        // Yapılacaklar listesini al
        Intent intent = getIntent();
        gorevSil = intent.getStringArrayListExtra("gorevListesi");

        // ArrayAdapter'ı ve ListView'ı yapılandır
        if (gorevSil != null) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, gorevSil);
        }
        listViewGorevler.setAdapter(adapter);

        // Görev silme olayını dinle
        listViewGorevler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Seçilen görevi sil
                String secilenGorev = gorevSil.get(position);
                gorevSil.remove(position);
                adapter.notifyDataSetChanged();

                // Görev silindiğine dair geri bildirim
                Toast.makeText(gorev_sil.this, secilenGorev + " silindi!", Toast.LENGTH_SHORT).show();
            }
        });

        // Geri butonu tıklama olayını dinle
        buttonGorevSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Geri dön, güncellenmiş liste ile
                Intent geriIntent = new Intent();
                geriIntent.putStringArrayListExtra("guncellenmisListe", gorevSil);
                setResult(RESULT_OK, geriIntent);
                finish();
            }
        });
        Button Geri = findViewById(R.id.gorev_sil_geri);
        Geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gorevSilIntent = new Intent(gorev_sil.this, yapilacaklar.class);
                startActivity(gorevSilIntent);
            }
        });
    }
}
