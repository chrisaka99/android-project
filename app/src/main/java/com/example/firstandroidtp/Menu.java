package com.example.firstandroidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Fade());
        }


    }

    public  void gotoCalculatrice(View v){
        Intent intent = new Intent(getApplicationContext(),Calculatrice.class);
        startActivity(intent);
    }
    public  void gotoApropos(View v){
        Intent intent = new Intent(getApplicationContext(),Apropos.class);
        startActivity(intent);
    }
    public  void gotoChrono(View v){
        Intent intent = new Intent(getApplicationContext(),Chrono.class);
        startActivity(intent);
    }
    public  void gotoContact(View v){
        Intent intent = new Intent(getApplicationContext(),ContactActivity.class);
        startActivity(intent);
    }
}
