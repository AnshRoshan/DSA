
public class IntegerMethods {
    public static void main(String[] args) {
        String binaryStr = "1010";
        String hexStr = "1A";
        String octalStr = "12";

        // Parsing strings as integers
        int decimalInt = Integer.parseInt(binaryStr, 2);
        int hexInt = Integer.parseInt(hexStr, 16);
        int octalInt = Integer.parseInt(octalStr, 8);

        System.out.println("Parsed binary string: " + decimalInt);
        System.out.println("Parsed hexadecimal string: " + hexInt);
        System.out.println("Parsed octal string: " + octalInt);

        // Creating Integer instances
        Integer intValue = Integer.valueOf(10);
        System.out.println("Integer value: " + intValue);

        // Converting integers to strings in different radix
        String binaryString = Integer.toBinaryString(10);
        String hexString = Integer.toHexString(10);
        String octalString = Integer.toOctalString(10);

        System.out.println("Binary string: " + binaryString);
        System.out.println("Hexadecimal string: " + hexString);
        System.out.println("Octal string: " + octalString);

        // Comparing integers
        Integer num1 = 10;
        Integer num2 = 20;
        int comparisonResult = num1.compareTo(num2);
        System.out.println("Comparison result: " + comparisonResult);

        // Checking equality
        boolean isEqual = num1.equals(num2);
        System.out.println("Are num1 and num2 equal? " + isEqual);

        // Hash code
        int hashCode = num1.hashCode();
        System.out.println("Hash code of num1: " + hashCode);

        // Getting primitive values
        int intValuePrimitive = num1.intValue();
        System.out.println("Primitive value of num1: " + intValuePrimitive);

        long longValue = num1.longValue();
        System.out.println("Long value of num1: " + longValue);

        float floatValue = num1.floatValue();
        System.out.println("Float value of num1: " + floatValue);

        double doubleValue = num1.doubleValue();
        System.out.println("Double value of num1: " + doubleValue);

        byte byteValue = num1.byteValue();
        System.out.println("Byte value of num1: " + byteValue);

        short shortValue = num1.shortValue();
        System.out.println("Short value of num1: " + shortValue);

        // Bit manipulation methods
        int num = 23;
        int leadingZeros = Integer.numberOfLeadingZeros(num);
        System.out.println("Number of leading zeros in " + num + ": " + leadingZeros);

        int trailingZeros = Integer.numberOfTrailingZeros(num);
        System.out.println("Number of trailing zeros in " + num + ": " + trailingZeros);

        int bitCount = Integer.bitCount(num);
        System.out.println("Number of set bits in " + num + ": " + bitCount);

        int rotatedLeft = Integer.rotateLeft(num, 2);
        System.out.println("Number " + num + " rotated left by 2: " + rotatedLeft);

        int rotatedRight = Integer.rotateRight(num, 2);
        System.out.println("Number " + num + " rotated right by 2: " + rotatedRight);

        int reversed = Integer.reverse(num);
        System.out.println("Reverse of " + num + ": " + reversed);

        int reversedBytes = Integer.reverseBytes(num);
        System.out.println("Reverse bytes of " + num + ": " + reversedBytes);
    }
}
