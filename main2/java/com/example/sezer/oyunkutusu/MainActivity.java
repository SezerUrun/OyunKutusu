package com.example.sezer.oyunkutusu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button sayiOyunu,hafizaOyunu,zarAtma,tasKagitMakas,mayinTarlasi,tikSayici,farkliOlaniBul,golgeOyunu,ucanKus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sayiOyunu=findViewById(R.id.sayiOyunu);
        sayiOyunu.setOnClickListener(this);
        hafizaOyunu=findViewById(R.id.hafizaOyunu);
        hafizaOyunu.setOnClickListener(this);
        zarAtma=findViewById(R.id.zarAtma);
        zarAtma.setOnClickListener(this);
        tasKagitMakas=findViewById(R.id.tasKagitMakas);
        tasKagitMakas.setOnClickListener(this);
        mayinTarlasi=findViewById(R.id.mayinTarlasi);
	    mayinTarlasi.setOnClickListener(this);
        tikSayici=findViewById(R.id.tikSayici);
        tikSayici.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
	    if (view.getId()==sayiOyunu.getId()){
            Intent i= new Intent(MainActivity.this,SayiOyunu.class);
            startActivity(i);
        }
        else if (view.getId()==hafizaOyunu.getId()){
            Intent i= new Intent(MainActivity.this,HafizaOyunu.class);
            startActivity(i);
        }
        else if (view.getId()==zarAtma.getId()){
            Intent i= new Intent(MainActivity.this,ZarAtma.class);
            startActivity(i);
        }
        else if (view.getId()==tasKagitMakas.getId()){
            Intent i= new Intent(MainActivity.this,TasKagitMakas.class);
            startActivity(i);
        }
        else if(view.getId()==mayinTarlasi.getId()){
            Intent i=new Intent(MainActivity.this,MayinTarlasi.class);
            startActivity(i);
        }
        else if(view.getId()==tikSayici.getId()) {
            Intent i = new Intent(MainActivity.this, TikSayici.class);
            startActivity(i);
        }
    }
}
