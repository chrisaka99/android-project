package com.example.firstandroidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ecranResultat = null;
    private EditText ecranCalcul = null;
    private Button un = null;
    private String and = null;

=======
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button contactButton;
>>>>>>> origin/contact
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD


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
=======
        contactButton = (Button) findViewById(R.id.contactButton);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* on lance la nouvelle activite */
                Intent contactlist = new Intent(getApplicationContext(), ContactList.class);
                startActivity(contactlist);
            }
        });
>>>>>>> origin/contact
    }

    public void ans(View v){
        ecranCalcul.getText().append(and);
        calcul();
    }


}
