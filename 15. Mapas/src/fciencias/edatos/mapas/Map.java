package fciencias.edatos.mapas;

/**
* Define las operaciones sobre un mapa.
* @author Emmanuel Cruz H.
* @version 2.0 Enero 2022. Anterior 1.0 Enero 2021.
* @since Estructuras de Datos 2022-1.
*/
public interface Map<K,V>{
	
	/**
	* Regresa la cantidad de elementos contenidos en el mapa.
	* @return la cantidad de elementos contenidos.
	*/
	public int size();

	/**
	* Verifica si el mapa es vacio.
	* @return true si es vacio, false en otro caso.
	*/
	public boolean isEmpty();

	/**
	* Obtiene el elemento con clave k en el mapa.
	* @param key la clave asignada a un elemento para obtener.
	* @return el elemento con clave key.
	*/
	public V get(K key);

	/**
	* Agrega un nuevo elemento al mapa.
	* @param key la clave del elemento a agregar.
	* @param value el elemento a agregar.
	* @return el elemento antiguo almacenado con clave key o null si no existe.
	*/
	public V put(K key, V value);

	/**
	* Elimina el elemento con clave key.
	* @param key la clave del elemento a remover.
	* @return el elemento con clave key eliminado o null si no existe.
	*/
	public V remove(K key);
}
