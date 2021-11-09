package fciencias.edatos.generalTree;

import java.util.List;

/**
* TDA para árboles.
* @author Emmanuel Cruz Hernández.
* @version 2.0 Octubre 2021.
* @since Estructuras de datos 2022-1.
*/
public interface TDATree<T>{

	/**
	 * Agrega una raíz al árbol.
	 * @param node el nodo a agregar como raíz.
	 */
	public void addRoot(TreeNode<T> node);

	/**
	 * Regresa una lsita con los hijos de un nodo.
	 * @param node el nodo del cual regresar hijos.
	 * @return una lista con los hijos de node.
	 */
	public List<TreeNode<T>> children(TreeNode<T> node);

	/**
	 * Verifica si un nodo es interno.
	 * @param node el nodo a verificar.
	 * @return true si node es interno, false en otro caso.
	 */
	public boolean isInternal(TreeNode<T> node);

	/**
	 * Verifica si un nodo es hoja.
	 * @param node el nodo a verificar.
	 * @return true si node es hoja, false en otro caso.
	 */
	public boolean isLeaf(TreeNode<T> node);

	/**
	 * Regresa la raíz del árbol.
	 * @return la raíz del árbol.
	 */
	public TreeNode<T> root();

	/**
	 * Recorrido en preorden del árbol.
	 */
	public void preorden();

	/**
	 * Recorrido en preorden del árbol.
	 */
	public void posorden();

}