package com.example.csc322project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class VisitorActivity extends AppCompatActivity {
    private Button buttonContinue, buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor);
        buttonContinue = (Button) findViewById(R.id.btnContinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVisitorPageActivity();
            }
        });
        buttonRegister = (Button) findViewById(R.id.btnRegisterActivity);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisterActivity();
            }
        });
    }

    public void openRegisterActivity(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void openVisitorPageActivity() {
        Intent intent = new Intent(this,VisitorPageActivity.class);
        startActivity(intent);
    }
}

