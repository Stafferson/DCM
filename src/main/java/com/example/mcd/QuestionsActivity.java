package com.example.mcd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileReader;
import java.util.Calendar;

public class QuestionsActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    Button first_var, second_var, third_var, fourth_var;
    Intent i;
    int dayoftheweek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        first_var = findViewById(R.id.button_activityquestions_1variant);
        second_var = findViewById(R.id.button_activityquestions_2variant);
        third_var = findViewById(R.id.button_activityquestions_3variant);
        fourth_var = findViewById(R.id.button_activityquestions_4variant);
        i = new Intent(this, questions.class);
        Calendar calendar = Calendar.getInstance();
        dayoftheweek = calendar.get(Calendar.DAY_OF_WEEK);
    }

    public void first_variant_onClick(View view) {
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        startActivity(i);
    }

    public void second_variant_onClick(View view) {
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        startActivity(i);
    }

    public void third_variant_onClick(View view) {
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        switch (dayoftheweek) {
            case 1:
                ed.putInt("SUNDAY", (sp.getInt("SUNDAY", 0) + 1));
            case 2:
                ed.putInt("MONDAY", (sp.getInt("MONDAY", 0) + 1));
            case 3:
                ed.putInt("TUESDAY", (sp.getInt("TUESDAY", 0) + 1));
            case 4:
                ed.putInt("WEDNESDAY", (sp.getInt("WEDNESDAY", 0) + 1));
            case 5:
                ed.putInt("THURSDAY", (sp.getInt("THURSDAY", 0) + 1));
            case 6:
                ed.putInt("FRIDAY", (sp.getInt("FRIDAY", 0) + 1));
            case 7:
                ed.putInt("SATURDAY", (sp.getInt("SATURDAY", 0) + 1));
                ed.apply();
                ed.clear();
        }
        startActivity(i);
    }

    public void fourth_variant_onClick(View view) {
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        switch (dayoftheweek) {
            case 1:
                ed.putInt("SUNDAY", (sp.getInt("SUNDAY", 0) + 2));
            case 2:
                ed.putInt("MONDAY", (sp.getInt("MONDAY", 0) + 2));
            case 3:
                ed.putInt("TUESDAY", (sp.getInt("TUESDAY", 0) + 2));
            case 4:
                ed.putInt("WEDNESDAY", (sp.getInt("WEDNESDAY", 0) + 2));
            case 5:
                ed.putInt("THURSDAY", (sp.getInt("THURSDAY", 0) + 2));
            case 6:
                ed.putInt("FRIDAY", (sp.getInt("FRIDAY", 0) + 2));
            case 7:
                ed.putInt("SATURDAY", (sp.getInt("SATURDAY", 0) + 2));
                ed.apply();
                ed.clear();
        startActivity(i);
    }

    /*public void variant_onClick(View v) {
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        Log.i(TAG, "QWERTYUIOP[]ASDFGHJKL;'ZXCVBNM,./");
        switch (v.getId()) {
            case R.id.button_activityquestions_1variant:
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
            case R.id.button_activityquestions_2variant:
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
            case R.id.button_activityquestions_3variant:
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
            case R.id.button_activityquestions_4variant:
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
        }
    }*/
    }
}