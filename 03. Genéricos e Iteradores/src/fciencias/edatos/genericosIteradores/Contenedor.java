package fciencias.edatos.genericosIteradores;

import java.util.Iterator;

/**
 * Ejemplo de clase parametrizada.
 * @version 1.0 2020.
 * @since Estructuras de Datos 2021-2
 */
public class Contenedor<T>{

    /** Atributo genérico. */
    public T[] arreglo;

    /** Tope de elementos disponibles. */
    private int tope;

    /**
     * Crea un nuevo contenedor genérico.
     * @param size a la cantidad de elementos del arreglo.
     */
    public Contenedor(int size){
        arreglo = (T[]) new Object[size];
        tope = 0;
    }

    /**
     * Agrega un elemento al arreglo.
     * @param elem el elemento a agregar dentro del arreglo.
     */
    public void add(T elem){
        // Verificar que aun tiene espacio
        if(tope >= arreglo.length){
            throw new RuntimeException("Ya no hay espacio disponible");
        }

        arreglo[tope++] = elem;
    }

    /**
     * Regresa un iterador.
     * @return un iterador del contenedor.
     */
    public Iterator<T> generaIterador(){
        return new IteradorContenedor<T>(arreglo, tope);
    }

    /**
     * Iterador de la clase.
     */
    public class IteradorContenedor<T> implements Iterator<T>{

        /** Arreglo  */
        private T[] arreglo;

        /** Tope */
        private int tope;

        /** Punto de recorrido. */
        private int apuntador;

        /**
         * Crea un nuevo iterador.
         * @param arreglo el arreglo de elementos
         * @param tope el tope del recorrido.
         */
        public IteradorContenedor(T[] arreglo, int tope){
            this.arreglo = arreglo;
            this.tope = tope;
            this.apuntador = 0;
        }

        @Override
        public boolean hasNext(){
            if(apuntador<tope)
                return true;
            return false;
        }

        @Override
        public T next(){
            return arreglo[apuntador++];
        }
    }

    public static void main(String[] args) {
        Contenedor<String> contenedorString = new Contenedor<>(10);
        contenedorString.add("Hola");
        contenedorString.add("mundo");
        contenedorString.add("Una rola");
        contenedorString.add("Yonaguni");
        contenedorString.add("Al Zuri");
        contenedorString.add("El ultimo");
        contenedorString.add("El ultimo");
        contenedorString.add("El ultimo");
        contenedorString.add("El ultimo");
        contenedorString.add("El ultimo");

        Iterator<String> iterador = contenedorString.generaIterador();
        
        while(iterador.hasNext()){
            String elem = iterador.next();
            System.out.println(elem);
        } // O(n)

        System.out.println("\nSegunda iteración");

        iterador = contenedorString.generaIterador();
        
        while(iterador.hasNext()){
            String elem = iterador.next();
            System.out.println(elem);
        }
    }

}