package fciencias.edatos.heap;

import java.util.Arrays;

/**
* Implementación de un max heap
* @author Emmanuel Cruz Hernández.
* @version 1.0 Diciembre 2021.
* @since Estructuras de Datos 2022-1.
*/
public class MaxHeap<K extends Comparable>{

	/** Representación del árbol. */
	private K[] arbol;

	/** Siguiente posición disponible. */
	private int pos;

	/**
	 * Crea un MaxHeap
	 * @param length la cantidad de elementos.
	 */
	public MaxHeap(int length){
		arbol = (K[]) new Comparable[length];
	}

	/**
	 * Inserta un nuevo elemento en el heap.
	 * @param e el elemento a insertar.
	 * @param k la clave del elemento a insertar.
	 */
	public void insert(K k){
		// Ya no hay espacio disponible
		if(pos >= arbol.length){
			arbol = Arrays.copyOf(arbol, arbol.length * 2);
		}

		// Insertar el elemento
		arbol[pos++] = k;

		// Reacomodarlo. Desde la hoja hasta la raíz.
		reacomodaArriba(pos-1);
	}

	/**
	 * Reacomoda un elemento hacia arriba
	 * @param posicion la posicion del elemento a reacomodar.
	 */
	public void reacomodaArriba(int posicion){
		int i = posicion;
		int padre = (i-1) / 2;

		while(padre >= 0){
			// Si el elemento es menor a su padre
			if(arbol[i].compareTo(arbol[padre]) < 0){
				return;
			} else{ // El elemento es mayor a su padre
				swap(i, padre);
				i = padre;
				if(padre-1 < 0)
					return;
				padre = (i-1) / 2;
			}
		}

	}

	/**
	 * Hace el swap de dos nodos.
	 * @param i la posicion del primer elemento.
	 * @param j la posición del segundo elemento.
	 */
	private void swap(int i, int j){
		K kTemp = arbol[i];
		arbol[i] = arbol[j];
		arbol[j] = kTemp;
	}

	/**
	 * Preorden
	 */
	public void preorden(){
		preorden(0, "");
	}

	/**
	 * Preorden
	 * @param posicion del elemento
	 */
	private void preorden(int posicion, String space){
		// Si el nodo no existe
		if(posicion >= pos)
			return;

		// Visitamos
		System.out.println(space + arbol[posicion]);

		// Aplicamos preorden a los hijos
		int izquierdo = 2*posicion + 1;
		int derecho = 2*posicion + 2;

		preorden(izquierdo, space + "    ");
		preorden(derecho, space + "    ");
	}

	/**
	 * Elimina un elemento del heap.
	 * @param k la clave del elemento a eliminar.
	 * @return el elemento eliminado.
	 */
	public K delete(K k){
		return null;
	}

	/**
	 * Obtiene el máximo elemento.
	 * @return el elemento con clave mayor.
	 */
	public K get(){
		return null;
	}

	public static void main(String[] args) {
		MaxHeap<Integer> maxHeap = new MaxHeap<>(10);
		
		maxHeap.insert(50);
		maxHeap.insert(60);
		maxHeap.insert(70);
		maxHeap.insert(100);
		maxHeap.insert(2);
		maxHeap.insert(200);
		maxHeap.insert(8);
		maxHeap.insert(45);

		maxHeap.preorden();
	}
}