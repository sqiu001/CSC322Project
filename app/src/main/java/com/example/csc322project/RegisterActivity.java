package com.example.csc322project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    Database db;
    EditText e1,e2,e3, name, email, interest, credential, reference;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new Database(this);

        e1 = (EditText) findViewById(R.id.edUsername);
        e2 = (EditText) findViewById(R.id.edPassword);
        e3 = (EditText) findViewById(R.id.edConfirmPassword);
        e1.setVisibility(View.GONE);
        e2.setVisibility(View.GONE);
        e3.setVisibility(View.GONE);
        b1 = (Button) findViewById(R.id.btnRegister);
        b2 = (Button) findViewById(R.id.btnGoToLogin);
        name = findViewById(R.id.edname);
        email = findViewById(R.id.edemail);
        interest = findViewById(R.id.edinterest);
        credential = findViewById(R.id.edcredential);
        reference = findViewById(R.id.edreference);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = name.getText().toString();
                String s5 = email.getText().toString();
                String s6 = interest.getText().toString();
                String s7 = credential.getText().toString();
                String s8 = reference.getText().toString();

                if (s4.equals("") || s5.equals("") || s6.equals("") || s7.equals("") || s8.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    sendMessage();
                    db.insert("test","test");
//                    if (s2.equals(s3)) {
//                        Boolean chkUser = db.chkuser(s1);
//                        if (chkUser == true) {
//                            Boolean insert = db.insert(s1, s2);
//                            if (insert == true) {
//                                Toast.makeText(getApplicationContext(), "Registered Successful!", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Username already exist", Toast.LENGTH_LONG).show();
//                        }
                    }
                }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
            }
        });
    }

    private void openMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void goToLogin() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    private void sendMessage() {
        final ProgressDialog dialog = new ProgressDialog(RegisterActivity.this);
        final String userEmail = email.getText().toString();
        final String text = name.getText().toString() + "\n"+ userEmail + "\n" + interest.getText().toString() + "\n" +
                credential.getText().toString() +  "\n" + reference.getText().toString();
        dialog.setTitle("Sending Email");
        dialog.setMessage("Thank you for registering! A super-user will get back to you regarding your acceptance.");
        dialog.show();
        final Handler handler = new Handler();
        Thread sender = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GmailSender sender = new GmailSender("email", "password");
                    sender.sendMail("IDK App",
                            text,
                            userEmail,
                            "support@idk.com");
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            dialog.dismiss();
                        }
                    }, 3000);
                } catch (Exception e) {
                    Log.e("mylog", "Error: " + e.getMessage());
                }
            }
        });
        sender.start();
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

}

