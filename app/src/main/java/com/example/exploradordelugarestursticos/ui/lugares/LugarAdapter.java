package com.example.exploradordelugarestursticos.ui.lugares;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exploradordelugarestursticos.R;
import com.example.exploradordelugarestursticos.entidades.LugarTuristico;

import java.util.List;

public class LugarAdapter extends RecyclerView.Adapter<LugarAdapter.viewHolder> {
    private List<LugarTuristico> lista;
    private Context contexto;

    public LugarAdapter(List<LugarTuristico> lista, Context contexto) {
        this.lista = lista;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(contexto).inflate(R.layout.cardlugar,parent,false);


        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        LugarTuristico lugarTuristico = lista.get(position);
        holder.nombre.setText(lugarTuristico.getNombre());
        holder.descripcion.setText(lugarTuristico.getDescripcion());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contexto, SegundaActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("lugar", lugarTuristico);
                contexto.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        TextView descripcion;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            descripcion = itemView.findViewById(R.id.descripcion);
        }


    }
}
