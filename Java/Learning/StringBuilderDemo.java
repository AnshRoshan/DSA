
public class StringBuilderDemo {

    public static void main(String[] args) {
        // Creating a StringBuilder object
        StringBuilder stringBuilder = new StringBuilder("Hello");

        // 1. append(String str) - appends the specified string to the end
        stringBuilder.append(", World!");
        System.out.println("After appending: " + stringBuilder);

        // 2. insert(int offset, String str) - inserts the specified string at the
        // specified position
        stringBuilder.insert(6, "Beautiful ");
        System.out.println("After insertion: " + stringBuilder);

        // 3. delete(int start, int end) - deletes characters from a sequence of
        // characters
        stringBuilder.delete(6, 16);
        System.out.println("After deletion: " + stringBuilder);

        // 4. deleteCharAt(int index) - deletes a character at the specified index
        stringBuilder.deleteCharAt(5);
        System.out.println("After deletion at index 5: " + stringBuilder);

        // 5. reverse() - reverses the sequence of characters
        stringBuilder.reverse();
        System.out.println("After reversing: " + stringBuilder);

        // 6. replace(int start, int end, String str) - replaces the characters in a
        // substring with the specified string
        stringBuilder.replace(0, 6, "Hi");
        System.out.println("After replacement: " + stringBuilder);

        // 7. capacity() - returns the current capacity of the StringBuilder
        int capacity = stringBuilder.capacity();
        System.out.println("Current capacity: " + capacity);

        // 8. ensureCapacity(int minCapacity) - ensures that the capacity is at least
        // equal to the specified minimum capacity
        stringBuilder.ensureCapacity(30);
        System.out.println("Capacity after ensuring: " + stringBuilder.capacity());

        // 9. setLength(int newLength) - sets the length of the character sequence
        stringBuilder.setLength(3);
        System.out.println("After setting length to 3: " + stringBuilder);

        // 10. charAt(int index) - returns the character at the specified index
        char charAtIndex = stringBuilder.charAt(1);
        System.out.println("Character at index 1: " + charAtIndex);

        // 11. indexOf(String str) - returns the index of the first occurrence of the
        // specified substring
        int indexOfSubstring = stringBuilder.indexOf("o");
        System.out.println("Index of substring 'o': " + indexOfSubstring);

        // 12. indexOf(String str, int fromIndex) - returns the index of the first
        // occurrence of the specified substring, starting from the specified index
        int indexOfSubstringFromIndex = stringBuilder.indexOf("o", 3);
        System.out.println("Index of substring 'o' after index 3: " + indexOfSubstringFromIndex);

        // 13. lastIndexOf(String str) - returns the index of the last occurrence of the
        // specified substring
        int lastIndexOfSubstring = stringBuilder.lastIndexOf("o");
        System.out.println("Last index of substring 'o': " + lastIndexOfSubstring);

        // 14. substring(int start) - returns a new String that contains a subsequence
        // of characters
        String substring = stringBuilder.substring(1);
        System.out.println("Substring from index 1: " + substring);

        // 15. substring(int start, int end) - returns a new String that contains a
        // subsequence of characters within the specified range
        String substringInRange = stringBuilder.substring(1, 3);
        System.out.println("Substring within range [1, 3): " + substringInRange);

        // 16. toString() - converts StringBuilder to String
        String finalString = stringBuilder.toString();
        System.out.println("Final String: " + finalString);
    }
}
