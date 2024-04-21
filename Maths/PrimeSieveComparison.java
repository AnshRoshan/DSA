package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrimeSieveComparison {

    // Sieve of Eratosthenes
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

    // Segmented Sieve
    public static List<Integer> segmentedSieve(int limit) {
        List<Integer> primes = new ArrayList<>();
        int sqrtLimit = (int) Math.sqrt(limit);
        int segmentSize = Math.max(2, sqrtLimit / 2);
        int numSegments = (limit + segmentSize - 1) / segmentSize;
        boolean[] isPrime = new boolean[segmentSize];
        Arrays.fill(isPrime, true);

        for (int s = 0; s < numSegments; s++) {
            Arrays.fill(isPrime, true);
            int start = s * segmentSize * 2;
            int end = Math.min(start + segmentSize * 2 - 1, limit);

            for (int p : primes) {
                int startIdx = (start + p - 1) / p * p - start;
                for (int j = Math.max(p * p, start); j <= end; j += p) {
                    isPrime[j - start] = false;
                }
            }

            if (s == 0) {
                isPrime[0] = isPrime[1] = false;
            }

            for (int i = start; i <= end; i++) {
                if (isPrime[i - start]) {
                    primes.add(i);
                }
            }
        }

        return primes;
    }

    // Sieve of Atkin
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

    // Wheel Sieve
    public static List<Integer> wheelSieve(int limit) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isComposite = new boolean[limit + 1];
        int[] wheel = { 2, 3, 5 }; // Primes to skip multiples of
        int[] offsets = { 4, 2, 4, 2, 4, 6, 2, 6 }; // Offsets for the wheel

        for (int num = 7, wheelIndex = 0; num <= limit; num += offsets[wheelIndex++]) {
            if (!isComposite[num]) {
                primes.add(num);
                if (wheelIndex == 8)
                    wheelIndex = 0; // Reset wheel index
                for (int i = 0; i < wheel.length; i++) {
                    int multiple = num * wheel[i];
                    if (multiple > limit)
                        break;
                    isComposite[multiple] = true;
                }
            }
            if (wheelIndex == 8)
                wheelIndex = 0; // Reset wheel index
        }

        return primes;
    }

    // Parallel Sieve Algorithm
    public static List<Integer> parallelSieve(int limit) {
        List<Integer> primes = Collections.synchronizedList(new ArrayList<>());
        int numThreads = Runtime.getRuntime().availableProcessors(); // Number of available processors
        Thread[] threads = new Thread[numThreads];
        int segmentSize = (limit + numThreads - 1) / numThreads; // Size of each segment

        for (int t = 0; t < numThreads; t++) {
            final int start = t * segmentSize + 1;
            final int end = Math.min((t + 1) * segmentSize, limit);
            threads[t] = new Thread(() -> {
                List<Integer> segmentPrimes = sieveOfEratosthenes(start, end);
                primes.addAll(segmentPrimes);
            });
            threads[t].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return primes;
    }

    // Sieve of Eratosthenes for a given range
    public static List<Integer> sieveOfEratosthenes(int start, int end) {
        boolean[] isPrime = new boolean[end - start + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();

        for (int p = 2; p * p <= end; p++) {
            for (int i = Math.max(p * p, (start + p - 1) / p * p); i <= end; i += p) {
                isPrime[i - start] = false;
            }
        }

        for (int i = Math.max(2, start); i <= end; i++) {
            if (isPrime[i - start]) {
                primes.add(i);
            }
        }

        return primes;
    }

    // Prime Number Formulae
    public static List<Integer> primeNumberFormulae(int limit) {
        List<Integer> primes = new ArrayList<>();
        if (limit >= 2)
            primes.add(2);
        if (limit >= 3)
            primes.add(3);

        for (int num = 5; num <= limit; num += 6) {
            if (isPrime(num))
                primes.add(num);
            if (num + 2 <= limit && isPrime(num + 2))
                primes.add(num + 2);
        }

        return primes;
    }

    // Check if a number is prime using trial division
    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num <= 3)
            return true;
        if (num % 2 == 0 || num % 3 == 0)
            return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int limit = 99999; // Upper limit for generating prime numbers

        long startTime, endTime;

        // Measure time taken by Sieve of Eratosthenes
        startTime = System.nanoTime();
        sieveOfEratosthenes(limit);
        endTime = System.nanoTime();
        System.out.println("Time taken by Sieve of Eratosthenes: " + (endTime - startTime) / 1e6 + " milliseconds");

        // Measure time taken by Segmented Sieve
        // startTime = System.nanoTime();
        // segmentedSieve(limit);
        // endTime = System.nanoTime();
        // System.out.println("Time taken by Segmented Sieve: " + (endTime - startTime)
        // / 1e6 + " milliseconds");

        // Measure time taken by Sieve of Atkin
        startTime = System.nanoTime();
        sieveOfAtkin(limit);
        endTime = System.nanoTime();
        System.out.println("Time taken by Sieve of Atkin: " + (endTime - startTime) /
                1e6 + " milliseconds");

        // Measure time taken by Wheel Sieve
        startTime = System.nanoTime();
        wheelSieve(limit);
        endTime = System.nanoTime();
        System.out.println("Time taken by Wheel Sieve: " + (endTime - startTime) / 1e6 + " milliseconds");

        // Measure time taken by Parallel Sieve Algorithm
        startTime = System.nanoTime();
        parallelSieve(limit);
        endTime = System.nanoTime();
        System.out.println("Time taken by Parallel Sieve Algorithm: " + (endTime - startTime) / 1e6 + " milliseconds");

        // Measure time taken by Prime Number Formulae
        startTime = System.nanoTime();
        primeNumberFormulae(limit);
        endTime = System.nanoTime();
        System.out.println("Time taken by Prime Number Formulae: " + (endTime -
                startTime) / 1e6 + " milliseconds");
    }
}
