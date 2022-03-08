package clase2;

import java.util.Scanner;

class BubbleSortDemo {
//	el argumento que le paso es el array de string que tome por consola
	public static void bubbleAscending(String[] args) {

// genero un nuevo array de ints con la misma longitud que el array de args
		int[] myArray = new int[args.length];

// saco los valores en ints de los argumentos y lo almaceno en my array
		for (int i = 0; i < args.length; i++) {
			myArray[i] = Integer.valueOf(args[i]);
		}

		int n = myArray.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (myArray[j - 1] > myArray[j]) {
					// Code to swap the elements
					temp = myArray[j - 1];
					myArray[j - 1] = myArray[j];
					myArray[j] = temp;
				}
			}
		}

		System.out.println("Array after applying Bubble Sort: ");
		for (int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i] + " ");
		}
	}

	public static void main(String[] args) {

//		pido por consola la longitud del array que voy a usar, uso scanner para leerlo
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter length of String array");
		int length = sc.nextInt();

//		genero un nuevo string array input con la longitud de lo que leo en consola
		String[] input = new String[length];

//		loopeo el userinput con el metodo next del scanner para guardalo en un string array
		System.out.println("Please enter array elements");
		for (int i = 0; i < length; i++) {
			String userInput = sc.next();
			input[i] = userInput;
		}
//		muestro por consola el array que voy a ordenar
		System.out.println("Array on which we apply Bubble Sort: ");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
//		llamo al metodo para ordenar el codigo
		bubbleAscending(input);
	}
}