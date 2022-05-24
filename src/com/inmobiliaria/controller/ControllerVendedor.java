package com.inmobiliaria.controller;

import com.inmobiliaria.exception.OwnException;
import com.inmobiliaria.model.Cotizar;
import com.inmobiliaria.model.Inmueble;
import com.inmobiliaria.model.Recibo;

import java.util.ArrayList;

public class ControllerVendedor {
    //todo Cuando esta apartado, debe ponerse bajo que nombre para despues ser comprado o pagado a cuotas
    public static void Apartar(String clave) throws OwnException {
        Inmueble inmueble = ControllerConsulta.ConsultaInmueble(clave);

        if (inmueble.getStatus().equals("Apartado") || inmueble.getStatus().equals("Vendido") || inmueble.getStatus().equals("Cuotas")) {
            throw new OwnException("El inmueble ya esta apartado, vendido o siendo pagado en cuotas");
        }
        ControllerPersonal.Modificar(inmueble.getClave(), inmueble.getTipo(), String.valueOf(inmueble.getTamArea()), String.valueOf(inmueble.getPrecio()),
                String.valueOf(inmueble.getNumCuartos()), String.valueOf(inmueble.getNumBaños()), inmueble.getUbicacion(), "Apartado", inmueble.getDescripcionGeneral());


    }

    public static void Vender(String clave) throws OwnException {
        Inmueble inmueble = ControllerConsulta.ConsultaInmueble(clave);

        if (inmueble.getStatus().equals("Apartado") || inmueble.getStatus().equals("Vendido") || inmueble.getStatus().equals("Cuotas")) {
            throw new OwnException("El inmueble ya esta apartado, vendido o siendo pagado en cuotas");
        }

        ControllerPersonal.Modificar(inmueble.getClave(), inmueble.getTipo(), String.valueOf(inmueble.getTamArea()), String.valueOf(inmueble.getPrecio()),
                String.valueOf(inmueble.getNumCuartos()), String.valueOf(inmueble.getNumBaños()), inmueble.getUbicacion(), "Vendido", inmueble.getDescripcionGeneral());

        Recibo.CrearRecibo(inmueble.getClave(), inmueble.getTipo(), inmueble.getUbicacion(),inmueble.getTamArea(), inmueble.getPrecio(),
                inmueble.getNumCuartos(), inmueble.getNumBaños(),  inmueble.getDescripcionGeneral(),"Vendido");

    }

    public static void Cotizar(String clave, String sueldo, String mensualidad) throws OwnException {
        ArrayList<Double> arr = Cotizar.Cuotas(clave, sueldo, mensualidad);
        Inmueble inmueble = ControllerConsulta.ConsultaInmueble(clave);



        if (inmueble.getStatus().equals("Apartado") || inmueble.getStatus().equals("Vendido") || inmueble.getStatus().equals("Cuotas")) {
            throw new OwnException("El inmueble ya esta apartado, vendido o siendo pagado en cuotas");
        }
        ControllerPersonal.Modificar(inmueble.getClave(), inmueble.getTipo(), String.valueOf(inmueble.getTamArea()), String.valueOf(inmueble.getPrecio()),
                String.valueOf(inmueble.getNumCuartos()), String.valueOf(inmueble.getNumBaños()), inmueble.getUbicacion(), "Cuotas", inmueble.getDescripcionGeneral());

        Recibo.CrearReciboCuotas(inmueble.getClave(), inmueble.getTipo(), inmueble.getUbicacion(),inmueble.getTamArea(), inmueble.getPrecio(),
                inmueble.getNumCuartos(), inmueble.getNumBaños(),  inmueble.getDescripcionGeneral(),"Cuotas", arr);

    }
}
