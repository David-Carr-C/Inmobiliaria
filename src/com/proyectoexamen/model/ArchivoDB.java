
package com.proyectoexamen.model;

import com.proyectoexamen.controller.ControllerConsulta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author jordi, david, samanta
 */
/*
Esto es una prueba para poder guardar archivos y de igual forma leerlos 
*/
public class ArchivoDB {
    public static ArrayList<Inmueble> inmuebles;

    public static void ActualizarBaseDeDatos() {
        ArrayList<String> lecturas = Leer();//Se lee el archivo Datos.txt
        inmuebles = ControllerConsulta.ConsultaArray(lecturas);//Se pasa las lineas leidas, para transformarlos en objetos inmuebles
    }
    
    public static void Guardar(String clave, String tipo, String ubicacion, double tamArea, double precio, int numCuartos,
                               int numBaños, String descripcionGeneral, String status) {

        try{
            FileWriter archivo = new FileWriter("Datos.txt",true);
            try(BufferedWriter almacen = new BufferedWriter(archivo)) {
                almacen.write(clave + "\n");
                almacen.write(tipo + "\n");
                almacen.write(ubicacion + "\n");
                almacen.write(tamArea + "\n");
                almacen.write(precio + "\n");
                almacen.write(numCuartos + "\n");
                almacen.write(numBaños + "\n");
                almacen.write(descripcionGeneral + "\n");
                almacen.write(status + "\n");
                almacen.close();
            }
            archivo.close();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
    
    public static ArrayList<String> Leer(){
        ArrayList<String> datos = new ArrayList<>();
        try{
            FileReader archivo = new FileReader("Datos.txt");
            BufferedReader lectura = new BufferedReader(archivo);
            String cadena;
            
            while((cadena = lectura.readLine())!=null){
                datos.add(cadena);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return datos;
    }

    public static void EliminarDB() {
        try{
            FileWriter archivo = new FileWriter("Datos.txt");
            try(BufferedWriter almacen = new BufferedWriter(archivo)) {
                almacen.write("");
                almacen.close();
            }
            archivo.close();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

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

    public static void CrearReciboCuotas(String clave, String tipo, String ubicacion, double tamArea, double precio, int numCuartos,
                                   int numBaños, String descripcionGeneral, String status) {//<-
        try{
            FileWriter archivo = new FileWriter("Recibo.txt");
            try(BufferedWriter almacen = new BufferedWriter(archivo)) {
                almacen.write("Clave del inmueble: "+clave + "\n");
                almacen.write("Tipo de inmueble: "+tipo + "\n");
                almacen.write("Ubicacion del inmueble: "+ubicacion + "\n");
                almacen.write("Tamaño del area: "+tamArea + "\n");
                almacen.write("Total a pagar: "+precio +"$" +"\n");
                almacen.write("Total a pagar : "+precio +"$" +"");//nuevo precio
                almacen.write(" en "+precio +" cuotas mensuales" +"\n");//meses
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
