package fciencias.edatos.sorter;

import java.util.Arrays;
import java.lang.System;
import java.util.Random;

/**
 * Implementación de algunos algoritmos de ordenamiento.
 * @author Emmanuel Cruz Hernández.
 * @version 2.0 Octubre 2021.
 * @since Estructuras de datos 2022-1.
 */
public class Sorter{

	/**
	 * Cambia de posición dos elementos entre sí de un arreglo de enteros.
	 * @param arr el arreglo del cual cambiar la posición de los elementos.
	 * @param i el índice del primer elemento a cambiar.
	 * @param j el índice del segundo elemento a cambiar.
	 */
	private static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	/**
	 * Ordena un arreglo de forma ascendente con insertion sort.
	 * @param arr el arreglo a ordenar.
	 */
	public static void insertionSort(int[] arr){
		for(int i = 0; i < arr.length-1; i++)
			for(int j = i+1; j>0 && arr[j-1]>arr[j]; j--)
				swap(arr, j, j-1);
	}

	/**
	 * Ordena un arreglo de forma ascendente con selection sort.
	 * @param arr el arreglo a ordenar.
	 */
	public static void selectionSort(int[] arr){
		for(int i = arr.length-1; i > 0 ; i--){
			int max = 0;
			for(int j = 1; j<=i; j++){
				if(arr[j] > arr[max])
					max = j;
			}
			swap(arr, max, i);
		}
	} // El peor caso es tener el arreglo ordenado descendentemente

	/**
	 * Ordena un arreglo de forma ascendente con merge sort.
	 * @param arr el arreglo a ordenar.
	 */
	public static void mergeSort(int[] arr){}

	/**
	 * Auxiliar de mergeSort para dividir y mezclar.
	 * @param arr el arreglo con los elementos a dividir y mezclar.
	 * @param lo el índice de inicio a modificación.
	 * @param hi el índice del último elemento a modificación.
	 */
	private static void mergeSort(int[] arr, int lo, int hi){}

	/**
	 * Mezcla dos arreglos, ordenando de menor a mayor.
	 * @param arr el arreglo con los elementos a modificar.
	 * @param lo el inicio de la primera mitad.
	 * @param mid el índice de la mitad del subarreglo.
	 * @param hi el índice del último elemento.
	 */
	private static void merge(int[] arr, int lo, int mid, int hi){} 

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

	public static void main(String[] args) {
		int[] arr1 = generate(10000, 15);
		//System.out.println("No ordenado: " + Arrays.toString(arr1));
		long inicio = System.currentTimeMillis();
		selectionSort(arr1);
		long fin = System.currentTimeMillis();

		System.out.println("Ordenado con selectionSort tardó: " + (fin - inicio) + " milisegundos");

		int[] arr2 = generate(10000, 15);

		inicio = System.currentTimeMillis();
		insertionSort(arr2);
		fin = System.currentTimeMillis();

		System.out.println("Ordenado con insertionSort tardó: " + (fin - inicio) + " milisegundos");
	}
}