import java.util.*;

public class PatternRecursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = 3;
		System.out.println(" Print using High Value");
		displayhigh(row, row);
		System.out.println(" Print using Low Value");
		displaylow(row, 0);
		System.out.println("Print using Str Value ");
		System.out.println(displayStr(row, 0));
		System.out.println("Print Normal Traingle ");
		System.out.println(normalTraingle(row, 0));
		System.out.println("Print Normal Value ");
		displayNormal(row, 0);
		System.out.println();
		int[] nums = { 2, 4, 3, 1, 7, 5, 8, 9, 6 };
		System.out.println(Arrays.toString(nums));
		selectionSort(nums, nums.length - 1, 0, 0);
		System.out.println(Arrays.toString(nums));
		bubbleSort(nums, nums.length - 1, 0);
		System.out.println(Arrays.toString(nums));
		sc.close();
	}

	static void displayhigh(int row, int col) {
		if (row == 0) {
			return;
		}
		if (col == 0) {
			System.out.println();
			row -= 1;
			col = row + 1;
		} else
			System.out.print("* ");
		displayhigh(row, col - 1);
	}

	static void displaylow(int row, int col) {
		if (row == 0) {
			return;
		}
		if (row == col) {
			System.out.println();
			row--;
			// using recursion col+1 is there from before.
			col = -1;
		} else
			System.out.print("* ");
		displaylow(row, col + 1);
	}

	static String displayStr(int row, int col) {
		if (row == 0) {
			return "";
		}
		if (row == col)
			return "\n" + displayStr(row - 1, 0);
		else
			return "* " + displayStr(row, col + 1);
	}

	static String normalTraingle(int row, int col) {
		if (row == 0) {
			return "";
		}
		if (row == col) {
			return normalTraingle(row - 1, 0) + "\n";
		} else {
			return normalTraingle(row, col + 1) + "* ";

		}
	}

	static void displayNormal(int row, int col) {
		if (row == 0) {
			return;
		}
		if (row == col) {
			displayNormal(row - 1, 0);
			System.out.println();
		} else {
			displayNormal(row, col + 1);
			System.out.print("* ");
		}

	}

	static void selectionSort(int[] arr, int row, int col, int index) {
		if (row == 0)
			return;
		if (row >= col) {
			if (arr[index] < arr[col])
				index = col;
			selectionSort(arr, row, col + 1, index);
		} else {
			int temp = arr[row];
			arr[row] = arr[index];
			arr[index] = temp;
			selectionSort(arr, row - 1, 0, 0);
		}
	}

	static void bubbleSort(int[] arr, int row, int col) {
		if (row == 0)
			return;
		if (row > col) {
			if (arr[col] >= arr[col + 1]) {
				int temp = arr[col];
				arr[col] = arr[col + 1];
				arr[col + 1] = temp;
			}
			bubbleSort(arr, row, col + 1);
		} else {
			bubbleSort(arr, row - 1, 0);
		}
	}
}