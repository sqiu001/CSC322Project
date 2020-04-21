package com.example.csc322project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    Database db;
    EditText e1,e2,e3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new Database(this);

        e1 = (EditText) findViewById(R.id.edUsername);
        e2 = (EditText) findViewById(R.id.edPassword);
        e3 = (EditText) findViewById(R.id.edConfirmPassword);
        b1 = (Button) findViewById(R.id.btnRegister);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();

                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (s2.equals(s3)) {
                        Boolean chkUser = db.chkuser(s1);
                        if (chkUser == true) {
                            Boolean insert = db.insert(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered Successful!", Toast.LENGTH_SHORT);
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Email already exist", Toast.LENGTH_LONG);
                        }
                    }
                }
            }
        });
    }
}