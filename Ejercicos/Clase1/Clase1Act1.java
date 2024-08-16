package Ejercicios.Clases;

public class Clase1Act1 {
    public static void main(String[] args) {
        int[] array = {1,4,5,6,7,3};
        int max = maximo(array);
        System.out.println("el maximo es:" + max);
    }

    public static int maximo(int[] array){
        int max = array[0];
        for (int i =0; i<array.length; i++){
            if(array[i]>max){
                max = array[i];
            }
        }
        return max;
    }
}


/* Complejidad Asintótica
    El tiempo para encontrar el maximo es O(n), ya que el elemento
    debe recorrer cada elemento del array.

    la complejidad espacial es O(1), ya que solo se utiliza la variable max
 */