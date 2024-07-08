import java.util.Scanner;

public class Fare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String src, des;
		String[] code = { "TH", "GA", "IC", "HA", "TE", "LU", "NI", "CA" };
		int[] distance = { 800, 600, 750, 900, 1400, 1200, 1100, 1500 };
		src = sc.nextLine().toUpperCase();
		des = sc.nextLine().toUpperCase();
		System.out.println(src);
		System.out.println(des);
		if (src.equals(des)) {
			System.out.println("INVALID INPUT");
			System.exit(0);
		}
		int srci = 0, desi = 0;
		int sum = 0;
		for (int i = 0; i < code.length; i++) {
			if (src.equals(code[i]))
				srci = i;
			if (src.equals(code[i]))
				desi = i;
			sum += distance[i];
			distance[i] = sum;
		}
		double fare = 0.0;
		if (srci < desi)
			fare = Math.ceil((distance[desi] - distance[srci]) / 200);
		else
			fare = Math.ceil((distance[desi] - distance[srci] + distance[distance.length - 1]) / 200);

		System.out.println(fare);
		sc.close();
	}
}