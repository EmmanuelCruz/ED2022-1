package fciencias.edatos.listas;

import java.util.Scanner;

/**
 * Clase para poner a prueba las operaciones de la lista.
 * @version 1.0 Octubre 2021.
 * @since Estructuras de Datos 2022-1
 */
public class Main{

    public static void main(String[] args) {
        SimpleList<String> lista = new SimpleList<>();

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("[1] Agrega\n"+
            "[2] Longitud\n"+
            "[3] Muestra\n"+
            "[4] Salir\n"+
            "Elige una opcion: ");

            int opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    int i = sc.nextInt();
                    sc.nextLine();
                    String s = sc.nextLine();
                    lista.add(i, s);
                    break;
                case 2:
                    System.out.println("La longitud es "+ lista.size());
                    break;
                case 3:
                    System.out.println(lista);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        } while(true);
    
    }
}