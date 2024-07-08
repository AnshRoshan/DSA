import java.util.Arrays;
import java.util.Scanner;

public class RemoveVowels {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().toLowerCase();
		// store a,e,i,o,u in array
		int[] vowels = new int[5];
		String vowel = "aeiou";
		for (int i = 0; i < str.length(); i++) {
			int index = (vowel.indexOf(str.charAt(i)));
			if (index >= 0)
				vowels[index]++;

		}

		System.out.println(Arrays.toString(vowels));
		sc.close();
	}
}