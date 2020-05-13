package com.example.csc322project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class VoteVIP extends AppCompatActivity {
    Boolean correct = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_v_i_p);
        getSupportActionBar().setTitle("VoteVIP");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void Ischeck(View view){
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Spinner spinner = findViewById(R.id.spinner5);
        int S_item = spinner.getSelectedItemPosition();
        if(radioGroup.getCheckedRadioButtonId() == -1){
            Toast.makeText(getApplicationContext(),  "Button is not selected", Toast.LENGTH_SHORT).show();
            correct = false;
        }
        else{
            correct = true;
        }
        if(S_item == 0){
            Toast.makeText(getApplicationContext(), "candidate is empty", Toast.LENGTH_SHORT).show();
            correct = false;
        }
        if(correct){
            Toast.makeText(getApplicationContext(), "Submitted Successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,VoteActivity.class);
            startActivity(intent);
        }


    }
}
