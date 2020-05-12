package com.example.csc322project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VoteSuper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_super);
        getSupportActionBar().setTitle("VoteSuper");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
