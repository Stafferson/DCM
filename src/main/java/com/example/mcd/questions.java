package com.example.mcd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class questions extends AppCompatActivity {

    Button var1, var2, var3, var4, var5, var6, var7, var8, var9,var10;
    DBHelper dbHelper;
    Intent i;

    static int counter;
    static int[] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions2);

        i = new Intent(this, MainMenu.class);
        arr = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        counter = 0;

        var1 = findViewById(R.id.button_activityquestions2_anger);
        var2 = findViewById(R.id.button_activityquestions2_anxiety);
        var3 = findViewById(R.id.button_activityquestions2_confidence);
        var4 = findViewById(R.id.button_activityquestions2_depression);
        var5 = findViewById(R.id.button_activityquestions2_fear);
        var6 = findViewById(R.id.button_activityquestions2_happiness);
        var7 = findViewById(R.id.button_activityquestions2_interest);
        var8 = findViewById(R.id.button_activityquestions2_irritation);
        var9 = findViewById(R.id.button_activityquestions2_sad);
        var10 = findViewById(R.id.button_activityquestions2_stress);
    }

    @Override
    protected void onPause() {
        super.onPause();
        dbHelper = new DBHelper(this);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.KEY_DATE, String.valueOf(date));
        cv.put(DBHelper.KEY_FEELING_ANGER, arr[0]);
        cv.put(DBHelper.KEY_FEELING_ANXIETY, arr[1]);
        cv.put(DBHelper.KEY_FEELING_CONFIDENCE, arr[2]);
        cv.put(DBHelper.KEY_FEELING_DEPRESSION, arr[3]);
        cv.put(DBHelper.KEY_FEELING_FEAR, arr[4]);
        cv.put(DBHelper.KEY_FEELING_HAPPINESS, arr[5]);
        cv.put(DBHelper.KEY_FEELING_INTEREST, arr[6]);
        cv.put(DBHelper.KEY_FEELING_IRRITATION, arr[7]);
        cv.put(DBHelper.KEY_FEELING_STRESS, arr[8]);
        cv.put(DBHelper.KEY_FEELING_SAD, arr[9]);

        database.insert(DBHelper.TABLE_DAYS_INFO, null, cv);
    }

    public void onClick_questionactivity(View view) {
        dbHelper = new DBHelper(this);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        switch (view.getId()) {
            case R.id.button_activityquestions2_anger:
                counter++;
                arr[0] += 1;
                Toast.makeText(this, "Anger", Toast.LENGTH_SHORT).show();
                if (counter == 3) {
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
                    cv.put(DBHelper.KEY_FEELING_SAD, 10);
                    Toast.makeText(this, "Please write your name", Toast.LENGTH_SHORT).show();*/
                    var1.setVisibility(View.GONE);
                    startActivity(i);
                }
                //
            case R.id.button_activityquestions2_anxiety:
                counter++;
                arr[1] += 1;
                Toast.makeText(this, "Anxiety", Toast.LENGTH_SHORT).show();
                if (counter == 3) {
                    //Toast.makeText(this, "Please write your name anx", Toast.LENGTH_SHORT).show();
                    var2.setVisibility(View.GONE);
                    startActivity(i);
                }
                //
            case R.id.button_activityquestions2_confidence:
                counter++;
                arr[2] += 1;
                if (counter == 3) {
                    var3.setVisibility(View.GONE);
                    startActivity(i);
                }
                //
            case R.id.button_activityquestions2_depression:
                counter++;
                arr[3] += 1;
                if (counter == 3) {
                    var4.setVisibility(View.GONE);
                    startActivity(i);
                }
                //
            case R.id.button_activityquestions2_fear:
                counter++;
                arr[4] += 1;
                if (counter == 3) {
                    var5.setVisibility(View.GONE);
                    startActivity(i);
                }
                //
            case R.id.button_activityquestions2_happiness:
                counter++;
                arr[5] += 1;
                if (counter == 3) {
                    var6.setVisibility(View.GONE);
                    startActivity(i);
                }
                //
            case R.id.button_activityquestions2_interest:
                counter++;
                arr[6] += 1;
                if (counter == 3) {
                    var7.setVisibility(View.GONE);
                    startActivity(i);
                }
                //
            case R.id.button_activityquestions2_irritation:
                counter++;
                arr[7] += 1;
                if (counter == 3) {
                    var8.setVisibility(View.GONE);
                    startActivity(i);
                }
                //
            case R.id.button_activityquestions2_sad:
                counter++;
                arr[8] += 1;
                if (counter == 3) {
                    var9.setVisibility(View.GONE);
                    startActivity(i);
                }
                //
            case R.id.button_activityquestions2_stress:
                counter++;
                arr[9] += 1;
                if (counter == 3) {
                    var10.setVisibility(View.GONE);
                    startActivity(i);
                }
        }
    }
}