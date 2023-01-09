package com.example.yourpills;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class UpdateCompActivity extends AppCompatActivity {

    private EditText name_comp, mil_comp, med_comp, emb_comp, data_comp;
    private Button update, voltar;

    String id, nome, miligramas, medicamentos, embalagens, data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatecomp);
        name_comp = findViewById(R.id.name_comp1);
        mil_comp = findViewById(R.id.mil_comp1);
        med_comp = findViewById(R.id.med_comp1);
        emb_comp = findViewById(R.id.emb_comp1);
        data_comp = findViewById(R.id.date_comp1);
        update = findViewById(R.id.update);
        voltar = findViewById(R.id.voltar3);

        getAndSetIntentData();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB myDB = new DB(UpdateCompActivity.this);
                myDB.updateData(id, nome, miligramas, medicamentos, embalagens, data);

            }
        });
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") &&
                getIntent().hasExtra("nome") &&
                getIntent().hasExtra("miligramas") &&
                getIntent().hasExtra("medicamentos") &&
                getIntent().hasExtra("embalagens") &&
                getIntent().hasExtra("data")){
            //pega os dados partir do Intent
            id = getIntent().getStringExtra("id");
            nome = getIntent().getStringExtra("nome");
            miligramas = getIntent().getStringExtra("miligramas");
            medicamentos = getIntent().getStringExtra("medicamentos");
            embalagens = getIntent().getStringExtra("embalagens");
            data = getIntent().getStringExtra("data");

            name_comp.setText(nome);
            mil_comp.setText(miligramas);
            med_comp.setText(medicamentos);
            emb_comp.setText(embalagens);
            data_comp.setText(data);

        }else{
            Toast.makeText(this, "Sem Dados disponíveis", Toast.LENGTH_SHORT).show();
        }
    }
}