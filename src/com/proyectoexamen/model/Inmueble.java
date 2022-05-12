package com.proyectoexamen.model;

/**
 * @author jordi, david, samanta
 */

public abstract class Inmueble {
    private String clave, tipo, ubicacion, descripcionGeneral, status;
    private double tamArea, precio;
    private int numCuartos,numBaños;

    //Status = Disponible, apartado, vendido, cuotas
    //Tipo = subclases

    public Inmueble(String clave, String tipo, String ubicacion, double tamArea, double precio, int numCuartos,
                    int numBaños, String descripcionGeneral, String status){

       this.clave = clave;
       this.tipo = tipo;
       this.ubicacion = ubicacion;
       this.tamArea = tamArea;
       this.precio = precio;
       this.numCuartos = numCuartos;
       this.numBaños = numBaños;
       this.descripcionGeneral = descripcionGeneral;
       this.status = status;
    }

    public String getClave() {
        return clave;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    public String getStatus() {
        return status;
    }

    public double getTamArea() {
        return tamArea;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNumCuartos() {
        return numCuartos;
    }

    public int getNumBaños() {
        return numBaños;
    }

    abstract double gastosRegistro();

    @Override
    public String toString(){
        return " \n Clave: " + getClave() +
                "\n Tipo: "+ getTipo() +
                "\n Ubicacion: " + getUbicacion() +
                "\n Tamaño del Area: " + getTamArea() +
                "\n Precio: " + getPrecio() +
                "\n Numero de cuartos: " + getNumCuartos() +
                "\n Numero de baños: " + getNumBaños() +
                "\n Descripcion: " + getDescripcionGeneral() +
                "\n Status: " + getStatus();
    }
     
}
