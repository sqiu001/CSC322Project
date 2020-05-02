package com.example.csc322project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class Home_Page extends AppCompatActivity {
    Spinner spinner, spinner2;
    ViewPager project_display;
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);
        project_display = (ViewPager) findViewById(R.id.top_projects);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        project_display.setAdapter(viewPagerAdapter);
        spinner2 = findViewById(R.id.spinner2);
        spinner2.setVisibility(View.GONE);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        openBrowseActivity();
                        break;
                    case 2:
                        openInviteActivity();
                        break;
                    case 3:
                        openComplainActivity();
                        break;
                    case 4:
                        openGroupActivity();
                        break;
                    case 5:
                        openScheduleActivity();
                        break;
                    case 6:
                        openVoteActivity();
                        break;
                    case 7:
                        openLogoutActivity();
                    default:
                        return;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void openLogoutActivity() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    private void openBrowseActivity() {
        Intent intent = new Intent(this,BrowseActivity.class);
        startActivity(intent);
    }
    private void openInviteActivity() {
        Intent intent = new Intent(this,InviteActivity.class);
        startActivity(intent);
    }
    private void openComplainActivity() {
        Intent intent = new Intent(this,ComplainActivity.class);
        startActivity(intent);
    }
    private void openGroupActivity() {
        Intent intent = new Intent(this,GroupActivity.class);
        startActivity(intent);
    }
    private void openScheduleActivity() {
        Intent intent = new Intent(this,Schedule.class);
        startActivity(intent);
    }
    private void openVoteActivity(){
        Intent intent = new Intent(this,VoteActivity.class);
        startActivity(intent);
    }
}
