package Recursion;

public class Factorial {

    public static void main(String[] args) {
        int n = 5;
        nto1(n);
        System.out.println();
        oneton(n);
        System.out.println();
        System.out.println("the sum of 5 is " + sumTillN(n));
        System.out.println("the product of 5 is " + productTillN(n));
        System.out.println("the sum of digits of 5 is " + sumofdigits(128));
        System.out.println("the product of digits of 5 is " + productofdigits(128));
        System.out.println("the reversing of digits of 5 is " + reverse(1280));
        reverseofnumber(589);
        System.out.println("the factorial of 5 is " + reverseval);
        System.out.println("the factorial of 5 is " + factorial(n));

    }

    public static void nto1(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + ",");
        nto1(n - 1);
    }

    public static void oneton(int n) {
        if (n == 0) {
            return;
        }
        oneton(n - 1);
        System.out.print(n + ",");
    }

    public static int sumTillN(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumTillN(n - 1);
    }

    public static int productTillN(int n) {
        if (n == 1) {
            return 1;
        }
        return n * productTillN(n - 1);
    }

    public static int sumofdigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumofdigits(n / 10);
    }

    public static int productofdigits(int n) {
        if (n == 0)
            return 1;
        return n % 10 * productofdigits(n / 10);
    }

    static int reverseval = 0;

    public static void reverseofnumber(int n) {
        if (n == 0) {
            return;
        }
        int digit = n % 10;
        reverseval = reverseval * 10 + digit;
        reverseofnumber(n / 10);
    }

    public static int reverse(int num) {
        // Call the recursive method with reversedNum initialized to 0
        return reverseHelper(num, 0);
    }

    private static int reverseHelper(int num, int reversedNum) {
        if (num == 0) {
            return reversedNum;
        }
        int lastDigit = num % 10;
        int remainingNumber = num / 10;
        reversedNum = (reversedNum * 10) + lastDigit;
        return reverseHelper(remainingNumber, reversedNum);
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
