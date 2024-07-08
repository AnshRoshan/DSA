public class Factorial {

    public static void main ( String[] args ) {
        int n = 5;
        nto1 ( n );
        System.out.println();
        oneton ( n );
        System.out.println();
        System.out.println ( "the sum of 5 is " + sumTillN ( n ) );
        System.out.println ( "the product of 5 is " + productTillN ( n ) );
        System.out.println ( "the sum of digits of 5 is " + sumofdigits ( 128 ) );
        System.out.println ( "the product of digits of 5 is " + productofdigits ( 128 ) );
        System.out.println ( "the reversing of digits of 5 is " + reverse ( 1280 ) );
        System.out.println ( "the reversing of digits of 5 is " + reverse2 ( 1289 ) );
        reverseofnumber ( 589 );
        System.out.println ( "the  of 5 is " + reverseval );
        System.out.println ( "the  Number of zero  is " + countZeroes ( 5060008 ) );
        System.out.println ( "the  Number of steps  is " + countSteps ( 5060008 ) );
        System.out.println ( "the factorial of 5 is " + factorial ( n ) );

    }

    public static void nto1 ( int n ) {
        if ( n == 0 )
            return;
        System.out.print ( n + "," );
        nto1 ( n - 1 );
    }

    public static void oneton ( int n ) {
        if ( n == 0 )
            return;
        oneton ( n - 1 );
        System.out.print ( n + "," );
    }

    public static int sumTillN ( int n ) {
        if ( n == 0 )
            return 0;
        return n + sumTillN ( n - 1 );
    }

    public static int productTillN ( int n ) {
        if ( n == 1 )
            return 1;
        return n * productTillN ( n - 1 );
    }

    public static int sumofdigits ( int n ) {
        if ( n == 0 )
            return 0;
        return n % 10 + sumofdigits ( n / 10 );
    }

    public static int productofdigits ( int n ) {
        if ( n == 0 )
            return 1;
        return n % 10 * productofdigits ( n / 10 );
    }

    static int reverseval = 0;

    public static void reverseofnumber ( int n ) {
        if ( n == 0 )
            return;
        int digit = n % 10;
        reverseval = reverseval * 10 + digit;
        reverseofnumber ( n / 10 );
    }

    public static int reverse ( int num ) {
        // Handle negative numbers by converting to positive before reversing
        if ( num < 0 )
            return -reverseHelper ( -num, 0 );
        else {
            // Call the recursive method with reversedNum initialized to 0
            return reverseHelper ( num, 0 );
        }
    }

    private static int reverseHelper ( int num, int reversedNum ) {
        // Base case: num is 0, return the reversed number
        if ( num == 0 )
            return reversedNum;

        // Extract the last digit from num
        int lastDigit = num % 10;
        // Remove the last digit from num
        int remainingNumber = num / 10;
        // Update the reversed number
        reversedNum = ( reversedNum * 10 ) + lastDigit;

        // Recursive call with the updated remainingNumber and reversedNum
        return reverseHelper ( remainingNumber, reversedNum );
    }

    public static int reverse2 ( int num ) {
        int i = 0;
        while ( num > Math.pow ( 10, ++i ) );
        return reverseSide ( num, i );
    }

    private static int reverseSide ( int num, int index ) {
        if ( index == 0 )
            return num;
        return num % 10 * ( int ) Math.pow ( 10, index - 1 ) + reverseSide ( num / 10, index - 1 );
    }

    static boolean pallindrome ( int n ) {
        return reverse2 ( n ) == n;
    }

    static int countZeroes ( int num ) {
        return countZeroes ( num, 0 );
    }

    static int countZeroes ( int n, int zero ) {
        if ( n == 0 )
            return zero;
        if ( n % 10 == 0 )
            zero += 1;

        return countZeroes ( n / 10, zero );
    }

    static int countSteps ( int num ) {
        return countSteps ( num, 0 );
    }

    static int countSteps ( int num, int steps ) {
        if ( num == 0 )
            return steps;
        if (( num & 1) == 0 )
            num /= 2;
        else
            num--;
        steps++;
        return countSteps ( num, steps );


    }

    public static int factorial ( int n ) {
        if ( n == 0 )
            return 1;
        return n * factorial ( n - 1 );
    }
}
