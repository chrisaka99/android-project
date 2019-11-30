package com.example.firstandroidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    private Button validerButton;
    private EditText nom;
    private EditText numero;
    private TextView textView;
    DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        mydb = new DatabaseHelper(this);
        validerButton = (Button) findViewById(R.id.save);
        nom = (EditText) findViewById(R.id.nom);
        numero = (EditText) findViewById(R.id.numero);
        textView = (TextView) findViewById(R.id.textView);


        Bundle extras = getIntent().getExtras();
        if(extras != null && !extras.isEmpty()){
            mydb = new DatabaseHelper(this);
            textView.setText("Modifier le contact");
            final String id_item = getIntent().getStringExtra("CONTACT_INFO_ID");
            final String nom_item = getIntent().getStringExtra("CONTACT_INFO_NOM");
            final String num_item = getIntent().getStringExtra("CONTACT_INFO_NUM");

            Log.d("ID", String.valueOf(id_item));
            Log.d("NOM", String.valueOf(nom_item));
            Log.d("NUM", String.valueOf(num_item));
            nom.setText(nom_item);
            numero.setText(num_item);

            validerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean is_updated = mydb.update(id_item.toString(), nom.getText().toString(), numero.getText().toString());
                    if (is_updated ==true){
                        Intent contactList = new Intent(getApplicationContext(), ContactList.class);
                        startActivity(contactList);
                        finish();
                    }else{
                        Toast.makeText(ContactActivity.this, "Erreur", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }else{
            /* ON VALIDE POUR CREER UN NOUVEAU CONTACT */
            validerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nomtxt = nom.getText().toString();
                    String num = numero.getText().toString();

                    boolean is_inserted = mydb.inserer(nomtxt, num);
                    if (is_inserted == true){
                        Toast.makeText(ContactActivity.this, "Contact crée", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(ContactActivity.this, "Contact crée", Toast.LENGTH_SHORT).show();
                    }
                    Intent contactList = new Intent(getApplicationContext(), ContactList.class);
                    startActivity(contactList);
                    finish();
                }
            });
        }




    }



}
