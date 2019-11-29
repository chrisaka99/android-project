package com.example.firstandroidtp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculatrice extends AppCompatActivity {

    private TextView ecranResultat = null;
    private EditText ecranCalcul = null;
    private String and = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);


        ecranResultat = (TextView) findViewById(R.id.ecranResultat);
        ecranCalcul = (EditText) findViewById(R.id.ecranCalcul);



    }

    public void saisirCalcul(View v){
        ecranCalcul.getText().append(((Button) v).getText());
        calcul();
    }

    public void cleanAll(View v){
        ecranCalcul.getText().clear();
        ecranResultat.setText("");
    }

    public  void del(View v) {
        int t = ecranCalcul.getText().length();
        if ( t > 0) {
            ecranCalcul.getText().delete(t-1, t);
            calcul();
        }
    }

    public void calcul() {
        try {
            Compile calculateur = new Compile();
            ecranResultat.setText("" + calculateur.analyseur(ecranCalcul.getText().toString()));
            and = (calculateur.analyseur(ecranCalcul.getText().toString())!=null) ? "" + calculateur.analyseur(ecranCalcul.getText().toString()) : (and==null)? "":and;
        } catch (Exception ex) {
            ecranResultat.setText("");
        }
    }

    public void themeDark(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    public void ans(View v){
        ecranCalcul.getText().append(and);
        calcul();
    }


}
