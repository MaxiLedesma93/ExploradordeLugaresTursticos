package com.example.exploradordelugarestursticos.ui.lugares;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.exploradordelugarestursticos.R;
import com.example.exploradordelugarestursticos.entidades.LugarTuristico;

import java.util.ArrayList;
import java.util.List;

public class LugaresViewModel extends AndroidViewModel {

    private  MutableLiveData<List<LugarTuristico>> mLista;

    public LugaresViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<LugarTuristico>> getMutableLista() {
        if(mLista==null){
            mLista = new MutableLiveData<>();
        }
        return mLista;
    }
    public void cargarLugares(){
        ArrayList<LugarTuristico> lista = new ArrayList<>();
        List<Integer>listaFmerlo = new ArrayList<>();
        listaFmerlo.add(R.drawable.merlo1);
        listaFmerlo.add(R.drawable.merlo2);
        listaFmerlo.add(R.drawable.merlo3);
        List<Integer>listaFCarolina = new ArrayList<>();
        listaFCarolina.add(R.drawable.carolina1);
        listaFCarolina.add(R.drawable.carolina2);
        listaFCarolina.add(R.drawable.carolina3);
        List<Integer>listaFQuijadas = new ArrayList<>();
        listaFQuijadas.add(R.drawable.lasquijadas1);
        listaFQuijadas.add(R.drawable.lasquijadas2);
        listaFQuijadas.add(R.drawable.lasquijadas3);
        List<Integer> listaFLaschacras = new ArrayList<>();
        listaFLaschacras.add(R.drawable.laschacras1);
        listaFLaschacras.add(R.drawable.laschacras2);
        listaFLaschacras.add(R.drawable.laschacras3);
        List<Integer> listaFLosfunes = new ArrayList<>();
        listaFLosfunes.add(R.drawable.potrero1);
        listaFLosfunes.add(R.drawable.potrero2);
        listaFLosfunes.add(R.drawable.potrero3);
        List<Integer> listaFTrapiche = new ArrayList<>();
        listaFTrapiche.add(R.drawable.trapiche1);
        listaFTrapiche.add(R.drawable.trapiche2);
        listaFTrapiche.add(R.drawable.trapiche3);
        List<Integer> listaFSiete = new ArrayList<>();
        listaFSiete.add(R.drawable.sietecajones1);
        listaFSiete.add(R.drawable.sietecajones2);
        listaFSiete.add(R.drawable.sietecajones3);
        List<Integer> listaFSalto = new ArrayList<>();
        listaFSalto.add(R.drawable.saltochispiadero1);
        listaFSalto.add(R.drawable.saltochispiadero2);
        listaFSalto.add(R.drawable.saltochispiadero3);
        lista.add(new LugarTuristico("Villa de Merlo","El destino sanluiseño que cautiva a los " +
                "turistas" +
                "Tal es el encanto y la magia especial de la Villa de Merlo, que no solamente es " +
                "el destino turístico más elegido de la provincia cada año, sino que además es el " +
                "lugar que muchos visitantes eligieron para vivir luego de conocerlo.","Abierto 24hs.",
                listaFmerlo));
        lista.add(new LugarTuristico("La Carolina","entre la Gruta de Inti Huasi, las Minas de Oro " +
                "y el Museo de Lafinur\n" +
                "En esta localidad es posible visitar el Museo de la Poesía Manuscrita que fue " +
                "construido en honor al poeta, patriota y pensador puntano Juan Crisóstomo Lafinur " +
                "nacido en ese paraje en 1797, cuando La Carolina era un centro de explotación " +
                "del oro.","Horarios de comercios de 8hs a 18hs\n Excursiones de 10hs a 16hs",
                listaFCarolina));
        lista.add(new LugarTuristico("Parque Nacional Sierra de las Quijadas","Al noroeste de la " +
                "provincia de San Luis, se sitúa uno de los parques nacionales más reconocidos. A " +
                "menos de dos horas de la capital sanluiseña, el Parque cuenta con amplitud de " +
                "servicios para pasar una jornada excepcional. Allí, se pueden realizar algunas" +
                " actividades de turismo de aventura y observar animales autóctonos",
                "Horarios de excursiones de 10hs a 17hs, Horario de permanencia hasta las 19hs"
                ,listaFQuijadas));
        lista.add(new LugarTuristico("Las Chacras","El Monumento al Pueblo Puntano de la " +
                "Independencia es un símbolo cultural que representa el valor de los hombres y " +
                "mujeres de San Luis que participaron en la gesta patriótica del General San Martín." +
                " Este histórico espacio tiene la especial característica que amalgama el " +
                "patrimonio cultural con los espacios verdes, un destino imperdible para los " +
                "puntanos y turistas que recorren la provincia.","Horario de ingreso 8hs, Salida 20hs"
                ,listaFLaschacras));
        lista.add(new LugarTuristico("Potrero de los Funes","A solo 20 kilómetros de la capital de " +
                "San Luis, se encuentra Potrero de los Funes, uno de los sitios turísticos más " +
                "concurridos de la provincia. Se trata de una localidad que ofrece un paisaje único," +
                " conformado por un lago rodeado por cerros que forman parte de las Sierras de " +
                "San Luis.","Horarios de comercios de 8 a 24hs",listaFLosfunes));
        lista.add(new LugarTuristico("El Trapiche","El pueblo Trapiche se encuentra en un valle " +
                "recorrido por el río que le da nombre, a solo 40 kilómetros de la capital de San " +
                "Luis. Si te gusta la naturaleza, este es, sin lugar a dudas, uno de los destinos " +
                "más adecuados en la provincia puntana.","Horario comercios de 8 a 22hs",
                listaFTrapiche));
        lista.add( new LugarTuristico("Siete Cajones","Los Siete Cajones es un conjunto de siete " +
                "piletas naturales formadas por el río Grande. Cada una de ellas tiene diferentes " +
                "profundidades y corrientes, por lo que hay que tener cuidado al momento de " +
                "refrescarse en ellas.","Horario de proveedurias de 8 a 18hs",listaFSiete));
        lista.add(new LugarTuristico("Salto del Chispiadero","Ubicado en las sierras de San Luis, " +
                "entre las Quebradas del Cebollar y las Higueritas, este salto está a 1300 metros " +
                "sobre el nivel del mar, tiene 55 metros de altura y cuenta con una espectacular " +
                "vista.","Horario recomendado de excuersion 10hs a 17hs.",listaFSalto));
        mLista.setValue(lista);
    }
}