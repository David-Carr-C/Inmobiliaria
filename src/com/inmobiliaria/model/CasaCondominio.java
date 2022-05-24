package com.inmobiliaria.model;

public class CasaCondominio extends Inmueble {

    public CasaCondominio(String clave, String tipo, String ubicacion, double tamArea, double precio, int numCuartos,
                int numBaños, String descripcionGeneral, String status){
        super(clave, tipo ,ubicacion ,tamArea ,precio, numCuartos,numBaños,descripcionGeneral, status);
    }
}
