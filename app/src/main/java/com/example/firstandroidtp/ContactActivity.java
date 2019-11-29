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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
        textView=(TextView) findViewById(R.id.resutas);

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
                /*Intent intent = new Intent(getBaseContext(), ContactList.class);
                intent.putExtra("DATA_REP", name1);
                intent.putExtra("DATA_REP1", numero1);

                startActivity(intent);
                finish();*/
            }
        });


    }



}
