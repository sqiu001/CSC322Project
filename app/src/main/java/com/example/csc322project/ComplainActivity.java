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
import android.widget.Toast;

public class ComplainActivity extends AppCompatActivity {
    Spinner spinner;
    private Button submitBtn;
    private EditText subject_text, complain;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        subject_text = findViewById(R.id.user_complain);
        complain=findViewById(R.id.complain_text);
        submitBtn= findViewById(R.id.complain_submit);
        spinner = (Spinner) findViewById(R.id.spinner);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
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
//send email via email client
//    private void sendMail() {
//        String[] recipient = {"support@idk.com"};
//        String subject = subject_text.getText().toString();
//        String message = complain.getText().toString();
//
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.putExtra(Intent.EXTRA_EMAIL, recipient);
//        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
//        intent.putExtra(Intent.EXTRA_TEXT, message);
//
//        intent.setType("message/rfc822");
//        startActivity(Intent.createChooser(intent, "Choose an email client"));
//    }

//send email from inside application
    private void sendMessage() {
        final ProgressDialog dialog = new ProgressDialog(ComplainActivity.this);
        final String subject = subject_text.getText().toString();
        final String text = complain.getText().toString();

        if (subject.equals("") || text.equals("")) {
            Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
        }
        else {
            dialog.setTitle("Sending Email");
            dialog.setMessage("Sending Complaint/Compliment to SuperUser. \n Thank you for your feedback.");
            dialog.show();
            final Handler handler = new Handler();
            Thread sender = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        GmailSender sender = new GmailSender("email", "password"); //require email login info thus empty for security reasons
                        sender.sendMail(subject,
                                text,
                                "email",
                                "support@idk.com");
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                dialog.dismiss();
                            }
                        }, 1000);
                    } catch (Exception e) {
                        Log.e("mylog", "Error: " + e.getMessage());
                    }
                }
            });
            sender.start();
        }
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