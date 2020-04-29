package com.example.csc322project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Schedule extends AppCompatActivity {
//    private static final String TAG = "Schedule";
    private TextView theDate, meeting;
    private EditText theMeeting;
    private Button btnGoCalendar, btnSave;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        theDate = (TextView) findViewById(R.id.view_date);
        theMeeting = (EditText) findViewById(R.id.meeting);
        meeting = (TextView) findViewById(R.id.display_meeting);
        btnSave = findViewById(R.id.save_meeting);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = theMeeting.getText().toString();
                meeting.setText(text);
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
                        openHomeActivity();
                        break;
                    default:
                        return;

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void openHomeActivity() {
        Intent intent = new Intent(this,Home_Page.class);
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
}
