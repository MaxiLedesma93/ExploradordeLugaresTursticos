package com.example.exploradordelugarestursticos.ui.lugares;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exploradordelugarestursticos.databinding.FragmentLugaresBinding;
import com.example.exploradordelugarestursticos.entidades.LugarTuristico;

import java.util.List;

public class LugaresFragment extends Fragment {

    private FragmentLugaresBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LugaresViewModel lugaresViewModel =
                new ViewModelProvider(this).get(LugaresViewModel.class);

        binding = FragmentLugaresBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        lugaresViewModel.getMutableLista().observe(getViewLifecycleOwner(), new Observer<List<LugarTuristico>>() {
            @Override
            public void onChanged(List<LugarTuristico> lugarTuristicos) {
                LugarAdapter lugarAdapter = new LugarAdapter(lugarTuristicos,getContext());
                GridLayoutManager gridLayout = new GridLayoutManager(getContext(),1, GridLayoutManager.VERTICAL, false);
                RecyclerView rc = binding.listaLugares;
                rc.setLayoutManager(gridLayout);
                rc.setAdapter(lugarAdapter);

            }
        });
        lugaresViewModel.cargarLugares();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}