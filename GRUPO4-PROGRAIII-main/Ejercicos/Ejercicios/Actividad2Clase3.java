public class Actividad2Clase3 {
    public static void main(String[] args) {
        int[] numeros = {3, 5, 6, 9, 9};
        int[] resultado = encontrarDosMayores(numeros);
        System.out.println("Mayor: " + resultado[0]);
        System.out.println("Segundo Mayor: " + resultado[1]);
    }

    private static int[] encontrarDosMayores(int[] numeros) {
        return encontrarDosMayores(numeros, 0, numeros.length);
    }

    private static int[] encontrarDosMayores(int[] numeros, int i, int f) {
        if (f - i == 1) {
            return new int[]{numeros[i], Integer.MIN_VALUE};
        }

        if (f - i == 2) {
            int mayor = Math.max(numeros[i], numeros[i + 1]);
            int segundoMayor = Math.min(numeros[i], numeros[i + 1]);
            return new int[]{mayor, segundoMayor};
        }

        int mitad = (f + i) / 2;
        int[] izq = encontrarDosMayores(numeros, i, mitad);
        int[] der = encontrarDosMayores(numeros, mitad, f);

        int nuevoMayor, nuevoSegundoMayor;

        if (izq[0] > der[0]) {
            nuevoMayor = izq[0];
            nuevoSegundoMayor = Math.max(izq[1], der[0]);
        } else {
            nuevoMayor = der[0];
            nuevoSegundoMayor = Math.max(der[1], izq[0]);
        }

        return new int[]{nuevoMayor, nuevoSegundoMayor};
    }
}
