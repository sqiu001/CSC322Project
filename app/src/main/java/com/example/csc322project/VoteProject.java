package com.example.csc322project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class VoteProject extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7,btnHome,btnEnd;
    TextView sc1, sc2, sc3, sc4, sc5, sc6, sc7;

    int s1 = 0;
    int s2 = 0;
    int s3 = 0;
    int s4 = 0;
    int s5 = 0;
    int s6 = 0;
    int s7 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_project);
//        getSupportActionBar().setTitle("VoteProject");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Button btn1 = (Button)findViewById(R.id.buttonP1);
        final Button btn2 = (Button)findViewById(R.id.buttonP2);
        final Button btn3 = (Button)findViewById(R.id.buttonP3);
        final Button btn4 = (Button)findViewById(R.id.buttonP4);
        final Button btn5 = (Button)findViewById(R.id.buttonP5);
        final Button btn6 = (Button)findViewById(R.id.buttonP6);
        final Button btn7 = (Button)findViewById(R.id.buttonP7);
        final Button btnEnd = (Button)findViewById(R.id.buttonEnd);
        final  Button btnHome = (Button)findViewById(R.id.buttonHome);
        sc1 = (TextView) findViewById(R.id.score1);
        sc2 = (TextView) findViewById(R.id.score2);
        sc3 = (TextView) findViewById(R.id.score3);
        sc4 = (TextView) findViewById(R.id.score4);
        sc5 = (TextView) findViewById(R.id.score5);
        sc6 = (TextView) findViewById(R.id.score6);
        sc7 = (TextView) findViewById(R.id.score7);



        sc1.setText("VOTE: " + s1);
        sc2.setText("VOTE: " + s2);
        sc3.setText("VOTE: " + s3);
        sc4.setText("VOTE: " + s4);
        sc5.setText("VOTE: " + s5);
        sc6.setText("VOTE: " + s6);
        sc7.setText("VOTE: " + s7);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                goToHome();
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor= preferences.edit();
                editor.putInt("lastScore1", s1);
                editor.putInt("lastScore2", s2);
                editor.putInt("lastScore3", s3);
                editor.putInt("lastScore4", s4);
                editor.putInt("lastScore5", s5);
                editor.putInt("lastScore6", s6);
                editor.putInt("lastScore7", s7);
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), VoteProject.class);
                startActivity(intent);
                finish();


            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                s1++;
                sc1.setText("VOTE: " + s1);
                btn1.setEnabled(false);


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                s2++;
                sc2.setText("VOTE: " + s2);
                btn2.setEnabled(false);


            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                s3++;
                sc3.setText("VOTE: " + s3);
                btn3.setEnabled(false);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                s4++;
                sc4.setText("VOTE: " + s4);
                btn4.setEnabled(false);

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                s5++;
                sc5.setText("VOTE: " + s5);
                btn5.setEnabled(false);


            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                s6++;
                sc6.setText("VOTE: " + s6);
                btn6.setEnabled(false);


            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                s7++;
                sc7.setText("VOTE: " + s7);
                btn7.setEnabled(false);

            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        @SuppressLint("WrongConstant") SharedPreferences preferences = getSharedPreferences("PREFS", MODE_APPEND);
        int a = preferences.getInt("score1", 0);
        int b = preferences.getInt("score2", 0);
        int c = preferences.getInt("score3", 0);
        int d = preferences.getInt("score4", 0);
        int e = preferences.getInt("score5", 0);
        int f = preferences.getInt("score6", 0);
        int g = preferences.getInt("score7", 0);

        sc1.setText(String.valueOf(a));
        sc2.setText(String.valueOf(b));
        sc3.setText(String.valueOf(c));
        sc4.setText(String.valueOf(d));
        sc5.setText(String.valueOf(e));
        sc6.setText(String.valueOf(f));
        sc7.setText(String.valueOf(g));
    }
//    @Override
//    protected void onPause(){
//        super.onPause();
//
//        SharedPreferences sharedPreferences = getSharedPreferences("PREFS", MODE_PRIVATE);
//        SharedPreferences.Editor myEdit= sharedPreferences.edit();
//        myEdit.putInt("Score1",Integer.parseInt(sc1.getText().toString()));
//        myEdit.putInt("Score2",Integer.parseInt(sc2.getText().toString()));
//        myEdit.putInt("Score3",Integer.parseInt(sc3.getText().toString()));
//        myEdit.putInt("Score4",Integer.parseInt(sc4.getText().toString()));
//        myEdit.putInt("Score5",Integer.parseInt(sc5.getText().toString()));
//        myEdit.putInt("Score6",Integer.parseInt(sc6.getText().toString()));
//        myEdit.putInt("Score7",Integer.parseInt(sc7.getText().toString()));
//        myEdit.commit();
//    }



    //    public void project1UP(View view){
//        count1++;
//        btn1.setEnabled(false);
//        int finalcount1 = count1;
//    }
//    public void project2UP(View view){
//        count2++;
//        btn2.setEnabled(false);
//        int finalcount2 = count2;
//    }
//    public void project3UP(View view){
//        count3++;
//        btn3.setEnabled(false);
//        int finalcount3 = count3;
//    }
//    public void project4UP(View view){
//        count4++;
//        btn4.setEnabled(false);
//        int finalcount4 = count3;
//    }
//    public void project5UP(View view){
//        count5++;
//        btn5.setEnabled(false);
//        int finalcount5 = count3;
//    }
//    public void project6UP(View view){
//        count6++;
//        btn6.setEnabled(false);
//        int finalcount6 = count3;
//    }
//    public void project7UP(View view){
//        count7++;
//        btn7.setEnabled(false);
//        int finalcount7 = count3;
//    }
    private void goToHome() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

}