package com.example.csc322project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupPageActivity extends AppCompatActivity {
    GridView gridView;
    List<String> postName = Arrays.asList("Finished the Login UI", "Working on User Profile", "Check out the invite page","Check out this logo");
    List<Integer> postImages = Arrays.asList(R.drawable.login, R.drawable.profile, R.drawable.invite, R.drawable.react);
    Spinner spinner, spinner2;
    Button poll, record, chat, groupVotes;
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_group);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        spinner2.setVisibility(View.GONE);
        poll = findViewById(R.id.btnpoll);
        poll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPollActivity();
            }
        });
        record = findViewById(R.id.recordbtn);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecordActivity();
            }
        });
        chat = findViewById(R.id.btnchat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatActivity();
            }
        });
        groupVotes = findViewById(R.id.group_votes);
        groupVotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGroupFeedbackActivity();
            }
        });

        gridView = findViewById(R.id.grid);
        GroupPageActivity.customAdapter customAdapter = new GroupPageActivity.customAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), GridViewActivity.class);
                intent.putExtra("name", postName.get(position));
                intent.putExtra("image", postImages.get(position));
                startActivity(intent);
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
                    default:
                        return;

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private class customAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return postImages.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.activity_post, null);
            TextView name = view.findViewById(R.id.posttext);
            ImageView image = view.findViewById(R.id.postimage);
            name.setText(postName.get(position));
            image.setImageResource(postImages.get(position));
            return view;
        }
    }

    private void openPollActivity() {
        Intent intent = new Intent(this,pollActivity.class);
        startActivity(intent);
    }
    private void openRecordActivity() {
        Intent intent = new Intent(this,recordActivity.class);
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
    private void openTodoActivity() {
        Intent intent = new Intent(this,todoActivity.class);
        startActivity(intent);
    }
    private void openChatActivity() {
        Intent intent = new Intent(this,GroupActivity.class);
        startActivity(intent);
    }
    private void goToGroupFeedbackActivity() {
        Intent intent = new Intent(this,GroupFeedbackActivity.class);
        startActivity(intent);
    }
}
