package com.oyunkutusu;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class ArabaYarisi extends AppCompatActivity {
    ImageView araba, yol;
    CountDownTimer timer;
    FrameLayout frameLayout;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_araba_yarisi);

        frameLayout=findViewById(R.id.frameLayout);
        layout=findViewById(R.id.layout);
        yol=findViewById(R.id.ilk);
        yol.setY(-yol.getHeight());
        araba=findViewById(R.id.araba);
        final ScrollView scrollView= findViewById(R.id.scrollView);

        timer=new CountDownTimer(1000,10) {
            @Override
            public void onTick(long l) {
                if (yol.getY()>=0){
                    addBackground();
                }
                scrollView.scrollTo(scrollView.getScrollX(),scrollView.getScrollY()-10);
            }
            @Override
            public void onFinish() {
                timer.start();
                addBackground();
            }
        }.start();
    }

    void addBackground(){
        ImageView iv= new ImageView(this);
        iv.setBackground(getResources().getDrawable(R.drawable.arkaplan));
        iv.setLayoutParams(yol.getLayoutParams());
        iv.setY(-iv.getHeight());
        yol=iv;
        layout.addView(yol);
    }
}
