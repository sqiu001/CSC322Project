package com.example.csc322project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import javax.xml.datatype.Duration;

public class VoteSuper extends AppCompatActivity {
    Boolean correct = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_super);
        getSupportActionBar().setTitle("VoteSuper");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void toast(View view) {
        RadioButton radio1 = findViewById(R.id.radioButton_yes);
        RadioButton radio2 = findViewById(R.id.radioButton_no);
        EditText editText = findViewById(R.id.editText);
        final Spinner spinner = findViewById(R.id.spinner4);
        String text;
        final int S_item = spinner.getSelectedItemPosition();
        if (radio1.isChecked() || radio2.isChecked()) {
            correct = true;
        } else {
            Toast.makeText(getApplicationContext(),  "Button is not selected", Toast.LENGTH_SHORT).show();
            correct = false;
        }

        text = editText.getText().toString();
        if (text.matches("")) {
            Toast.makeText(getApplicationContext(), "comment is empty", Toast.LENGTH_SHORT).show();
            correct = false;
        }
        if(S_item == 0){
            Toast.makeText(getApplicationContext(), "candidate is empty", Toast.LENGTH_SHORT).show();
            correct = false;
        }

    }
    public void submit(View view){
        if(correct == true){
            Toast.makeText(getApplicationContext(), "Submitted Successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,VoteActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Please check first!", Toast.LENGTH_SHORT).show();
        }
    }
}
