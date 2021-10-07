package fciencias.edatos.listas;

/**
 * Clase para poner a prueba las operaciones de la lista.
 * @version 1.0 Octubre 2021.
 * @since Estructuras de Datos 2022-1
 */
public class Main{

    public static void main(String[] args) {
        SimpleList<String> lista = new SimpleList<>();

        lista.add(0, "Hola");
        lista.add(1, "mundo");
        lista.add(1, "Himno nacional");
        lista.add(1, "Ojos color sol");
        lista.add(2, "Down in a hole");
        lista.add(1, "Si no le contesto");
        lista.add(4, "Extasis");

        System.out.print("Longitud de la lista: " + lista.size() + "\n");

        System.out.print(lista);
    }
}