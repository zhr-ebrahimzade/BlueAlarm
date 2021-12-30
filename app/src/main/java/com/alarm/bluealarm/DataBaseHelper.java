package com.alarm.bluealarm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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
    //table for doctors
    public static final String DOCTOR_TABLE = "DOCTOR_TABLE";
    public static final String COLUMN_DOCTOR_ID = "ID";
    public static final String COLUMN_DOCTOR_NAME = "DOCTOR_NAME";
    public static final String COLUMN_DOCTOR_SPECIALITY = "DOCTOR_SPECIALITY";
    public static final String COLUMN_DOCTOR_REMINDING = "DOCTOR_REMINDING";
    public static final String COLUMN_DOCTOR_DATE = "DOCTOR_DATE";
    public static final String COLUMN_DOCTOR_TIME = "DOCTOR_TIME";
    //table for records
    public static final String RECORD_TABLE = "RECORD_TABLE";
    public static final String COLUMN_RECORD_ID = "RECORD_ID";
    public static final String COLUMN_SYS = "SYS";
    public static final String COLUMN_DYA = "DYA";
    public static final String COLUMN_PLU = "PLU";
    public static final String COLUMN_FBS = "FBS";



    public DataBaseHelper(@Nullable Context context) {
        super(context, "blue_alarm.db", null, 2);

    }

    // table create statements
    String createTableStatement= "CREATE TABLE " + PILL_TABLE + " " +
            "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_PILL_NAME + " TEXT, " + COLUMN_PILL_COLOR + " TEXT, " + COLUMN_PILL_DAY + " TEXT" +
            "," + COLUMN_PILL_TIME + " INTEGER, " + COLUMN_PILL_DURATION + " INTEGER, " + COLUMN_PILL_DESCRIPTION + " TEXT, " + COLUMN_PILL_REMINDING + " INTEGER)";

    String createDoctorsTableStatement= "CREATE TABLE " + DOCTOR_TABLE + " (" + COLUMN_DOCTOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DOCTOR_NAME + " TEXT, " + COLUMN_DOCTOR_SPECIALITY + " TEXT, " + COLUMN_DOCTOR_REMINDING + " BOOL, " + COLUMN_DOCTOR_DATE + " TEXT, " + COLUMN_DOCTOR_TIME + " TEXT)";

    String createRecordTable= "CREATE TABLE " + RECORD_TABLE + " (" + COLUMN_RECORD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_SYS + " INTEGER, " + COLUMN_DYA + " INTEGER, " + COLUMN_PLU + " INTEGER, " + COLUMN_FBS + " INTEGER)";

    //this is called the first time a database is accessed.
    // There should be code here to create a new database.

    @Override
    public void onCreate(SQLiteDatabase db) {

        //creating required Tables

        db.execSQL(createDoctorsTableStatement);
        db.execSQL(createTableStatement);
        db.execSQL(createRecordTable);

    }


    //this is called if the database version number changes.
    // It prevents previous users app from breaking when you change the database design.

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+PILL_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+DOCTOR_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+RECORD_TABLE);

        onCreate(db);
    }

    public boolean addOnePill(Pills pills){
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

    public boolean addOneDoctor(Doctors doctors) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DOCTOR_NAME, doctors.getDrName());
        cv.put(COLUMN_DOCTOR_SPECIALITY, doctors.getDrSpeciality());
        cv.put(COLUMN_DOCTOR_REMINDING, doctors.isReminder());
        cv.put(COLUMN_DOCTOR_TIME, doctors.getDrTime());
        cv.put(COLUMN_DOCTOR_DATE, doctors.getDrDate());

        long insert = db.insert(DOCTOR_TABLE, null, cv);
        if (insert == -1)
            return false;
        else
            return true;

    }

    public boolean addOneRecord(Records records) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_SYS, records.getSys());
        cv.put(COLUMN_DYA, records.getDya());
        cv.put(COLUMN_PLU, records.getPlu());
        cv.put(COLUMN_FBS, records.getFbs());



        long insert = db.insert(RECORD_TABLE, null, cv);
        if (insert == -1)
            return false;
        else
            return true;

    }












    public List<Pills> getEveryPill(){
        List<Pills> returnList=new ArrayList<>();

        //get data from database
        String queryString= "SELECT * FROM "+ PILL_TABLE;
        SQLiteDatabase db=this.getReadableDatabase(); //I only want to read, not write
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst()){
            //loop through the cursor (result set) and create new Pills obj. put them into the return list.
            do {
                int pill_id=cursor.getInt(0);
                String pill_name=cursor. getString(1);
                String pill_color=cursor.getString(2);
                String pill_day=cursor.getString(3);
                String pill_time=cursor.getString(4);
                int pill_duration=cursor.getInt(5);
                String pill_description=cursor.getString(6);
                boolean alarmed=cursor.getInt(7) == 1;
                Pills pillsList=new Pills(pill_id,pill_name,pill_color,pill_day,pill_time,pill_duration,pill_description,alarmed);
                returnList.add(pillsList);

            }while (cursor.moveToNext()); // as long as there is new lines.


        }else {
            //failure. do not add anything to the list.
        }
        //close the cursor and the database when done.
        cursor.close();
        db.close();

        return returnList;
    }
}
