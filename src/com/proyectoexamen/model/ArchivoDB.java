
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
}
