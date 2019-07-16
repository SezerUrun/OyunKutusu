package com.oyunkutusu;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Minyon extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    ImageView pic1,pic2,pic3,pic4,pic5,
            pic6,pic7,pic8,pic9,pic10,
            pic11,pic12,pic13,pic14,pic15,
            pic16,pic17,pic18,pic19,pic20,
            pic21,pic22,pic23,pic24,pic25,
            onceki;
    TextView puanTextView;
    CountDownTimer timer;
    static int acilacak=0, puan=0;
    byte[] acilanlar=new byte[25];
    Button yeniOyun;
    LinearLayout layout;
    boolean tiklamaIzni=false;
    MediaPlayer player;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minyon);

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

        layout=findViewById(R.id.anaLayout);
        yeniOyun=findViewById(R.id.yeniOyun);
        pic1=findViewById(R.id.pic1);
        pic2=findViewById(R.id.pic2);
        pic3=findViewById(R.id.pic3);
        pic4=findViewById(R.id.pic4);
        pic5=findViewById(R.id.pic5);
        pic6=findViewById(R.id.pic6);
        pic7=findViewById(R.id.pic7);
        pic8=findViewById(R.id.pic8);
        pic9=findViewById(R.id.pic9);
        pic10=findViewById(R.id.pic10);
        pic11=findViewById(R.id.pic11);
        pic12=findViewById(R.id.pic12);
        pic13=findViewById(R.id.pic13);
        pic14=findViewById(R.id.pic14);
        pic15=findViewById(R.id.pic15);
        pic16=findViewById(R.id.pic16);
        pic17=findViewById(R.id.pic17);
        pic18=findViewById(R.id.pic18);
        pic19=findViewById(R.id.pic19);
        pic20=findViewById(R.id.pic20);
        pic21=findViewById(R.id.pic21);
        pic22=findViewById(R.id.pic22);
        pic23=findViewById(R.id.pic23);
        pic24=findViewById(R.id.pic24);
        pic25=findViewById(R.id.pic25);
        puanTextView=findViewById(R.id.puanTextView);

        layout.setOnClickListener(this);
        yeniOyun.setOnClickListener(this);
        pic1.setOnClickListener(this);
        pic2.setOnClickListener(this);
        pic3.setOnClickListener(this);
        pic4.setOnClickListener(this);
        pic5.setOnClickListener(this);
        pic6.setOnClickListener(this);
        pic7.setOnClickListener(this);
        pic8.setOnClickListener(this);
        pic9.setOnClickListener(this);
        pic10.setOnClickListener(this);
        pic11.setOnClickListener(this);
        pic12.setOnClickListener(this);
        pic13.setOnClickListener(this);
        pic14.setOnClickListener(this);
        pic15.setOnClickListener(this);
        pic16.setOnClickListener(this);
        pic17.setOnClickListener(this);
        pic18.setOnClickListener(this);
        pic19.setOnClickListener(this);
        pic20.setOnClickListener(this);
        pic21.setOnClickListener(this);
        pic22.setOnClickListener(this);
        pic23.setOnClickListener(this);
        pic24.setOnClickListener(this);
        pic25.setOnClickListener(this);

        player=MediaPlayer.create(this,R.raw.minion);

        preferences=getSharedPreferences("preferences",MODE_PRIVATE);
        editor=preferences.edit();
        editor.putInt("MinyonEnYuksekPuan", preferences.getInt("MinyonEnYuksekPuan",0));
        editor.commit();
        puanTextView.setText("Puan: 0 \nEn Yüksek Puan: "+preferences.getInt("MinyonEnYuksekPuan",0));

        timer=new CountDownTimer(1000,100) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                /* OYUNUN SONLU YAPMAK ICIN GEREKLI KODLAR
                do {
                    acilacak=(byte)(Math.random()*25);
                } while(acilanlar[acilacak]==1);
                */
                acilacak=(byte)(Math.random()*25);
                switch (acilacak){
                    case 0: openPic(pic1); acilanlar[0]=1; break;
                    case 1: openPic(pic2); acilanlar[1]=1; break;
                    case 2: openPic(pic3); acilanlar[2]=1; break;
                    case 3: openPic(pic4); acilanlar[3]=1; break;
                    case 4: openPic(pic5); acilanlar[4]=1; break;
                    case 5: openPic(pic6); acilanlar[5]=1; break;
                    case 6: openPic(pic7); acilanlar[6]=1; break;
                    case 7: openPic(pic8); acilanlar[7]=1; break;
                    case 8: openPic(pic9); acilanlar[8]=1; break;
                    case 9: openPic(pic10); acilanlar[9]=1; break;
                    case 10: openPic(pic11); acilanlar[10]=1; break;
                    case 11: openPic(pic12); acilanlar[11]=1; break;
                    case 12: openPic(pic13); acilanlar[12]=1; break;
                    case 13: openPic(pic14); acilanlar[13]=1; break;
                    case 14: openPic(pic15); acilanlar[14]=1; break;
                    case 15: openPic(pic16); acilanlar[15]=1; break;
                    case 16: openPic(pic17); acilanlar[16]=1; break;
                    case 17: openPic(pic18); acilanlar[17]=1; break;
                    case 18: openPic(pic19); acilanlar[18]=1; break;
                    case 19: openPic(pic20); acilanlar[19]=1; break;
                    case 20: openPic(pic21); acilanlar[20]=1; break;
                    case 21: openPic(pic22); acilanlar[21]=1; break;
                    case 22: openPic(pic23); acilanlar[22]=1; break;
                    case 23: openPic(pic24); acilanlar[23]=1; break;
                    case 24: openPic(pic25); acilanlar[24]=1; break;
                }
                timer.start();
            }
        }.start();
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
        if (viewId==onceki.getId()){
            puan++;
            puanTextView.setText("Puan: "+puan+"\nEn Yüksek Puan: "+preferences.getInt("MinyonEnYuksekPuan",0));
            view.setVisibility(View.INVISIBLE);
            timer.onFinish();
        }
        else if(viewId==yeniOyun.getId()){
            yeniOyun.setVisibility(View.INVISIBLE);
            tiklamaIzni=true;
            puan=0;
            puanTextView.setText("Puan: \nEn Yüksek Puan: "+preferences.getInt("MinyonEnYuksekPuan",0));
            timer.start();
        }
        else{
            tiklamaIzni=false;
            onceki.setVisibility(View.INVISIBLE);
            yeniOyun.setVisibility(View.VISIBLE);
            timer.cancel();
            Toast.makeText(Minyon.this,"Yandın!",Toast.LENGTH_SHORT).show();
            if (puan>preferences.getInt("MinyonEnYuksekPuan",0)) {
                editor.putInt("MinyonEnYuksekPuan", puan);
            }
            editor.commit();
        }
    }

    void openPic(ImageView img){
        /*if (player.isPlaying()){
            player.stop();
        }
        player.start();*/
        if (onceki!=null){
            onceki.setVisibility(View.INVISIBLE);
        }
        img.setVisibility(View.VISIBLE);
        onceki=img;
    }

    @Override
    protected void onPause() {
        if (player.isPlaying()){
            player.stop();
        }
        super.onPause();
    }

    @Override
    protected void onStop() {
        if (player.isPlaying()){
            player.stop();
        }
        super.onStop();
    }
}
