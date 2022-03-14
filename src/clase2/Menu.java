package clase2;

import java.util.Scanner;

class Menu {

	private int chosenOption;
	private static String[] arrayToSort;
	private static int[] intArrayToSort;

	public Menu() {
	}

	public static int[] getIntArrayToSort() {
		return intArrayToSort;
	}

	public static void setIntArrayToSort(int[] intArrayToSort) {
		Menu.intArrayToSort = intArrayToSort;
	}

	public int getChosenOption() {
		return chosenOption;
	}

	public void setChosenOption(int chosenOption) {
		this.chosenOption = chosenOption;
	}

	public String[] getArrayToSort() {
		return arrayToSort;
	}

	public static void setArrayToSort(String[] arrayToSort) {
		Menu.arrayToSort = arrayToSort;
	}

	private static void getArray() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter length of int array");
		int length = sc.nextInt();
		String[] input = new String[length];

		System.out.println("Please enter array elements");
		for (int i = 0; i < length; i++) {
			String userInput = sc.next();
			input[i] = userInput;
		}
		setArrayToSort(input);
	}

	private static void convertArray(String[] args) {
		String[] array = args;
		int[] intArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			intArray[i] = Integer.parseInt(array[i]);
		}
		setIntArrayToSort(intArray);
	}

	public static void main(String[] args) {
		Menu myMenu = new Menu();

		Scanner sc = new Scanner(System.in);
		System.out.format("Please select the sorting method: %nEnter 1 for Bubble sort %nEnter 2 for Quick sort");
		int option = sc.nextInt();

		if (option == 1) {
			myMenu.setChosenOption(option);
			System.out.println("You selected option: " + myMenu.getChosenOption());
			getArray();
			BubbleSortDemo.bubbleAscending(myMenu.arrayToSort);

		} else if (option == 2) {
			myMenu.setChosenOption(option);
			System.out.println("You selected option: " + myMenu.getChosenOption());
			getArray();
			convertArray(myMenu.arrayToSort);
			QuickSort.main(myMenu.intArrayToSort);

		} else {
			throw new ArrayIndexOutOfBoundsException("Selected option is not in the menu.");
		}

	}
}
