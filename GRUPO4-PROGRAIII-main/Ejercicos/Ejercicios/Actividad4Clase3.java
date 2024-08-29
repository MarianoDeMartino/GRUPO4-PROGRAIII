import java.util.Arrays;
import java.util.PriorityQueue;

public class Actividad4Clase3 {
    public static void main(String[] args) {
        int[] numeros = {3, 5, 6, 9, 9, 2, 8, 7, 10};
        int n = 3;
        int[] resultado = encontrarNMayores(numeros, n);
        System.out.println("Los " + n + " elementos más grandes: " + Arrays.toString(resultado));
    }

    private static int[] encontrarNMayores(int[] numeros, int n) {
        return encontrarNMayores(numeros, n, 0, numeros.length);
    }

    private static int[] encontrarNMayores(int[] numeros, int n, int inicio, int fin) {
        if (fin - inicio <= n) {
            int[] sublista = Arrays.copyOfRange(numeros, inicio, fin);
            Arrays.sort(sublista);
            reverse(sublista);  // Ordenar en orden descendente
            return Arrays.copyOf(sublista, Math.min(n, sublista.length));
        }

        int mitad = (inicio + fin) / 2;
        int[] izq = encontrarNMayores(numeros, n, inicio, mitad);
        int[] der = encontrarNMayores(numeros, n, mitad, fin);

        PriorityQueue<Integer> pq = new PriorityQueue<>(n);  // Min-Heap para mantener los "n" mayores
        for (int num : izq) pq.offer(num);
        for (int num : der) pq.offer(num);

        while (pq.size() > n) pq.poll();  // Remover los más pequeños, mantener los "n" mayores

        int[] resultado = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            resultado[i] = pq.poll();
        }

        return resultado;
    }

    private static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}
