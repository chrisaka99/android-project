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
    private String and = null;

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
        calcul();
    }

    public void cleanAll(View v){
        ecranCalcul.getText().clear();
        ecranResultat.getText().clear();
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

    public void ans(View v){
        ecranCalcul.getText().append(and);
        calcul();
    }


}
