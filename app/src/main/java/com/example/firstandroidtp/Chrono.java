package com.example.firstandroidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.transition.Explode;
import android.view.View;
import android.widget.Chronometer;


public class Chrono extends AppCompatActivity {
    private Chronometer chrono;
    private  boolean running;
    private  long pauseOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrono);
        chrono=(Chronometer) findViewById(R.id.chrono);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Explode());
        }
    }
    //lancer le chrono
    public void startChronometer(View v){
        if(!running){
            chrono.setBase(SystemClock.elapsedRealtime()-pauseOffset);
            chrono.start();
            running=true;
        }
    }
    //stopper le chrono
    public void pauseChronometer(View v){
        if(running){
            chrono.stop();
            pauseOffset=SystemClock.elapsedRealtime()-chrono.getBase();
            running=false;
        }
    }
    //reinitialiser le chrono
    public void resetChronometer(View v){
        chrono.setBase(SystemClock.elapsedRealtime());
        pauseOffset=0;
    }

}