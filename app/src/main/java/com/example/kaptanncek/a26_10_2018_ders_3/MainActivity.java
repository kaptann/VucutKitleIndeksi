package com.example.kaptanncek.a26_10_2018_ders_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText boy,kilo;
    Button hesapla,temizle;
    TextView sonuc,durum;
    double Boy,Kilo,Sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boy=(EditText)findViewById(R.id.et_Boy);
        kilo=(EditText)findViewById(R.id.et_Kilo);
        hesapla=(Button)findViewById(R.id.btn_Hesapla);
        temizle=(Button)findViewById(R.id.btn_Temizle);
        sonuc=(TextView)findViewById(R.id.tv_sonuc);
        durum=(TextView)findViewById(R.id.tv_durum);

        temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boy.getText().toString().isEmpty() || kilo.getText().toString().isEmpty()) Toast.makeText(getApplicationContext(), "Boy ve kilo degerlerini eksiksiz giriniz !", Toast.LENGTH_LONG).show();
                else {
                    Boy = (Double.parseDouble(boy.getText().toString())) / 100;
                    Kilo = Double.parseDouble(kilo.getText().toString());
                    Sonuc = Kilo / (Boy * Boy);
                    sonuc.setText(Double.toString(Sonuc));
                    if (Sonuc < 18.5) durum.setText("ZAYIF");
                    else if (Sonuc >= 18.5 && Sonuc < 24.9) durum.setText("NORMAL");
                    else if (Sonuc >= 24.9 && Sonuc < 29.9) durum.setText("FAZLA KILOLU");
                    else if (Sonuc >= 29.9 && Sonuc < 34.9) durum.setText("I. DERECE OBEZ");
                    else if (Sonuc >= 34.9 && Sonuc < 39.9) durum.setText("II. DERECE OBEZ");
                    else durum.setText("III. DERECE OBEZ");
                }
            }
        });
    }
}