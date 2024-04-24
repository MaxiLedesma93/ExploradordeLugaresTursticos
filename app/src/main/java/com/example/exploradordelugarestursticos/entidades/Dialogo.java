package com.example.exploradordelugarestursticos.entidades;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Dialogo {

    public static void salir(Context context){
        new AlertDialog.Builder(context)
                .setTitle("confirma salida")
                .setMessage("¿desea SALIR? SI O NO")
                .setPositiveButton("si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
}