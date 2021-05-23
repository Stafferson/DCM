package com.example.mcd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Date;

import static java.sql.Types.DATE;
import static java.sql.Types.NULL;

public class DBHelper extends SQLiteOpenHelper {

    private final String TAG = this.getClass().getSimpleName();
    DBHelper dbHelper;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DCM_DATABASE";
    //private static final String TABLE_WEEK_INFO = "TABLE_WEEK_INFO"; ///NOW SAVED BY USING SHAREDPREFERENCES///
    public static final String TABLE_DAYS_INFO = "TABLE_INFO";

    public static final String KEY_ID = "_id";
    public static final String KEY_DATE = "date";
    public static final String KEY_FEELING_ANXIETY = "anxiety";
    public static final String KEY_FEELING_HAPPINESS = "happiness";     // <--  Happiness is a drug
    public static final String KEY_FEELING_INTEREST =  "interest";      //      Happiness don't pull the rug on
    public static final String KEY_FEELING_ANGER = "anger";             //      Happiness has begun
    public static final String KEY_FEELING_STRESS = "stress";           //      Happiness that's never undone
    public static final String KEY_FEELING_DEPRESSION = "depression";   // (c) Shawn Lee
    public static final String KEY_FEELING_FEAR = "fear";
    public static final String KEY_FEELING_IRRITATION = "irritation";
    public static final String KEY_FEELING_CONFIDENCE = "confidence";
    public static final String KEY_FEELING_SAD = "confidence";

    String query = "create table " + TABLE_DAYS_INFO + "(" + KEY_ID + " integer primary key," // creating sqlite query to create db
            + KEY_DATE + " text,"
            + KEY_FEELING_ANXIETY + " integer,"
            + KEY_FEELING_HAPPINESS + " integer,"
            + KEY_FEELING_INTEREST + " integer,"
            + KEY_FEELING_ANGER + " integer,"
            + KEY_FEELING_STRESS + " integer,"
            + KEY_FEELING_DEPRESSION + " integer,"
            + KEY_FEELING_FEAR + " integer,"
            + KEY_FEELING_IRRITATION + " integer,"
            + KEY_FEELING_CONFIDENCE + " integer"
            + KEY_FEELING_SAD + "integer" + ")";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query); // creating db
        Log.i(TAG, "Db created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_DAYS_INFO);
    }
}
