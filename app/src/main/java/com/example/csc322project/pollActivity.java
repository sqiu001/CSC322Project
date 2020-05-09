package com.example.csc322project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pollActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView one, two, three, four, five;
    Button choose;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);
        radioGroup = findViewById(R.id.poll_options);
        one = findViewById(R.id.vote1);
        two = findViewById(R.id.vote2);
        three = findViewById(R.id.vote3);
        four = findViewById(R.id.vote4);
        five = findViewById(R.id.vote5);
        choose = findViewById(R.id.choose_poll);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                //radioButton = findViewById(radioId);
                switch (radioId){
                    case R.id.radioButton:
                        String vote1 = one.getText().toString().trim();
                        int total = Integer.parseInt(vote1);
                        total ++;
                        one.setText(String.valueOf(total));
                        break;
                    case R.id.radioButton2:
                        String vote2 = two.getText().toString().trim();
                        int total2 = Integer.parseInt(vote2);
                        total2 ++;
                        two.setText(String.valueOf(total2));
                        break;
                    case R.id.radioButton3:
                        String vote3 = three.getText().toString().trim();
                        int total3 = Integer.parseInt(vote3);
                        total3 ++;
                        three.setText(String.valueOf(total3));
                        break;
                    case R.id.radioButton4:
                        String vote4 = four.getText().toString().trim();
                        int total4 = Integer.parseInt(vote4);
                        total4 ++;
                        four.setText(String.valueOf(total4));
                        break;
                    case R.id.radioButton5:
                        String vote5 = five.getText().toString().trim();
                        int total5 = Integer.parseInt(vote5);
                        total5 ++;
                        five.setText(String.valueOf(total5));
                        break;
                }
            }
        });
        spinner = findViewById(R.id.spinner3);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 1:
                        openBrowseActivity();
                        break;
                    case 2:
                        openInviteActivity();
                        break;
                    case 3:
                        openComplainActivity();
                        break;
                    case 4:
                        openGroupActivity();
                        break;
                    case 5:
                        openScheduleActivity();
                        break;
                    case 6:
                        openVoteActivity();
                        break;
                    case 7:
                        break;
                    case 8:
                        openHomeActivity();
                        break;
                    case 9:
                        openLogoutActivity();
                    default:
                        return;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        Toast.makeText(this, "Selected Option: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    private void openTodoActivity() {
        Intent intent = new Intent(this,todoActivity.class);
        startActivity(intent);
    }

    private void openLogoutActivity() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    private void openBrowseActivity() {
        Intent intent = new Intent(this,BrowseActivity.class);
        startActivity(intent);
    }
    private void openInviteActivity() {
        Intent intent = new Intent(this,InviteActivity.class);
        startActivity(intent);
    }
    private void openComplainActivity() {
        Intent intent = new Intent(this,ComplainActivity.class);
        startActivity(intent);
    }
    private void openGroupActivity() {
        Intent intent = new Intent(this,GroupActivity.class);
        startActivity(intent);
    }
    private void openScheduleActivity() {
        Intent intent = new Intent(this,Schedule.class);
        startActivity(intent);
    }
    private void openVoteActivity(){
        Intent intent = new Intent(this,VoteActivity.class);
        startActivity(intent);
    }
    private void openHomeActivity() {
        Intent intent = new Intent(this,HomePage.class);
        startActivity(intent);
    }
}
