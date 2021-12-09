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

	/** Cantidad de elementos por default. */
	private final int MAX = 100;

	/**
	 * Crea un MaxHeap
	 * @param length la cantidad de elementos.
	 */
	public MaxHeap(int length){
		if(length<=0)
			arbol = (K[]) new Comparable[MAX];
		else
			arbol = (K[]) new Comparable[length];
	}

	/**
	 * Crea un MaxHeap
	 */
	public MaxHeap(){
		arbol = (K[]) new Comparable[MAX];
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
	 * @param space la cantidad de espacio entre hijos
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
	 * @return el elemento eliminado.
	 */
	public K delete(){
		// Verificamos que no sea vacío
		if(arbol[0] == null)
			return null;

		// Almacenamos el elemento que se va a eliminar
		K eliminado = arbol[0];

		// Intercambiamos la raíz con el último insertado
		swap(0, pos-1);

		// Eliminamos la hoja
		arbol[pos-1] = null;
		pos--;

		// Reacomodar hacia abajo
		reacomodaAbajo(0);

		return eliminado;
	}

	/**
	 * Reacomoda un elemento desde la raíz hasta las hojas.
	 * @param posicion la posicion del elemento a reacomodar.
	 */
	private void reacomodaAbajo(int posicion){
		int i = posicion;
		int izquierdo = 2*i + 1;
		int derecho = 2*i + 2;

		// Mientras tenga hijos
		while(izquierdo < arbol.length && arbol[izquierdo]!=null){
			// Si tiene un solo hijo
			if(arbol[derecho]==null){

				// El padre es mayor a su izquierdo
				if(arbol[i].compareTo(arbol[izquierdo]) >= 0)
					return;

				swap(i, izquierdo);

				i = izquierdo;

			} else{ // Tiene dos hijos
				if(arbol[i].compareTo(arbol[izquierdo]) >= 0 && 
					arbol[i].compareTo(arbol[derecho]) >= 0)
					return;

				if(arbol[izquierdo].compareTo(arbol[derecho]) > 0){ // El izquierdo es mayor
					swap(i, izquierdo);
					i = izquierdo;
				} else{ // El derecho es el mayor
					swap(i, derecho);
					i = derecho;
				}
			}
			izquierdo = 2*i + 1;
			derecho = 2*i + 2;
		}
	}

	/**
	 * Obtiene el máximo elemento.
	 * @return el elemento con clave mayor.
	 */
	public K get(){
		if(arbol[0]==null)
			return null;
		return arbol[0];
	}

	public static void main(String[] args) {
		MaxHeap<Integer> maxHeap = new MaxHeap<>(15);

		maxHeap.insert(50);
		maxHeap.insert(60);
		maxHeap.insert(70);
		maxHeap.insert(100);
		maxHeap.insert(2);
		maxHeap.insert(200);
		maxHeap.insert(8);
		maxHeap.insert(45);
		maxHeap.insert(5);
		maxHeap.insert(250);

		maxHeap.delete();
		maxHeap.delete();
		System.out.println("Resultado del delete: " + maxHeap.delete());

		maxHeap.preorden();

	}
}