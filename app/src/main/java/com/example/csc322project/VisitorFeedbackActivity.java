package com.example.csc322project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class VisitorFeedbackActivity extends AppCompatActivity {
    Spinner spinner,spinner2;
    private Button submitBtn;
    private EditText subject_text, feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        subject_text = findViewById(R.id.user);
        feedback=findViewById(R.id.feedback_text);
        submitBtn= findViewById(R.id.feedback_submit);
        spinner = findViewById(R.id.spinner);
        spinner.setVisibility(View.GONE);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
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
                        openComplainActivity();
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
    //send email via email client
    private void sendMail() {
        String[] recipient = {"support@idk.com"};
        String subject = subject_text.getText().toString();
        String message = feedback.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipient);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }

    private void openTodoActivity() {
        Intent intent = new Intent(this,todoActivity.class);
        startActivity(intent);
    }

    private void openLogoutActivity() {
        Intent intent = new Intent(this,LoginActivity.class);
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
    private void openRegisterActivity() {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
