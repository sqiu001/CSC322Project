package com.example.csc322project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class GroupFeedbackActivity extends AppCompatActivity {
    Spinner spinner;
    Button submitBtn1,submitBtn2,submitBtn3;
    private EditText feedback1,feedback2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_feedback);
        feedback1 = findViewById(R.id.group_feedback);
        feedback2 = findViewById(R.id.member_feedback);
        submitBtn1= findViewById(R.id.button3);
        submitBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFeedbackMessage();
            }
        });
        submitBtn2= findViewById(R.id.button4);
        submitBtn3= findViewById(R.id.button5);
        submitBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFeedbackMessageTwo();
            }
        });
        submitBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFeedbackMessageThree();
            }
        });
        spinner = (Spinner) findViewById(R.id.spinner);
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
                        openTodoActivity();
                        break;
                    case 8:
                        openHomeActivity();
                        break;
                    case 9:
                        openLogoutActivity();
                        break;
                    default:
                        return;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        TabHost tabs = (TabHost) findViewById(R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec = tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Group Evaluation");
        tabs.addTab(spec);
        spec = tabs.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Member Evaluation");
        tabs.addTab(spec);
    }
    private void sendFeedbackMessage() {
        final ProgressDialog dialog = new ProgressDialog(GroupFeedbackActivity.this);
        final String text = feedback1.getText().toString();

        if (text.equals("")) {
            Toast.makeText(getApplicationContext(), "Field is empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Feedback Submitted", Toast.LENGTH_SHORT).show();
            goToGroupFeedbackActivity();
        }
    }
    private void sendFeedbackMessageTwo() {
        final ProgressDialog dialog = new ProgressDialog(GroupFeedbackActivity.this);
        final String text = feedback2.getText().toString();

        if (text.equals("")) {
            Toast.makeText(getApplicationContext(), "Field is empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Feedback Submitted", Toast.LENGTH_SHORT).show();
            goToGroupFeedbackActivity();
        }
    }
    private void sendFeedbackMessageThree() {
        final ProgressDialog dialog = new ProgressDialog(GroupFeedbackActivity.this);
        final String text = feedback2.getText().toString();

        if (text.equals("")) {
            Toast.makeText(getApplicationContext(), "Field is empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Vote Submitted", Toast.LENGTH_SHORT).show();
            goToGroupFeedbackActivity();
        }
    }
    private void openLogoutActivity() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
    private void goToGroupFeedbackActivity() {
        Intent intent = new Intent(this,GroupFeedbackActivity.class);
        startActivity(intent);
    }
    private void openHomeActivity() {
        Intent intent = new Intent(this, HomePage.class);
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
        Intent intent = new Intent(this,GroupPageActivity.class);
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
    private void openTodoActivity() {
        Intent intent = new Intent(this,todoActivity.class);
        startActivity(intent);
    }
}
