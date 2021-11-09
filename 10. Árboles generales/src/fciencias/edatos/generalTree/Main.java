package fciencias.edatos.generalTree;

/**
* Prueba para árboles generales.
* @author Emmanuel Cruz Hernández.
* @version 2.0 Octubre 2021.
* @since Estructuras de datos 2022-1.
*/
public class Main{

	public static void main(String[] args) {
		TDATree<String> tree = new Tree<>();

		TreeNode<String> a = new TreeNode<>("A", null);
		TreeNode<String> z = new TreeNode<>("Z", a);
		TreeNode<String> r = new TreeNode<>("R", a);
		TreeNode<String> p = new TreeNode<>("P", z);
		TreeNode<String> t = new TreeNode<>("T", r);
		TreeNode<String> h = new TreeNode<>("H", r);
		TreeNode<String> w = new TreeNode<>("W", r);

		tree.addRoot(a);

		tree.preorden();
		tree.posorden();

		TDATree<String> tree2 = new Tree<>();

		TreeNode<String> a2 = new TreeNode<>("A", null);
		TreeNode<String> b2 = new TreeNode<>("B", a2);
		TreeNode<String> c2 = new TreeNode<>("C", a2);
		TreeNode<String> z2 = new TreeNode<>("Z", a2);
		TreeNode<String> j2 = new TreeNode<>("J", b2);
		TreeNode<String> e2 = new TreeNode<>("E", b2);
		TreeNode<String> h2 = new TreeNode<>("H", c2);

		tree2.addRoot(a2);

		//tree2.preorden();
		//tree2.posorden();

	}

}