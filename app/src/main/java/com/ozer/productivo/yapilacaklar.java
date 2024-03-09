package com.ozer.productivo;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class yapilacaklar extends AppCompatActivity {

    private ArrayList<String> yapilacaklarListesi;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yapilacaklar);

        // Görev ekleme butonu
        Button gorevEkleButton = findViewById(R.id.gorev_ekle);
        gorevEkleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Yeni görev ekleme ekranına yönlendirme
                Intent gorevEkleIntent = new Intent(yapilacaklar.this, gorev_ekle.class);
                startActivity(gorevEkleIntent);
            }
        });

        // Görev listesi
        ListView gorevListView = findViewById(R.id.gorev);
        yapilacaklarListesi = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, yapilacaklarListesi);
        gorevListView.setAdapter(adapter);

        // Intent'ten gelen görev listesini kontrol et
        Intent intent = getIntent();
        if (intent.hasExtra("gorevListesi")) {
            ArrayList<String> yeniGorevler = intent.getStringArrayListExtra("gorevListesi");
            yapilacaklarListesi.addAll(yeniGorevler);
            adapter.notifyDataSetChanged();
        }

        // Göreve tıklanıldığında diyalog penceresini gösterme
        gorevListView.setOnItemClickListener((parent, view, position, id) -> showTaskDialog(position));

        // Bottom Navigation View
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

    // Aktiviteyi açma metodunu tanımla
    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    // Göreve tıklandığında diyalog penceresini gösterme
    private void showTaskDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Görev Durumu");
        builder.setMessage(yapilacaklarListesi.get(position));

        builder.setPositiveButton("Bitti", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Görevi bitirme işlemini gerçekleştir
                finishTask(position);
            }
        });

        builder.setNegativeButton("Sil", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Görevi silme işlemini gerçekleştir
                removeTask(position);
            }
        });

        builder.setNeutralButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Diyalogu kapat
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    // Görevi bitirme işlemleri
    private void finishTask(int position) {
        // İlgili görevi bitirme işlemleri burada gerçekleştirilebilir
        // Örneğin, görevi listview'den silmek ve tamamlanan görevi işaretlemek için
        // Özel olarak oluşturduğumuz CustomStrikethroughSpan sınıfını kullanarak görevi çizmek

        String taskText = yapilacaklarListesi.get(position);
        SpannableString spannableString = new SpannableString(taskText);

        // Çizgi rengi ve kalınlığını ayarla (isteğe bağlı)
        int color = Color.GREEN; // Yeşil renk
        float thickness = 4.0f; // Kalınlık

        // CustomStrikethroughSpan kullanarak çizgi rengi ve kalınlığını ayarla
        CustomStrikethroughSpan customStrikethroughSpan = new CustomStrikethroughSpan(color, thickness);

        // SpannableString'e CustomStrikethroughSpan'ı ekle
        spannableString.setSpan(customStrikethroughSpan, 0, spannableString.length(), 0);

        // Listeye güncellenmiş görevi ekle
        yapilacaklarListesi.set(position, spannableString.toString());
        adapter.notifyDataSetChanged();
    }


    // Görevi silme işlemleri
    private void removeTask(int position) {
        // İlgili görevi silme işlemleri burada gerçekleştirilebilir
        yapilacaklarListesi.remove(position);
        adapter.notifyDataSetChanged();
    }
}
