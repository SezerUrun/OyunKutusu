package com.example.sezer.oyunkutusu;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TasKagitMakas extends AppCompatActivity implements View.OnClickListener {

    ImageView karsiTaraf, oyuncu;
    Button tas,kagit,makas;
    CountDownTimer timer;
    boolean izin=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tas_kagit_makas);
        karsiTaraf=findViewById(R.id.karsiTaraf);
        oyuncu=findViewById(R.id.sen);
        tas=findViewById(R.id.tas);
        kagit=findViewById(R.id.kagit);
        makas=findViewById(R.id.makas);
        tas.setOnClickListener(this);
        kagit.setOnClickListener(this);
        makas.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        timer=new CountDownTimer(2000,1) {
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {
                izin=true;
            }
        }.start();
        byte b=(byte)(Math.random()*3);
        String s="";
        if (izin==true){
            if (view.getId()==tas.getId()){
                oyuncu.setImageResource(R.drawable.tas);
                s="tas";
            }
            if (view.getId()==kagit.getId()){
                oyuncu.setImageResource(R.drawable.kagit);
                s="kagit";
            }
            if (view.getId()==makas.getId()){
                oyuncu.setImageResource(R.drawable.makas);
                s="makas";
            }
            if (b==0){
                karsiTaraf.setImageResource(R.drawable.tas);
            }
            if (b==1){
                karsiTaraf.setImageResource(R.drawable.kagit);
            }
            if (b==2){
                karsiTaraf.setImageResource(R.drawable.makas);
            }
            if (s=="tas"){
                switch (b){
                    case 0: Toast.makeText(TasKagitMakas.this,"Kazanan yok",Toast.LENGTH_SHORT).show(); break;
                    case 1: Toast.makeText(TasKagitMakas.this,"Kağıt taşı sarar, kaybettin...",Toast.LENGTH_SHORT).show(); break;
                    case 2: Toast.makeText(TasKagitMakas.this,"Taş makası kırar, kazandın!",Toast.LENGTH_SHORT).show(); break;
                }
            }
            else if (s=="kagit"){
                switch (b){
                    case 0: Toast.makeText(TasKagitMakas.this,"Kağıt taşı sarar, kazandın!",Toast.LENGTH_SHORT).show(); break;
                    case 1: Toast.makeText(TasKagitMakas.this,"Kazanan yok",Toast.LENGTH_SHORT).show(); break;
                    case 2: Toast.makeText(TasKagitMakas.this,"Makas kağıdı keser, kaybettin...",Toast.LENGTH_SHORT).show(); break;
                }
            }
            else if (s=="makas"){
                switch (b){
                    case 0: Toast.makeText(TasKagitMakas.this,"Taş makası kırar, kaybettin...",Toast.LENGTH_SHORT).show(); break;
                    case 1: Toast.makeText(TasKagitMakas.this,"Makas kağıdı keser, kazandın!",Toast.LENGTH_SHORT).show(); break;
                    case 2: Toast.makeText(TasKagitMakas.this,"Kazanan yok",Toast.LENGTH_SHORT).show(); break;
                }
            }
            izin=false;
        }
    }
}
