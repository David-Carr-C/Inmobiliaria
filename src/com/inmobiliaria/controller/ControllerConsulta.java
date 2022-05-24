package com.inmobiliaria.controller;

import com.inmobiliaria.model.*;

import java.util.ArrayList;
import java.util.Objects;

public class ControllerConsulta {

    /**
     * Da de alta un inmueble
     * @param inmueble
     * */
    public static void AltaInmueble(Inmueble inmueble) {
        ArchivoDB.Guardar(inmueble.getClave(),inmueble.getTipo(),inmueble.getUbicacion(),inmueble.getTamArea(),inmueble.getPrecio(),
                inmueble.getNumCuartos(),inmueble.getNumBaños(),inmueble.getDescripcionGeneral(),inmueble.getStatus());
    }

    /**
     * Da de alta un inmueble
     * @param {{@code Cadenas}}
     * */
    public static void AltaString(String clave, String tipo, String ubicacion, String tamArea, String precio,
                                  String numCuartos, String numBaños, String descripcion, String status) {

        double tamAreaD = Double.parseDouble(tamArea);
        double precioD = Double.parseDouble(precio);
        int numCuartosI = Integer.parseInt(numCuartos);
        int numBañosI = Integer.parseInt(numBaños);

        ArchivoDB.Guardar(clave,tipo,ubicacion,tamAreaD,precioD,numCuartosI,numBañosI,descripcion,status);

    }

    /**
     * Lee los datos con la clase de archivo, busca el archivo que coincida con la clave y devuelve la string del estado
     * del inmueble
     * */
    public static String ConsultaClave(String clave) {
        ArchivoDB.ActualizarBaseDeDatos();

        String elementosADevolver = "";
        for (Inmueble element: ArchivoDB.inmuebles) {
            String claveObtenida = element.getClave();
            String claveAComparar = clave;

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
    public static Inmueble ConsultaInmueble(String clave) {//Para diferenciar de los dos metodos, este regresa el inmueble deseado
        ArchivoDB.ActualizarBaseDeDatos();

        String elementosADevolver = "";
        for (Inmueble element: ArchivoDB.inmuebles) {
            String claveObtenida = element.getClave();
            String claveAComparar = clave;

            if (Objects.equals(claveObtenida,claveAComparar)) {
                return element;
            }
        }

        return null;
    }

    public static ArrayList<Inmueble> Buscar(String precio, String numCuartos, String numBanios) {
        ArrayList<Inmueble> inmueblesArr = new ArrayList<>();

        double precioD = Double.parseDouble(precio);
        int numCuartosI = Integer.parseInt(numCuartos);
        int numBaniosI = Integer.parseInt(numBanios);


        ArchivoDB.ActualizarBaseDeDatos();

        for (int i = 0; i < ArchivoDB.inmuebles.size(); i++) {
            if (ArchivoDB.inmuebles.get(i).getPrecio() <= precioD) {
                if (ArchivoDB.inmuebles.get(i).getNumCuartos() == numCuartosI) {
                    if (ArchivoDB.inmuebles.get(i).getNumBaños() == numBaniosI) {
                        inmueblesArr.add(ArchivoDB.inmuebles.get(i));
                    }
                }
            }
        }

        return inmueblesArr;
    }

    public static ArrayList<Inmueble> Buscar(String precio) {
        ArrayList<Inmueble> inmueblesArray = new ArrayList<>();
        double precioD = Double.parseDouble(precio);


        ArchivoDB.ActualizarBaseDeDatos();

        for (int i = 0; i < ArchivoDB.inmuebles.size(); i++) {
            if (ArchivoDB.inmuebles.get(i).getPrecio() <= precioD) {
                inmueblesArray.add(ArchivoDB.inmuebles.get(i));
            }
        }

        return inmueblesArray;
    }

    public static ArrayList<Inmueble> BuscarPrecioCuarto(String precio, String numCuarto) {
        ArrayList<Inmueble> inmueblesArray = new ArrayList<>();
        double precioD = Double.parseDouble(precio);
        int numCuartoI = Integer.parseInt(numCuarto);

        ArchivoDB.ActualizarBaseDeDatos();

        for (int i = 0; i < ArchivoDB.inmuebles.size(); i++) {
            if (ArchivoDB.inmuebles.get(i).getPrecio() <= precioD) {
                if (ArchivoDB.inmuebles.get(i).getNumCuartos() == numCuartoI) {
                    inmueblesArray.add(ArchivoDB.inmuebles.get(i));
                }
            }
        }

        return inmueblesArray;
    }

    public static ArrayList<Inmueble> BuscarNumero(String numCuarto, String numBanio) {
        ArrayList<Inmueble> inmuebleArrayList = new ArrayList<>();
        int numCuartoI = Integer.parseInt(numCuarto);
        int numBanioI = Integer.parseInt(numBanio);

        ArchivoDB.ActualizarBaseDeDatos();

        for (int i = 0; i < ArchivoDB.inmuebles.size(); i++) {
            if (ArchivoDB.inmuebles.get(i).getNumCuartos() == numCuartoI) {
                if (ArchivoDB.inmuebles.get(i).getNumBaños() == numBanioI) {
                    inmuebleArrayList.add(ArchivoDB.inmuebles.get(i));
                }
            }
        }

        return inmuebleArrayList;
    }

    public static ArrayList<Inmueble> BuscarCuarto(String numCuarto) {
        ArrayList<Inmueble> inmuebleArrayList = new ArrayList<>();
        int numCuartoI = Integer.parseInt(numCuarto);

        ArchivoDB.ActualizarBaseDeDatos();

        for (int i = 0; i < ArchivoDB.inmuebles.size(); i++) {
            if (ArchivoDB.inmuebles.get(i).getNumCuartos() == numCuartoI) {
                inmuebleArrayList.add(ArchivoDB.inmuebles.get(i));
            }
        }

        return inmuebleArrayList;
    }
}
