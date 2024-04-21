package Maths;

import java.util.Scanner;

public class EvenOdd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 21;
		System.out.println("Even number check -" + evencheck(num));
		System.out.println("Odd number check -" + oddcheck(num));
		int[] arr = { 1, 1, 5, 4, 2, 5, 4, 6, 7, 6, 7 };
		System.out.println("Check for the single nuber -> " + aloneNum(arr));
		arr = new int[] { 1, -1, 2, 3, -2, -5, 5 };
		System.out.println("The single positive -> " + singlePos(arr));
		System.out.println("the ith bit is " + ithBits(6, 0));
		System.out.println("the set bit is " + setBits(4, 1));
		System.out.println("the unset bit is " + unsetBits(7, 2));
		sc.close();

	}

	// last digit=n&1
	public static boolean evencheck(int num) {
		if ((num & 1) == 0)
			return true;
		return false;
	}

	public static boolean oddcheck(int num) {
		if ((num & 1) == 1)
			return true;
		return false;
	}

	public static byte ithBits(int num, int pos) {
		// byte val = ( byte ) ( ( num & ( 1 << pos ) ) >> pos ) ;
		byte val = (byte) (num >> pos & 1);
		return val;
	}

	public static int setBits(int num, int pos) {
		num |= (1 << pos);
		return num;
	}

	public static int unsetBits(int num, int pos) {
		num &= ~(1 << pos);
		return num;
	}

	public static int rightsetBit(int num, int pos) {
		num &= ~(1 << pos);

		return num;
	}

	public static int aloneNum(int[] nums) {
		int xorvl = 0;
		for (int i : nums)
			xorvl ^= i;
		return xorvl;
	}

	public static int singlePos(int[] nums) {
		int sum = 0;
		for (int i : nums)
			sum += i;
		return sum;
	}
}