package com.oyunkutusu;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class HafizaOyunu extends AppCompatActivity implements View.OnClickListener {
    Button sifirla;
    Button[] butonlar;
    int onceki;
    int[] dizi;
    boolean ilk=true,hepsiDogrumu=false;
    boolean[] eslesenler;
    ArrayList<Integer> liste;
    int hamleSayisi=0;
    TextView tv_hamleSayisi;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hafiza_oyunu);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2616577523967769/1675849450");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
            }
            @Override
            public void onAdFailedToLoad(int errorCode) {
            }
            @Override
            public void onAdOpened() {
            }
            @Override
            public void onAdLeftApplication() {
            }
            @Override
            public void onAdClosed() {
                HafizaOyunu.super.onStop();
            }
        });

        preferences=getSharedPreferences("preferences",MODE_PRIVATE);
        editor=preferences.edit();
        editor.putInt("HafizaOyunuEnIyiSkor", preferences.getInt("HafizaOyunuEnIyiSkor",1000));
        editor.commit();
        eslesenler=new boolean[16];
        liste=new ArrayList<>();
        butonlar=new Button[16];
        dizi=new int[16];
        tv_hamleSayisi=findViewById(R.id.hamleSayisi);
        sifirla=findViewById(R.id.sifirla);
        butonlar[0]=findViewById(R.id.b0);
        butonlar[1]=findViewById(R.id.b1);
        butonlar[2]=findViewById(R.id.b2);
        butonlar[3]=findViewById(R.id.b3);
        butonlar[4]=findViewById(R.id.b4);
        butonlar[5]=findViewById(R.id.b5);
        butonlar[6]=findViewById(R.id.b6);
        butonlar[7]=findViewById(R.id.b7);
        butonlar[8]=findViewById(R.id.b8);
        butonlar[9]=findViewById(R.id.b9);
        butonlar[10]=findViewById(R.id.b10);
        butonlar[11]=findViewById(R.id.b11);
        butonlar[12]=findViewById(R.id.b12);
        butonlar[13]=findViewById(R.id.b13);
        butonlar[14]=findViewById(R.id.b14);
        butonlar[15]=findViewById(R.id.b15);

        butonlar[0].setOnClickListener(this);
        butonlar[1].setOnClickListener(this);
        butonlar[2].setOnClickListener(this);
        butonlar[3].setOnClickListener(this);
        butonlar[4].setOnClickListener(this);
        butonlar[5].setOnClickListener(this);
        butonlar[6].setOnClickListener(this);
        butonlar[7].setOnClickListener(this);
        butonlar[8].setOnClickListener(this);
        butonlar[9].setOnClickListener(this);
        butonlar[10].setOnClickListener(this);
        butonlar[11].setOnClickListener(this);
        butonlar[12].setOnClickListener(this);
        butonlar[13].setOnClickListener(this);
        butonlar[14].setOnClickListener(this);
        butonlar[15].setOnClickListener(this);
        sifirla.setOnClickListener(this);

        sifirla();
    }


    @Override
    public void onBackPressed() {
        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }
        super.onBackPressed();
    }


    @Override
    public void onClick(View view) {
        int viewId=view.getId();
        if (viewId==sifirla.getId()){
            sifirla();
        }
        else if(!hepsiDogrumu){
            if(viewId==butonlar[0].getId())
                goster(0);
            else if(viewId==butonlar[1].getId())
                goster(1);
            else if(viewId==butonlar[2].getId())
                goster(2);
            else if(viewId==butonlar[3].getId())
                goster(3);
            else if(viewId==butonlar[4].getId())
                goster(4);
            else if(viewId==butonlar[5].getId())
                goster(5);
            else if(viewId==butonlar[6].getId())
                goster(6);
            else if(viewId==butonlar[7].getId())
                goster(7);
            else if(viewId==butonlar[8].getId())
                goster(8);
            else if(viewId==butonlar[9].getId())
                goster(9);
            else if(viewId==butonlar[10].getId())
                goster(10);
            else if(viewId==butonlar[11].getId())
                goster(11);
            else if(viewId==butonlar[12].getId())
                goster(12);
            else if(viewId==butonlar[13].getId())
                goster(13);
            else if(viewId==butonlar[14].getId())
                goster(14);
            else if(viewId==butonlar[15].getId())
                goster(15);
        }
    }

    void sifirla(){
        dizi[0]=dizi[1]=0;
        dizi[2]=dizi[3]=1;
        dizi[4]=dizi[5]=2;
        dizi[6]=dizi[7]=3;
        dizi[8]=dizi[9]=4;
        dizi[10]=dizi[11]=5;
        dizi[12]=dizi[13]=6;
        dizi[14]=dizi[15]=7;
        liste.clear();
        for (int i=0;i<dizi.length;i++){
            liste.add(dizi[i]);
        }
        Collections.shuffle(liste);
        for(int i=0;i<16;i++){
            butonlar[i].setBackgroundColor(getResources().getColor(R.color.sari));
        }
        for(int i=0;i<16;i++){
            eslesenler[i]=false;
        }
        hepsiDogrumu=false;
        ilk=true;
        hamleSayisi=0;
        tv_hamleSayisi.setText("Hamle Sayısı : ");
        int enIyiSkor=preferences.getInt("HafizaOyunuEnIyiSkor",0);
        if (enIyiSkor!=0){
            tv_hamleSayisi.setText(tv_hamleSayisi.getText()+"\t En İyi Skor : "+enIyiSkor);
        }
    }
    void goster(int x){
        if (!ilk){
            if (butonlar[x].getId()==butonlar[onceki].getId()){
                return;
            }
            else if (liste.get(x).equals(liste.get(onceki))){
                eslesenler[x]=eslesenler[onceki]=true;
            }
        }
        for(int i=0;i<16;i++){
            if (!eslesenler[i]){
                butonlar[i].setBackgroundColor(getResources().getColor(R.color.sari));
            }
        }
        if(liste.get(x)==0)
            butonlar[x].setBackground(getResources().getDrawable(R.drawable.rabbit));
        if(liste.get(x)==1)
            butonlar[x].setBackground(getResources().getDrawable(R.drawable.squirrel));
        if(liste.get(x)==2)
            butonlar[x].setBackground(getResources().getDrawable(R.drawable.bird));
        if(liste.get(x)==3)
            butonlar[x].setBackground(getResources().getDrawable(R.drawable.dog));
        if(liste.get(x)==4)
            butonlar[x].setBackground(getResources().getDrawable(R.drawable.horse));
        if(liste.get(x)==5)
            butonlar[x].setBackground(getResources().getDrawable(R.drawable.fish));
        if(liste.get(x)==6)
            butonlar[x].setBackground(getResources().getDrawable(R.drawable.penguin));
        if(liste.get(x)==7)
            butonlar[x].setBackground(getResources().getDrawable(R.drawable.cat));

        for(int i=0;i<16;i++){
            if (eslesenler[i]==false){
                hepsiDogrumu=false;
                break;
            }
            hepsiDogrumu=true;
        }
        int enIyiSkor=preferences.getInt("HafizaOyunuEnIyiSkor",0);
        if (hepsiDogrumu){
            Toast.makeText(HafizaOyunu.this,"TEBRİKLER",Toast.LENGTH_SHORT).show();
            if (hamleSayisi<enIyiSkor){
                editor.putInt("HafizaOyunuEnIyiSkor",hamleSayisi);
                editor.commit();
            }
        }
        onceki=x;
        ilk=false;
        tv_hamleSayisi.setText("Hamle Sayısı: "+(++hamleSayisi));
        if (enIyiSkor!=0){
            tv_hamleSayisi.setText(tv_hamleSayisi.getText()+"\t En İyi Skor : "+enIyiSkor);
        }
    }
}
