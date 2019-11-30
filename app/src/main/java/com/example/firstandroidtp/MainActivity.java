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

public class MainActivity extends AppCompatActivity {

    private Button contactButton;

    private Button validerButton;
    private EditText nom;
    private EditText numero;
    private TextView textView;
    private contactBDD ContactBDD;
    private Chronometer chrono;
    private  boolean running;
    private  long pauseOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_chrono);
        chrono=(Chronometer) findViewById(R.id.chronometer);
    }
    public void startChronometer(View v){
        if(!running){
            chrono.setBase(SystemClock.elapsedRealtime()-pauseOffset);
            chrono.start();
            running=true;
        }
    }
    public void pauseChronometer(View v){
        if(running){
            chrono.stop();
            pauseOffset=SystemClock.elapsedRealtime()-chrono.getBase();
            running=false;
        }
    }
    public void resetChronometer(View v){
        chrono.setBase(SystemClock.elapsedRealtime());
        pauseOffset=0;
    }

}

