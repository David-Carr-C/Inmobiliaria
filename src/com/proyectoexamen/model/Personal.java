
package com.proyectoexamen.model;

import java.util.ArrayList;

/**
 *
 * @author jordi
 */
public class Personal {
    private Cliente cliente ;
    private ArrayList <Inmueble> lista;
    
    public Personal(Cliente cliente,ArrayList<Inmueble>lista){
        this.cliente = cliente;
        this.lista = lista;
    }
    
    public Personal(){
        this.cliente = new Cliente() ;
        this.lista = new ArrayList <Inmueble>();
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public ArrayList<Inmueble> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Inmueble> lista) {
        this.lista = lista;
    }
    
    public double valorVenta(){
        double val=0;
        for (int i = 0; i < lista.size(); i++) {
            val+= lista.get(i).gastosRegistro()+lista.get(i).getPrecio();
        }
        return val;
    }
    
    @Override
    public String toString(){
        
        String datos = "";
        for (int i = 0; i < lista.size(); i++) {
            datos+=lista.get(i).toString()+"\n";
        }
        return "\n Datos Venta: " + "\nCliente: " + cliente + "\nInmueble: " + datos ;
    }
    
    //buscar elemento de arrayList
    
}
