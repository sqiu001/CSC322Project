package com.example.csc322project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VisitorGroupActivity extends AppCompatActivity {
    GridView gridView;
    String[] postName = {"Finished the Login UI", "Working on User Profile", "Check out the invite page","Check out this logo"};
    int[] postImages = {R.drawable.login, R.drawable.profile, R.drawable.invite, R.drawable.react};
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_group);
        gridView = findViewById(R.id.grid);
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
}
