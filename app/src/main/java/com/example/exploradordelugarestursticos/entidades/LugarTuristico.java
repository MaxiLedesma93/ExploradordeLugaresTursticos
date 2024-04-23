package com.example.exploradordelugarestursticos.entidades;

import java.io.Serializable;
import java.util.List;

public class LugarTuristico implements Serializable {
    private String nombre;
    private String descripcion;
    private String horarios;
    private List<Integer> foto;

    public LugarTuristico(String nombre, String descripcion, String horarios, List<Integer> foto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horarios = horarios;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public List<Integer> getFoto() {
        return foto;
    }

    public void setFoto(List<Integer> foto) {
        this.foto = foto;
    }
}
