package com.proyectoexamen.model;


public class Cliente {
    private String id,nombre,tel;

    public Cliente(String id, String nombre, String tel) {
        this.id = id;
        this.nombre = nombre;
        this.tel = tel;
    }
    
     public Cliente() {
        this.id = "";
        this.nombre = "";
        this.tel = "";
    }
    
    @Override
    public String toString(){
       return "\n Identificacio: " + id + "\n Nombre: " + nombre +
               "\n Telefono: " + tel;
    } 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    public static int CalcularMensualidad(int sueldo,int precio){
        if(sueldo > precio){
            int i = 1;
            i++;
            System.out.println(i+" "+ precio);  
            
        }else{
            CalcularMensualidad(sueldo, (int) (precio*0.5));
            CalcularMensualidad(sueldo, (int) (precio*0.4));
            CalcularMensualidad(sueldo, (int) (precio*0.3));
            CalcularMensualidad(sueldo, (int) (precio*0.2));
            CalcularMensualidad(sueldo, (int) (precio*0.1));
        }  
        return precio;
    }
    
}
