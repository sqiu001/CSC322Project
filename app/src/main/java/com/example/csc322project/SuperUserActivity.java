package com.example.csc322project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SuperUserActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<String> mylist = new ArrayList<>();
    Button registration, logout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mylist);
        mylist.add("John");
        mylist.add("Tony");
        mylist.add("Sandy");
        mylist.add("Kevin");
        mylist.add("Quetourah");
        mylist.add("Spongebob");
        mylist.add("Patrick");
        mylist.add("Plankton");
        mylist.add("Mr.Krabs");
        mylist.add("Squidward");
        mylist.add("test");
        lv = (ListView) findViewById(R.id.reg_users);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                mylist.remove(position);
                lv.invalidateViews();
                Toast.makeText(getBaseContext(), "Sent Email notifying user of removal", Toast.LENGTH_SHORT).show();
            }
        });
        registration = findViewById(R.id.registr);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Registration.class);
                startActivity(intent);
            }
        });
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
