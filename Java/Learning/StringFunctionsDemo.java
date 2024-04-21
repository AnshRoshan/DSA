package Java.Learning;

public class StringFunctionsDemo {

    public static void main(String[] args) {
        // Example string
        String str = "Hello, World!";

        // 1. length() - returns the length of the string
        int length = str.length();
        System.out.println("Length of the string: " + length);

        // 2. charAt(int index) - returns the character at the specified index
        char charAtIndex = str.charAt(7);
        System.out.println("Character at index 7: " + charAtIndex);

        // 3. substring(int beginIndex) - returns a substring starting from the
        // specified index
        String subStringFromIndex = str.substring(7);
        System.out.println("Substring from index 7: " + subStringFromIndex);

        // 4. substring(int beginIndex, int endIndex) - returns a substring within the
        // specified range
        String subStringWithinRange = str.substring(7, 12);
        System.out.println("Substring within range [7, 12): " + subStringWithinRange);

        // 5. indexOf(String str) - returns the index of the first occurrence of the
        // specified substring
        int indexOfSubstring = str.indexOf("World");
        System.out.println("Index of substring 'World': " + indexOfSubstring);

        // 6. indexOf(String str, int fromIndex) - returns the index of the first
        // occurrence of the specified substring, starting from the specified index
        int indexOfSubstringFromIndex = str.indexOf("o", 5);
        System.out.println("Index of character 'o' after index 5: " + indexOfSubstringFromIndex);

        // 7. lastIndexOf(String str) - returns the index of the last occurrence of the
        // specified substring
        int lastIndexOfSubstring = str.lastIndexOf("o");
        System.out.println("Last index of character 'o': " + lastIndexOfSubstring);

        // 8. startsWith(String prefix) - checks if the string starts with the specified
        // prefix
        boolean startsWithPrefix = str.startsWith("Hello");
        System.out.println("Starts with prefix 'Hello': " + startsWithPrefix);

        // 9. endsWith(String suffix) - checks if the string ends with the specified
        // suffix
        boolean endsWithSuffix = str.endsWith("World!");
        System.out.println("Ends with suffix 'World!': " + endsWithSuffix);

        // 10. contains(CharSequence s) - checks if the string contains the specified
        // character sequence
        boolean containsSequence = str.contains("lo");
        System.out.println("Contains character sequence 'lo': " + containsSequence);

        // 11. replace(char oldChar, char newChar) - replaces all occurrences of a
        // specified character with another character
        String replacedString = str.replace('l', 'z');
        System.out.println("String after replacing 'l' with 'z': " + replacedString);

        // 12. toLowerCase() - converts all characters in the string to lowercase
        String lowerCaseString = str.toLowerCase();
        System.out.println("String in lowercase: " + lowerCaseString);

        // 13. toUpperCase() - converts all characters in the string to uppercase
        String upperCaseString = str.toUpperCase();
        System.out.println("String in uppercase: " + upperCaseString);

        // 14. trim() - removes leading and trailing whitespaces from the string
        String stringWithWhitespace = "   Hello, World!   ";
        String trimmedString = stringWithWhitespace.trim();
        System.out.println("Trimmed string: '" + trimmedString + "'");

        // 15. split(String regex) - splits the string into an array of substrings based
        // on the specified regular expression
        String[] splittedStrings = str.split(",");
        System.out.println("Splitted strings:");
        for (String s : splittedStrings) {
            System.out.println(s.trim()); // trim() used to remove leading and trailing whitespaces
        }

        // 16. concat(String str) - concatenates the specified string to the end of this
        // string
        String concatenatedString = str.concat(" How are you?");
        System.out.println("Concatenated string: " + concatenatedString);

        // 17. isEmpty() - checks if the string is empty
        boolean isEmptyString = str.isEmpty();
        System.out.println("Is the string empty? " + isEmptyString);

        // 18. valueOf() - returns the string representation of the specified value
        int intValue = 123;
        String stringValue = String.valueOf(intValue);
        System.out.println("String representation of integer value: " + stringValue);
    }
}
