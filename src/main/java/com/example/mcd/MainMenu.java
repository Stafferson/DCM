package com.example.mcd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class MainMenu extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    SharedPreferences sp;
    TextView tv_name;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        /*Date date = new Date();
        tv_name = findViewById(R.id.textViewName);
        tv_name.setText(date.toString());*/

        /*sp = getSharedPreferences("1_2", MODE_PRIVATE);
        String name = sp.getString("user_name", "-1");
        tv_name = findViewById(R.id.textViewName);
        tv_name.setText(name + "");*/
        /*tv_name = findViewById(R.id.textViewName);

        dbHelper = new DBHelper(this);

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        Date date = new Date();
        cv.put(DBHelper.KEY_DATE, String.valueOf(date));
        database.insert(DBHelper.TABLE_DAYS_INFO, null, cv);
        Cursor cursor = database.query(DBHelper.TABLE_DAYS_INFO, null, null, null, null, null, null);
        String date1 = String.valueOf(cursor.getColumnIndex(DBHelper.KEY_DATE));
        tv_name.setText(date1 + "");*/
    }

    public void Button_information_onlick(View view) {
    }

    public void Button_statistics_onlick(View view) {
    }

    public void button_question_onclick(View view) {
        Intent i = new Intent(this, QuestionsActivity.class);
        startActivity(i);
    }

    //public void Button_options_onclick(View view) {
    //}
    public void Button_options_onclick(View view) {
        tv_name = findViewById(R.id.textViewName);

        dbHelper = new DBHelper(this);

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        Date date = new Date();

        /*cv.put(DBHelper.KEY_DATE, String.valueOf(date));
        cv.put(DBHelper.KEY_FEELING_ANGER, 1);
        cv.put(DBHelper.KEY_FEELING_ANXIETY, 2);
        cv.put(DBHelper.KEY_FEELING_CONFIDENCE, 3);
        cv.put(DBHelper.KEY_FEELING_DEPRESSION, 4);
        cv.put(DBHelper.KEY_FEELING_FEAR, 5);
        cv.put(DBHelper.KEY_FEELING_HAPPINESS, 6);
        cv.put(DBHelper.KEY_FEELING_INTEREST, 7);
        cv.put(DBHelper.KEY_FEELING_IRRITATION, 8);
        cv.put(DBHelper.KEY_FEELING_STRESS, 9);
        cv.put(DBHelper.KEY_FEELING_SAD, 10);*/

        //database.insert(DBHelper.TABLE_DAYS_INFO, null, cv);

        Cursor cursor = database.query(DBHelper.TABLE_DAYS_INFO, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int id1 = cursor.getColumnIndex(DBHelper.KEY_ID);
            int id2 =  cursor.getColumnIndex(DBHelper.KEY_DATE);
            int id3 =  cursor.getColumnIndex(DBHelper.KEY_FEELING_ANGER);
            int id4 =  cursor.getColumnIndex(DBHelper.KEY_FEELING_ANXIETY);
            int id5 =  cursor.getColumnIndex(DBHelper.KEY_FEELING_CONFIDENCE);
            int id6 =  cursor.getColumnIndex(DBHelper.KEY_FEELING_DEPRESSION);
            int id7 =  cursor.getColumnIndex(DBHelper.KEY_FEELING_FEAR);
            int id8 =  cursor.getColumnIndex(DBHelper.KEY_FEELING_HAPPINESS);
            int id9 =  cursor.getColumnIndex(DBHelper.KEY_FEELING_INTEREST);
            int id10 =  cursor.getColumnIndex(DBHelper.KEY_FEELING_IRRITATION);
            int id11 =  cursor.getColumnIndex(DBHelper.KEY_FEELING_STRESS);
            int id12 =  cursor.getColumnIndex(DBHelper.KEY_FEELING_SAD);
            do {
                Log.d("mLog", "ID = " + cursor.getInt(id1) + cursor.getString(id2) + cursor.getInt(id3) +
                        cursor.getInt(id4) + cursor.getInt(id5) + cursor.getInt(id6) + cursor.getInt(id7) +
                        cursor.getInt(id8) + cursor.getInt(id9) + cursor.getInt(id10) + cursor.getInt(id11) + cursor.getInt(id12));
                String p = tv_name.getText().toString();
            } while (cursor.moveToNext());
        } else {
            Log.d("MainMenuLog", "0 rows");
            tv_name.setText("F");
        }

        String date1 = String.valueOf(cursor.getColumnIndex(DBHelper.KEY_DATE));
        tv_name.setText(date1 + "");
    }
}