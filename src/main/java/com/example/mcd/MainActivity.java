package com.example.mcd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    EditText et_name_first_time;
    Intent i;
    Button button;
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getPreferences(MODE_PRIVATE);
        int a = sp.getInt("hasvisited1", 0);
        if (a == 1) {
            i = new Intent(this, MainMenu.class);
            startActivity(i);
        }
    }

    public void click(View view) {

        et_name_first_time = findViewById(R.id.editTextTextPersonName);
        String name = String.valueOf(et_name_first_time.getText());

        if (name.matches(""))  {
            Toast.makeText(this, "Please write your name", Toast.LENGTH_SHORT).show();
        }
        else if (name.length() < 3) {
            Toast.makeText(this, "Length of the name is too short.", Toast.LENGTH_SHORT).show();
        }
        else {
            sp = getSharedPreferences("1_2",MODE_PRIVATE);
            SharedPreferences.Editor ed = sp.edit();
            ed.putString("user_name", name);
            ed.apply();

            sp = getPreferences(MODE_PRIVATE);
            ed = sp.edit();
            ed.putInt("hasvisited1", 1);
            ed.apply();
            Log.i(TAG, "Name and hasvivsited1 saved");

            i = new Intent(this, MainMenu.class);
            startActivity(i);
        }
    }
}