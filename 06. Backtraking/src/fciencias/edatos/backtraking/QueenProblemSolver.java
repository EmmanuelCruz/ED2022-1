package fciencias.edatos.backtraking;

import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Implementación del problema de las n reinas.
 * @author Emmanuel Cruz Hernández.
 * @version 2.0 Octubre 2021 (Anterior 1.0 Junio 2021).
 * @since Estructuras de datos 2022-1.
 */
public class QueenProblemSolver{

	/**
	 * Tablero que representa un estado del problema de las 8 reinas.
	 */
	public class Board{

		/** Tablero que representa un estado. */
		public int[] board;

		/** Elementos visitados. */
		public ArrayList<Integer> visited = new ArrayList<>();

		/** Longitud del tablero. */
		public int n;

		/**
		 * Crea un nuevo tablero.
		 * @param board el nuevo tablero a almacenar.
		 * @param n la longitud del tablero.
		 */
		public Board(int[] board, int n){

		}

		/**
		 * Verifica si el tablero es solución.
		 * @return true si el tablero es solucion. False en otro caso.
		 */
		public boolean isSolution(){
			// Debe ser de longitud n
			// Debe ser extendible

			return false;
		}

		/**
		 * Verifica si el tablero se puede extender.
		 * @return true si el tablero se puede extender, false en otro caso.
		 */
		public boolean isExtensible(){
			// Si ya se visitaron n -> ?????
			
			// No debe haber en la misma columna
			// No debe haber diagonales
			// No debe haber diagonales invertidas
			return false;
		}

		/**
		 * Extiende el tablero.
		 * @return un nuevo tablero creado a partir del actual. 
		 * Este resultado representa el tablero extendido.
		 */
		public Board extend(){
			return null;
		}

		@Override
		public String toString(){
			String rep = "";
			for(int i = 0; i < board.length; i++){
				rep += "|";
				for(int j = 0; j < 8; j++)
					rep += board[i]==j ? " R " : " - ";
				rep += "|\n";
			}
			return rep;
		}
	}

	/**
	 * Encuentra una solución al problema de las n reinas.
	 * @param n la longitud del tablero.
	 * @return una solución al problema de las n reinas.
	 */
	public Board solve(int n){
		return null;
	}

	public static void main(String[] args) {
		
	}
}