package fciencias.edatos.binarySearch;

import java.util.Arrays;

/**
* Búsqueda binaria en un arreglo.
* @author Emmanuel Cruz Hernández.
* @version 1.0 Julio 2021.
* @since Estructuras de datos 2021-2.
*/
public class BinarySearcher{
	
	/**
	 * Verifica si un elemento está contenido en un arreglo.
	 * @param arr el arreglo donde buscar.
	 * @param e el elemento a buscar.
	 */
	public static boolean contains(int[] arr, int e){
		return contains(arr, e, 0, arr.length-1);
	}

	private static boolean contains(int[] array, int elem, int lo, int hi){
		if(lo>hi)
			return false;
		int mid = lo + ((hi-lo)/2);
		System.out.println(array[mid]);
		if(array[mid] == elem)
			return true;

		if(array[mid] > elem)
			return contains(array, elem, lo, mid-1);
		else
			return contains(array, elem, mid+1, hi);
	}

	/**
	 * Regresa la posición de un elemento en un arreglo.
	 * @param arr el arreglo donde buscar.
	 * @param e el elemento a buscar.
	 */
	public int find(int[] arr, int e){
		return 0;
	}

	public static void main(String[] args) {
		int[] arr = {1, 5, 7, 9, 12, 34, 57, 80, 134, 567, 894, 900, 930, 989, 1034, 1067, 1134, 2456};
		int elem = -500;
		System.out.println("¿El elemento "+elem+
			" está contenido en "+Arrays.toString(arr)+"? " +
			contains(arr, elem));
	}
}