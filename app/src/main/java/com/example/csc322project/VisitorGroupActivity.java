package com.example.csc322project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VisitorGroupActivity extends AppCompatActivity {
    GridView gridView;
    String[] postName = {"Finished the Login UI", "Working on User Profile", "Check out the invite page","Check out this logo"};
    int[] postImages = {R.drawable.login, R.drawable.profile, R.drawable.invite, R.drawable.react};
    Spinner spinner, spinner2;
    Button poll, record, chat, groupVotes;
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_group);
        gridView = findViewById(R.id.grid);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        spinner.setVisibility(View.GONE);
        poll = findViewById(R.id.btnpoll);
        record = findViewById(R.id.recordbtn);
        chat = findViewById(R.id.btnchat);
        groupVotes = findViewById(R.id.group_votes);
        poll.setVisibility(View.GONE);
        record.setVisibility(View.GONE);
        chat.setVisibility(View.GONE);
        groupVotes.setVisibility(View.GONE);
        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), GridViewActivity.class);
                intent.putExtra("name", postName[position]);
                intent.putExtra("image", postImages[position]);
                startActivity(intent);
            }
        });
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
    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return postImages.length;
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
           name.setText(postName[position]);
           image.setImageResource(postImages[position]);
           return view;
        }
    }

    private void openHomeActivity() {
        Intent intent = new Intent(this,VisitorPageActivity.class);
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
    private void openRegisterActivity() {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
