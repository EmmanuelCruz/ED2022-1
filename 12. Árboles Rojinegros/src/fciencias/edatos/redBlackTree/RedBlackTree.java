package fciencias.edatos.redBlackTree;

/**
* Implementación de un árbol rojinegro.
* @author Emmanuel Cruz Hernández.
* @version 2.0 Noviembre 2021.
* @since Estructuras de Datos 2022-1.
*/
public class RedBlackTree<K extends Comparable, T> extends BinarySearchTree<K, T>{

	/**
	 * Nodo rojinegro.
	 */
	public class RedBlackNode<K extends Comparable, T> extends BinarySearchTree.BinaryNode{ 

		/** Color del nodo */
		/* True para rojo false para negro. */
		public boolean color;

		/**
		 * Crea un nuevo nodo rojinegro
		 * @param key la clave.
		 * @param element el elemento a almacenar.
		 * @param parent el padre del nodo.
		 */
		public RedBlackNode(K key, T element, RedBlackNode parent){
			super(key, element, parent);
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
			super(key, element, parent);
			this.color = color;
		}

		public RedBlackNode(BinaryNode node){
			super(node.key, node.element, node.parent);
			super.rigth = node.rigth;
			super.left = node.left;
			color = true;
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
		RedBlackNode<K, T> v = insert(e, k, root);
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

	}


	@Override
	public T delete(K k){
		return null;
	}

	
	public static void main(String[] args) {
		
	}
}