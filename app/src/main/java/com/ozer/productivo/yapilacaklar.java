package com.ozer.productivo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class yapilacaklar extends AppCompatActivity {

    private ArrayList<String> yapilacaklarListesi;
    private ArrayAdapter<String> adapter;
    private boolean[] isTaskCompleted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yapilacaklar);

        Button gorevEkleButton = findViewById(R.id.gorev_ekle);
        gorevEkleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gorevEkleIntent = new Intent(yapilacaklar.this, gorev_ekle.class);
                startActivity(gorevEkleIntent);
            }
        });

        ListView gorevListView = findViewById(R.id.gorev);
        yapilacaklarListesi = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, yapilacaklarListesi);
        gorevListView.setAdapter(adapter);

        isTaskCompleted = new boolean[yapilacaklarListesi.size()];

        Intent intent = getIntent();
        if (intent.hasExtra("gorevListesi")) {
            ArrayList<String> yeniGorevler = intent.getStringArrayListExtra("gorevListesi");
            yapilacaklarListesi.addAll(yeniGorevler);
            isTaskCompleted = new boolean[yapilacaklarListesi.size()]; // Görevlerin tamamlanma durumlarını güncelle
            adapter.notifyDataSetChanged();
        }

        gorevListView.setOnItemClickListener((parent, view, position, id) -> showTaskDialog(position));

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

        TextView tarihTextView = findViewById(R.id.tarihTextView);
        String tarih = getGuncelTarih();
        tarihTextView.setText(tarih);
    }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    //Dialog işlemleri
    private void showTaskDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("TASK CHECKER");
        builder.setMessage(yapilacaklarListesi.get(position));

        builder.setPositiveButton("FINISH", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Görevi bitirme işlemini gerçekleştir
                finishTask(position);
            }
        });

        builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Görevi silme işlemini gerçekleştir
                removeTask(position);
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    private void finishTask(int position) {
        if (!isTaskCompleted[position]) {
            String taskText = yapilacaklarListesi.get(position);

            SpannableString spannableString = new SpannableString("✓ " + taskText);

            CharacterStyle characterStyle = new CharacterStyle() {
                @Override
                public void updateDrawState(TextPaint tp) {
                    tp.setColor(ContextCompat.getColor(yapilacaklar.this, R.color.Green)); // Tik işaretinin rengi
                    tp.setTextSize(tp.getTextSize() * 1.2f); // Tik işaretinin boyutu
                }
            };

            spannableString.setSpan(characterStyle, 0, 1, 0);

            yapilacaklarListesi.set(position, spannableString.toString());
            adapter.notifyDataSetChanged();

            isTaskCompleted[position] = true;
        }
    }



    private void removeTask(int position) {
        yapilacaklarListesi.remove(position);
        isTaskCompleted[position] = false;
        adapter.notifyDataSetChanged();
    }

    private String getGuncelTarih() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }
}
