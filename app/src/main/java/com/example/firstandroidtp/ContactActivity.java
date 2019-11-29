package com.example.firstandroidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    private Button validerButton;
    private EditText nom;
    private EditText numero;
    int dim = 2;
    int inc = 0;

    ArrayList<ArrayList<String>> list = new ArrayList<>(dim);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        validerButton = (Button) findViewById(R.id.save);
        nom = (EditText) findViewById(R.id.nom);
        numero = (EditText) findViewById(R.id.numero);



        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nomtxt = nom.getText().toString();
                String numtxt = String.valueOf(numero.getText().toString());
                //Log.d("Nom", nom.getText().toString());
                //Log.d("Numero", numero.get Text().toString());
                saveData(nomtxt, numtxt);
                loadData();

                //Log.v()
            }
        });
        loadData();
        //update();
    }

    private void saveData(String nom, String num) {
        list.add(new ArrayList<String>());
        inc++;
        Toast.makeText(this, "Contact sauvegargé", Toast.LENGTH_SHORT).show();
        loadData();
    }

    private void loadData() {
        Log.d("taille", String.valueOf(list.size()));
        for (int i = 0; i < list.size(); i++){
            Log.d("nom" + i, list.get(i).get(i));
        }
    }


}
