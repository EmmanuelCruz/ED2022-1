package fciencias.edatos.complejidad;

import java.lang.System;

public class PositionFindex {
    
    /**
     * Encuentra la primera y ultima posicion de un elemento
     * en un arreglo de enteros.
     * @param arr el arreglo que contiene los enteros donde buscar.
     * @param elem el elemento a buscar.
     * @return un arreglo unidimensional de longitud 2.
     * En la primera posicion se almacena el primer indice donde esta
     * elem y la segunda posicion almacena el último índice donde esta elem.
     * Si no se encuentra se almacena un -1.
     */
    public static int[] findIndexes(int[] arr, int elem){
        // Buscar la posicion del primer indice [1, 1, 1]
        int inicio = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == elem){
                inicio = i;
                break;
            }
        }

        // Buscar la posicion del segundo indice
        int fin = -1;
        for(int j = arr.length-1; j >= 0; j--){
            if(arr[j] == elem){
                fin = j;
                break;
            }
        } 

        int[] result = {inicio, fin};

        return result;
    } // O(2n)

    /**
     * Encuentra la primera y ultima posicion de un elemento
     * en un arreglo de enteros.
     * @param arr el arreglo que contiene los enteros donde buscar.
     * @param elem el elemento a buscar.
     * @return un arreglo unidimensional de longitud 2.
     * En la primera posicion se almacena el primer indice donde esta
     * elem y la segunda posicion almacena el último índice donde esta elem.
     * Si no se encuentra se almacena un -1.
     */
    public static int[] findIndexesPro(int[] arr, int elem){
        // Buscar la posicion de ambos al mismo tiempo
        int inicio = -1, fin = -1;
        for(int i=0; i < arr.length; i++){
            if(arr[i] == elem && inicio==-1)
                inicio = i;
            
            if(arr[arr.length-1-i] == elem && fin==-1)
                fin = arr.length-1-i;

            if(inicio != -1 && fin != -1)
                break;
        }

        int[] result = {inicio, fin};

        return result;
    } // O(n)

    public static void main(String[] args) {
        int[] arr = ArrayReader.readArray("Tests/ArrayTests/ArrayF2.txt");

        long inicio = System.currentTimeMillis();
        findIndexes(arr, -20);
        long fin = System.currentTimeMillis();

        System.out.println("El algoritmo 1 se tardó: " + (fin-inicio) + " milisegundos");

        inicio = System.currentTimeMillis();
        findIndexesPro(arr, -20);
        fin = System.currentTimeMillis();

        System.out.println("El algoritmo 2 se tardó: " + (fin-inicio) + " milisegundos");
    }
}
