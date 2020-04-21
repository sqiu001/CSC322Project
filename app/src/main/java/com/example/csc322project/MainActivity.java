package com.example.csc322project;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button buttonLogin;
    private Button buttonVisitor;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin=(Button)findViewById(R.id.BtnLogin);
        buttonVisitor=(Button)findViewById(R.id.BtnVisitor);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginActivity();
            }
        });
        buttonVisitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVisitorActivity();
            }
        });
    }

    private void openLoginActivity() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
    private void openVisitorActivity() {
        Intent intent = new Intent(this,VisitorActivity.class);
        startActivity(intent);
    }
}