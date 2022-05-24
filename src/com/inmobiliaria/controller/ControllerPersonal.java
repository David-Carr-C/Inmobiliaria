package com.inmobiliaria.controller;

import com.inmobiliaria.model.*;

import java.util.ArrayList;

public class ControllerPersonal {

    public static void Alta(String clave, String tipoMueble, String tamanio, String precio, String noCuartos, String noBaños, String ubicacion, String status, String descripcionGeneral) {
        ControllerConsulta.AltaString(clave, tipoMueble, ubicacion, tamanio, precio, noCuartos, noBaños, descripcionGeneral, status);
        ArchivoDB.ActualizarBaseDeDatos();
    }

    public static void Baja(String clave) {
        ArchivoDB.ActualizarBaseDeDatos();

        for (int i = 0; i < ArchivoDB.inmuebles.size(); i++) {
            if (ArchivoDB.inmuebles.get(i).getClave().equals(clave)) {
                ArchivoDB.inmuebles.remove(i);
            }
        }

        ArchivoDB.EliminarDB();

        for (Inmueble element:ArchivoDB.inmuebles) {
            ControllerConsulta.AltaInmueble(element);
        }

        ArchivoDB.ActualizarBaseDeDatos();
    }

    public static void Modificar(String clave, String tipoMueble, String tamanio, String precio, String noCuartos,
                                 String noBaños, String ubicacion, String status, String descripcionGeneral) {

        ArchivoDB.ActualizarBaseDeDatos();

        for (int i = 0; i < ArchivoDB.inmuebles.size(); i++) {
            if (ArchivoDB.inmuebles.get(i).getClave().equals(clave)) {
                ArchivoDB.inmuebles.remove(i);
            }
        }

        ArchivoDB.EliminarDB();

        for (Inmueble element:ArchivoDB.inmuebles) {
            ControllerConsulta.AltaInmueble(element);
        }

        Alta(clave,tipoMueble,tamanio,precio,noCuartos,noBaños,ubicacion,status,descripcionGeneral);
    }

    public static ArrayList<Inmueble> Visualizar(String precio, String numCuartos, String numBanios) {
        ArrayList<Inmueble> inmueblesArr = ControllerConsulta.Buscar(precio,numCuartos,numBanios);
        return inmueblesArr;
    }

    public static ArrayList<Inmueble> Visualizar(String precio) {
        ArrayList<Inmueble> inmueblesArr = ControllerConsulta.Buscar(precio);
        return inmueblesArr;
    }

    public static ArrayList<Inmueble> VisualizarPrecioCuarto(String precio, String numCuarto) {
        ArrayList<Inmueble> inmuebleArrayList = ControllerConsulta.BuscarPrecioCuarto(precio,numCuarto);
        return inmuebleArrayList;
    }

    public static ArrayList<Inmueble>  VisualizarNumero(String numCuarto, String numBanio) {
        ArrayList<Inmueble>  inmuebleArrayList = ControllerConsulta.BuscarNumero(numCuarto,numBanio);
        return inmuebleArrayList;
    }

    public static ArrayList<Inmueble> VisualizarCuarto(String numCuarto) {
        ArrayList<Inmueble> inmuebleArrayList = ControllerConsulta.BuscarCuarto(numCuarto);
        return inmuebleArrayList;
    }
}
