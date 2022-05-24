package com.inmobiliaria.model;

public class Terreno extends Inmueble {

    public Terreno(String clave, String tipo, String ubicacion, double tamArea, double precio, int numCuartos,
                int numBaños, String descripcionGeneral, String status){
        super(clave, tipo ,ubicacion ,tamArea ,precio, numCuartos,numBaños,descripcionGeneral, status);
    }
}
