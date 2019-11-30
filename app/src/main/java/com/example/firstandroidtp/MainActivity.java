package com.example.firstandroidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button chronoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronoButton = (Button) findViewById(R.id.chronoButton);
        chronoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* on lance la nouvelle activite */
                Intent chronoActivity = new Intent(getApplicationContext(), chronoActivity.class);
                startActivity(chronoActivity);
            }
        });
    }
}
