package com.example.csc322project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class VisitorBrowseActivity extends AppCompatActivity {
    Spinner spinner, spinner2;
    ViewPager projects;
    Button group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        spinner.setVisibility(View.GONE);
        group = findViewById(R.id.group);
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVisitorGroupActivity();
            }
        });
        projects=(ViewPager) findViewById(R.id.all_projects);
        SliderAdapter sliderAdapter = new SliderAdapter(this);
        projects.setAdapter(sliderAdapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 1:
                        break;
                    case 2:
                        openComplainActivity();
                        break;
                    case 3:
                        openRegisterActivity();
                        break;
                    case 4:
                        openHomeActivity();
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

    private void openRegisterActivity() {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    private void openHomeActivity() {
        Intent intent = new Intent(this,VisitorPageActivity.class);
        startActivity(intent);
    }

    private void openComplainActivity() {
        Intent intent = new Intent(this,VisitorComplainActivity.class);
        startActivity(intent);
    }
    private void openVisitorGroupActivity() {
        Intent intent = new Intent(this,VisitorGroupActivity.class);
        startActivity(intent);
    }
}
