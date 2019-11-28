package com.example.firstandroidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ecranResultat = null;
    private EditText ecranCalcul = null;
    private Button un = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        un = (Button) findViewById(R.id.un);
        ecranResultat = (EditText) findViewById(R.id.ecranResultat);
        ecranCalcul = (EditText) findViewById(R.id.ecranCalcul);



    }

    public void saisirCalcul(View v){
        ecranCalcul.getText().append(((Button) v).getText());
    }

    public void cleanAll(View v){
        ecranCalcul.getText().clear();
        ecranResultat.getText().clear();
    }

    public  void del(View v) {
        int t = ecranCalcul.getText().length();
        if ( t > 0) {
            ecranCalcul.getText().delete(t-1, t);
        }
    }


}
