package com.example.csc322project;

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

import androidx.appcompat.app.AppCompatActivity;

public class VisitorComplainActivity extends AppCompatActivity {
    Spinner spinner, spinner2;
    private Button submitBtn;
    private EditText subject_text, complain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        subject_text = findViewById(R.id.user_complain);
        complain=findViewById(R.id.complain_text);
        submitBtn= findViewById(R.id.complain_submit);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setVisibility(View.GONE);
        spinner2 = findViewById(R.id.spinner2);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 1:
                        openBrowseActivity();
                        break;
                    case 2:
                        break;
                    case 3:
                        openRegisterActivity();
                        break;
                    case 4:
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

    //send email from inside application
    private void sendMessage() {
        final ProgressDialog dialog = new ProgressDialog(VisitorComplainActivity.this);
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
            openComplainActivity();
        }
    }

    private void openRegisterActivity() {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    private void openHomeActivity() {
        Intent intent = new Intent(this,VisitorPageActivity.class);
        startActivity(intent);
    }
    private void openBrowseActivity() {
        Intent intent = new Intent(this,VisitorBrowseActivity.class);
        startActivity(intent);
    }
    private void openComplainActivity() {
        Intent intent = new Intent(this,VisitorComplainActivity.class);
        startActivity(intent);
    }


}
