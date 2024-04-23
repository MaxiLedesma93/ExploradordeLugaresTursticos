package com.example.exploradordelugarestursticos.ui.configuracion;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.exploradordelugarestursticos.ui.mapas.mapa.MapaViewModel;

public class ConfiguracionViewModel extends AndroidViewModel {

    private  MutableLiveData<Integer> mTipoMapa;
    private MutableLiveData<String> mIdioma;



    public ConfiguracionViewModel(@NonNull Application application) {
        super(application);

    }
    public LiveData<String > getmIdioma(){
        if(mIdioma==null){
            mIdioma = new MutableLiveData<>();
        }
        return mIdioma;
    }

    public LiveData<Integer> getMTipoMapa() {
        if(mTipoMapa==null){
            mTipoMapa = new MutableLiveData<>();
        }
        return mTipoMapa;
    }

    public void cambiarIdioma(String idioma, boolean bool){
        if(idioma.equals("Ingles") && bool){
            mIdioma.setValue("My Location");
        }
        if(idioma.equals("Español")&& bool){
            mIdioma.setValue("Mi Ubicacion");
        }

    }

    public void cambiarMapa(String name, Boolean b){
        if(name.equals("satelite")&& b){
            mTipoMapa.setValue(2);
        }
        if(name.equals("hibrido")&& b){
            mTipoMapa.setValue(4);
        }
        if(name.equals("normal") && b){
            mTipoMapa.setValue(1);
        }




    }
}