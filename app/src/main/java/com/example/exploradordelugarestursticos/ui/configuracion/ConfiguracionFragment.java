package com.example.exploradordelugarestursticos.ui.configuracion;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.exploradordelugarestursticos.R;
import com.example.exploradordelugarestursticos.databinding.FragmentConfiguracionBinding;
import com.example.exploradordelugarestursticos.ui.mapas.mapa.MapsFragment;

public class ConfiguracionFragment extends Fragment {

    public static String IDIOMA="Mi ubicacion";
    public static int TIPO_MAP=1;

    private boolean rbTHibrido;
    private boolean rbTSatelite;
    private boolean rbTNormal;
    private boolean rbIngles;
    private boolean rbEsp;

    private FragmentConfiguracionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ConfiguracionViewModel configuracionViewModel =
                new ViewModelProvider(this).get(ConfiguracionViewModel.class);

        binding = FragmentConfiguracionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        configuracionViewModel.getMTipoMapa().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer tipoMapa) {

                TIPO_MAP =  tipoMapa;
            }
        });
        configuracionViewModel.getmIdioma().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                IDIOMA=s;
            }
        });

        binding.rbSatelite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                configuracionViewModel.cambiarMapa("satelite",b);
            }
        });
        binding.rbHibrido.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                configuracionViewModel.cambiarMapa("hibrido",b);
            }
        });
        binding.rbNormal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                configuracionViewModel.cambiarMapa("normal",b);
            }
        });


        binding.rbEng.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                configuracionViewModel.cambiarIdioma("Ingles", b);
            }
        });
        binding.rbEsp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                configuracionViewModel.cambiarIdioma("Español", b);
            }
        });






     //   final TextView textView = binding.textSlideshow;
      //  configuracionViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}