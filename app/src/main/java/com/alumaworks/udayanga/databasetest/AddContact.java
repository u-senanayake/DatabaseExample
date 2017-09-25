package com.alumaworks.udayanga.databasetest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContact extends AppCompatActivity {
    DatabaseHandler databaseHandler= new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button button = (Button) findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextName = (EditText) findViewById(R.id.editTextName);
                EditText editTextTp = (EditText) findViewById(R.id.editTextTelephoneNumber);

                String name = editTextName.getText().toString();
                String tpNum = editTextTp.getText().toString();
                databaseHandler.addContact(new Contact(name,tpNum));

                Toast.makeText(getApplicationContext(),"Added to database", Toast.LENGTH_SHORT).show();
                editTextName.setText("");
                editTextTp.setText("");

            }
        });

    }

}
