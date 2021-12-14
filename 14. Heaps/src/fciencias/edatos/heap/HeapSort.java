package fciencias.edatos.heap;

import java.util.Arrays;
import java.util.Random;

/**
* Implementación heap sort.
* @author Emmanuel Cruz Hernández.
* @version 1.0 Diciembre 2021.
* @since Estructuras de Datos 2022-1.
*/
public class HeapSort{

	/**
	 * Crea un nuevo arreglo con números pseudoaleatorios.
	 * @param n el tamaño del arreglo a crear.
	 * @param max el mayor elemento a generar en el arreglo.
	 * @return un arreglo de tamaño n con números pseudoaleatorios de 0 a 19.
	 */
	public static int[] generate(int n, int max){
		int[] res = new int[n];
		Random rn = new Random();
		for(int i = 0 ; i < n; i++)
			res[i] = rn.nextInt(max);
		return res;
	}

	/**
	 * Algoritmo de ordenamiento heapsort
	 * @param arr un arreglo de enteros.
	 */
	public static void heapSort(int[] arr){
		// Creamos el heap
		MaxHeap<Integer> heap = new MaxHeap<>(arr.length);

		// Insertamos todos los elementos del arreglo en el heap
		for(int entero: arr)
			heap.insert(entero);

		// Empezamos a sacar los elementos del heap y los guardamos de nuevo en el arreglo.
		for(int i = arr.length-1; i >= 0; i--)
			arr[i] = heap.delete();

	} // n + n log n + n log n --> O(n log n)



	public static void main(String[] args) {
		int[] arr1 = generate(200000, 100);

		//System.out.println("No ordenado: "+Arrays.toString(arr1));
		long inicio = System.currentTimeMillis();
		heapSort(arr1);
		long fin = System.currentTimeMillis();

		System.out.println("HeapSort se tardó: "+(fin-inicio)+" milisegundos");
		//System.out.println("Sí ordenado: "+Arrays.toString(arr1));
	}
}