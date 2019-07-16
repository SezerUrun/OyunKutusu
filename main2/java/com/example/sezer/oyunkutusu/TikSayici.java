package com.example.sezer.oyunkutusu;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TikSayici extends AppCompatActivity implements View.OnClickListener {
    int sayac=0, sure=10;
    Button button_tikla,button_sifirla;
    TextView textView_sure, textView_tikSayici;
    CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tik_sayici);
        button_tikla=findViewById(R.id.button_tikla);
        button_sifirla=findViewById(R.id.sifirla);
        textView_sure=findViewById(R.id.tw_sure);
        textView_tikSayici=findViewById(R.id.tikSayici);
        button_tikla.setOnClickListener(this);
        button_sifirla.setOnClickListener(this);
        sayac=0;
        sure=0;
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==button_sifirla.getId()){
            button_sifirla.setText("Sıfırla");
            sayac=0;
            sure=10;
            button_tikla.setEnabled(true);
            textView_tikSayici.setText("Tık : 0");
            timer = new CountDownTimer(10000,1000){
                @Override
                public void onTick(long l) {
                    textView_sure.setText("Süre : "+--sure);
                }
                @Override
                public void onFinish() {
                    textView_sure.setText("Süre : "+--sure);
                    button_tikla.setEnabled(false);
                    Toast.makeText(TikSayici.this,"Süre doldu",Toast.LENGTH_SHORT).show();
                }
            }.start();
        }
        else if(view.getId()==button_tikla.getId()){
            textView_tikSayici.setText("Tık : " + Integer.toString(++sayac));
        }
    }
}
