package com.inmobiliaria.test;

import com.inmobiliaria.controller.ControllerConsulta;
import com.inmobiliaria.model.ArchivoDB;
import com.inmobiliaria.model.Inmueble;

import java.util.ArrayList;

public class TestArchivos {
    public static void main(String[] args) {
        ArchivoDB.Guardar("101","Casa","FrayNoseQue",1000, 10000,2,2,"Mucha casa", "Disponible");

        //ArrayList<String> array = ArchivoDB.Leer();//Rescatar las cadenas de texto del archivo de texto

        //ArrayList<Inmueble> inmuebles2 = ArchivoDB.LoadObjects(array);

        /*for (Inmueble element: inmuebles2) {
            System.out.println(element);
        }*/
    }
}
