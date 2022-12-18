package com.example.yourpills;

import static com.example.yourpills.R.id.BottomMenu2;
import static com.example.yourpills.R.id.item4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ComprimidosActivity extends AppCompatActivity {

    RecyclerView view;
    FloatingActionButton add;
    private Button volta1;
    private BottomNavigationView BottomMenu2 = findViewById(R.id.BottomMenu2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprimidos);

        view = findViewById(R.id.view);
        add = findViewById(R.id.add);
        volta1 = (Button) findViewById(R.id.voltar1);
        BottomMenu2.setSelectedItemId(R.id.item2);
        BottomMenu2.setSelectedItemId(R.id.item3);
        BottomMenu2.setSelectedItemId(item4);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarCompActivity.class);
                startActivity(intent);
            }
        });

        BottomMenu2.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
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

        volta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}