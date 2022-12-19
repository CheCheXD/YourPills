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
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.CalendarView;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AdicionarCompActivity extends AppCompatActivity {

    EditText name_comp, mil_comp, med_comp, emb_comp, data_comp;
    Button inserir, voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_comp);

        name_comp = findViewById(R.id.name_comp);
        mil_comp = findViewById(R.id.mil_comp);
        med_comp = findViewById(R.id.med_comp);
        emb_comp = findViewById(R.id.emb_comp);
        data_comp = findViewById(R.id.date_comp);
        inserir = findViewById(R.id.inserir);
        voltar= findViewById(R.id.voltar2);
        inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB MyDB = new DB(AdicionarCompActivity.this);
                MyDB.addComp(name_comp.getText().toString().trim(),
                        mil_comp.getText().toString().trim(),
                        med_comp.getText().toString().trim(),
                        emb_comp.getText().toString().trim(),
                        data_comp.getText().toString().trim(),
                        Integer.valueOf(name_comp.getText().toString().trim()));}
        });

    }
}