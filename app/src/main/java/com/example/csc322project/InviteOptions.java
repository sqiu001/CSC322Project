package com.example.csc322project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InviteOptions extends AppCompatActivity {
    Spinner spinner;
    Button white, black, invite;
    ArrayList<String> addWhite = new ArrayList<>();
    ArrayList<String> addBlack = new ArrayList<>();
    ArrayList<String> testWhite = new ArrayList<>();
    ArrayList<String> testBlack = new ArrayList<>();
    List<String> mylist = Arrays.asList("John", "Tony", "Sandy", "Kevin", "test", "Quetourah", "Hong", "Patrick",
            "Spongebob", "Plankton", "Mr.Krabs", "Squidward");
    ArrayAdapter<String> whiteAdapter;
    ArrayAdapter<String> blackAdapter;
    ListView showWhite, showBlack;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invite_option);
        spinner = (Spinner) findViewById(R.id.spinner);
        text = findViewById(R.id.user_search);
        white = findViewById(R.id.white);
        black = findViewById(R.id.black);
        addWhite.add("Hong");
        addBlack.add("Quetourah");
        testWhite.add("Kevin");
        testBlack.add("Sandy");
        showBlack = findViewById(R.id.blackbox);
        showWhite = findViewById(R.id.whitebox);
        whiteAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, addWhite);
        showWhite.setAdapter(whiteAdapter);
        blackAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, addBlack);
        showBlack.setAdapter(blackAdapter);
        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = text.getText().toString();
                boolean check = mylist.contains(getInput);
                if(addWhite.contains(getInput)){
                    Toast.makeText(getBaseContext(), "User already in list", Toast.LENGTH_SHORT).show();
                }
                else if(getInput == null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(), "Field is empty", Toast.LENGTH_SHORT).show();
                }
                else if(!check){
                    Toast.makeText(getBaseContext(), "User does not exist", Toast.LENGTH_SHORT).show();
                }
                else if(addBlack.contains(getInput)){
                    Toast.makeText(getBaseContext(), "User in blacklist", Toast.LENGTH_SHORT).show();
                }
                else{
                    addWhite.add(getInput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(InviteOptions.this, android.R.layout.simple_list_item_1, addWhite);
                    showWhite.setAdapter(adapter);
                    ((EditText) findViewById(R.id.user_search)).setText(" ");
                }
            }
        });
        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = text.getText().toString();
                boolean check = mylist.contains(getInput);
                if(addBlack.contains(getInput)){
                    Toast.makeText(getBaseContext(), "User already in list", Toast.LENGTH_SHORT).show();
                }
                else if(getInput == null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(), "Field is empty", Toast.LENGTH_SHORT).show();
                }
                else if(!check){
                    Toast.makeText(getBaseContext(), "User does not exist", Toast.LENGTH_SHORT).show();
                }
                else if(addWhite.contains(getInput)){
                    Toast.makeText(getBaseContext(), "User in whitelist", Toast.LENGTH_SHORT).show();
                }
                else{
                    addBlack.add(getInput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(InviteOptions.this, android.R.layout.simple_list_item_1, addBlack);
                    showBlack.setAdapter(adapter);
                    ((EditText) findViewById(R.id.user_search)).setText(" ");
                }
            }
        });
        invite = findViewById(R.id.invite);
        invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = text.getText().toString();
                if(testBlack.contains(getInput)){
                    Toast.makeText(getBaseContext(), "Invitation Rejected", Toast.LENGTH_SHORT).show();
                }
                else if(testWhite.contains(getInput)){
                    Toast.makeText(getBaseContext(), "Invitation Accepted", Toast.LENGTH_SHORT).show();
                }
                else if(getInput == null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(), "Field is empty", Toast.LENGTH_SHORT).show();
                }
                else if(!mylist.contains(getInput)){
                    Toast.makeText(getBaseContext(), "User does not exist", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getBaseContext(), "Invitation Sent", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
                        openTodoActivity();
                        break;
                    case 8:
                        openHomeActivity();
                        break;
                    case 9:
                        openLogoutActivity();
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
    private void openTodoActivity() {
        Intent intent = new Intent(this,todoActivity.class);
        startActivity(intent);
    }
    private void openLogoutActivity() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
    private void openHomeActivity() {
        Intent intent = new Intent(this, HomePage.class);
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
        Intent intent = new Intent(this,GroupPageActivity.class);
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
