package com.example.exploradordelugarestursticos.ui.lugares;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.exploradordelugarestursticos.entidades.LugarTuristico;

public class NuevoDetalleViewModel extends AndroidViewModel {
    private MutableLiveData<LugarTuristico> turisticoMutableLiveData;
    public NuevoDetalleViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<LugarTuristico> getTuristicoMutableLiveData() {
        if(turisticoMutableLiveData==null){
            turisticoMutableLiveData=new MutableLiveData<>();
        }
        return turisticoMutableLiveData;
    }
    public void recuperarLugar(Bundle bundle){
        LugarTuristico lugarTuristico = (LugarTuristico)bundle.get("lugar");
        if(lugarTuristico!=null){
            turisticoMutableLiveData.setValue(lugarTuristico);
        }
    }
}