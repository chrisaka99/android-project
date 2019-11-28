package com.example.firstandroidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity {

    private Button validerButton;
    private EditText nom;
    private EditText numero;

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

                Log.d("Nom", nom.getText().toString());
                Log.d("Numero", numero.getText().toString());
            }
        });

    }
    private void save() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("eliud","ok");
        
    }
}
