package fciencias.edatos.genericosIteradores;

import java.util.Iterator;

/**
 * Ejemplo de clase parametrizada.
 * @version 1.0 2020.
 * @since Estructuras de Datos 2021-2
 */
public class Contenedor<T, V>{

    /** Atributo genérico. */
    public T generico1;

    /** Segundo atributo genérico */
    public V generico2;

    /**
     * Crea un nuevo contenedor genérico.
     * @param generico un objeto de tipo T.
     * @param generico2 un objeto de tipo V.
     */
    public Contenedor(T generico, V generico2){
        this.generico1 = generico;
        this.generico2 = generico2;
    }

    /**
     * Obtiene el genérico T-
     * @return el atributo T.
     */
    public T getGenerico(){
        return generico1;
    }

    /**
     * Obtiene el genérico V.
     * @return el genético V.
     */
    public V getGenerico2(){
        return generico2;
    }

    @Override
    public String toString(){
        return "Genérico 1: " + generico1 + "\nGenérico 2: " + generico2;
    }

    public static void main(String[] args) {
        Contenedor<String, String> contenedorString = new Contenedor<String, String>("Hola", "mundo");
        Contenedor<Integer, Float> contenedorInteger = new Contenedor<>(1, 4.5f);
        Contenedor<Boolean, String> contenedorBoolean = new Contenedor<>(true, "Verdadero");
        Contenedor<Integer, Integer> contenedorIntegerI = new Contenedor<>(5, 1);

        System.out.println(contenedorString);

        System.out.println(contenedorBoolean);

        System.out.println(contenedorInteger.getGenerico() + contenedorInteger.getGenerico2());

        // Contenedor<Cancion> contenedorCancion = new Cancion<>(new Cancion(), new Cancion());
    }

}