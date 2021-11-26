package fciencias.edatos.redBlackTree;

/**
* Implementación de un árbol rojinegro.
* @author Emmanuel Cruz Hernández.
* @version 2.0 Noviembre 2021.
* @since Estructuras de Datos 2022-1.
*/
public class RedBlackTree<K extends Comparable, T> implements TDABinarySearchTree<K, T>{

	/**
	 * Nodo rojinegro.
	 */
	public class RedBlackNode{ 

		/** Color del nodo */
		/* True para rojo false para negro. */
		public boolean color;

		/** Clave. */
		public K key;

		/** Elemento. */
		public T element;

		/** Padre del nodo. */
		public RedBlackNode parent;

		/** Hijo izquierdo. */
		public RedBlackNode left;

		/** Hijo derecho. */
		public RedBlackNode rigth;

		/**
		 * Crea un nuevo nodo rojinegro
		 * @param key la clave.
		 * @param element el elemento a almacenar.
		 * @param parent el padre del nodo.
		 */
		public RedBlackNode(K key, T element, RedBlackNode parent){
			this.key = key;
			this.element = element;
			this.parent = parent;
			color = true;
		}

		/**
		 * Crea un nuevo nodo rojinegro
		 * @param key la clave.
		 * @param element el elemento a almacenar.
		 * @param parent el padre del nodo.
		 * @param color el color del nodo.
		 */
		public RedBlackNode(K key, T element, RedBlackNode parent, boolean color){
			this.key = key;
			this.element = element;
			this.parent = parent;
			this.color = color;
		}

		/**
		 * Modifica el color del nodo.
		 */
		public void changeColor(){
			color = !color;
		}

		/**
		 * Accede al color del nodo
		 * @return el color del nodo.
		 */
		public boolean getColor(){
			return this.color;
		}

		/**
		 * Modifica al color del nodo
		 * @param color el color a asignar.
		 */
		public void setColor(boolean color){
			this.color=color;
		}

	}

	/** Raíz del árbol. */
	private RedBlackNode root;

	public RedBlackNode insert(T e, K k, RedBlackNode actual){
		return null;
	}

	@Override
	public void insert(T e, K k){
		RedBlackNode v = insert(e, k, root);
		rebalancea(v);
	}

	private void rebalancea(RedBlackNode v){
		// Caso 1
		if(v.parent == null){
			v.changeColor();
			v.setColor(false);
			return;
		}

		RedBlackNode p = v.parent;

		// Caso 2
		if(!p.getColor()){
			return;
		}

		RedBlackNode a = p.parent;
		RedBlackNode t = a.rigth == p ? a.left : a.rigth;

		// Caso 3
		if(t.getColor()){
			p.setColor(false);
			t.setColor(false);
			a.setColor(true);
			rebalancea(a);
			return;
		}

		// Case 4
		boolean leftV = v == p.left; // true // false
		boolean leftP = p == a.left; // false // true

		if(leftV!=leftP){
			if(leftP){
				// Rotar hacia la izquierda
			} else{
				// Rotar hacia la derecha
			}
			rebalancea(p);
			return;
		}

		// Caso 5
		p.setColor(false); // Cambiamos el color de p a negro
		a.setColor(true); // Cambiamos el color de a a rojo

		if(leftV){ // V es izquierdo
			// Rotamos al nodo "a" hacia la derecha
		} else{ // V es derecho
			// Rotamos al nodo "a" hacia la izquierda
		}

	}

	private RedBlackNode retrieve(RedBlackNode actual, K k){
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

	public RedBlackNode findMax(RedBlackNode actual){
		return null;
	}


	@Override
	public T delete(K k){
		RedBlackNode v = retrieve(root, k);

		// Si es null
		if(v == null){
			return null;
		}

		RedBlackNode h = null;

		// Si tiene dos hijos
		if(v.left!=null && v.rigth!=null){
			// Swap
			h = findMax(v.left);
			// Eliminamos el elemento con el que se hizo swap
		} else if(v.left==null && v.rigth==null){ // No tiene hijos
			h = null;
			boolean leftV = v.parent.left == v;
			if(leftV){
				v.parent.left = null;
			} else{
				v.parent.rigth = null;
			}
		} else{ // Solo tiene un hijo
			h = v.left!=null ? v.left : v.rigth;
		}

		// Caso a

		if(v.getColor()){
			return v.element;
		}

		// Caso b

		if(h.getColor()){
			h.changeColor();
			return v.element;
		}

		// Caso c
		if(!v.getColor() && !h.getColor()){
			// Tarea moral
			/*
			* Envolvemos a h en un nodo negro
			* Rebalanceamos sobre h
			* Desenvolvemos a h
			*/
		}


		return v.element;
	}

	@Override
	public T retrieve(K k){
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