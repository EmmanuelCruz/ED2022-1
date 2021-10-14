package fciencias.edatos.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * Implementación de una pila basada en una lista oblemente ligada.
 *  Implementa las operaciones del TDAStack.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Octubre 2021.
 * @since Estructuras de datos 2021-2.
 */
public class Stack<T> implements TDAStack<T>{

    /** Lista base */
    public LinkedList<T> list = new LinkedList<>();
    
    @Override
    public void clear(){
        list.clear();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public T pop() throws EmptyStackException{
        if(list.isEmpty())
            throw new EmptyStackException();
        return list.remove(0);
    }

    @Override
    public void push(T e){
        list.add(0, e);
    }

    @Override
    public T top() throws EmptyStackException{
        if(list.isEmpty())
            throw new EmptyStackException();
        return list.get(0);
    }
}