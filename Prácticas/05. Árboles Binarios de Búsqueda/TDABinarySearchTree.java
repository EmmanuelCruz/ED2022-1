/**
* Interfaz que define las operaciones sobre un arbol
* binario de busqueda.
* @author Emmanuel Cruz Hernández.
* @version 3.0 Noviembre 2021 (Anterior 2.0 Julio 2021).
* @since Estructuras de Datos 2022-1.
*/
public interface TDABinarySearchTree<K extends Comparable, T>{

	/**
	* Recupera el objeto con clave k.
	* @param k la clave a buscar.
	* @return el elemento con clave k o null si no existe.
	*/
	public T retrieve(K k);

	/**
	* Inserta un nuevo elemento al árbol.
	* @param e el elemento a ingresar.
	* @param k la clave del elemento a ingresar.
	*/
	public void insert(T e, K k);

	/**
	* Elimina el nodo con clave k del árbol.
	* @param k la clave perteneciente al nodo a eliminar.
	* @return el elemento almacenado en el nodo a eliminar.
	* null si el nodo con clave k no existe.
	*/
	public T delete(K k);

	/**
	* Encuentra la clave k con valor o peso mínimo del árbol.
	* @return el elemento con llave de peso mínimo.
	*/
	public T findMin();

	/**
	* Encuentra la clave k con valor o peso máximo del árbol.
	* @return el elemento con llave de peso máximo.
	*/
	public T findMax();

	/**
	 * Recorre el árbol en preorden.
	 */
	public void preorden();

	/**
	 * Recorre el árbol en inorden.
	 */
	public void inorden();

	/**
	 * Recorre el árbol en postorden.
	 */
	public void postorden();

	/**
	* Verifica si el árbol es vacío.
	* @return true si el árbol es vacío, false en otro caso.
	*/
	public boolean isEmpty();

}