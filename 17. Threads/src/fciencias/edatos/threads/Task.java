package fciencias.edatos.threads;

import java.util.Scanner;

/**
 * Ejemplo de programa con threads.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Eneror 2022.
 * @since Estructuras de datos 2022-1.
 */
public class Task{

	public int value = 5;

	public Task1 t1 = new Task1();
	public Task2 t2 = new Task2();

	public void comienza(){
		t1.start();
		t2.start();
	}

	public class Task1 extends Thread{

		@Override
		public void run(){
			try{
				Thread t = new Thread();
				while(true){
					t.sleep(5000);
					System.out.println("Task 1 " + value);
				}
			} catch(Exception e){
				System.out.println("El task 1 se ha detenido");
			}
		}
	}

	public class Task2 extends Thread{

		private Scanner sc = new Scanner(System.in);

		@Override
		public void run(){
			try{
				Thread t = new Thread();
				while(true){
					t.sleep(2000);
					System.out.println("Task 2 ");
				}
			} catch(Exception e){
				System.out.println("El task 2 se ha detenido");
			}
		}
	}

    public static void main(String[] args) {
        Task t = new Task();
        t.comienza();
    }
}