package com.example.exploradordelugarestursticos.ui.mapas.mapa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.exploradordelugarestursticos.R;
import com.example.exploradordelugarestursticos.databinding.FragmentMapsBinding;
import com.example.exploradordelugarestursticos.ui.configuracion.ConfiguracionFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {
    private MapaViewModel mapaViewModel;



    private OnMapReadyCallback callback = new OnMapReadyCallback() {


        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */



        @Override
        public void onMapReady(GoogleMap googleMap) {



            mapaViewModel.getMutableLocation().observe(getViewLifecycleOwner(), new Observer<Location>() {
                @Override
                public void onChanged(Location location) {
                    LatLng ubi = new LatLng(location.getLatitude(),location.getLongitude());
                    googleMap.addMarker(new MarkerOptions().position(ubi).title(ConfiguracionFragment.IDIOMA));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubi, 15f));
                   googleMap.setMapType(ConfiguracionFragment.TIPO_MAP);
                }
            });


            LatLng catedral = new LatLng(-33.30213, -66.3369);
            LatLng parque = new LatLng(-33.29207, -66.31441);
            LatLng aeropuerto = new LatLng(-33.27507, -66.34997);
            LatLng potrero = new LatLng(-33.22941, -66.2335);
            LatLng cruzDePiedra = new LatLng(-33.26029, -66.21834);
            LatLng laFlorida = new LatLng(-33.11545, -66.03119);
            LatLng lasChacras = new LatLng(-33.25928, -66.2462);
            LatLng elTrapiche = new LatLng(-33.10711, -66.06329);
            googleMap.addMarker(new MarkerOptions().position(catedral).title("Iglesia Catedral"));
            googleMap.addMarker(new MarkerOptions().position(parque).title("Parque de las Naciones"));
            googleMap.addMarker(new MarkerOptions().position(aeropuerto).title("Aeropuerto"));
            googleMap.addMarker(new MarkerOptions().position(potrero).title("Potrero"));
            googleMap.addMarker(new MarkerOptions().position(cruzDePiedra).title("Cruz de Piedra"));
            googleMap.addMarker(new MarkerOptions().position(laFlorida).title("La Florida"));
            googleMap.addMarker(new MarkerOptions().position(lasChacras).title("Las Chacras"));
            googleMap.addMarker(new MarkerOptions().position(elTrapiche).title("El Trapiche"));


        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mapaViewModel =
                new ViewModelProvider(this).get(MapaViewModel.class);

        mapaViewModel.lecturaUbicacion();
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {


            mapFragment.getMapAsync(callback);

        }
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();



    }
}