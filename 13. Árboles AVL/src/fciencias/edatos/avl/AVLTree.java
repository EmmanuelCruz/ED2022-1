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

	/**
	 * Obtenia el nodo con una clave específica.
	 * @param k la clave a buscar
	 * @param actual el nodo actual
	 * @return el nodo con clave k o null si no existe.
	 */
	private AVLNode retrieve(K k, AVLNode actual){
		// Verificamos que actual es null
		if(actual == null)
			return null;

		int compare = k.compareTo(actual.clave);

		// Si existe el elemento
		if(compare == 0){
			return actual;
		}

		if(compare < 0){ // Caso del hijo izquiero
			return retrieve(k, actual.izquierdo);
		} else { // Caso del hijo derecho
			return retrieve(k, actual.derecho);
		}
	}

	@Override
	public void insert(T e, K k){
		if(raiz == null){ // Arbol vacío
			raiz = new AVLNode(e, k, null);
			return;
		}
		AVLNode v = insert(e, k, raiz);

		// Rebalancear a partir de v hasta raiz
		//rebalancea(v);
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
		AVLNode v = retrieve(k, raiz);

		// El elemento que queremos eliminar no está en el árbol
		if(v == null){
			return null;
		}

		T eliminado = v.elemento;

		// Eliminar con auxiliar
		AVLNode w = delete(v);

		// Rebalancear
		//rebalancea(w);

		return eliminado;
	}

	private AVLNode delete(AVLNode v){
		if(v.izquierdo!=null && v.derecho!=null){ // Tiene dos hijos
			AVLNode menor = findMin(v.derecho);
			swap(menor, v);
			return delete(menor);
		} else if(v.izquierdo==null && v.derecho==null){ // No tiene hijos
			boolean esIzquierdo = v.padre.izquierdo==v;
			if(esIzquierdo){
				v.padre.izquierdo = null;
			} else{
				v.padre.derecho = null;
			}
			return v.padre;
		} else{ // Sólo tiene un hijo
			boolean hijoIzquierdo = v.izquierdo!=null;
			if(hijoIzquierdo){
				swap(v, v.izquierdo);
				return delete(v.izquierdo);
			} else{
				swap(v, v.derecho);
				return delete(v.derecho);
			}
		}
	}

	@Override
	public T findMin(){
		return null;
	}

	private void swap(AVLNode v, AVLNode w){
		T value = v.elemento;
		K clave = v.clave;
		v.elemento = w.elemento;
		v.clave = w.clave;
		w.elemento = value;
		w.clave = clave;
	}

	private AVLNode findMin(AVLNode actual){
		if(actual == null)
			return null;
		AVLNode iterador = actual;

		while(iterador.izquierdo != null){
			iterador = actual.izquierdo;
		}

		return iterador;

	}

	@Override
	public T findMax(){
		return null;
	}

	@Override
	public void preorden(){
		preorden(raiz);
	}

	private void preorden(AVLNode actual){
		if(actual==null)
			return;

		System.out.println(actual.elemento);
		preorden(actual.izquierdo);
		preorden(actual.derecho);
	}

	@Override
	public void inorden(){}

	@Override
	public void postorden(){}

	public static void main(String[] args) {
		AVLTree<Integer, Integer> arbol = new AVLTree<>();

		arbol.insert(9, 9);
		arbol.insert(12, 12);
		arbol.insert(3, 3);
		arbol.insert(4, 4);
		arbol.insert(2, 2);
		arbol.insert(5, 5);
		arbol.insert(1, 1);
		arbol.insert(11, 11);
		arbol.insert(14, 14);
		arbol.insert(15, 15);

		arbol.delete(9);
		arbol.delete(12);
		arbol.delete(5);

		arbol.preorden();
	}
}