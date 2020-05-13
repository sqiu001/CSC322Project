package com.example.csc322project;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PopUpActivity extends AppCompatActivity {
    Button save;
    EditText oldPw, newPw;
    ArrayList<String> account = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        save = findViewById(R.id.update);
        oldPw = findViewById(R.id.old);
        newPw = findViewById(R.id.newpw);
        account.add("test, 1234");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String old = oldPw.getText().toString();
                String update = newPw.getText().toString();
                if(account.contains(old) && !update.isEmpty()){
                    account.set(0, update);
                    Toast.makeText(getBaseContext(), "Saved Changes", Toast.LENGTH_SHORT).show();
                }
                else if(old.equals("") || update.equals("")){
                    Toast.makeText(getBaseContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getBaseContext(), "Incorrect Password", Toast.LENGTH_SHORT).show();
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
