package fciencias.edatos.mapas;

import java.util.Random;

/**
* Implementación básica de un HashMap.
* @author Emmanuel Cruz Hernández.
* @version 2.0 Enero 2022. Anterior 1.0 Enero 2021.
* @since Estructuras de Datos 2022-1.
*/
public class AbstractHashMap<K,V> implements Map<K,V>{

	/** Arreglo de elementos. */
	private V[] table;

	/** Capacidad de la tabla. */
	private int capacity;

	/** Factor primo para calcular longitudes. */
	private int prime;

	/** Cantidad del cambio y escala. */
	private long scale, shift;

	/**
	* Crea un nuevo AbstractHashMap. 
	* @param cap la capacidad de la tabla.
	* @param p el factor primo.
	*/
	public AbstractHashMap(int cap, int p){
		table = (V[]) new Object[cap];
		prime = p;
		capacity = cap;
		Random rn = new Random();
		scale = rn.nextInt(prime-1) + 1;
		shift = rn.nextInt(prime);
	}

	/**
	* Crea un nuevo AbstractHashMap.
	* @param cap la capacidad de la tabla.
	*/
	public AbstractHashMap(int cap){
		this(cap, 109345121);
	}

	/**
	* Crea un nuevo AbstractHashMap.
	*/
	public AbstractHashMap(){
		this(17);
	}

	@Override
	public int size(){
		return 0;
	}

	@Override
	public V get(K key){
		return null;
	}

	@Override
	public V put(K key, V value){
		return null;
	}

	@Override
	public V remove(K key){
		return null;
	}

	@Override
	public boolean isEmpty(){
		return false;
	}

	public static void main(String[] args) {
		Integer cinco = new Integer(5);
		System.out.println(cinco.hashCode());
		String hola = "Hola";
		String hola2 = "Hola";

		System.out.println(hola.hashCode());
		System.out.println(hola2.hashCode());

		AbstractHashMap<String, String> map = new AbstractHashMap<>();
		System.out.println("Hash code map: " + map.hashCode());

	}

}
