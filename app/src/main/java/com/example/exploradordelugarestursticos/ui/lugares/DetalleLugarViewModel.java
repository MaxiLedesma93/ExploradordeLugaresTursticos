package com.example.exploradordelugarestursticos.ui.lugares;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.exploradordelugarestursticos.entidades.LugarTuristico;

public class DetalleLugarViewModel extends AndroidViewModel {

    private MutableLiveData<LugarTuristico> turisticoMutableLiveData;
    public DetalleLugarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<LugarTuristico> getTuristicoMutableLiveData() {
        if(turisticoMutableLiveData==null){
            turisticoMutableLiveData=new MutableLiveData<>();
        }
        return turisticoMutableLiveData;
    }
    public void recuperarLugar(Intent intent){
        LugarTuristico lugarTuristico = (LugarTuristico)intent.getSerializableExtra("lugar");
        if(lugarTuristico!=null){
            turisticoMutableLiveData.setValue(lugarTuristico);

        }
    }

}