import java.util.EmptyStackException;

/**
* TDA para pilas.
* @author Emmanuel Cruz Hernández.
* @version 2.0 Octubre 2021.
* @since Estructuras de datos 2022-1.
*/
public interface TDAStack<T>{

	/**
	 * Limpia la pila. Elimina todos los elementos.
	 */
	public void clear();

	/**
	 * Verifica si la pila está vacía.
	 * @return true si la pila no contiene elementos, false en otro caso.
	 */
	public boolean isEmpty();

	/**
	 * Remueve y regresa el tope de la pila.
	 * @return el tope de la pila.
	 * @throws EmptyStackExpception si la pila está vacía.
	 */
	public T pop() throws EmptyStackException;

	/**
	 * Agrega un nuevo elemento a la pila.
	 * @param e el elemento a agregar.
	 */
	public void push(T e);

	/**
	 * Regresa el tope de la pila.
	 * @throws EmptyStackExpception si la pila está vacía.
	 */
	public T top() throws EmptyStackException;

}