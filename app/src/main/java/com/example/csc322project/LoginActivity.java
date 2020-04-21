package com.example.csc322project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private Button LoginButton;
    private Button CancelBtn;
    EditText ed1, ed2;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new Database(this);
        ed1=(EditText)findViewById(R.id.Username);
        ed2=(EditText)findViewById(R.id.Password);
        CancelBtn = findViewById(R.id.buttonCancel);
        LoginButton=findViewById(R.id.buttonLogin);
        CancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = ed1.getText().toString();
                String password = ed2.getText().toString();
                Boolean chkaccount = db.checkAccount(username, password);
                if(chkaccount==true){
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();
                     Home();}
                else
                    Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();
               //Login();
            }
        });

    }
    private void goBack(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    private void Login(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    private void Home(){
        Intent intent = new Intent(this,Home_Page.class);
        startActivity(intent);
    }
}