package com.example.csc322project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {
    Button accept, accept2, reject, reject_2, back;
    TextView view21, view22;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        view21 = findViewById(R.id.textView21);
        view22 = findViewById(R.id.textView22);
        accept = findViewById(R.id.approve);
        accept2 = findViewById(R.id.approve2);
        reject = findViewById(R.id.reject);
        reject_2 = findViewById(R.id.reject3);
        back = findViewById(R.id.goback);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SuperUserActivity.class);
                startActivity(intent);
            }
        });
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accept.setVisibility(View.GONE);
                reject.setVisibility(View.GONE);
                view21.setVisibility(View.GONE);
                Toast.makeText(getBaseContext(), "Sent Email notifying user of acceptance", Toast.LENGTH_SHORT).show();
            }
        });
        accept2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accept2.setVisibility(View.GONE);
                reject_2.setVisibility(View.GONE);
                view22.setVisibility(View.GONE);
                Toast.makeText(getBaseContext(), "Sent Email notifying user of acceptance", Toast.LENGTH_SHORT).show();
            }
        });
        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accept.setVisibility(View.GONE);
                reject.setVisibility(View.GONE);
                view21.setVisibility(View.GONE);
                Toast.makeText(getBaseContext(), "Sent Email notifying user of rejection", Toast.LENGTH_SHORT).show();
            }
        });
        reject_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accept2.setVisibility(View.GONE);
                reject_2.setVisibility(View.GONE);
                view22.setVisibility(View.GONE);
                Toast.makeText(getBaseContext(), "Sent Email notifying user of rejection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
