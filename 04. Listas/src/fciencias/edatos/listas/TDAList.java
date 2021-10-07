package fciencias.edatos.listas;

/**
* TDA para listas.
* @author Emmanuel Cruz Hernández.
* @version 3.0 Octubre 2021.
* @since Estructuras de datos 2022-1.
*/
public interface TDAList<T>{

	/**
	 * Inserta un nuevo elemento <i>e</i> en la posición <i>i</i>.
	 * @param i la posición donde agregar el elemento.
	 * @param e el elemento a insertar.
	 * @throws IndexOutOfBoundException si el índice está fuera de rango.
	 */
	public void add(int i, T e) throws IndexOutOfBoundsException;

	/**
	 * Regresa la cantidad de elementos contenidos en la lista.
	 * @return la cantidad de elementos contenidos.
	 */
	public int size();

}