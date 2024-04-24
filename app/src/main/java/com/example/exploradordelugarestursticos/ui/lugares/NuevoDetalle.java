package com.example.exploradordelugarestursticos.ui.lugares;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.exploradordelugarestursticos.databinding.FragmentNuevoDetalleBinding;
import com.example.exploradordelugarestursticos.entidades.LugarTuristico;

import java.util.ArrayList;
import java.util.List;

public class NuevoDetalle extends Fragment {


    private NuevoDetalleViewModel mViewModel;
    private FragmentNuevoDetalleBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        mViewModel= new ViewModelProvider(this).get(NuevoDetalleViewModel.class);
        binding = FragmentNuevoDetalleBinding.inflate(inflater,container,false);

        View root = binding.getRoot();
        mViewModel.getTuristicoMutableLiveData().observe(getViewLifecycleOwner(), new Observer<LugarTuristico>() {
            @Override
            public void onChanged(LugarTuristico lugarTuristico) {
                List<Integer> listafoto = lugarTuristico.getFoto();
                binding.imageView2.setImageResource(listafoto.get(0));
                binding.imageView3.setImageResource(listafoto.get(1));
                binding.imageView4.setImageResource(listafoto.get(2));
                binding.tvTitulodetalle.setText(lugarTuristico.getNombre());
                binding.tvHorarios.setText(lugarTuristico.getHorarios());
            }
        });


        mViewModel.recuperarLugar(getArguments());
        return root;
    }



}