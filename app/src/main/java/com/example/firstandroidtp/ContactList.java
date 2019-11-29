package com.example.firstandroidtp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ContactList extends AppCompatActivity {
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        mydb = new DatabaseHelper(this);

        final List<ContactItem> contactItemList = new ArrayList<>();
        Cursor res = mydb.getAllData();
        if (res.getCount() == 0){
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            contactItemList.add(new ContactItem(res.getString(1), res.getString(2)));
        }

        final ListView contactView = findViewById(R.id.listView1);
        contactView.setAdapter(new ContactItemAdapter(ContactList.this, contactItemList));


        //Lorsqu'on clique sur un contact
        contactView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Vous avez cliqué sur cet element", Toast.LENGTH_LONG).show();
            }
        });
        //Lorssqu'on maintient sur un contact
        contactView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int item_id = position;
                AlertDialog.Builder delDialog = new AlertDialog.Builder(ContactList.this);
                delDialog.setIcon(R.drawable.ic_cancel);
                delDialog.setTitle("Supprimer");
                delDialog.setMessage("Voulez vous supprimer ce contact ?");
                delDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        contactItemList.remove(item_id);
                    }
                });
                delDialog.setNegativeButton("Non", null);
                delDialog.show();
                return true;
            }
        });

        //Bouton + flottant
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* on lance la nouvelle activite */
                Intent contactActivity = new Intent(getApplicationContext(), ContactActivity.class);
                startActivity(contactActivity);

            }
        });

    }

}
