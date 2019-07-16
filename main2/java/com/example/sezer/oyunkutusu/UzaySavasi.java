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
import java.util.Random;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class UzaySavasi extends AppCompatActivity implements View.OnClickListener, SensorEventListener {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    ImageView asteroid, arac;
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
        setContentView(R.layout.activity_uzay_savasi);

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

        player=MediaPlayer.create(this,R.raw.spaceship_sound);
        Toast.makeText(UzaySavasi.this,"Aracınız sensörler ile hareket eder.",Toast.LENGTH_SHORT).show();
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);
        asteroid=findViewById(R.id.asteroid);
        anaLayout=findViewById(R.id.anaLayout);
        arac=findViewById(R.id.arac);
        ustLayout=findViewById(R.id.ustLayout);
        altLayout=findViewById(R.id.altLayout);
        yeniOyun=findViewById(R.id.yeniOyun);
        yeniOyun.setOnClickListener(this);
        ates=findViewById(R.id.ates);
        ates.setOnClickListener(this);
        puanTextView=findViewById(R.id.puanTextView);
        preferences=getSharedPreferences("preferences",MODE_PRIVATE);
        editor=preferences.edit();
        editor.putInt("UzaySavasiEnYuksekPuan", preferences.getInt("UzaySavasiEnYuksekPuan",0));
        editor.commit();
        puanTextView.setText("Puan: 0 \nEn Yüksek Puan: "+preferences.getInt("UzaySavasiEnYuksekPuan",0));
        //newAsteroid();
    }


    @Override
    public void onClick(View view) {
        //ates etme
        if (view.getId()==ates.getId()){
            player.start();
            ates(new  ImageView(this));
        }
        //yeni oyun baslatma
        if (view.getId()==yeniOyun.getId()){
            Toast.makeText(UzaySavasi.this,"Yaklasan cisimleri vurdukca oyun hızlanır.",Toast.LENGTH_SHORT).show();
            yeniOyun.setText("Yeni Oyun");
            yeniOyun.setVisibility(View.INVISIBLE);
            ates.setVisibility(View.VISIBLE);
            asteroid.setVisibility(View.VISIBLE);
            atesIzni=true;
            hiz=3;
            puan=0;
            puanTextView.setText("Puan: 0 \nEn Yüksek Puan: "+preferences.getInt("UzaySavasiEnYuksekPuan",0));
            newAsteroid();
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

    void newAsteroid(){//Yeni asteroid olusturma
        hareketIzni=true;
        int yer=(int)(Math.random()*(ustLayout.getWidth()-100));
        int ast=(int)(Math.random()*3);
        switch (ast){
            case 0:asteroid.setBackground(getResources().getDrawable(R.drawable.asteroid)); break;
            case 1:asteroid.setBackground(getResources().getDrawable(R.drawable.asteroid2)); break;
            case 2:asteroid.setBackground(getResources().getDrawable(R.drawable.asteroid3)); break;
        }
        asteroid.setX(yer+50);
        asteroid.setY(ustLayout.getY());
        //asteroidi asagi kaydirma
        timer=new CountDownTimer(100000,1) {
            @Override
            public void onTick(long l) {
                asteroid.setY(asteroid.getY()+hiz);
                //nesnenin sınırı gecip gecmedigine bakma
                if (asteroid.getY()+50>=altLayout.getY()){
                    Toast.makeText(UzaySavasi.this,"Oyun Bitti",Toast.LENGTH_SHORT).show();
                    yeniOyun.setVisibility(View.VISIBLE);
                    atesIzni=false;
                    hareketIzni=false;
                    ates.setVisibility(View.INVISIBLE);
                    //timer.onFinish();
                    timer.cancel();
                    if (puan>preferences.getInt("UzaySavasiEnYuksekPuan",0)){
                        editor.putInt("UzaySavasiEnYuksekPuan",puan);
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
        //yeni.setLayoutParams(arac.getLayoutParams());
        yeni.setMaxHeight(20);
        yeni.setMaxWidth(10);
        yeni.setX(arac.getX()+30);
        yeni.setY(altLayout.getY());
        yeni.setBackground(getResources().getDrawable(R.drawable.ammo));
        ustLayout.addView(yeni);
        new CountDownTimer(10000,10) {
            @Override
            public void onTick(long l) {
                //merminin yukari kaydirilmasi
                yeni.setY(yeni.getY()-50);
                //dusmanin vurulmasi
                if (yeni.getX()>=asteroid.getX()-50 && yeni.getX()<asteroid.getX()+100 && yeni.getY()<=asteroid.getY()+50){
                    //patlama efekti (timer kullanarak uzatmayı dene)
                    yeni.setBackground(getResources().getDrawable(R.drawable.patlama));
                    yeni.setY(ustLayout.getHeight());
                    yeni.setX(ustLayout.getWidth());
                    ustLayout.removeView(yeni);
                    timer.cancel();
                    newAsteroid();
                    vurulan++;
                    puanTextView.setText("Puan: "+(++puan)+"\nEn Yüksek Puan: "+preferences.getInt("UzaySavasiEnYuksekPuan",0));
                        if (vurulan==5){
                            hiz++;
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
    }

    //Araci kaydirma fonksiyonu
    void kaydir(String yon){
        if (hareketIzni){
            if (yon=="left" && arac.getX()>=0) {
                arac.setX(arac.getX()-hiz);
            }
            if (yon=="right" && arac.getX()<altLayout.getWidth()-arac.getWidth()) {
                arac.setX(arac.getX()+hiz);
            }
        }
    }
}
