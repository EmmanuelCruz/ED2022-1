package fciencias.edatos.generalTree;

import java.util.List;
import java.util.ArrayList;

/**
* Nodo para ún árbol general.
* @author Emmanuel Cruz Hernández.
* @version 1.0 Julio 2021.
* @since Estructuras de datos 2021-2.
*/
public class TreeNode<T>{

	/** Elemento que almacena. */
	public T element;

	/** Padre del nodo. */
	public TreeNode<T> parent;

	/** Hijos del nodo. */
	public List<TreeNode<T>> children = new ArrayList<>();

	/**
	 * Crea un nuevo nodo.
	 * @param element el elemento almacenado en el nodo.
	 * @param parent el padre del elemento.
	 */
	public TreeNode(T element, TreeNode<T> parent){
		this.element = element;

		// Se hace realación del nodo padre a hijo
		if(parent != null)
			parent.addChild(this);

		this.parent = parent;
	}

	/**
	 * Agrega un hijo al nodo.
	 * @param child el hijo a agregar.
	 */
	public void addChild(TreeNode<T> child){
		children.add(children.size(), child);
	}
}