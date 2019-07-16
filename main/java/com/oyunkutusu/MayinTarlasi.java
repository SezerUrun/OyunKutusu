package com.oyunkutusu;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MayinTarlasi extends AppCompatActivity implements View.OnClickListener {
    TextView bilgi;
    byte[] dizi=new byte[100];
    int tekrarSayisi=3;
    byte skor=0, onceki=0,simdiki=0;
    boolean ilk_adim=true;
    Button  b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,
            b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,
            b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,
            b31,b32,b33,b34,b35,b36,b37,b38,b39,b40,
            b41,b42,b43,b44,b45,b46,b47,b48,b49,b50,
            b51,b52,b53,b54,b55,b56,b57,b58,b59,b60,
            b61,b62,b63,b64,b65,b66,b67,b68,b69,b70,
            b71,b72,b73,b74,b75,b76,b77,b78,b79,b80,
            b81,b82,b83,b84,b85,b86,b87,b88,b89,b90,
            b91,b92,b93,b94,b95,b96,b97,b98,b99,b100,
            sifirla,tekrar;
    Button[] button_dizi=new Button[]{
            b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,
            b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,
            b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,
            b31,b32,b33,b34,b35,b36,b37,b38,b39,b40,
            b41,b42,b43,b44,b45,b46,b47,b48,b49,b50,
            b51,b52,b53,b54,b55,b56,b57,b58,b59,b60,
            b61,b62,b63,b64,b65,b66,b67,b68,b69,b70,
            b71,b72,b73,b74,b75,b76,b77,b78,b79,b80,
            b81,b82,b83,b84,b85,b86,b87,b88,b89,b90,
            b91,b92,b93,b94,b95,b96,b97,b98,b99,b100};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mayin_tarlasi);

        sifirla=findViewById(R.id.sifirla);
        sifirla.setOnClickListener(this);
        tekrar=findViewById(R.id.tekrar);
        tekrar.setOnClickListener(this);
        bilgi=findViewById(R.id.bilgi);
        bilgi.setText("");
        button_dizi[0]=findViewById(R.id.b1);
        button_dizi[1]=findViewById(R.id.b2);
        button_dizi[2]=findViewById(R.id.b3);
        button_dizi[3]=findViewById(R.id.b4);
        button_dizi[4]=findViewById(R.id.b5);
        button_dizi[5]=findViewById(R.id.b6);
        button_dizi[6]=findViewById(R.id.b7);
        button_dizi[7]=findViewById(R.id.b8);
        button_dizi[8]=findViewById(R.id.b9);
        button_dizi[9]=findViewById(R.id.b10);
        button_dizi[10]=findViewById(R.id.b11);
        button_dizi[11]=findViewById(R.id.b12);
        button_dizi[12]=findViewById(R.id.b13);
        button_dizi[13]=findViewById(R.id.b14);
        button_dizi[14]=findViewById(R.id.b15);
        button_dizi[15]=findViewById(R.id.b16);
        button_dizi[16]=findViewById(R.id.b17);
        button_dizi[17]=findViewById(R.id.b18);
        button_dizi[18]=findViewById(R.id.b19);
        button_dizi[19]=findViewById(R.id.b20);
        button_dizi[20]=findViewById(R.id.b21);
        button_dizi[21]=findViewById(R.id.b22);
        button_dizi[22]=findViewById(R.id.b23);
        button_dizi[23]=findViewById(R.id.b24);
        button_dizi[24]=findViewById(R.id.b25);
        button_dizi[25]=findViewById(R.id.b26);
        button_dizi[26]=findViewById(R.id.b27);
        button_dizi[27]=findViewById(R.id.b28);
        button_dizi[28]=findViewById(R.id.b29);
        button_dizi[29]=findViewById(R.id.b30);
        button_dizi[30]=findViewById(R.id.b31);
        button_dizi[31]=findViewById(R.id.b32);
        button_dizi[32]=findViewById(R.id.b33);
        button_dizi[33]=findViewById(R.id.b34);
        button_dizi[34]=findViewById(R.id.b35);
        button_dizi[35]=findViewById(R.id.b36);
        button_dizi[36]=findViewById(R.id.b37);
        button_dizi[37]=findViewById(R.id.b38);
        button_dizi[38]=findViewById(R.id.b39);
        button_dizi[39]=findViewById(R.id.b40);
        button_dizi[40]=findViewById(R.id.b41);
        button_dizi[41]=findViewById(R.id.b42);
        button_dizi[42]=findViewById(R.id.b43);
        button_dizi[43]=findViewById(R.id.b44);
        button_dizi[44]=findViewById(R.id.b45);
        button_dizi[45]=findViewById(R.id.b46);
        button_dizi[46]=findViewById(R.id.b47);
        button_dizi[47]=findViewById(R.id.b48);
        button_dizi[48]=findViewById(R.id.b49);
        button_dizi[49]=findViewById(R.id.b50);
        button_dizi[50]=findViewById(R.id.b51);
        button_dizi[51]=findViewById(R.id.b52);
        button_dizi[52]=findViewById(R.id.b53);
        button_dizi[53]=findViewById(R.id.b54);
        button_dizi[54]=findViewById(R.id.b55);
        button_dizi[55]=findViewById(R.id.b56);
        button_dizi[56]=findViewById(R.id.b57);
        button_dizi[57]=findViewById(R.id.b58);
        button_dizi[58]=findViewById(R.id.b59);
        button_dizi[59]=findViewById(R.id.b60);
        button_dizi[60]=findViewById(R.id.b61);
        button_dizi[61]=findViewById(R.id.b62);
        button_dizi[62]=findViewById(R.id.b63);
        button_dizi[63]=findViewById(R.id.b64);
        button_dizi[64]=findViewById(R.id.b65);
        button_dizi[65]=findViewById(R.id.b66);
        button_dizi[66]=findViewById(R.id.b67);
        button_dizi[67]=findViewById(R.id.b68);
        button_dizi[68]=findViewById(R.id.b69);
        button_dizi[69]=findViewById(R.id.b70);
        button_dizi[70]=findViewById(R.id.b71);
        button_dizi[71]=findViewById(R.id.b72);
        button_dizi[72]=findViewById(R.id.b73);
        button_dizi[73]=findViewById(R.id.b74);
        button_dizi[74]=findViewById(R.id.b75);
        button_dizi[75]=findViewById(R.id.b76);
        button_dizi[76]=findViewById(R.id.b77);
        button_dizi[77]=findViewById(R.id.b78);
        button_dizi[78]=findViewById(R.id.b79);
        button_dizi[79]=findViewById(R.id.b80);
        button_dizi[80]=findViewById(R.id.b81);
        button_dizi[81]=findViewById(R.id.b82);
        button_dizi[82]=findViewById(R.id.b83);
        button_dizi[83]=findViewById(R.id.b84);
        button_dizi[84]=findViewById(R.id.b85);
        button_dizi[85]=findViewById(R.id.b86);
        button_dizi[86]=findViewById(R.id.b87);
        button_dizi[87]=findViewById(R.id.b88);
        button_dizi[88]=findViewById(R.id.b89);
        button_dizi[89]=findViewById(R.id.b90);
        button_dizi[90]=findViewById(R.id.b91);
        button_dizi[91]=findViewById(R.id.b92);
        button_dizi[92]=findViewById(R.id.b93);
        button_dizi[93]=findViewById(R.id.b94);
        button_dizi[94]=findViewById(R.id.b95);
        button_dizi[95]=findViewById(R.id.b96);
        button_dizi[96]=findViewById(R.id.b97);
        button_dizi[97]=findViewById(R.id.b98);
        button_dizi[98]=findViewById(R.id.b99);
        button_dizi[99]=findViewById(R.id.b100);

        for(byte b=0;b<button_dizi.length;b++){
            button_dizi[b].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        int[] tiklananlar=new int[100];
        if (view.getId()==sifirla.getId()){
            sifirla();
        }
        else if(view.getId()==tekrar.getId()){
            if (tekrarSayisi<=0){
                tekrar.setEnabled(false);
            }
            for(byte b=0;b<button_dizi.length;b++){
                button_dizi[b].setBackgroundColor(getResources().getColor(R.color.gri));
                tekrarSayisi--;
            }
            for(byte x=0;x<100;x++){
                button_dizi[x].setEnabled(true);
            }
            ilk_adim=true;
            button_dizi[simdiki].setText("");
            button_dizi[onceki].setText("");
            bilgi.setText("");
        }
        else {
            for(byte b=0;b<10;b++){
                for(byte b2=0;b2<10;b2++){
                    if (view.getId()==button_dizi[b*10+b2].getId()) {
                        simdiki = (byte)(b * 10 + b2);
                        break;
                    }
                }
            }
            if (ilk_adim || simdiki==onceki+1 || simdiki==onceki-1 || simdiki==onceki-10 || simdiki==onceki+10) {
                ilk_adim=false;
                skor++;
                button_dizi[simdiki].setText("O");
                button_dizi[onceki].setText("");
                onceki=simdiki;
                view.setBackgroundColor(getResources().getColor(R.color.yesil));
                for (byte b = 0; b < button_dizi.length; b++) {
                    if (view.getId() == button_dizi[b].getId() && dizi[b] == 2) {
                        for (byte by = 0; by < dizi.length; by++) {
                            if (dizi[by] == 2) {
                                button_dizi[by].setBackgroundResource(R.drawable.mine);
                            }
                            else{
                                button_dizi[by].setBackgroundColor(getResources().getColor(R.color.kirmizi));
                            }
                        }
                        Toast.makeText(MayinTarlasi.this,"Skor : "+skor,Toast.LENGTH_SHORT).show();
                        skor=0;
                        bilgi.setText("PATLADIN !");
                        for(byte x=0;x<100;x++){
                            button_dizi[x].setEnabled(false);
                        }
                        break;
                    }
                }
                if(simdiki<10){
                    Toast.makeText(MayinTarlasi.this,"Tebrikler, hefede ulaştın.",Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(this,"Yoldan Çıkma",Toast.LENGTH_SHORT).show();
            }
        }
    }

    void sifirla(){
        tekrarSayisi=3;
        sifirla.setText("Sıfırla");
        tekrar.setVisibility(View.VISIBLE);
        bilgi.setText("");
        button_dizi[simdiki].setText("");
        button_dizi[onceki].setText("");
        tekrar.setText("Tekrarla");
        tekrar.setEnabled(true);
        ilk_adim=true;

        for(byte b=0;b<dizi.length;b++) {//butonlara rastgele 0-1-2 degeri verme(mayinlari yerlestirme)
            dizi[b] = (byte) (Math.random() * 3);
        }
        for(byte b=0;b<dizi.length; b++) {
            button_dizi[b].setEnabled(true);
            if(dizi[b]==2){
                button_dizi[b].setBackground(getResources().getDrawable(R.drawable.mine));
            }
        }
        CountDownTimer timer=new CountDownTimer(3000,1) {
            @Override
            public void onTick(long l) {

            }
            @Override
            public void onFinish() {
                for(byte b=0;b<dizi.length; b++) {
                    button_dizi[b].setBackgroundColor(getResources().getColor(R.color.gri));
                }
            }
        }.start();


    }
}