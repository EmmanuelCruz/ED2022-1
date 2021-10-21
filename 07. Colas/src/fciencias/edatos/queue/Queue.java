package fciencias.edatos.queue;

import java.util.LinkedList;

/**
 * Implementación de una colas basada en una lista oblemente ligada.
 *  Implementa las operaciones del TDAQueue.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Octubre 2021.
 * @since Estructuras de datos 2021-2.
 */
public class Queue<T> implements TDAQueue<T>{

    /** Lista */
    private LinkedList<T> lista = new LinkedList<T>();

    @Override
    public void clear(){
        lista.clear();
    }

    @Override
    public T dequeue(){
        if(lista.isEmpty())
            return null;
        return lista.remove(0);
    }

    @Override
    public void enqueue(T e){
        lista.add(lista.size(), e);
    }

    @Override
    public T first(){
        if(lista.isEmpty())
            return null;
        return lista.get(0);
    }

    @Override
    public boolean isEmpty(){
        return lista.isEmpty();
    }

}