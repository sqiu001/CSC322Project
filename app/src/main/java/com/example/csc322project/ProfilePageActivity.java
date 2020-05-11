package com.example.csc322project;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfilePageActivity extends AppCompatActivity {
    private static int RESULT_LOAD_IMAGE = 1;
    Spinner spinner, spinner2;
    FloatingActionButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_profile_page);
        spinner2 = findViewById(R.id.spinner2);
        spinner2.setVisibility(View.GONE);
        btn = findViewById(R.id.change);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PopUpActivity.class);
                startActivity(intent);
            }
        });
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 1:
                        openBrowseActivity();
                        break;
                    case 2:
                        openInviteActivity();
                        break;
                    case 3:
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

        ImageView buttonLoadImage = (ImageView) findViewById(R.id.edit);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

//                Intent i = new Intent(
//                        Intent.ACTION_PICK,
//                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//
//                startActivityForResult(i, RESULT_LOAD_IMAGE);
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType("image/*");
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
//            Uri selectedImage = data.getData();
//            String[] filePathColumn = { MediaStore.Images.Media.DATA };
//
//            Cursor cursor = getContentResolver().query(selectedImage,
//                    filePathColumn, null, null, null);
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            String picturePath = cursor.getString(columnIndex);
//            cursor.close();
//
//            CircleImageView imageView = findViewById(R.id.profile);
//            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
////            Bitmap bitmapProfilePic = BitmapFactory.decodeFile(picturePath);
////            Bitmap b = BitmapFactory.decodeByteArray(bitmapProfilePic , 0, bitmapProfilePic);
////            imageView.setImageBitmap(Bitmap.createScaledBitmap(b, 120, 120, false));
//        }
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK){
            CircleImageView imageView = findViewById(R.id.profile);
            Uri imageUri = data.getData();
            imageView.setImageURI(imageUri);

        }


    }
    private void openTodoActivity() {
        Intent intent = new Intent(this,todoActivity.class);
        startActivity(intent);
    }

    private void openLogoutActivity () {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        private void openHomeActivity () {
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
        }
        private void openBrowseActivity () {
            Intent intent = new Intent(this, BrowseActivity.class);
            startActivity(intent);
        }
        private void openInviteActivity () {
            Intent intent = new Intent(this, InviteActivity.class);
            startActivity(intent);
        }
        private void openComplainActivity () {
            Intent intent = new Intent(this, ComplainActivity.class);
            startActivity(intent);
        }
        private void openGroupActivity () {
            Intent intent = new Intent(this, GroupActivity.class);
            startActivity(intent);
        }
        private void openScheduleActivity () {
            Intent intent = new Intent(this, Schedule.class);
            startActivity(intent);
        }
        private void openVoteActivity () {
            Intent intent = new Intent(this, VoteActivity.class);
            startActivity(intent);
        }
    }

