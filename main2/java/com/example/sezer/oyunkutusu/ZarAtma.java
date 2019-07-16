package com.example.sezer.oyunkutusu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ZarAtma extends AppCompatActivity implements View.OnClickListener {

    Button zar_at;
    ImageView resim;
    TextView bilgi;
    byte sayi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zar_atma);
        zar_at=findViewById(R.id.zar_at);
        resim=findViewById(R.id.resim);
        bilgi=findViewById(R.id.bilgi);
        zar_at.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==zar_at.getId()){
            sayi=(byte)(Math.random()*6);
            switch (sayi){
                case 0: bilgi.setText("1"); break;
                case 1: bilgi.setText("2"); break;
                case 2: bilgi.setText("3"); break;
                case 3: bilgi.setText("4"); break;
                case 4: bilgi.setText("5"); break;
                case 5: bilgi.setText("6"); break;
            }
        }
    }
}
