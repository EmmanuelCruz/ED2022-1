import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 * Leector de archivos de texto para su conversión a matrices.
* @author Emmanuel Cruz Hernández.
* @version 1.0 Septiembre 2021.
* @since Laboratorio de Estructuras de Datos 2022-1.
*/
public class ArrayReader {

    /*
    * SUPER NOTA: SI QUIERES HACER QUE LA CLASE BOX SEA ANIDADA EN MAZE, PUEDES
    * COPIAR EL MÉTODO PARA QUE ESTÉ EN LA CLASE MAZE SIN PROBLEMA
    */

    /**
     * Lee una matriz de un archivo de texto.
     * @param name el nombre del archivo.
     * @return una matriz de enteros.
     */
    public static Box[][] readMatrix(String name){
        try(BufferedReader reader = new BufferedReader(new FileReader(name))){
            String[] dimensions = reader.readLine().split(",");
            // Se leen las dimensiones del laberinto
            int h = Integer.valueOf(dimensions[0]), w = Integer.valueOf(dimensions[1]);
            Box[][] result = new Box[h][w];
            
            String line = null;
            int index = 0;
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                // Se obtiene la fila y columna de la casilla del laberinto
                int row = Integer.valueOf(data[0]), column = Integer.valueOf(data[1]);

                // Depende de como definas el constructor de Box ajusta la siguiente linea
                //result[row][colum] = new Box(row, colum);
            }
            
            return result;
        } catch(FileNotFoundException fnfe){
            System.out.println("ARCHIVO "+name+" NO ENCONTRADO");
        } catch(IOException ioe){}

        return null;
    }

}
