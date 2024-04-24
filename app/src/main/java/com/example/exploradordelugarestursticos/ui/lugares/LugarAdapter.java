package com.example.exploradordelugarestursticos.ui.lugares;

import static com.example.exploradordelugarestursticos.R.id.action_nav_lugares_to_nuevoDetalle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exploradordelugarestursticos.R;
import com.example.exploradordelugarestursticos.entidades.LugarTuristico;

import java.util.List;

public class LugarAdapter extends RecyclerView.Adapter<LugarAdapter.viewHolder> {
    private List<LugarTuristico> lista;
    public Context contexto;


    public LugarAdapter(List<LugarTuristico> lista, Context contexto) {
        this.lista = lista;
        this.contexto = contexto;

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlugar,parent,false);

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
                Bundle bundle = new Bundle();
                bundle.putSerializable("lugar",lugarTuristico);
                Navigation.findNavController((Activity)contexto,R.id.nav_host_fragment_content_main).navigate(action_nav_lugares_to_nuevoDetalle,bundle);

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
