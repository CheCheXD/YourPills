package com.example.yourpills;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList comp_id, nome_comprimido, miligramas_comprimido, medicamentos_comprimido, embalagens_comprimido, data_comprimido;

    CustomAdapter(Context context,
                  ArrayList comp_id,
                  ArrayList nome_comprimido,
                  ArrayList miligramas_comprimido,
                  ArrayList medicamentos_comprimido,
                  ArrayList embalagens_comprimido,
                  ArrayList data_comprimido){
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
