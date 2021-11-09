package fciencias.edatos.generalTree;

import java.util.List;
import java.util.ArrayList;

/**
* Implementación de un árbol.
* @author Emmanuel Cruz Hernández.
* @version 2.0 Octubre 2021 (anterior 1.0 Julio 2021).
* @since Estructuras de datos 2022-1.
*/
public class Tree<T> implements TDATree<T>{

	/** Raíz del árbol. */
	private TreeNode<T> root;

	@Override
	public void addRoot(TreeNode<T> node){
		this.root = node;
	}
	
	@Override
	public List<TreeNode<T>> children(TreeNode<T> node){
		return node.children;
	}

	@Override
	public boolean isInternal(TreeNode<T> node){
		return !node.children.isEmpty();
	}

	@Override
	public boolean isLeaf(TreeNode<T> node){
		return node.children.isEmpty();
	}

	@Override
	public TreeNode<T> root(){
		return root;
	}

	@Override
	public void preorden(){
		this.preorden(root, 0);
	}

	public void preorden(TreeNode<T> p, int spaces){
		// Si el nodo es null
		if(p == null)
			return;

		// visitamos el nodo
		String space = "";
		for(int j = 0; j < spaces; j++)
			space += "  ";

		System.out.println(space + "> " + p.element);

		// Aplicamos preorden a cada hijo de p
		for(int i = 0; i < p.children.size(); i++){
			preorden(p.children.get(i), spaces+1);
		}
	}

	@Override
	public void posorden(){
		posorden(root);
	}

	public void posorden(TreeNode<T> p){
		// Si el nodo es null
		if(p == null)
			return;

		// Aplicamos preorden a cada hijo de p
		for(int i = 0; i < p.children.size(); i++){
			posorden(p.children.get(i));
		}

		// visitamos el nodo

		System.out.println(p.element);

		
	}
	
}