package fciencias.edatos.queue;

import java.util.Scanner;

/**
* Simulación de un comprador que atiende vendedores.
* Implementa las operaciones del TDAQueue.
* @author Emmanuel Cruz Hernández.
* @version 1.0 Octubre 2021.
* @since Estructuras de datos 2021-2.
*/
public class Buyer{

	/**
	 * Representación de un cliente
	 */
	private class Client {

		/** Objeto que quiere vender el cliente. */
		public String thing;

		/** Precio del objeto sugerido */
		public double price;

		/**
		 * Crea un nuevo cliente.
		 * @param thing el objeto a vender.
		 * @param price el precio del objeto a vender.
		 */
		public Client(String thing, double price){
			this.thing = thing;
			this.price = price;
		}

		@Override
		public String toString(){
			return price + " chelines por " + thing;
		}
	}

	/** Chelines del comprador. */
	public double chelines;

	/** Clientes por atender. */
	public TDAQueue<Client> clients;

	/**
	 * Crea un nuevo comprador.
	 * @param amountClients la cantidad de clientes por atender.
	 * @param chelines la cantidad de chelines disponibles del comprador.
	 */
	public Buyer(int amountClients, double chelines){
		// Creación de clientes
		Scanner sc = new Scanner(System.in);
		clients = new Queue<Client>();

		for(int i = 0; i < amountClients; i++){
			System.out.println("¿Qué quieres vender?");
			String thing = sc.nextLine();
			System.out.println("¿Cuántos chelines pides?");
			double chelinesDato = sc.nextDouble();
			sc.nextLine();

			Client nuevo = new Client(thing, chelinesDato);

			clients.enqueue(nuevo);
		}

		// Asignación de chelines
		this.chelines = chelines;
	}

	/**
	 * Atiende a todos los objetos de la fila.
	 */
	public void attend(){
		Scanner sc = new Scanner(System.in);
		while(!clients.isEmpty()){
			Client actual = clients.dequeue();
			System.out.println(actual);

			boolean b = sc.nextBoolean();

			if(this.chelines <= 0){
				System.out.println("Venga otro día");
				return;
			}

			if(b){
				this.chelines -= actual.price;
				System.out.println("Comprado!");
			} else{
				System.out.println("Fuera de mi vista");
			}
		}
	}

	public static void main(String[] args) {
		Buyer comprador = new Buyer(3, 100);

		comprador.attend();
	}

}