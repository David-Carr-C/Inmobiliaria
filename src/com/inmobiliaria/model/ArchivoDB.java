package com.inmobiliaria.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Manejador de base de datos, en este caso mediante archivos
 * */
public class ArchivoDB {
    public static ArrayList<Inmueble> inmuebles; //Lista de los inmuebles del registro de la base de datos

    /**
     * Se leera el archivo y cada linea de texto sera una posicion en el arraylist de Strings, despues se
     * pasara a una funcion que donde toda la informacion leida pasara a ser de tipo Casa, Terreno, etc. donde sera almacenado
     * en un arraylist de inmuebles, y con ello se habran recuperado todos los datos del archivo en objetos de Java
     * <html><br></html>
     * {@code metodo estatico}
     * */
    public static void ActualizarBaseDeDatos() {
        ArrayList<String> lecturas = Leer();//Se lee el archivo Datos.txt
        inmuebles = LoadObjects(lecturas);//Se pasa las lineas leidas para transformarlos en objetos inmuebles
    }

    /**
     * Del array de Strings recuperado del archivo Datos.txt recreamos la informacion en subobjectos de inmueble
     * */
    private static ArrayList<Inmueble> LoadObjects(ArrayList<String> array) {
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
     * Guardara los parametros en el archivo de texto, usando la forma de concatenacion para no perder los anteriores datos
     * @param clave sera la clave unica del inmueble
     * @param tipo el tipo de inmueble: Casa, Casa Condominio, Departamento, Terreno
     * @param ubicacion ubicacion del inmueble
     * @param tamArea tamaño del inmueble
     * @param precio precio del inmueble
     * @param numCuartos numero de cuartos del inmueble
     * @param numBaños numero de baños del inmueble
     * @param descripcionGeneral una descripcion general acerca del inmueble
     * @param status posibles status: Disponible, Apartado, Vendido o Cuotas
     * <html><br></html>
     * {@code metodo estatico}
     * */
    public static void Guardar(String clave, String tipo, String ubicacion, double tamArea, double precio, int numCuartos,
                               int numBaños, String descripcionGeneral, String status) {

        try{
            FileWriter archivo = new FileWriter("Datos.txt",true); //Se creara un lector de archivos
            // el cual tendra como argumentos del contructor, el nombre del archivo a evaluar y si se desea anexar la informacion a escribir o no
            try(BufferedWriter almacen = new BufferedWriter(archivo)) {//Se creara un lectorBuffered para poder hacer un escrito de la siguiente informacion
                almacen.write(clave + "\n"); //Clave del inmueble
                almacen.write(tipo + "\n"); //Tipo del inmueble
                almacen.write(ubicacion + "\n"); //Ubicacion del inmueble
                almacen.write(tamArea + "\n"); //Tamaño del area del inmueble
                almacen.write(precio + "\n"); //Precio del inmueble
                almacen.write(numCuartos + "\n"); //No. cuartos del inmueble
                almacen.write(numBaños + "\n"); //No. cuartos del inmueble
                almacen.write(descripcionGeneral + "\n"); //Descripcion del inmueble
                almacen.write(status + "\n"); //Status del inmueble
                almacen.close(); //Siendo un total de 9 datos, y cada dato separado por un salto de linea
            } //Se cerraran los lectores para que el archivo pueda ser editado por otra parte del codigo
            archivo.close();
        }catch(Exception ex){ //Cualquier tipo de exception es capturada
            ex.printStackTrace(); //Se mostrara el trazo de la exception
            System.out.println(ex.getMessage()); //Y se informara sobre que fue la exception
            System.out.println("Fallo en el guardado de datos - ArchivoDB"); //Se informara que fue una falla en el metodo 'guardar'
        }
    }

    /**
     * Hace una lectura sobre el archivo Datos.txt para rescatar toda la informacion en forma de cadenas de texto
     * almacenadas en solo array
     * @return {@code ArrayList<String> Datos del archivo linea por linea}
     * */
    private static ArrayList<String> Leer(){
        ArrayList<String> datos = new ArrayList<>();
        try{
            FileReader archivo = new FileReader("Datos.txt");
            BufferedReader lectura = new BufferedReader(archivo);
            String cadena;
            
            while((cadena = lectura.readLine())!=null){
                datos.add(cadena);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return datos;
    }

    /**
     * Se hace una peticion de escritura sobre el archivo Datos.txt pero sin la opcion de 'append' para que este archivo
     * sea sobreescrito con una cadena vacia y por ende se borre todo el contenido
     * */
    public static void EliminarDB() {
        try{
            FileWriter archivo = new FileWriter("Datos.txt");
            try(BufferedWriter almacen = new BufferedWriter(archivo)) {
                almacen.write("");
                almacen.close();
            }
            archivo.close();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
}
