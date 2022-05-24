package com.inmobiliaria.model;

public abstract class Inmueble {
    private String clave, tipo, ubicacion, descripcionGeneral, status; //Valores para identificar al inmueble
    private double tamArea, precio; //Valores double
    private int numCuartos,numBaños; //Valores enteros

    /**
     * Constructor de inmueble, un inmueble solo puede ser creado con los siguientes argumentos
     * @param clave sera la clave unica del inmueble
     * @param tipo el tipo de inmueble, este se comparará con una string para despues definir a que subclase va
     * @param ubicacion ubicacion del inmueble
     * @param tamArea tamaño del inmueble
     * @param precio precio del inmueble
     * @param numCuartos numero de cuartos del inmueble
     * @param numBaños numero de baños del inmueble
     * @param descripcionGeneral una descripcion general acerca del inmueble
     * @param status posibles status: Disponible, Apartado, Vendido o Cuotas
     * <html><br></html>
     * return {@code No retorna, es constructor .-. }
     * */
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
