
package com.proyectoexamen.model;

/**
 *
 * @author jordi
 */
public class Terreno extends Inmueble {

    public Terreno(String clave, String tipo, String ubicacion, double tamArea, double precio, int numCuartos,
                int numBaños, String descripcionGeneral, String status){
        super(clave, tipo ,ubicacion ,tamArea ,precio, numCuartos,numBaños,descripcionGeneral, status);
    }

   @Override
    public double gastosRegistro() {
        return getPrecio()*0.1;
    }
    
}
