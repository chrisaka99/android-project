package com.example.firstandroidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

public class Chrono extends AppCompatActivity {
    private Chronometer chrono;
    private  boolean running;
    private  long pauseOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrono);
        chrono=(Chronometer) findViewById(R.id.chrono);
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