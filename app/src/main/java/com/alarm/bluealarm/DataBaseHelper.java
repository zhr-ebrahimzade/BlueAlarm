package com.alarm.bluealarm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String PILL_TABLE = "PILL_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_PILL_NAME = "PILL_NAME";
    public static final String COLUMN_PILL_COLOR = "PILL_COLOR";
    public static final String COLUMN_PILL_DAY = "PILL_DAY";
    public static final String COLUMN_PILL_TIME = "PILL_TIME";
    public static final String COLUMN_PILL_DURATION = "PILL_DURATION";
    public static final String COLUMN_PILL_DESCRIPTION = "PILL_DESCRIPTION";
    public static final String COLUMN_PILL_REMINDING = "PILL_REMINDING";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "blue_alarm.db", null, 1);
    }


    //this is called the first time a database is accessed.
    // There should be code here to create a new database.

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + PILL_TABLE + " " +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_PILL_NAME + " TEXT, " + COLUMN_PILL_COLOR + " TEXT, " + COLUMN_PILL_DAY + " TEXT" +
                "," + COLUMN_PILL_TIME + " INTEGER, " + COLUMN_PILL_DURATION + " INTEGER, " + COLUMN_PILL_DESCRIPTION + " TEXT, " + COLUMN_PILL_REMINDING + " INTEGER)";
        db.execSQL(createTableStatement);

    }


    //this is called if the database version number changes.
    // It prevents previous users app from breaking when you change the database design.

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(Pills pills){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(COLUMN_PILL_NAME,pills.getPillName());
        cv.put(COLUMN_PILL_COLOR,pills.getPillColor());
        cv.put(COLUMN_PILL_DAY,pills.getPillDay());
        cv.put(COLUMN_PILL_TIME,pills.getPillTime());
        cv.put(COLUMN_PILL_DURATION,pills.getPillDuration());
        cv.put(COLUMN_PILL_DESCRIPTION,pills.getPillDescription());
        cv.put(COLUMN_PILL_REMINDING,pills.isAlarmed());

        long insert = db.insert(PILL_TABLE, null, cv);
        if (insert==-1)
            return false;
        else
            return true;

    }
}
