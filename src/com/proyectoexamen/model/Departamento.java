
package com.proyectoexamen.model;

/**
 *
 * @author jordi
 */
public class Departamento extends Inmueble {

    public Departamento(String clave, String tipo, String ubicacion, double tamArea, double precio, int numCuartos,
                int numBaños, String descripcionGeneral, String status){
        super(clave, tipo ,ubicacion ,tamArea ,precio, numCuartos,numBaños,descripcionGeneral, status);
    }

    @Override
    public double gastosRegistro() {
        return getPrecio()*0.05;
    }
    
}
