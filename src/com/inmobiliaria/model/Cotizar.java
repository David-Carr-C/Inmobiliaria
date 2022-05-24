package com.inmobiliaria.model;

import com.inmobiliaria.controller.ControllerConsulta;

import java.util.ArrayList;

public class Cotizar {

    public static ArrayList<Double> Cuotas(String clave, String s, String m) {
        ArrayList<Double> num = new ArrayList<>();
        int mensualidades = Integer.parseInt(m);
        double sueldo = Integer.parseInt(s);
        double porcentaje = 0;

        Inmueble inmueble = ControllerConsulta.ConsultaInmueble(clave);
        assert inmueble != null;
        double precio = inmueble.getPrecio();

        double cadaMesPago = 0.00;

        switch (mensualidades) {//Se hace un switch para saber que opcion eligio el usuario
            case 1:

                porcentaje = inmueble.getPrecio();
                porcentaje = porcentaje/100;
                porcentaje = porcentaje*10;//Se obtiene el 10%, y en los demas casos el 20%,30%...etc.

                precio = precio+porcentaje;//Se calcula el precio total
                num.add(precio);//Precio total nuevo

                System.out.println("Precio total del auto, ahora: "+precio);

                mensualidades = (int) (precio/sueldo); //500/20   ->  25, se obtiene cuantos meses tiene que pagar
                cadaMesPago = precio/mensualidades;//Se obtiene cuanto debe pagar por cada mes

                System.out.println("Cada mes pagar... "+cadaMesPago);
                break;
            case 2:

                porcentaje = inmueble.getPrecio();
                porcentaje = porcentaje/100;
                porcentaje = porcentaje*20;

                precio = precio+porcentaje;
                num.add(precio);//Precio total nuevo

                System.out.println("Precio total del auto, ahora: "+precio);

                mensualidades = (int) (precio/sueldo); //500/20   ->  25
                cadaMesPago = precio/mensualidades;

                System.out.println("Cada mes pagar... "+cadaMesPago);

                break;
            case 3:

                porcentaje = inmueble.getPrecio();
                porcentaje = porcentaje/100;
                porcentaje = porcentaje*30;

                precio = precio+porcentaje;
                num.add(precio);//Precio total nuevo

                System.out.println("Precio total del auto, ahora: "+precio);

                mensualidades = (int) (precio/sueldo); //500/20   ->  25
                cadaMesPago = precio/mensualidades;

                System.out.println("Cada mes pagar... "+cadaMesPago);

                break;
            case 4:

                porcentaje = inmueble.getPrecio();
                porcentaje = porcentaje/100;
                porcentaje = porcentaje*40;

                precio = precio+porcentaje;
                num.add(precio);//Precio total nuevo

                System.out.println("Precio total del auto, ahora: "+precio);

                mensualidades = (int) (precio/sueldo); //500/20   ->  25
                cadaMesPago = precio/mensualidades;

                System.out.println("Cada mes pagar... "+cadaMesPago);

                break;
            case 5:

                porcentaje = inmueble.getPrecio();
                porcentaje = porcentaje/100;
                porcentaje = porcentaje*50;

                precio = precio+porcentaje;
                num.add(precio);//Precio total nuevo

                System.out.println("Precio total del auto, ahora: "+precio);

                mensualidades = (int) (precio/sueldo); //500/20   ->  25
                cadaMesPago = precio/mensualidades;

                System.out.println("Cada mes pagar... "+cadaMesPago);

                break;
            default:
                System.out.println("Opcion no encontrada");//Si inserta otro numero diferente
                break;
        }
        //0 se pone el precio total
        num.add(cadaMesPago);//En la posicion 1 se guarda el pago de cada mes
        num.add((double) mensualidades);//En la posicion 2 se guarda cuantos meses seran
        return num;//Se regresa el arreglo de los dos numeros
    }
}
