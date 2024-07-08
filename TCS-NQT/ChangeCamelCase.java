import java.util.Scanner;

public class ChangeCamelCase {
	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// String str=sc.nextLine();
		// StringBuilder sb= new StringBuilder(str);
		// sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
		// for(int i=1;i<sb.length();i++) {
		// if (sb.charAt(i)-65<=26) {
		// sb.replace(i,i+1,(" "+sb.charAt(i)).toLowerCase());
		// }
		// }
		// System.out.println(sb.toString());
		// sc.close();
		solution();
	}

	public static void solution() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		// Convert the first character to lowercase
		str = str.substring(0, 1).toLowerCase() + str.substring(1);

		// Convert subsequent uppercase characters to lowercase preceded by a space
		// using regex
		str = str.replaceAll("([A-Z])", " $1").toLowerCase();

		System.out.println(str);
		sc.close();
	}
}