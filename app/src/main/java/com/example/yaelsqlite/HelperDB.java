package com.example.yaelsqlite;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.yaelsqlite.grades.AGE;
import static com.example.yaelsqlite.grades.GRADE;
import static com.example.yaelsqlite.grades.SUBJECT;
import static com.example.yaelsqlite.grades.TABLE_GRADES;
import static com.example.yaelsqlite.personInfo.KEY_ID;
import static com.example.yaelsqlite.personInfo.STUDENT_ID;
import static com.example.yaelsqlite.personInfo.STUDENT_NAME;
import static com.example.yaelsqlite.personInfo.TABLE_PERSONINFO;


public class HelperDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbexam.db";
    private static final int DATABASE_VERSION = 1;
    String strCreate, strDelete;


    public HelperDB( Context context) {
        super(context,DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        strCreate="CREATE TABLE "+TABLE_PERSONINFO;
        strCreate+=" ("+KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+STUDENT_ID+" TEXT,";
        strCreate+=" "+ STUDENT_NAME+" TEXT";
        strCreate+=");";
        db.execSQL(strCreate);

        strCreate="CREATE TABLE "+TABLE_GRADES;
        strCreate+=" ("+grades.KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+AGE+" TEXT,";
        strCreate+=" "+SUBJECT+" INTEGER,";
        strCreate+=" "+GRADE+" INTEGER";
        strCreate+=");";
        db.execSQL(strCreate);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        strDelete = "DROP TABLE IF EXISTS " + TABLE_PERSONINFO;
        db.execSQL(strDelete);
        strDelete = "DROP TABLE IF EXISTS " + TABLE_GRADES;
        db.execSQL(strDelete);
        onCreate(db);
    }
}
