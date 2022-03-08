package clase2;

class QuickSort {

// funcion para intercambiar las posiciones de arr[j] y arr[i]
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

//	  tomamos el ultimo elemento como pivote, los numeros menores al pivote
//	  van a la izquierda y los mayores a la derecha

	static int partition(int[] arr, int low, int high) {

		// pivot, el ultimo valor del array
		int pivot = arr[high];

		// siendo low 0, -1 empieza comparando el pivote con si mismo (el ultimo numero)
		// indicates the right position
		// of pivot found so far
		int i = (low - 1);

		// mientras j sea menor o igual al indice del ultimo elemento, ejecuta y le suma
		// 1 a j
		for (int j = low; j <= high - 1; j++) {

			// si el elemento en arr[j] es menor al pivote
			if (arr[j] < pivot) {

				// Increment index of
				// smaller element
				i++;
				swap(arr, i, j);
			}
		}
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