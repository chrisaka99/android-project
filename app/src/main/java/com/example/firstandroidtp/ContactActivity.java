package com.example.firstandroidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ExpandableListActivity;
import android.content.SharedPreferences;
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

public class ContactActivity extends AppCompatActivity {

    private Button validerButton;
    private EditText nom;
    private EditText numero;
    private TextView textView;
    private contactBDD ContactBDD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ContactBDD=new contactBDD(this);
        validerButton = (Button) findViewById(R.id.save);
        nom = (EditText) findViewById(R.id.nom);
        numero = (EditText) findViewById(R.id.numero);
        textView=(TextView) findViewById(R.id.resutas);

        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactBDD.open();
                contact Contact=new contact(nom.getText().toString(),3003030);
                textView.append(Contact.toString());
                ContactBDD.insertContact(Contact);
                contact contactFromBD=ContactBDD.getContactWithNom();
                String name=contactFromBD.toString();
                textView.append(name);
            }
        });
    }

}
