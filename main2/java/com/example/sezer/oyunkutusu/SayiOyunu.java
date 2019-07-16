package com.example.sezer.oyunkutusu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SayiOyunu extends AppCompatActivity implements View.OnClickListener {
    Button up;
    Button down;
    Button try_;
    EditText input;
    TextView header;
    byte try_counter;
    byte sayi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayi_oyunu);

        up=findViewById(R.id.up);
        down=findViewById(R.id.down);
        try_=findViewById(R.id.try_);
        input=findViewById(R.id.input);
        header=findViewById(R.id.header);
        up.setOnClickListener(this);
        down.setOnClickListener(this);
        try_.setOnClickListener(this);
        sayi=(byte)(Math.random()*100);
        try_counter=0;
    }

    @Override
    public void onClick(View view) {
        byte b=Byte.parseByte(input.getText().toString());
        if (view.getId()==up.getId()){
            b++;
            input.setText(Byte.toString(b));
        }
        else if(view.getId()==down.getId()){
            b--;
            input.setText(Byte.toString(b));
        }
        else{
            if (b<sayi){
                try_counter++;
                header.setText("Yukarı...");
            }
            else if(b>sayi){
                try_counter++;
                header.setText("Aşağı...");
            }
            else{
                header.setText("Tebrikler "+try_counter+" Denemede Bildin...");
            }
        }

    }
}
