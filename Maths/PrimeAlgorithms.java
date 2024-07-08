
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeAlgorithms {
    // Method to generate prime numbers up to a given limit using the Sieve of
    // Eratosthenes algorithm
    public static List<Integer> sieveOfEratosthenes(int limit) {
        // Create a boolean array "isPrime" of size (limit+1) to mark whether a number
        // is prime or not
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true); // Initialize all elements as true initially

        // Traverse from 2 to sqrt(limit) to mark multiples of primes as composite
        for (int p = 2; p * p <= limit; p++) {
            // If p is prime, mark all multiples of p as composite
            if (isPrime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Create a list to store prime numbers
        List<Integer> primes = new ArrayList<>();

        // Traverse the array again and add all prime numbers to the list
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // Return the list of prime numbers
        return primes;
    }

    public static void main(String[] args) {
        int limit = 100; // Define the upper limit for generating prime numbers

        // Call the Sieve of Eratosthenes method to generate prime numbers up to the
        // given limit
        List<Integer> primes = sieveOfEratosthenes(limit);

        // Print the generated prime numbers
        System.out.println("Prime numbers up to " + limit + ":");
        for (int prime : primes) {
            System.out.print(prime + " ");
        }
    }
}