/**
* TDA para colas.
* @author Emmanuel Cruz Hernández.
* @version 3.0 Octubre 2021.
* @since Estructuras de datos 2022-1.
*/
public interface TDAQueue<T>{

	/**
	 * Limpia la cola. Elimina todos los elementos.
	 */
	public void clear();

	/**
	 * Remueve y regresa el siguiente elemento en la cola.
	 * @return el siguiente en la cola o null si es vacía.
	 */
	public T dequeue();

	/**
	 * Agrega un nuevo al final de la cola.
	 * @param e el elemento a agregar.
	 */
	public void enqueue(T e);

	/**
	 * Devuelve el elemento siguiente en la cola, sin eliminarlo.
	 * @return el siguiente elemento en la cola o null si es vacía.
	 */
	public T first();

	/**
	 * Verifica si la cola está vacía.
	 * @return true si la cola no contiene elementos, false en otro caso.
	 */
	public boolean isEmpty();

}