package fciencias.edatos.stack;

/**
 * Verifica si una cadena contiene paréntesis bien balanceados.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 OCtubre 2021.
 * @since Estructuras de datos 2021-2.
 */
public class Verifier{

	public static boolean verify(String expression){
		TDAStack<Character> pila = new Stack<>();

		for(int i = 0; i < expression.length(); i++){
			char caracter = expression.charAt(i);

			if(caracter == '('){
				pila.push('(');
			} else if(caracter == ')'){
				// Verificar si es vacía
				if(pila.isEmpty())
					return false;
				pila.pop();
			}
		}

		return pila.isEmpty();
	}

	public static void main(String[] args) {
		String case1 = "()()()()()()()"; // Si
		String case2 = "(((((())))))()(())"; // Si
		String case3 = "((((((("; // No
		String case4 = ")))))))))))"; // No
		String case5 = "(())()()((())"; // No
		String case6 = "()()(())(()"; // No
		String case7 = "()("; // No
		String case8 = "("; // No
		String case9 = ")("; // No
		String case10 = ""; // No

		System.out.println("La expresion '"+case1+"' es balanceado: " + verify(case1));
		System.out.println("La expresion '"+case2+"' es balanceado: " + verify(case2));
		System.out.println("La expresion '"+case3+"' es balanceado: " + verify(case3));
		System.out.println("La expresion '"+case4+"' es balanceado: " + verify(case4));
		System.out.println("La expresion '"+case5+"' es balanceado: " + verify(case5));
		System.out.println("La expresion '"+case6+"' es balanceado: " + verify(case6));
		System.out.println("La expresion '"+case7+"' es balanceado: " + verify(case7));
		System.out.println("La expresion '"+case8+"' es balanceado: " + verify(case8));
		System.out.println("La expresion '"+case9+"' es balanceado: " + verify(case9));
		System.out.println("La expresion '"+case10+"' es balanceado: " + verify(case10));
	}
}