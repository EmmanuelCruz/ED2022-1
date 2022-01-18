package fciencias.edatos.graficas;

import java.util.ArrayList;

/**
* Se definen las operaciones que se pueden hacer sobre graficas.
* @author Emmanuel Cruz Hernández.
* @version 1.0 Enero 2021.
* @since Estructuras de Datos 2021-1.
*/
public interface TDAGrafica<V, E>{

	/**
	* Representación de una arista.
	*/
	public class Arista<V, E>{

		/** Identificador de la arista. */
		private E id;

		/** Primer vertice de la arista. */
		private V v1;

		/** Segundo vertice de la arista. */
		private V v2;

		/**
		* Crea una nueva arista.
		* @param name el nombre de la arista.
		* @param v1 el primer vertice de adyacencia.
		* @param v2 el segundo vertice de adyacencia.
		*/
		public Arista(E name, V v1, V v2){
			this.id = name;
			this.v1 = v1;
			this.v2 = v2;
		}

		/**
		* Crea una nueva arista.
		* @param v1 el primer vertice de adyacencia.
		* @param v2 el segundo vertice de adyacencia.
		*/
		public Arista(V v1, V v2){
			this.v1 = v1;
			this.v2 = v2;
		}

		/**
		* Regresa el identificador de la arista.
		* @return el id de la arista.
		*/
		public E getId(){
			return id;
		}

		/**
		* Regresa el primer vertice de la arista.
		* @return el primer vertice.
		*/
		public V getV1(){
			return v1;
		}

		/**
		* Regresa el segundo vertice de la arista.
		* @return el segundo vertice.
		*/
		public V getV2(){
			return v2;
		}

		/**
		* Verifica si dos vertices conforman la arista.
		* @param v1 el primer vertice a verificacion.
		* @param v2 el segundo vertice a verificacion.
		* @return true si ambos vertices conforman la arista, false en otro caso.
		*/
		public boolean isContained(V v1, V v2){
			return (this.v1.equals(v1) || this.v2.equals(v1) ) && 
				(this.v1.equals(v2) || this.v2.equals(v2));
		}

		public boolean isEdge(V v1, V v2){
			return v1.equals(this.v1) && v2.equals(this.v2);
		}

		public boolean isContained(V v){
			return v.equals(v1) || v.equals(v2);
		}

		public boolean isSame(E e){
			return e.equals(id);
		}
	}

	/**
	* Regresa la cantidad de vertices de la grafica.
	* @return la cantidad de vertices.
	*/
	public int numVertex();

	/**
	* Regresa la cantidad de aristas de una grafica.
	* @return la cantidad de aristas de una grafica.
	*/
	public int numEdges();

	/**
	* Regresa una lista de vertices de una grafica.
	* @return una lista con todos los vertices de la grafica.
	*/
	public ArrayList<V> getVertex();

	/**
	* Regresa una lista de aristas de una grafica.
	* @return una lista con todas las aristas de la grafica.
	*/
	public ArrayList<Arista<V, E>> getEdge();

	/**
	* Regresa la arista que contiene dos vertices.
	* @param v1 el primer vertice a buscar arista.
	* @param v2 el segundo vertice a buscar arista.
	* @return la arista compuesta por v1 y v2, false en otro caso.
	*/
	public boolean getEdge(V v1, V v2);

	/**
	* Regresa la cantidad de aristas que salen de un vertice.
	* @param v el vertice a encontrar vecinos.
	* @return la cantidad de vertices que salen de un vertice.
	*/
	public int outDegree(V v);

	/**
	* Inserta un nuevo vertice a la grafica.
	* @param v el nuevo vertice a insertar.
	*/
	public void insertVertex(V v);

	/**
	* Elimina un vertice de la grafica.
	* @param v el vertice a eliminar de la grafica.
	* @return el valor almacenado en el vertice o null si no existe.
	*/
	public V removeVertex(V v);

	/**
	* Elimina una arista de la grafica.
	* @param e la arista a eliminar.
	*/
	public void removeEdge(V v1, V v2);
}