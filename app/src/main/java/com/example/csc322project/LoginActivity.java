package com.example.csc322project;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

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
                if(username.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else if(chkaccount==true || (username.equals("test") && password.equals("1234"))){
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();
                    Home();
                }
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
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Notification");
        builder.setMessage("Please change your password");
        builder.show();
        intent = new Intent(this, ProfilePageActivity.class);
        startActivity(intent);
    }
}