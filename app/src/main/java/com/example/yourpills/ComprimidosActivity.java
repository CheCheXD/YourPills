package com.example.yourpills;

import static com.example.yourpills.R.id.item2;
import static com.example.yourpills.R.id.item3;
import static com.example.yourpills.R.id.item4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ComprimidosActivity extends AppCompatActivity {

    RecyclerView view;
    FloatingActionButton add;
    private Button volta1;
    private BottomNavigationView BottomMenu2 = findViewById(R.id.BottomMenu2);
    ImageView empty_imageview;
    TextView textView4;

    DB myDB;
    ArrayList<String> comp_id, name_comp, mil_comp, med_comp, emb_comp, date_comp;
    CustomAdapter customAdapter;


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
        empty_imageview = findViewById(R.id.empty_imageView);
        textView4 = findViewById(R.id.textView4);

        myDB = new DB(ComprimidosActivity.this);
        comp_id = new ArrayList<>();
        name_comp = new ArrayList<>();
        mil_comp = new ArrayList<>();
        med_comp = new ArrayList<>();
        emb_comp = new ArrayList<>();
        date_comp = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(ComprimidosActivity.this,this, comp_id, name_comp, mil_comp, med_comp, emb_comp,
                date_comp);
        view.setAdapter(customAdapter);
        view.setLayoutManager(new LinearLayoutManager(ComprimidosActivity.this));



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
                    case item2:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0,0);
                }

                switch (item.getItemId()){
                    case item3:
                        startActivity(new Intent(getApplicationContext(), ComprimidosActivity.class));
                        overridePendingTransition(0,0);
                }

                switch (item.getItemId()){
                    case item4:
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

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            empty_imageview.setVisibility(View.VISIBLE);
            textView4.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                comp_id.add(cursor.getString(0));
                name_comp.add(cursor.getString(1));
                mil_comp.add(cursor.getString(2));
                med_comp.add(cursor.getString(3));
                emb_comp.add(cursor.getString(4));
                date_comp.add(cursor.getString(5));
            }
            empty_imageview.setVisibility(View.GONE);
            textView4.setVisibility(View.GONE);
        }
    }

    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1);
        recreate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}