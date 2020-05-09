package com.example.csc322project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Schedule extends AppCompatActivity {
//    private static final String TAG = "Schedule";
    private TextView theDate, meeting;
    private EditText theMeeting;
    private Button btnGoCalendar, btnSave, btnPoll, btnRecord;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        theDate = (TextView) findViewById(R.id.view_date);
        theMeeting = (EditText) findViewById(R.id.meeting);
        meeting = (TextView) findViewById(R.id.display_meeting);
        btnPoll = findViewById(R.id.btnpoll);
        btnPoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPollActivity();
            }
        });
        btnSave = findViewById(R.id.save_meeting);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = theMeeting.getText().toString();
                meeting.setText(text);
            }
        });
        btnRecord = findViewById(R.id.recordbtn);
        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecordActivity();
            }
        });
        btnGoCalendar = findViewById(R.id.btnDate);
        Intent IncomingIntent = getIntent();
        String date = IncomingIntent.getStringExtra("date");
        theDate.setText(date);
        btnGoCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Schedule.this, CalendarActivity.class);
                startActivity(intent);
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
                    default:
                        return;

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void openLogoutActivity() {
        Intent intent = new Intent(this,LoginActivity.class);
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
    private void openPollActivity() {
        Intent intent = new Intent(this,pollActivity.class);
        startActivity(intent);
    }
    private void openRecordActivity() {
        Intent intent = new Intent(this,recordActivity.class);
        startActivity(intent);
    }

}
