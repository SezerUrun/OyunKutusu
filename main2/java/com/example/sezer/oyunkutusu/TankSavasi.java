package com.oyunkutusu;

import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class TankSavasi extends AppCompatActivity implements View.OnClickListener, SensorEventListener {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    ImageView dusman,oyuncu;
    TextView puanTextView;
    CountDownTimer timer, timer2;
    LinearLayout anaLayout,altLayout;
    RelativeLayout ustLayout;
    Button yeniOyun,ates;
    boolean atesIzni=false, hareketIzni=false;
    private SensorManager sensorManager;
    private float last_x=0, last_y=0, last_z = 0;
    int hiz=3,vurulan=0, puan=0;
    MediaPlayer player;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tank_savasi);

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
            }
        });
        Toast.makeText(TankSavasi.this,"Tankınız sensörler ile hareket eder.",Toast.LENGTH_SHORT).show();
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);
        dusman=findViewById(R.id.dusman);
        anaLayout=findViewById(R.id.anaLayout);
        oyuncu=findViewById(R.id.arac);
        ustLayout=findViewById(R.id.ustLayout);
        altLayout=findViewById(R.id.altLayout);
        yeniOyun=findViewById(R.id.yeniOyun);
        yeniOyun.setOnClickListener(this);
        ates=findViewById(R.id.ates);
        ates.setOnClickListener(this);
        puanTextView=findViewById(R.id.puanTextView);
        preferences=getSharedPreferences("preferences",MODE_PRIVATE);
        editor=preferences.edit();
        editor.putInt("TankSavasiEnYuksekPuan", preferences.getInt("TankSavasiEnYuksekPuan",0));
        editor.commit();
        puanTextView.setText("Puan: 0 \nEn Yüksek Puan: "+preferences.getInt("TankSavasiEnYuksekPuan",0));
        //newTank();
    }

    @Override
    public void onClick(View view) {
        //ates etme
        if (view.getId()==ates.getId()){
            int ses=(int)(Math.random()*3);
            switch (ses){
                case 0: (player=MediaPlayer.create(this,R.raw.sound)).start(); break;
                case 1: (player=MediaPlayer.create(this,R.raw.sound2)).start(); break;
                case 2: (player=MediaPlayer.create(this,R.raw.sound3)).start(); break;
            }
            //player.start();
            ates(new ImageView(this));
        }
        //yeni oyun baslatma
        if (view.getId()==yeniOyun.getId()){
            Toast.makeText(TankSavasi.this,"Düşmanları vurdukça oyun hızlanır.",Toast.LENGTH_SHORT).show();
            yeniOyun.setVisibility(View.INVISIBLE);
            ates.setVisibility(View.VISIBLE);
            dusman.setVisibility(View.VISIBLE);
            atesIzni=true;
            hiz=3;
            puan=0;
            puanTextView.setText("Puan: 0 \nEn Yüksek Puan: "+preferences.getInt("TankSavasiEnYuksekPuan",0));
            newDusman();
        }

    }
    @Override
    protected void onStop() {
        if (timer!=null) {
            timer.cancel();
        }
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        if (timer!=null) {
            timer.cancel();
        }
        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        sensorManager.unregisterListener(this);
        super.onDestroy();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float[] values = sensorEvent.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];
            if (x > 0) {
                kaydir("left");
            }
            if (x < 0) {
                kaydir("right");
            }
            last_x = x;
            last_y = y;
            last_z = z;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    void newDusman(){//Yeni dusman olusturma
        atesIzni=true;
        hareketIzni=true;
        int yer=(int)(Math.random()*(ustLayout.getWidth()-100));
        dusman.setBackground(getResources().getDrawable(R.drawable.tank));
        dusman.setX(yer+50);
        dusman.setY(ustLayout.getY());
        //dusmani asagi kaydirma
        timer=new CountDownTimer(100000,1) {
            @Override
            public void onTick(long l) {
                dusman.setY(dusman.getY()+hiz);
                //dusmanin sınırı gecip gecmedigine bakma
                if (dusman.getY()+50>=altLayout.getY()){
                    Toast.makeText(TankSavasi.this,"Oyun Bitti",Toast.LENGTH_SHORT).show();
                    yeniOyun.setVisibility(View.VISIBLE);
                    yeniOyun.setText("Yeni Oyun");
                    atesIzni=false;
                    hareketIzni=false;
                    ates.setVisibility(View.INVISIBLE);
                    //timer.onFinish();
                    timer.cancel();
                    timer2.cancel();
                    if (puan>preferences.getInt("TankSavasiEnYuksekPuan",0)){
                        editor.putInt("TankSavasiEnYuksekPuan",puan);
                        editor.commit();
                    }
                }
            }
            @Override
            public void onFinish() {
            }
        }.start();
    }
    void ates(final ImageView yeni){
        timer2=new CountDownTimer(1000,10) {
            @Override
            public void onTick(long l) {

            }
            @Override
            public void onFinish() {
                atesIzni=true;
                ates.setVisibility(View.VISIBLE);
            }
        }.start();
        if (atesIzni){
            //yeni.setLayoutParams(arac.getLayoutParams());
            yeni.setMaxHeight(20);
            yeni.setMaxWidth(10);
            yeni.setX(oyuncu.getX()+30);
            yeni.setY(altLayout.getY());
            yeni.setBackground(getResources().getDrawable(R.drawable.ammo));
            ustLayout.addView(yeni);
            new CountDownTimer(10000,10) {
                @Override
                public void onTick(long l) {
                    //merminin yukari kaydirilmasi
                    yeni.setY(yeni.getY()-50);
                    //dusmanin vurulmasi
                    if (yeni.getX()>=dusman.getX()-50 && yeni.getX()<dusman.getX()+100 && yeni.getY()<=dusman.getY()+50){
                        //patlama efekti (timer kullanarak uzatmayı dene)
                        yeni.setBackground(getResources().getDrawable(R.drawable.patlama));

                        yeni.setY(ustLayout.getHeight());
                        yeni.setX(ustLayout.getWidth());
                        ustLayout.removeView(yeni);
                        timer.cancel();
                        newDusman();
                        vurulan++;
                        puanTextView.setText("Puan: "+(++puan)+"\nEn Yüksek Puan: "+preferences.getInt("TankSavasiEnYuksekPuan",0));
                        if (vurulan==5){
                            if(hiz<10){
                                hiz++;
                            }
                            vurulan=0;
                        }
                    }
                    if (yeni.getY()<0){
                        yeni.setY(ustLayout.getHeight());
                        yeni.setX(ustLayout.getWidth());
                        ustLayout.removeView(yeni);
                    }
                }
                @Override
                public void onFinish() {

                }
            }.start();
            atesIzni=false;
            ates.setVisibility(View.INVISIBLE);
        }
    }

    //Araci kaydirma fonksiyonu
    void kaydir(String yon){
        if (hareketIzni){
            if (yon=="left" && oyuncu.getX()>=0) {
                oyuncu.setX(oyuncu.getX()-hiz);
            }
            if (yon=="right" && oyuncu.getX()<altLayout.getWidth()-oyuncu.getWidth()) {
                oyuncu.setX(oyuncu.getX()+hiz);
            }
        }
    }
}
