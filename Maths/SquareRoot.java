
public class SquareRoot {

    public static double newtonRaphson(double x) {
        // Check if x is non-negative

        // Initial guess for the square root
        double guess = x / 2.0;

        // Tolerance level for convergence
        double epsilon = 1e-10; // Adjust epsilon as needed

        // Maximum number of iterations
        int maxIterations = 1000; // Adjust maxIterations as needed

        // Iterate until convergence or maximum iterations
        for (int i = 0; i < maxIterations; i++) {
            // Compute the next guess using Newton's method
            double nextGuess = 0.5 * (guess + x / guess);
            // Check for convergence
            if (Math.abs(nextGuess - guess) < epsilon) {
                return nextGuess; // Return the square root
            }
            // Update the guess for the next iteration
            guess = nextGuess;
        }

        // If the maximum number of iterations is reached without convergence,
        return guess;
    }

    public static void main(String[] args) {
        double number = 25.0; // Number whose square root is to be computed
        double sqrtNumber = newtonRaphson(number);
        System.out.println("Square root of " + number + " is approximately: " + sqrtNumber);
    }

    // Binary search to find square root of the number.
    public static double binarySearchRoot(double number) {
        double start = 0.0;
        double end = number;
        double mid = start + (end - start) / 2.0;
        while (Math.abs(mid * mid - number) > 1e-10) {
            if (mid * mid > number) {
                end = mid;
            } else {
                start = mid;
            }
            mid = start + (end - start) / 2.0;

        }
        return mid;
    }
}
