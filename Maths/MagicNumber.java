
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.close();
		System.out.println("THE MAGICAL NUMBER:--" + magicNumber(5));
		System.out.println("THE MAGICAL NUMBER:--" + magicNumber(6));
		System.out.println("The no .of the digits:--" + noOfDigits(128, 2));
		System.out.println("The no .of the digits:--" + noOfDigits(128, 10));

	}

	public static int magicNumber(int num) {
		int ans = 0;
		int base = 5;
		while (num > 0) {
			ans += base * (num & 1);
			num = num >> 1;
			base *= 5;
		}
		return ans;
	}

	public static int noOfDigits(int num, int base) {
		int ans = (int) (Math.log(num) / Math.log(base) + 1);
		return ans;
	}

	public List<List<Integer>> pascalTraingle(int numRows) {
		List<List<Integer>> triangle = new ArrayList<>();
		// Generate the first row
		List<Integer> firstRow = new ArrayList<>();
		firstRow.add(1);
		triangle.add(firstRow);

		for (int i = 1; i < numRows; i++) {
			List<Integer> prevRow = triangle.get(i - 1);
			List<Integer> currentRow = new ArrayList<>();

			// The first element of each row is always 1
			currentRow.add(1);

			// Calculate the elements of the current row
			for (int j = 1; j < i; j++) {
				currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
			}

			// The last element of each row is always 1
			currentRow.add(1);

			// Add the current row to the triangle
			triangle.add(currentRow);
		}
		return triangle;
	}

}