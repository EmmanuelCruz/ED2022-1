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
    
    /**
     * Lee un arreglo unidimensional de un archivo de texto.
     * @param name el nombre del archivo.
     * @return un arreglo de enteros.
     */
    public static int[] readArray(String name){
        try(BufferedReader reader = new BufferedReader(new FileReader(name))){
            String[] data = reader.readLine().split(",");
            int[] result = new int[data.length];
            for(int i = 0; i < data.length; i++ ){
                result[i] = Integer.valueOf(data[i]);
            }
            return result;
        } catch(FileNotFoundException fnfe){
            System.out.println("ARCHIVO "+name+" NO ENCONTRADO");
        } catch(IOException ioe){}

        return null;
    }

    /**
     * Lee una matriz de un archivo de texto.
     * @param name el nombre del archivo.
     * @return una matriz de enteros.
     */
    public static int[][] readMatrix(String name){
        try(BufferedReader reader = new BufferedReader(new FileReader(name))){
            int dimension = Integer.valueOf(reader.readLine());
            int[][] result = new int[dimension][dimension];
            String line = null;
            int index = 0;
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                for(int i = 0; i < data.length; i++ ){
                    result[index][i] = Integer.valueOf(data[i]);
                }
                index++;
            }
            
            return result;
        } catch(FileNotFoundException fnfe){
            System.out.println("ARCHIVO "+name+" NO ENCONTRADO");
        } catch(IOException ioe){}

        return null;
    }

}
