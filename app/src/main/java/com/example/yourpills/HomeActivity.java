package com.example.yourpills;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class HomeActivity extends AppCompatActivity {
    private DB DB;
    private CalendarView calendarView;
    private String selectedDate;
    private SQLiteDatabase sqLiteDatabase;
    private Button rotina, login1;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.bottom_nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item2:
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);

        }

        switch (item.getItemId()){
            case R.id.item3:
                Intent intent = new Intent(getApplicationContext(), ComprimidosActivity.class);
                startActivity(intent);
        }

        switch (item.getItemId()){
            case R.id.item4:
                Intent intent = new Intent(getApplicationContext(), ReicetasActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        calendarView = findViewById(R.id.calendarView);
        rotina = (Button) findViewById(R.id.rotina);
        login1 = (Button) findViewById(R.id.login1);



        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        rotina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RotinaActivity.class);
                startActivity(intent);
            }
        });



    }
}