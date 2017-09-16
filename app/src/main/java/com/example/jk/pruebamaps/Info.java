package com.example.jk.pruebamaps;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by JK on 13/08/2017.
 */

public class Info implements Serializable{
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }
    public Info(){
        String nombre="";
        String cedula="";
        String direccion="";
        String ciudad="";
        String pais="";
        String celular="";
        Boolean wifi=true;
        Boolean bluetooth=false;
    }
    public Info(String Nombre,String Cedula,String Direccion,String Ciudad,String Pais,String Celular){
        nombre=Nombre;
        direccion=Direccion;
        cedula=Cedula;
        ciudad=Ciudad;
        pais=Pais;
        celular=Celular;
    }
    private String nombre;
    private String cedula;
    private String direccion;
    private String ciudad;
    private String pais;
    private String celular;
    private Boolean wifi;
    private Boolean bluetooth;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    private String foto;

}
