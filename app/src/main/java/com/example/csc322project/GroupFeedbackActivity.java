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
    Button submitBtn;
    private EditText feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_feedback);
        feedback = findViewById(R.id.group_feedback);
        submitBtn= findViewById(R.id.button3);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFeedbackMessage();
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
        final String text = feedback.getText().toString();

        if (text.equals("")) {
            Toast.makeText(getApplicationContext(), "Field is empty", Toast.LENGTH_SHORT).show();
        }
        else {
            dialog.setTitle("Feedback Received");
            dialog.setMessage("Your feedback has been recorded.");
            dialog.show();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
    private void openTodoActivity() {
        Intent intent = new Intent(this,todoActivity.class);
        startActivity(intent);
    }
}
