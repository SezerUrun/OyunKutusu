package com.oyunkutusu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button hafizaOyunu,tasKagitMakas,mayinTarlasi,arabaYarisi,minyon,savasOyunu,ucanKus,uzaySavasi;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-2616577523967769~3539595465");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        hafizaOyunu=findViewById(R.id.hafizaOyunu);
        hafizaOyunu.setOnClickListener(this);
        tasKagitMakas=findViewById(R.id.tasKagitMakas);
        tasKagitMakas.setOnClickListener(this);
        mayinTarlasi=findViewById(R.id.mayinTarlasi);
	    mayinTarlasi.setOnClickListener(this);
        arabaYarisi=findViewById(R.id.arabaYarisi);
        arabaYarisi.setOnClickListener(this);
        ucanKus=findViewById(R.id.ucanKus);
        ucanKus.setOnClickListener(this);
        savasOyunu=findViewById(R.id.savasOyunu);
        savasOyunu.setOnClickListener(this);
        minyon=findViewById(R.id.minyon);
        minyon.setOnClickListener(this);
        uzaySavasi=findViewById(R.id.uzaySavasi);
        uzaySavasi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewID=view.getId();
        if (viewID==hafizaOyunu.getId()){
            Intent i= new Intent(MainActivity.this,HafizaOyunu.class);
            startActivity(i);
        }
        else if (viewID==tasKagitMakas.getId()){
            Intent i= new Intent(MainActivity.this,TasKagitMakas.class);
            startActivity(i);
        }
        else if(viewID==mayinTarlasi.getId()){
            Intent i=new Intent(MainActivity.this,MayinTarlasi.class);
            startActivity(i);
        }
        else if(viewID==arabaYarisi.getId()) {
            Intent i = new Intent(MainActivity.this, ArabaYarisi.class);
            startActivity(i);
        }
        else if(viewID==ucanKus.getId()) {
            Intent i = new Intent(MainActivity.this, UcanKus.class);
            startActivity(i);
        }
        else if(viewID==savasOyunu.getId()) {
            Intent i = new Intent(MainActivity.this, TankSavasi.class);
            startActivity(i);
        }
        else if(viewID==minyon.getId()){
            Intent i = new Intent(MainActivity.this, Minyon.class);
            startActivity(i);
        }
        else if(viewID==uzaySavasi.getId()){
	        Intent i=new Intent(MainActivity.this, UzaySavasi.class);
	        startActivity(i);
        }
    }
}
