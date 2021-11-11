package fciencias.edatos.binarySearchTree;

/**
* Implementación de un árbol binario de busqueda.
* @author Emmanuel Cruz Hernández.
* @version 3.0 Noviembre 2021 (Anterior 2.0 Julio 2021).
* @since Estructuras de Datos 2022-1.
*/
public class BinarySearchTree<K extends Comparable, T> implements TDABinarySearchTree<K, T>{
	
	/**
	 * Nodo para un árbol binario de búsqueda.
	 */
	public class BinaryNode{

		/** Clave. */
		public K key;

		/** Elemento. */
		public T element;

		/** Padre del nodo. */
		public BinaryNode parent;

		/** Hijo izquierdo. */
		public BinaryNode left;

		/** Hijo derecho. */
		public BinaryNode rigth;

		/**
		 * Crea un nuevo nodo.
		 * @param key la clave.
		 * @param element el elemento a almacenar.
		 * @param parent el padre del nodo.
		 */
		public BinaryNode(K key, T element, BinaryNode parent){
			this.key = key;
			this.element = element;
			this.parent = parent;
		}
	}

	/** Root */
	private BinaryNode root;

	@Override
	public T retrieve(K k){
		BinaryNode node = retrieve(root, k);
		if(node == null)
			return null;
		return node.element;
	}

	private BinaryNode retrieve(BinaryNode actual, K k){
		// No se encuentra el elemento
		if(actual == null)
			return null;

		// Si encontramos el elemento
		if(actual.key.compareTo(k) == 0)
			return actual;

		// Comparamos los elementos
		if(k.compareTo(actual.key) < 0){ // Verificamos en la izquierda
			return retrieve(actual.left, k);
		} else { // Verificar en la derecha
			return retrieve(actual.rigth, k);
		}
	}

	@Override
	public void insert(T e, K k){}


	@Override
	public T delete(K k){
		return null;
	}

	@Override
	public T findMin(){
		return null;
	}

	@Override
	public T findMax(){
		return null;
	}

	@Override
	public void preorden(){}

	@Override
	public void inorden(){}

	@Override
	public void postorden(){}

	public static void main(String[] args) {

	}
}