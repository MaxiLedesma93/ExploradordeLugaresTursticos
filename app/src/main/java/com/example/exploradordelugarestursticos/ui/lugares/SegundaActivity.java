package com.example.exploradordelugarestursticos.ui.lugares;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.exploradordelugarestursticos.R;
import com.example.exploradordelugarestursticos.databinding.ActivitySegundaBinding;
import com.example.exploradordelugarestursticos.entidades.LugarTuristico;

import java.util.ArrayList;

public class SegundaActivity extends AppCompatActivity {
    private DetalleLugarViewModel vmDetalle;
    private ActivitySegundaBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySegundaBinding.inflate(getLayoutInflater());
        vmDetalle= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(DetalleLugarViewModel.class);
        setContentView(binding.getRoot());

        vmDetalle.getTuristicoMutableLiveData().observe(this, new Observer<LugarTuristico>() {
            @Override
            public void onChanged(LugarTuristico lugarTuristico) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int foto: lugarTuristico.getFoto()
                ) {
                    list.add(foto);
                }
                TextView titulo = binding.tvTitulo;
                TextView horarios = binding.tvHorarios;
                ImageView imageView1 = binding.imv1;
                ImageView imageView2 = binding.imv2;
                ImageView imageView3 = binding.imv3;
                titulo.setText(lugarTuristico.getNombre());
                horarios.setText(lugarTuristico.getHorarios());
                imageView1.setImageResource(list.get(0));
                imageView2.setImageResource(list.get(1));
                imageView3.setImageResource(list.get(2));
            }
        });

        vmDetalle.recuperarLugar(getIntent());





    }
}