package clase2;

import java.util.Scanner;

class Menu {

	private int chosenOption;
	private static String[] arrayToSort;

	public Menu() {
	}

	public int getChosenOption() {
		return chosenOption;
	}

	public void setChosenOption(int chosenOption) {
		this.chosenOption = chosenOption;
	}

	public String[] getarrayToSort() {
		return arrayToSort;
	}

	public static void setArrayToSort(String[] arrayToSort) {
		Menu.arrayToSort = arrayToSort;
	}

	private static void getArray() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter length of String array");
		int length = sc.nextInt();
		String[] input = new String[length];

		System.out.println("Please enter array elements");
		for (int i = 0; i < length; i++) {
			String userInput = sc.next();
			input[i] = userInput;
		}

		setArrayToSort(input);
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
			System.out.println("You selected option: Quick sort ");
		} else {
			throw new ArrayIndexOutOfBoundsException("Selected option is not in the menu.");
		}

	}
}
