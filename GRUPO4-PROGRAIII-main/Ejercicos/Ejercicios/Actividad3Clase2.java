public class Actividad3Clase2 {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Encuentra el índice de partición
            int pi = partition(arr, low, high);

            // Ordena recursivamente los elementos antes y después de la partición
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // índice del elemento más pequeño

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= pivot) {
                i++;

                // Intercambia arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Intercambia arr[i+1] con el pivote (arr[high])
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1,7,3,5,23,8};
        int n = arr.length;
        printArray(arr);

        quickSort(arr,0,n-1);
        printArray(arr);

    }
}
