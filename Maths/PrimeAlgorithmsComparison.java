package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PrimeAlgorithmsComparison {
    // Sieve of Sundaram to generate prime numbers up to a given limit
    public static List<Integer> sieveOfSundaram(int limit) {
        int n = (limit - 2) / 2;
        boolean[] marked = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = i; (i + j + 2 * i * j) <= n; j++) {
                marked[i + j + 2 * i * j] = true;
            }
        }

        if (limit > 2) {
            primes.add(2);
        }

        for (int i = 1; i <= n; i++) {
            if (!marked[i]) {
                primes.add(2 * i + 1);
            }
        }

        return primes;
    }

    // Basic Sieve of Eratosthenes to generate prime numbers up to a given limit
    public static List<Integer> sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();

        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    // Sieve of Atkin to generate prime numbers up to a given limit
    public static List<Integer> sieveOfAtkin(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, false);
        List<Integer> primes = new ArrayList<>();

        for (int x = 1; x * x < limit; x++) {
            for (int y = 1; y * y < limit; y++) {
                int n = (4 * x * x) + (y * y);
                if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
                    isPrime[n] ^= true;
                }
                n = (3 * x * x) + (y * y);
                if (n <= limit && n % 12 == 7) {
                    isPrime[n] ^= true;
                }
                n = (3 * x * x) - (y * y);
                if (x > y && n <= limit && n % 12 == 11) {
                    isPrime[n] ^= true;
                }
            }
        }

        for (int n = 5; n * n < limit; n++) {
            if (isPrime[n]) {
                for (int k = n * n; k < limit; k += n * n) {
                    isPrime[k] = false;
                }
            }
        }

        primes.add(2);
        primes.add(3);
        for (int i = 5; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    // Method to check if a number is prime using Miller-Rabin primality test
    public static boolean isPrimeMillerRabin(int n, int k) {
        if (n <= 1 || n == 4)
            return false;
        if (n <= 3)
            return true;

        int d = n - 1;
        while (d % 2 == 0) {
            d /= 2;
        }

        Random rand = new Random();
        for (int i = 0; i < k; i++) {
            int a = 2 + rand.nextInt(n - 3);
            if (!millerRabinCheck(a, d, n)) {
                return false;
            }
        }
        return true;
    }

    private static boolean millerRabinCheck(int a, int d, int n) {
        int x = power(a, d, n);
        if (x == 1 || x == n - 1)
            return true;
        while (d != n - 1) {
            x = (x * x) % n;
            d *= 2;
            if (x == 1)
                return false;
            if (x == n - 1)
                return true;
        }
        return false;
    }

    // Method to calculate power in modular arithmetic
    private static int power(int x, int y, int p) {
        int res = 1;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % p;
            }
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    public static void main(String[] args) {
        int limit = 30000; // Upper limit for generating prime numbers
        int iterations = 5; // Number of iterations for Miller-Rabin test

        long startTime, endTime;
        List<Integer> primes;

        // Measure time taken by Sieve of Sundaram
        startTime = System.nanoTime();
        primes = sieveOfSundaram(limit);
        endTime = System.nanoTime();
        System.out.println("Time taken by Sieve of Sundaram: " + (endTime - startTime) / 1e6 + " milliseconds");

        // Measure time taken by Sieve of Eratosthenes
        startTime = System.nanoTime();
        primes = sieveOfEratosthenes(limit);
        endTime = System.nanoTime();
        System.out.println("Time taken by Sieve of Eratosthenes: " + (endTime - startTime) / 1e6 + " milliseconds");

        // Measure time taken by Sieve of Atkin
        startTime = System.nanoTime();
        primes = sieveOfAtkin(limit);
        endTime = System.nanoTime();
        System.out.println("Time taken by Sieve of Atkin: " + (endTime - startTime) / 1e6 + " milliseconds");

        // Measure time taken by Miller-Rabin primality test
        startTime = System.nanoTime();
        // boolean isPrime = isPrimeMillerRabin(limit, iterations);
        endTime = System.nanoTime();
        System.out
                .println("Time taken by Miller-Rabin primality test: " + (endTime - startTime) / 1e6 + " milliseconds");
    }
}
