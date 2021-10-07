package fciencias.edatos.listas;

/**
 * Introducción a la implementación de una lista
 * simplemente ligada.
 * @version 1.0 Octubre 2021.
 * @since Estructuras de Datos 2022-1
 */
public class SimpleList<T> implements TDAList<T>{

    /**
     * Nodo de una lista.
     */
    private class Node {

        /** El elemento del nodo. */
        private T element;

        /** El nodo siguiente. */
        private Node next;

        /**
         * Crea un nuevo nodo.
         * @param element el elemento que almacena el nodo.
         */
        public Node(T element){
            this.element = element;
        }

        /**
         * Permite cambiar el nodo siguiente.
         * @param newNode el nuevo nodo siguiente.
         */
        public void setNext(Node newNode){
            this.next = newNode;
        }

        /**
         * Accede a la información del nodo.
         * @return element.
         */
        public T getElement(){
            return element;
        }

        /**
         * Accede al nodo siguiente
         * @return next.
         */
        public Node getNext(){
            return next;
        }
    }

    /** Cabeza de la lista. */
    private Node head;

    /** Longitud de la lista . */
    private int size;

    @Override
    public void add(int i, T e) throws IndexOutOfBoundsException{
        // Cuando i no está en los rangos definidos
        if(i>size() || i<0)
            throw new IndexOutOfBoundsException();

        Node nuevo = new Node(e);

        // Es vacía
        if(head == null){
            head = nuevo;
            size++;
            return;
        }

        // Cuando se agrega al inicio
        if(i == 0){
            nuevo.setNext(head);
            head = nuevo;
            size++;
            return;
        }

        // Cuando se agrega en cualquier otra posición
        Node iterador = head;
        for(int j = 0; j < i-1 ; j++)
            iterador = iterador.getNext();

        nuevo.setNext(iterador.getNext());
        iterador.setNext(nuevo);
        size++;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public String toString(){
        String formato = "";

        Node iterador = head;
        while(iterador != null){
            formato += iterador.getElement() + "\n";
            iterador = iterador.getNext();
        }

        return formato;
    }

}