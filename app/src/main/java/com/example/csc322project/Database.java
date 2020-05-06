package com.example.csc322project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(Username text, email text primary key,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists user");
    }
    public boolean insert(String Username, String Password, String Email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username",Username);
        contentValues.put("Email",Email);
        contentValues.put("password",Password);
        long ins = db.insert("user", null, contentValues);
        if(ins == -1) return false;
        else return true;
    }
    public Boolean chkuser(String Email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where Email=?", new String[]{Email});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    public Boolean checkAccount(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where Username=? and Password=?", new String[]{username,password});
        if(cursor.getCount()>0) return true;
        else return false;
    }
}
