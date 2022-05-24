package com.inmobiliaria.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Recibo {

    /**
     * Escribe sobre el archivo Recibo.txt los datos necesarios para crear un recibo del inmueble comprado
     * */
    public static void CrearRecibo(String clave, String tipo, String ubicacion, double tamArea, double precio, int numCuartos,
                                   int numBaños, String descripcionGeneral, String status) {//<-
        try{
            FileWriter archivo = new FileWriter("Recibo.txt");
            try(BufferedWriter almacen = new BufferedWriter(archivo)) {
                almacen.write("Clave del inmueble: "+clave + "\n");
                almacen.write("Tipo de inmueble: "+tipo + "\n");
                almacen.write("Ubicacion del inmueble: "+ubicacion + "\n");
                almacen.write("Tamaño del area: "+tamArea + "\n");
                almacen.write("Total a pagar: "+precio +"$" +"\n");
                almacen.write("Numero de cuartos: "+numCuartos + "\n");
                almacen.write("Numero de baños: "+numBaños + "\n");
                almacen.write("\""+descripcionGeneral +"\""+ "\n");
                almacen.write("Status del inmueble: "+status + "\n");
                almacen.close();
            }
            archivo.close();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Escribe sobre el archivo Recibo.txt los datos necesarios para crear un recibo del inmueble comprado a cuotas,
     * con ello contiene el total a pagar, el total de plazos y el dinero a pagar en cada plazo
     * */
    public static void CrearReciboCuotas(String clave, String tipo, String ubicacion, double tamArea, double precio, int numCuartos,
                                         int numBaños, String descripcionGeneral, String status, ArrayList<Double> arr) {//<-
        try{
            FileWriter archivo = new FileWriter("Recibo.txt");
            try(BufferedWriter almacen = new BufferedWriter(archivo)) {
                almacen.write("Clave del inmueble: "+clave + "\n");
                almacen.write("Tipo de inmueble: "+tipo + "\n");
                almacen.write("Ubicacion del inmueble: "+ubicacion + "\n");
                almacen.write("Tamaño del area: "+tamArea + "\n");
                almacen.write("Total a pagar: "+arr.get(0) +"$" +"\n");//nuevo precio
                almacen.write("Tener que pagar "+arr.get(1) +"$" +"");//pago cada mes
                almacen.write(" en "+arr.get(2) +" cuotas mensuales" +"\n");//por cuantos meses
                almacen.write("Numero de cuartos: "+numCuartos + "\n");
                almacen.write("Numero de baños: "+numBaños + "\n");
                almacen.write("\""+descripcionGeneral +"\""+ "\n");
                almacen.write("Status del inmueble: "+status + "\n");
                almacen.close();
            }
            archivo.close();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
}
