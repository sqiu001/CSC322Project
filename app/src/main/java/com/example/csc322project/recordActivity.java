package com.example.csc322project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class recordActivity extends AppCompatActivity {
    CheckBox one, two, three, four, five, six, seven;
    Spinner spinner;
    //Button check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign);
        spinner = findViewById(R.id.spinner);
        one = findViewById(R.id.checkBox);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){
                    Toast.makeText(getBaseContext(), "Assignment Completed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        two = findViewById(R.id.checkBox2);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){
                    Toast.makeText(getBaseContext(), "Assignment Completed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        three = findViewById(R.id.checkBox3);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){
                    Toast.makeText(getBaseContext(), "Assignment Completed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        four = findViewById(R.id.checkBox4);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){
                    Toast.makeText(getBaseContext(), "Assignment Completed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        five = findViewById(R.id.checkBox5);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){
                    Toast.makeText(getBaseContext(), "Assignment Completed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        six = findViewById(R.id.checkBox6);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){
                    Toast.makeText(getBaseContext(), "Assignment Completed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        seven = findViewById(R.id.checkBox7);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){
                    Toast.makeText(getBaseContext(), "Assignment Completed", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        check = findViewById(R.id.check_option);
//        check.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                StringBuffer result = new StringBuffer();
//                result.append("Sandy: create the poll: ").append(one.isChecked());
//                result.append("Quetourah: create user profile: ").append(two.isChecked());
//                result.append("Kevin: create vote feature: ").append(three.isChecked());
//                result.append("Hong: create invite option: ").append(four.isChecked());
//                result.append("All: Finish design report: ").append(five.isChecked());
//                result.append("All: Attend meeting on Tuesday: ").append(six.isChecked());
//                result.append("Etc...: ").append(seven.isChecked());
//                Toast.makeText(getBaseContext(), result.toString(), Toast.LENGTH_LONG).show();
//            }
//        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
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
                        break;
                    case 8:
                        openHomeActivity();
                        break;
                    case 9:
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


    private void openTodoActivity() {
        Intent intent = new Intent(this,todoActivity.class);
        startActivity(intent);
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
    private void openHomeActivity() {
        Intent intent = new Intent(this,HomePage.class);
        startActivity(intent);
    }
}
