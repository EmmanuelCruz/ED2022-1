package fciencias.edatos.complejidad;

import java.lang.System;

/**
* Primer ejempo y ejercicio del curso de estructuras de datos.
* @author Emmanuel Cruz Hernández.
* @version 2.0 Septiembre 2021.
* @since Estructuras de datos 2022-1.
*/
public class Averager{

	/**
	* Calcula el promedio de n números
	* considerando 1, 2, 3, ..., n números involucrados en el promedio.
	* @param x el arreglo que contiene los n números.
	* @return un arreglo con el promedio de los primeros
	* 1, 2, 3, ..., n números.
	*/
	public static double[] prefixAverage1(double[] x) {
		int n = x.length;
		double[] a = new double[n];
		for (int j=0; j < n; j++) {
			double total = 0;
			for (int i=0; i <= j; i++){
				total += x[i];
			}
			a[j] = total / (j+1);
		}
		return a;
	} // O(n*n)

	/**
	* Calcula el promedio de n números
	* considerando 1, 2, 3, ..., n números involucrados en el promedio.
	* @param x el arreglo que contiene los n números.
	* @return un arreglo con el promedio de los primeros
	* 1, 2, 3, ..., n números.
	*/
	public static double[] prefixAverage2(double[] x){
		double[] result = new double[x.length];
		double total = 0;
		for(int i = 0; i < x.length; i++){
			total += x[i];
			result[i] = total / (i+1);
		}
		return result;
	} // O(n)

    public static void main(String[] args) {

		double[] entrada = new double[20000];

		long inicio = System.currentTimeMillis();
		prefixAverage1(entrada);
		long fin = System.currentTimeMillis();

		System.out.println("El algoritmo 1 se tardó: "+ (fin - inicio) + " milisegundos.");

		inicio = System.currentTimeMillis();
		prefixAverage2(entrada);
		fin = System.currentTimeMillis();

		System.out.println("El algoritmo 2 se tardó: "+ (fin - inicio) + " milisegundos.");
    }
}
