package com.example.firstandroidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ContactList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        List<ContactItem> contactItemList = new ArrayList<>();
        contactItemList.add(new ContactItem("Chris", 77372660));
        contactItemList.add(new ContactItem("Edy", 77441122));

        ListView contactView = findViewById(R.id.listView1);
        contactView.setAdapter(new ContactItemAdapter(ContactList.this, contactItemList));

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
