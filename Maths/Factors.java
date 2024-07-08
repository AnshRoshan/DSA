import java.util.ArrayList;
import java.util.List;

public class Factors {

    public static void main(String[] args) {
        int n = 10;
        factorsOptimised(n);
        primeFactors(n);
        factors(n);
    }

    /**
     * @param n number to find factors
     *          Prints all the factors of a number
     * @time O(n)
     * @space O(1)
     */
    static void factors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " , ");
            }
        }
        System.out.println();
    }

    /**
     * @param n number to find factors
     *          Prints all the prime factors of a number
     * @time O(sqrt(n))
     * @space O(1)
     *
     */
    static void primeFactors(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " , ");
                n = n / i;
            }
        }
        if (n > 1) {
            System.out.println(n);
        }
    }

    /**
     * @param num number to find factors
     *            Prints all the factors of a number
     * @time O(sqrt(n))
     * @space O(1)
     */
    static void factorsOptimised(int num) {
        // using List to store all prime
        List<Integer> primeList = new ArrayList<>();
        List<Integer> primeListRight = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                primeList.add(i);
                if (num == i * i) continue;
                primeListRight.add(num / i);
            }
        }
        primeList.addAll(primeListRight);
        System.out.println(primeList.toString());
    }
}
