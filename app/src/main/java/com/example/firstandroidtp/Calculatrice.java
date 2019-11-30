package com.example.firstandroidtp;

import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Explode());
        }


        //recuperer les deux ecrans
        ecranResultat = (TextView) findViewById(R.id.ecranResultat);
        ecranCalcul = (EditText) findViewById(R.id.ecranCalcul);



    }

    //entrer un caractere dans la zone de saisie
    public void saisirCalcul(View v){
        ecranCalcul.getText().append(((Button) v).getText());
        calcul();
    }

    //tout supprimer
    public void cleanAll(View v){
        ecranCalcul.getText().clear();
        ecranResultat.setText("");
    }

    //supprimer un caractere
    public  void del(View v) {
        int t = ecranCalcul.getText().length();
        if ( t > 0) {
            ecranCalcul.getText().delete(t-1, t);
            calcul();
        }
    }

    //fonction de calcul - return le resultat du calcul
    public void calcul() {
        try {
            Compile calculateur = new Compile();
            ecranResultat.setText("" + calculateur.analyseur(ecranCalcul.getText().toString()));
            and = (calculateur.analyseur(ecranCalcul.getText().toString())!=null) ? "" + calculateur.analyseur(ecranCalcul.getText().toString()) : (and==null)? "":and;
        } catch (Exception ex) {
            ecranResultat.setText("");
        }
    }

    //sauvegarder le dernier resultat
    public void ans(View v){
        ecranCalcul.getText().append(and);
        calcul();
    }


}
