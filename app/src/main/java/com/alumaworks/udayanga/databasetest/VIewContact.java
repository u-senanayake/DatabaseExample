package com.alumaworks.udayanga.databasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class VIewContact extends AppCompatActivity {

    DatabaseHandler handler = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);

        ArrayList<HashMap<String, String>> contactList = handler.getAllContacts();
        if(contactList.size()!=0){
            ListAdapter adapter = new SimpleAdapter( this,contactList, R.layout.json_list_view, new String[] {
                    "name","phone_number"}, new int[] {R.id.name, R.id.phone_number});
            ListView myList=(ListView)findViewById(R.id.list_jason);
            myList.setAdapter(adapter);
        }



        }

}
