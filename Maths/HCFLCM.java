package Maths;

public class HCFLCM {

    // Method to find the greatest common divisor (GCD) of two integers using the
    // Euclidean algorithm
    public static int gcd(int a, int b) {
        // Apply Euclidean algorithm
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        // Example numbers
        int number1 = 48;
        int number2 = 18;

        // Find the GCD of the numbers using the Euclidean algorithm
        int gcd = gcd(number1, number2);

        // Print the GCD
        System.out.println("GCD of " + number1 + " and " + number2 + " is: " + gcd);

        int[] arr = { 10, 20, 30, 80 };
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = lcm(lcm, arr[i]);
        }

        System.out.println("The LCM of the array is: " + lcm);
    }

    // Method to find the least common multiple (LCM) of two integers
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}
