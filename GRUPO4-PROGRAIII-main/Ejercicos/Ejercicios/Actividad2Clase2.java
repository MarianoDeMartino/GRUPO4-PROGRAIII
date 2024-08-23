public class Actividad2Clase2 {

    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            // Verificar si el objetivo está en el medio
            if (arreglo[medio] == objetivo) {
                return medio; // Retorna el índice del objetivo
            }

            // Si el objetivo es mayor, ignorar la mitad izquierda
            if (arreglo[medio] < objetivo) {
                izquierda = medio + 1;
            }
            // Si el objetivo es menor, ignorar la mitad derecha
            else {
                derecha = medio - 1;
            }
        }

        // Si no se encuentra el objetivo, retorna -1
        return -1;
    }


    public static void main(String[] args) {
        int[] arreglo = {1, 3, 5, 7, 9, 11, 13};
        int objetivo = 7;
        int resultado = busquedaBinaria(arreglo, objetivo);

        if (resultado == -1) {
            System.out.println("Elemento no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + resultado);
        }

        int[] arr = {10, 7, 8, 9, 1, 5};


        int obj = 10;
        int resultadoEjercicio = busquedaBinaria(arr,obj);

        }
    }



