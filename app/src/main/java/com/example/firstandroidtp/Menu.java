package com.example.firstandroidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;

import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //definir l'animation d'entre
            getWindow().setEnterTransition(new Fade());
        }


    }

    //aller à la calculatrice
    public  void gotoCalculatrice(View v){
        Intent intent = new Intent(getApplicationContext(),Calculatrice.class);
        startActivity(intent);
    }

    //se deplacer vers a propos
    public  void gotoApropos(View v){
        Intent intent = new Intent(getApplicationContext(),Apropos.class);
        startActivity(intent);
    }

    //se deplacer vers a propos
    public  void gotoChrono(View v){
        Intent intent = new Intent(getApplicationContext(),Chrono.class);
        startActivity(intent);
    }

    //se deplacer vers la liste de contact
    public  void gotoContact(View v){
        Intent intent = new Intent(getApplicationContext(),ContactList.class);
        startActivity(intent);
    }

}
