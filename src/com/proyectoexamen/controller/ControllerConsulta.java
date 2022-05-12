package com.proyectoexamen.controller;

import com.proyectoexamen.model.*;

import java.util.ArrayList;
import java.util.Objects;

public class ControllerConsulta {
    /**
     * Da de alta un inmueble
     * */
    public static void Alta(Inmueble inmueble) {
        ArchivoDB.Guardar(inmueble.getClave(),inmueble.getTipo(),inmueble.getUbicacion(),inmueble.getTamArea(),inmueble.getPrecio(),
                inmueble.getNumCuartos(),inmueble.getNumBaños(),inmueble.getDescripcionGeneral(),inmueble.getStatus());
    }

    /**
     * Del array de Strings recuperadas del archivo Datos.txt los recreamos haciendo inmuebles
     * */
    public static ArrayList<Inmueble> ConsultaArray(ArrayList<String> array) {
        ArrayList<Inmueble> inmuebles = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {

            if (i%9 == 0) {
                if (array.get(1+i).equals("Casa")) {
                    inmuebles.add(new Casa(array.get(0+i),array.get(1+i), array.get(2+i), Double.parseDouble(array.get(3+i)),
                            Double.parseDouble( array.get(4+i)), Integer.parseInt(array.get(5+i)),
                            Integer.parseInt(array.get(6+i)), array.get(7+i), array.get(8+i)));
                }

                if (array.get(1+i).equals("Casa Condominio")) {
                    inmuebles.add(new CasaCondominio(array.get(0+i),array.get(1+i), array.get(2+i), Double.parseDouble(array.get(3+i)),
                            Double.parseDouble( array.get(4+i)), Integer.parseInt(array.get(5+i)),
                            Integer.parseInt(array.get(6+i)), array.get(7+i), array.get(8+i)));
                }

                if (array.get(1+i).equals("Departamento")) {
                    inmuebles.add(new Departamento(array.get(0+i),array.get(1+i), array.get(2+i), Double.parseDouble(array.get(3+i)),
                            Double.parseDouble( array.get(4+i)), Integer.parseInt(array.get(5+i)),
                            Integer.parseInt(array.get(6+i)), array.get(7+i), array.get(8+i)));
                }

                if (array.get(1+i).equals("Terreno")) {
                    inmuebles.add(new Terreno(array.get(0+i),array.get(1+i), array.get(2+i), Double.parseDouble(array.get(3+i)),
                            Double.parseDouble( array.get(4+i)), Integer.parseInt(array.get(5+i)),
                            Integer.parseInt(array.get(6+i)), array.get(7+i), array.get(8+i)));
                }
            }
        }

        return inmuebles;
    }

    /**
     * Lee los datos con la clase de archivo, busca el archivo que coincida con la clave y devuelve la string del estado
     * del inmueble
     * */
    public static String ConsultaClave(int clave) {
        ArchivoDB.ActualizarBaseDeDatos();

        String elementosADevolver = "";
        for (Inmueble element: ArchivoDB.inmuebles) {
            String claveObtenida = element.getClave();
            String claveAComparar = String.valueOf(clave);

            if (Objects.equals(claveObtenida,claveAComparar)) {
                elementosADevolver = elementosADevolver + element.getClave() +"\n";
                elementosADevolver = elementosADevolver + element.getTipo() + "\n";
                elementosADevolver = elementosADevolver + element.getUbicacion() + "\n";
                elementosADevolver = elementosADevolver + element.getTamArea() + "\n";
                elementosADevolver = elementosADevolver + element.getPrecio() + "\n";
                elementosADevolver = elementosADevolver + element.getNumCuartos() + "\n";
                elementosADevolver = elementosADevolver + element.getNumBaños() + "\n";
                elementosADevolver = elementosADevolver + element.getDescripcionGeneral() + "\n";
                elementosADevolver = elementosADevolver + element.getStatus();
            }
        }

        return elementosADevolver;
    }

    /**
     * Busca un inmueble que coincida con la clave y regresa el inmueble
     * */
    public static Inmueble Consulta(int clave, boolean aztec) {//Para diferenciar de los dos metodos, este regresa el inmueble deseado
        ArchivoDB.ActualizarBaseDeDatos();

        String elementosADevolver = "";
        for (Inmueble element: ArchivoDB.inmuebles) {
            String claveObtenida = element.getClave();
            String claveAComparar = String.valueOf(clave);

            if (Objects.equals(claveObtenida,claveAComparar)) {
                return element;
            }
        }

        return null;
    }
}
