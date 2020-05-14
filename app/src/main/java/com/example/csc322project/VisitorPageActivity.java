package com.example.csc322project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class VisitorPageActivity extends AppCompatActivity {
    Spinner spinner, spinner2;
    ViewPager project_display, user_display;
    Button feedbackBtn, profileBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);
        project_display = (ViewPager) findViewById(R.id.top_projects);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        project_display.setAdapter(viewPagerAdapter);

        user_display = (ViewPager) findViewById(R.id.top_users);
        UserPagerAdapter userPagerAdapter = new UserPagerAdapter(this);
        user_display.setAdapter(userPagerAdapter);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setVisibility(View.GONE);
        profileBtn = findViewById(R.id.btnGoToProfile);
        profileBtn.setVisibility(View.GONE);
        feedbackBtn = findViewById(R.id.button);
        feedbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVisitorFeedbackActivity();
            }
        });
        spinner2 = (Spinner) findViewById(R.id.spinner2);
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

    private void openVisitorFeedbackActivity() {
        Intent intent = new Intent(this,VisitorFeedbackActivity.class);
        startActivity(intent);
    }

    private void openRegisterActivity() {
        Intent intent = new Intent(this,RegisterActivity.class);
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
    private void openFeedbackActivity() {
        Intent intent = new Intent(this,feedbackActivity.class);
        startActivity(intent);
    }



}
