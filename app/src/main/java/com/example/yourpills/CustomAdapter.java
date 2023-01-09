package com.example.yourpills;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList comp_id, nome_comprimido, miligramas_comprimido, medicamentos_comprimido, embalagens_comprimido, data_comprimido;


    CustomAdapter(Activity activity,
                  Context context,
                  ArrayList comp_id,
                  ArrayList nome_comprimido,
                  ArrayList miligramas_comprimido,
                  ArrayList medicamentos_comprimido,
                  ArrayList embalagens_comprimido,
                  ArrayList data_comprimido){
        this.activity = activity;
        this.context = context;
        this.comp_id = comp_id;
        this.nome_comprimido = nome_comprimido;
        this.miligramas_comprimido = miligramas_comprimido;
        this.medicamentos_comprimido = medicamentos_comprimido;
        this.embalagens_comprimido = embalagens_comprimido;
        this.data_comprimido = data_comprimido;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_recyclerview, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.comp_id_txt.setText(String.valueOf(comp_id.get(position)));
        holder.nome_comprimido_txt.setText(String.valueOf(nome_comprimido.get(position)));
        holder.miligramas_comprimido_txt.setText(String.valueOf(miligramas_comprimido.get(position)));
        holder.medicamentos_comprimido_txt.setText(String.valueOf(medicamentos_comprimido.get(position)));
        holder.embalagens_comprimido_txt.setText(String.valueOf(embalagens_comprimido.get(position)));
        holder.data_comprimido_txt.setText(String.valueOf(data_comprimido.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateCompActivity.class);
                intent.putExtra("id", String.valueOf(comp_id.get(position)));
                intent.putExtra("nome", String.valueOf(nome_comprimido.get(position)));
                intent.putExtra("miligramas", String.valueOf(miligramas_comprimido.get(position)));
                intent.putExtra("medicamentos", String.valueOf(medicamentos_comprimido.get(position)));
                intent.putExtra("embalagens", String.valueOf(embalagens_comprimido.get(position)));
                intent.putExtra("data", String.valueOf(data_comprimido.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return comp_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView comp_id_txt, nome_comprimido_txt, miligramas_comprimido_txt, medicamentos_comprimido_txt, embalagens_comprimido_txt, data_comprimido_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            comp_id_txt = itemView.findViewById(R.id.comprimido_id_txt);
            nome_comprimido_txt = itemView.findViewById(R.id.name_comp_txt);
            miligramas_comprimido_txt = itemView.findViewById(R.id.mil_comp_txt);
            medicamentos_comprimido_txt = itemView.findViewById(R.id.med_comp_txt);
            embalagens_comprimido_txt = itemView.findViewById(R.id.emb_comp_txt);
            data_comprimido_txt = itemView.findViewById(R.id.date_comp_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);


        }
    }
}
