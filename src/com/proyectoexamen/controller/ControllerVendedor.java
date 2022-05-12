package com.proyectoexamen.controller;

import com.proyectoexamen.exception.OwnException;
import com.proyectoexamen.model.ArchivoDB;
import com.proyectoexamen.model.Inmueble;

public class ControllerVendedor {
    public static void Apartar(String clave) throws OwnException {
        Inmueble inmueble = ControllerConsulta.ConsultaInmueble(clave);

        if (inmueble.getStatus().equals("Apartado") || inmueble.getStatus().equals("Vendido") || inmueble.getStatus().equals("Cuotas")) {
            throw new OwnException("El inmueble ya esta apartado, vendido o siendo pagado en cuotas");
        }
        if (inmueble != null) {
            throw new OwnException("El inmueble no se encontro");
        }
        ControllerPersonal.Modificar(inmueble.getClave(), inmueble.getTipo(), String.valueOf(inmueble.getTamArea()), String.valueOf(inmueble.getPrecio()),
                String.valueOf(inmueble.getNumCuartos()), String.valueOf(inmueble.getNumBaños()), inmueble.getUbicacion(), "Apartado", inmueble.getDescripcionGeneral());


    }

    public static void Vender(String clave) throws OwnException {
        Inmueble inmueble = ControllerConsulta.ConsultaInmueble(clave);

        if (inmueble.getStatus().equals("Apartado") || inmueble.getStatus().equals("Vendido") || inmueble.getStatus().equals("Cuotas")) {
            throw new OwnException("El inmueble ya esta apartado, vendido o siendo pagado en cuotas");
        }
        if (inmueble != null) {
            throw new OwnException("El inmueble no se encontro");
        }
        ControllerPersonal.Modificar(inmueble.getClave(), inmueble.getTipo(), String.valueOf(inmueble.getTamArea()), String.valueOf(inmueble.getPrecio()),
                String.valueOf(inmueble.getNumCuartos()), String.valueOf(inmueble.getNumBaños()), inmueble.getUbicacion(), "Vendido", inmueble.getDescripcionGeneral());

        ArchivoDB.CrearRecibo(inmueble.getClave(), inmueble.getTipo(), inmueble.getUbicacion(),inmueble.getTamArea(), inmueble.getPrecio(),
                inmueble.getNumCuartos(), inmueble.getNumBaños(),  inmueble.getDescripcionGeneral(),"Vendido");

    }

    public static void Cotizar(String clave, String sueldo) throws OwnException {
        Inmueble inmueble = ControllerConsulta.ConsultaInmueble(clave);

        if (inmueble.getStatus().equals("Apartado") || inmueble.getStatus().equals("Vendido") || inmueble.getStatus().equals("Cuotas")) {
            throw new OwnException("El inmueble ya esta apartado, vendido o siendo pagado en cuotas");
        }
        if (inmueble != null) {
            throw new OwnException("El inmueble no se encontro");
        }
        ControllerPersonal.Modificar(inmueble.getClave(), inmueble.getTipo(), String.valueOf(inmueble.getTamArea()), String.valueOf(inmueble.getPrecio()),
                String.valueOf(inmueble.getNumCuartos()), String.valueOf(inmueble.getNumBaños()), inmueble.getUbicacion(), "Cuotas", inmueble.getDescripcionGeneral());



        ArchivoDB.CrearReciboCuotas(inmueble.getClave(), inmueble.getTipo(), inmueble.getUbicacion(),inmueble.getTamArea(), inmueble.getPrecio(),
                inmueble.getNumCuartos(), inmueble.getNumBaños(),  inmueble.getDescripcionGeneral(),"Cuotas");

    }
}
