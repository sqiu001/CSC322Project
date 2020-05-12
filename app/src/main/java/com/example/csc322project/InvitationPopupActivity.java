package com.example.csc322project;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class InvitationPopupActivity extends AppCompatActivity {
    Spinner users;
    Button accept, reject;
    EditText reason;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitations);
        users = findViewById(R.id.invitations);
        accept = findViewById(R.id.accept2);
        reject = findViewById(R.id.reject2);
        reason = findViewById(R.id.reason);

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InvitationPopupActivity.this, "Invitation Accepted", Toast.LENGTH_SHORT).show();
            }
        });

        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cause = reason.getText().toString();
                if(cause.equals("")){
                    Toast.makeText(InvitationPopupActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(InvitationPopupActivity.this, "Invitation Declined", Toast.LENGTH_SHORT).show();
                }
            }
        });

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width*.8), (int)(height*.50));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x=0;
        params.y=-20;
        getWindow().setAttributes(params);
    }

}
