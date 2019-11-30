package com.example.firstandroidtp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    ImageView logoHome = null;
    TextView textHome = null;
    Button commencer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        commencer = (Button) findViewById(R.id.buttonBegin);
        logoHome = (ImageView) findViewById(R.id.logoHome);
        ObjectAnimator animation = ObjectAnimator.ofFloat(logoHome, "translationY", -60f);
        animation.setDuration(700);
        animation.start();

        ObjectAnimator anima = ObjectAnimator.ofInt(logoHome, "rotate", -60);
        anima.setDuration(700);
        anima.start();


    }

    public void gotoMenu(View view){
        Intent intent = new Intent(getApplicationContext(), Menu.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions
                    .makeSceneTransitionAnimation(this);
            startActivity(intent, options.toBundle());

        }


    }
}
