package fciencias.edatos.avl;

/**
* Implementación de árbol AVL
* @author Emmanuel Cruz Hernández.
* @version 3.0 Noviembre 2021 (Anterior 2.0 Julio 2021).
* @since Estructuras de Datos 2022-1.
*/
public class AVLTree<K extends Comparable, T> implements TDABinarySearchTree<K, T>{

	/**
	 * Nodo de un arbol AVL.
	 */
	public class AVLNode{

		/** Altura del nodo. */
		public int altura;

		/** Hijo izquierdo. */
		public AVLNode izquierdo;

		/** Hijo derecho. */
		public AVLNode derecho;

		/** Padre del nodo. */
		public AVLNode padre;

		/** Elemento almacenado en el nodo. */
		public T elemento;

		/** Clave del nodo. */
		public K clave;

		/**
		 * Crea un nuevo nodo AVL
		 * @param element el elemento a almacenar.
		 * @param key la clave del nodo.
		 * @param padre el padre del nodo
		 */
		public AVLNode(T element, K key, AVLNode padre){
			elemento = element;
			clave = key;
			this.padre = padre;
			altura = this.getAltura();
		}

		/**
		 * Calcula la altura del nodo.
		 */
		public int getAltura(){
			// Si este nodo es hoja
			if(izquierdo == null && derecho==null){
				return 0;
			} else if(izquierdo != null && derecho != null){ // Dos hijos
				int max = izquierdo.getAltura() > derecho.getAltura() ? izquierdo.getAltura() : derecho.getAltura();
				return 1 + max;
			} else{ // Tiene solo un hijo
				boolean tieneIzquierdo = izquierdo!=null;
				return 1 + (tieneIzquierdo ? izquierdo.getAltura() : derecho.getAltura());
			}
		}

		/**
		 * Actualiza la altura del nodo.
		 */
		public void actualizaAltura(){
			this.altura = this.getAltura();
		}
	}

	private AVLNode raiz;

	@Override
	public T retrieve(K k){
		return null;
	}

	@Override
	public void insert(T e, K k){
		if(raiz == null){ // Arbol vacío
			raiz = new AVLNode(e, k, null);
			return;
		}
		AVLNode v = insert(e, k, raiz);

		// Rebalancear a partir de v hasta raiz
	}

	/**
	 * Inserta un nodo de forma recursiva.
	 * @param e el elemento a insertar
	 * @param k es la clave del nodo a insertar
	 * @param actual el nodo actual
	 * @return 
	 */
	public AVLNode insert(T e, K k, AVLNode actual){
		if(k.compareTo(actual.clave)<0){ // Verificamos sobre el izquierdo
			if(actual.izquierdo == null){ // Insertamos en esa posición
				actual.izquierdo = new AVLNode(e, k, actual);
				return actual.izquierdo;
			} else { // Recursión sobre el izquierdo
				return insert(e, k, actual.izquierdo);
			}
		} else{ // Verificamos sobre la derecha
			if(actual.derecho == null){ // Insertamos en esa posición
				actual.derecho = new AVLNode(e, k, actual);
				return actual.derecho;
			} else { // Recursión sobre el derecho
				return insert(e, k, actual.derecho);
			}
		}
	}

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