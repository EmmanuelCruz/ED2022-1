package fciencias.edatos.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * Implementación de una pila basada en una lista oblemente ligada.
 *  Implementa las operaciones del TDAStack.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Junio 2021.
 * @since Estructuras de datos 2021-2.
 */
public class Stack<T> implements TDAStack<T>{
    
    @Override
    public void clear(){}

    @Override
    public boolean isEmpty(){
        return false;
    }

    @Override
    public T pop() throws EmptyStackException{
        return null;
    }

    @Override
    public void push(T e){}

    @Override
    public T top() throws EmptyStackException{
        return null;
    }
}