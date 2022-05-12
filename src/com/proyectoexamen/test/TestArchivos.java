package com.proyectoexamen.test;

import com.proyectoexamen.controller.ControllerConsulta;
import com.proyectoexamen.model.ArchivoDB;
import com.proyectoexamen.model.Casa;
import com.proyectoexamen.model.Inmueble;

import java.util.ArrayList;

public class TestArchivos {
    public static void main(String[] args) {
        ArchivoDB.Guardar("101","Casa","FrayNoseQue",1000, 10000,2,2,"Mucha casa", "Disponible");

        ArrayList<String> array = ArchivoDB.Leer();//Rescatar las cadenas de texto del archivo de texto

        ArrayList<Inmueble> inmuebles2 = ControllerConsulta.ConsultaArray(array);

        for (Inmueble element: inmuebles2) {
            System.out.println(element);
        }
    }
}
