package com.example.yourpills;

import static com.example.yourpills.R.id.item4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    // isto é para criar variaveis
    private DB DB;
    private CalendarView calendarView;
    private String selectedDate;
    private SQLiteDatabase sqLiteDatabase;
    private Button rotina, login1;
    private BottomNavigationView BottomMenu;




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.bottom_nav_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // este código ira procurar no layout o id das variaveis

        calendarView = findViewById(R.id.calendarView);
        rotina = (Button) findViewById(R.id.rotina);
        login1 = (Button) findViewById(R.id.login1);
        BottomMenu = findViewById(R.id.BottomMenu);
        BottomMenu.setSelectedItemId(R.id.item2);
        BottomMenu.setSelectedItemId(R.id.item3);
        BottomMenu.setSelectedItemId(item4);

        BottomMenu.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.item2:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0,0);
                }

                switch (item.getItemId()){
                    case R.id.item3:
                        startActivity(new Intent(getApplicationContext(), ComprimidosActivity.class));
                        overridePendingTransition(0,0);
                }

                switch (item.getItemId()){
                    case R.id.item4:
                        startActivity(new Intent(getApplicationContext(), ReceitasActivity.class));
                        overridePendingTransition(0,0);
                }

            }
        });

        // com este código a variavel vai chamar a página MainActivity
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        // e com este código a variavel rotina vai chamar a página RotinaActivity
        rotina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RotinaActivity.class);
                startActivity(intent);
            }
        });



    }
}