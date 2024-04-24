package com.example.exploradordelugarestursticos.ui.salir;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.exploradordelugarestursticos.R;
import com.example.exploradordelugarestursticos.databinding.FragmentSalirBinding;
import com.example.exploradordelugarestursticos.entidades.Dialogo;


public class SalirFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private FragmentSalirBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      //  dialogo = new Dialogo();
        binding = FragmentSalirBinding.inflate(inflater,container,false);
        View root = binding.getRoot();


        binding.btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Dialogo.salir(getContext());

            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}