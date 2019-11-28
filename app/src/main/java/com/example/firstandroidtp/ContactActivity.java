package com.example.firstandroidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    private Button validerButton;
    private EditText nom;
    private EditText numero;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        validerButton = (Button) findViewById(R.id.save);
        nom = (EditText) findViewById(R.id.nom);
        numero = (EditText) findViewById(R.id.numero);
        textView=(TextView) findViewById(R.id.resutas);
        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
                load();
            }
        });
    load();
    }
    private void save() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Nom","eliud");
        editor.putString("Numero","01020304");
        editor.apply();

    }
    private void load(){
        SharedPreferences sharedPreferences=getSharedPreferences("shared preference",MODE_PRIVATE);
        String res1=sharedPreferences.getString("Nom","");
        String res2=sharedPreferences.getString("Numero","");
        textView.setText("nom : "+res1+"\n"+"prenom : "+res2+"\n");
    }
}
