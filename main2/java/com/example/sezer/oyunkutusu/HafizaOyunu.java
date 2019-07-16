package com.example.sezer.oyunkutusu;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HafizaOyunu extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,sifirla;
    TextView bilgi;
    byte[][] dizi=new byte[3][3];
    int tikSayici=0;
    byte[][] tiklananlar=new byte[3][3];
    boolean hepsiDogrumu=false;
    byte bir_sayisi=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hafiza_oyunu);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        sifirla=findViewById(R.id.sifirla);
        bilgi=findViewById(R.id.bilgi);
        sifirla.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==sifirla.getId()){//Sıfırla butonuna tıklandığında
            bir_sayisi=0;
            for (int i=0;i<3;i++){
                for (int j=0;j<3;j++){
                    byte sayi=(byte) (Math.random() * 2);
                    dizi[i][j]= sayi;
                    if (sayi==1)bir_sayisi++;
                }
            }
            yerlestir(dizi);
            new CountDownTimer(1000, 1) {
                public void onTick(long millisUntilFinished) {

                }
                public void onFinish() {
                    b1.setText("");b2.setText("");b3.setText("");
                    b4.setText("");b5.setText("");b6.setText("");
                    b7.setText("");b8.setText("");b9.setText("");
                }
            }.start();
            tikSayici=0;
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);
            bilgi.setText("");
        }
        else{//Diğer butonlardan birine tıklandığında
            if (tikSayici<bir_sayisi){
                if(view.getId()==b1.getId()) tiklananlar[0][0]=1;
                if(view.getId()==b2.getId()) tiklananlar[0][1]=1;
                if(view.getId()==b3.getId()) tiklananlar[0][2]=1;
                if(view.getId()==b4.getId()) tiklananlar[1][0]=1;
                if(view.getId()==b5.getId()) tiklananlar[1][1]=1;
                if(view.getId()==b6.getId()) tiklananlar[1][2]=1;
                if(view.getId()==b7.getId()) tiklananlar[2][0]=1;
                if(view.getId()==b8.getId()) tiklananlar[2][1]=1;
                if(view.getId()==b9.getId()) tiklananlar[2][2]=1;
            }
            tikSayici++;
        }
        if(tikSayici>=bir_sayisi){
            karsilastir(dizi,tiklananlar);
            if(hepsiDogrumu){
                bilgi.setText("Tebrikler, doğru");
            }
            else{
                bilgi.setText("Yanlış");
            }
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            yerlestir(dizi);
        }

    }

    void yerlestir(byte dizi[][]){
        b1.setText(Integer.toString(dizi[0][0]));
        b2.setText(Integer.toString(dizi[0][1]));
        b3.setText(Integer.toString(dizi[0][2]));
        b4.setText(Integer.toString(dizi[1][0]));
        b5.setText(Integer.toString(dizi[1][1]));
        b6.setText(Integer.toString(dizi[1][2]));
        b7.setText(Integer.toString(dizi[2][0]));
        b8.setText(Integer.toString(dizi[2][1]));
        b9.setText(Integer.toString(dizi[2][2]));

        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                tiklananlar[i][j]=0;
            }
        }
    }
    void karsilastir(byte dizi[][], byte[][] tiklananlar){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (dizi[i][j]!=tiklananlar[i][j]){
                    hepsiDogrumu=false;
                    return;
                }
            }
            hepsiDogrumu=true;
        }
    }
}
