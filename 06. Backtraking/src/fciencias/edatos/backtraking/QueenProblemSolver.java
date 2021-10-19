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
			this.board = board;
			this.n = n;
		}

		/**
		 * Verifica si el tablero es solución.
		 * @return true si el tablero es solucion. False en otro caso.
		 */
		public boolean isSolution(){
			// Debe ser de longitud n
			if(board.length != n)
				return false;
			// Debe ser extendible
			return isExtensible();
		}

		/**
		 * Verifica si el tablero se puede extender.
		 * @return true si el tablero se puede extender, false en otro caso.
		 */
		public boolean isExtensible(){
			// Si ya se visitaron n -> significa que no se puede extender
			if(visited.size() == n)
				return false;

			int last = board[board.length-1];
			for(int i = board.length-2, counter = 1; i >= 0; i--, counter++){
				// No debe haber en la misma columna
				if(last == board[i])
					return false;

				// No debe haber diagonales
				if(last == board[i]+counter)
					return false;

				// No debe haber diagonales invertidas
				if(last == board[i]-counter)
					return false;
			}
			return true;
		}

		/**
		 * Extiende el tablero.
		 * @return un nuevo tablero creado a partir del actual. 
		 * Este resultado representa el tablero extendido.
		 */
		public Board extend(){
			int[] newBoard = Arrays.copyOf(board, board.length+1);
			Random rn = new Random();
			int random = rn.nextInt(n);
			while(visited.contains(random)){
				random = rn.nextInt(n);
			}
			newBoard[newBoard.length-1] = random;
			visited.add(0, random);
			return new Board(newBoard, n);
		}

		@Override
		public String toString(){
			String rep = "";
			for(int i = 0; i < board.length; i++){
				rep += "|";
				for(int j = 0; j < n; j++)
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
		// Variables iniciales
		int[] initial = new int[1];
		Random rn = new Random();
		initial[0] = rn.nextInt(n);
		Board actual = new Board(initial, n);
		TDAStack<Board> stack = new Stack<>();
		stack.push(actual);

		// Backtraking
		while(!actual.isSolution()){
			System.out.println(actual);
			if(actual.isExtensible()){
				stack.push(actual);
				actual = actual.extend();
			} else {
				actual = stack.pop();
			}
		}

		return actual;
	}

	public static void main(String[] args) {
		QueenProblemSolver q = new QueenProblemSolver();
		System.out.println(q.solve(12));
	}
}