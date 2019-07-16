package com.oyunkutusu;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class UcanKus extends AppCompatActivity{
    CountDownTimer timer;
    LinearLayout layout;
    RelativeLayout relativeLayout;
    int sure=10000;
    ImageView bird, ilk, boru;
    boolean boruEklendiMi=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucan_kus);
        ilk=findViewById(R.id.ilk);
        bird=findViewById(R.id.bird);
        layout=findViewById(R.id.layout);
        relativeLayout=findViewById(R.id.relativeLayout);
        final HorizontalScrollView scrollView= (HorizontalScrollView)findViewById(R.id.scrollView);
        scrollView.setOnTouchListener(new OnTouch());
        timer=new CountDownTimer(10000,10) {
            @Override
            public void onTick(long l) {
                scrollView.scrollTo(scrollView.getScrollX()+10,scrollView.getScrollY());
                bird.setY(bird.getY()+3);
                if (boruEklendiMi){
                    boru.setX(boru.getX()-10);
                }
                if (bird.getY()>=layout.getHeight()-270){
                    timer.cancel();
                }
                //Çarpışma kontrolü
                /*if(boruEklendiMi && bird.getX()>=boru.getX() && bird.getX()<boru.getX()+100 && bird.getY()>=boru.getHeight()/2-100 && bird.getY()<=boru.getHeight()/2+100){
                    //  && bird.getY()>boru.getY()+250 && bird.getY()<boru.getY()-350
                    timer.cancel();
                }*/
            }
            @Override
            public void onFinish() {
                timer.start();
                addBackground();
            }
        }.start();
    }

    private class OnTouch implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            bird.setY(bird.getY()-50);
            return true;
        }
    }
    void addBackground(){
        ImageView iv= new ImageView(this);
        iv.setBackground(getResources().getDrawable(R.drawable.arkaplan));
        iv.setLayoutParams(ilk.getLayoutParams());
        layout.addView(iv);

        boru =new ImageView(UcanKus.this);
        boru.setBackground(getResources().getDrawable(R.drawable.boru));
        boru.setLayoutParams(iv.getLayoutParams());
        layout.addView(boru);
        boruEklendiMi=true;
    }
}

