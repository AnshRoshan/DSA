
public class BitManipulation {
    public static void main(String[] args) {
        int num = 19; // Example number for demonstration

        // Setting a Bit (1) at a Specific Position 'pos'
        int pos = 2;
        int setBit = num | (1 << pos);
        System.out.println("Setting bit at position " + pos + ": " + setBit);

        // Clearing a Bit (0) at a Specific Position 'pos'
        int clearBit = num & ~(1 << pos);
        System.out.println("Clearing bit at position " + pos + ": " + clearBit);

        // Toggling a Bit at a Specific Position 'pos'
        int toggleBit = num ^ (1 << pos);
        System.out.println("Toggling bit at position " + pos + ": " + toggleBit);

        // Checking if a Bit at a Specific Position 'pos' is Set
        boolean isBitSet = (num & (1 << pos)) != 0;
        System.out.println("Is bit set at position " + pos + ": " + isBitSet);

        // Setting the Rightmost 1-bit to 0
        int clearRightmostBit = num & (num - 1);
        System.out.println("Clearing rightmost bit: " + clearRightmostBit);

        // Checking if a Number is Even or Odd
        boolean isEven = (num & 1) == 0;
        System.out.println("Is number even: " + isEven);

        // Extracting the Rightmost 1-bit
        int rightmostBit = num & -num;
        System.out.println("Rightmost bit: " + rightmostBit);

        // Turning Off the Rightmost 1-bit
        int turnOffRightmostBit = num & (num - 1);
        System.out.println("Turning off rightmost bit: " + turnOffRightmostBit);

        // Counting the Number of Set Bits (Population Count)
        int bitCount = Integer.bitCount(num);
        System.out.println("Number of set bits: " + bitCount);

        num = 23; // Example number
        int count = countSetBits(num);
        System.out.println("Number of set bits in " + num + ": " + count);

        // Extracting the Rightmost N Bits
        int N = 3;
        int rightmostNBits = num & ((1 << N) - 1);
        System.out.println("Rightmost " + N + " bits: " + rightmostNBits);

        // Extracting the Nth Bit from the Right
        int nthBitPos = 2;
        int nthBit = (num >> nthBitPos) & 1;
        System.out.println("Nth bit from the right at position " + nthBitPos + ": " + nthBit);

        // Swapping Two Numbers Without Using Temporary Variable
        int a = 10, b = 20;
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("Swapped a: " + a + ", Swapped b: " + b);

        // Detecting Opposite Signs of Two Numbers
        int x = -10, y = 20;
        boolean haveOppositeSigns = (x ^ y) < 0;
        System.out.println("Do x and y have opposite signs: " + haveOppositeSigns);

        // Checking if a Number is a Power of 2
        boolean isPowerOfTwo = (num & (num - 1)) == 0;
        System.out.println("Is number a power of 2: " + isPowerOfTwo);

        // Example array for duplicate and missing number examples
        int[] nums = { 1, 2, 3, 4, 5, 2, 3, 4, 5 };

        // Example numbers for other operations
        int n = 5;

        // Finding duplicate elements using XOR
        int duplicate = findSingle(nums);
        System.out.println("Duplicate element in the array: " + duplicate);

        // Finding missing number using XOR
        int missing = missingNumber(nums, nums.length + 1);
        System.out.println("Missing number in the array: " + missing);

        // Checking if a number is a power of 2
        System.out.println("Is " + n + " a power of 2? " + isPowerOfTwo(n));

        // Checking if a number is negative
        num = -5;
        System.out.println("Is " + num + " negative? " + isNegative(num));
        num = 5; // Number to multiply
        int powerOfTwo = 4; // Power of 2 to multiply by

        long result = multiplyByPowerOfTwo(num, powerOfTwo);
        System.out.println(num + " * 2^" + powerOfTwo + " = " + result);
        result = power(6, 12);
        System.out.println(a + " raised to the power of " + b + " is: " + result);

    }

    // Method to count the number of set bits in an integer
    public static int countSetBits(int num) {
        int count = 0;
        while (num != 0) {
            count += num & 1; // Check the last bit
            num >>= 1; // Right shift the number by 1
        }
        return count;
    }

    // Method to calculate a^b using bitwise manipulation --no power operation
    public static long power(long base, int exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= base;
            }
            base *= base; // Square the base
            exp >>= 1; // Divide the exponent by 2
        }
        return result;
    }

    // Method to multiply a number by a power of 2 using bitwise multiplication
    public static int multiplyByPowerOfTwo(int num, int power) {
        return num << power;
    }

    // Method to find duplicate element using XOR
    public static int findSingle(int[] nums) {
        int result = 0;
        for (int num : nums)
            result ^= num;
        return result;
    }

    // Method to find missing number using XOR
    public static int missingNumber(int[] nums, int n) {
        int result = 0;
        for (int i = 1; i <= n; i++)
            result ^= i;
        for (int num : nums)
            result ^= num;
        return result;
    }

    // Method to check if a number is a power of 2
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Method to check if a number is negative
    public static boolean isNegative(int num) {
        return (num & (1 << 31)) != 0;
    }
}