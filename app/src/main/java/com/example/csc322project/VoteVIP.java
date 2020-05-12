package com.example.csc322project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VoteVIP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_v_i_p);
        getSupportActionBar().setTitle("VoteVIP");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
