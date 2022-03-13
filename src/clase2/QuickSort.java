package clase2;

class QuickSort {

	// funcion para intercambiar las posiciones de arr[j] y arr[i]
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// tomamos el ultimo elemento como pivote, los numeros menores al pivote
	// van a la izquierda y los mayores a la derecha
	// 10, 7, 8, 9, 1, 5
	// 5,7,8,9,1,10
	static int partition(int[] arr, int low, int high) {

		// pivot, el ultimo valor del array
		int pivot = arr[high];

		// siendo low la posicion 0(numero 10) y arr[high] el 5 los va a comparar

		int i = (low - 1); // (-1) ES LA POSICION DEL PIVOTE

		// mientras j sea menor o igual al indice del ultimo elemento, ejecuta y le suma
		// 1 a j
		for (int j = low; j <= high - 1; j++) {

			// si el elemento en arr[j] es menor al pivote
			if (arr[j] < pivot) {

				// le suma 1 a i por que esa sera la nueva posicion del pivote
				i++;
				// los intercambia de lugar
				swap(arr, i, j);
			}
		}
		// si el elemento NO es menor mueve al elemento a la derecha
		swap(arr, i + 1, high);
		return (i + 1);
	}

	/*
	 * The main function that implements QuickSort arr[] --> Array to be sorted, low
	 * --> Starting index, high --> Ending index
	 */
	static void quickSort(int[] arr, int low, int high) {
		if (low < high) {

			// pi is partitioning index, arr[p]
			// is now at right place
			int pi = partition(arr, low, high);

			// Separately sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	// Function to print an array
	static void printArray(int[] arr, int size) {
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	// Driver Code
	public static void main(String[] args) {
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;

		quickSort(arr, 0, n - 1);
		System.out.println("Sorted array: ");
		printArray(arr, n);
	}
}