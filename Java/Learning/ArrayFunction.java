package Java.Learning;

import java.util.Arrays;

public class ArrayFunction {
    public static void main(String[] args) {
        // Example array
        int[] array = { 5, 2, 7, 1, 9, 3 };

        // 1. toString(int[] array) - returns a string representation of the contents of
        // the specified array
        System.out.println("Array as string: " + Arrays.toString(array));

        // 2. sort(int[] array) - sorts the specified array into ascending numerical
        // order
        Arrays.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));

        // 3. binarySearch(int[] array, int key) - searches the specified array for the
        // specified value using the binary search algorithm
        int key = 7;
        int index = Arrays.binarySearch(array, key);
        System.out.println("Index of " + key + " after sorting: " + index);

        // 4. binarySearch(int[] array, int fromIndex, int toIndex, int key) - searches
        // a range of the specified array for the specified value using the binary
        // search algorithm
        int fromIndex = 2;
        int toIndex = 5;
        int indexInRange = Arrays.binarySearch(array, fromIndex, toIndex, key);
        System.out.println("Index of " + key + " in range [" + fromIndex + ", " + toIndex + "): " + indexInRange);

        // 5. equals(int[] array1, int[] array2) - returns true if the two specified
        // arrays of integers are equal to one another
        int[] array2 = { 1, 2, 3, 5, 7, 9 };
        boolean isEqual = Arrays.equals(array, array2);
        System.out.println("Are arrays equal? " + isEqual);

        // 6. fill(int[] array, int value) - assigns the specified int value to each
        // element of the specified array of ints
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 10);
        System.out.println("Filled array: " + Arrays.toString(filledArray));

        // 7. copyOf(int[] original, int newLength) - copies the specified array,
        // truncating or padding with zeros (if necessary) so the copy has the specified
        // length
        int[] copiedArray = Arrays.copyOf(array, 8);
        System.out.println("Copied array: " + Arrays.toString(copiedArray));

        // 8. copyOfRange(int[] original, int from, int to) - copies the specified range
        // of the specified array into a new array
        int[] copiedRange = Arrays.copyOfRange(array, 2, 5);
        System.out.println("Copied range: " + Arrays.toString(copiedRange));

        // 9. hashCode(int[] array) - returns a hash code based on the contents of the
        // specified array
        int hashCode = Arrays.hashCode(array);
        System.out.println("Hash code of array: " + hashCode);

        // 10. asList(T... a) - returns a fixed-size list backed by the specified array
        Integer[] integerArray = { 1, 2, 3, 4, 5 };
        System.out.println("Array as list: " + Arrays.asList(integerArray));
    }
}
