import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

/**
 * SetInterfaceDemo
 * This class demonstrates various operations using the Set interface in Java.
 */
public class SetInterface {

    // Set is internally implemented using HashMap, LinkedHashMap, or TreeMap.
    // Set is internally keySet of a Map
    public static void main(String[] args) {
        // HashSet : No specific ordering of elements
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Apple"); // Duplicate, will be ignored
        System.out.println("HashSet: " + hashSet);

        // LinkedHashSet: Maintains the order of insertion
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Dog");
        linkedHashSet.add("Elephant");
        linkedHashSet.add("Fox");
        linkedHashSet.add("Dog"); // Duplicate, will be ignored
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // TreeSet - Maintains the natural sorted order of elements
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Grape");
        treeSet.add("Honeydew");
        treeSet.add("Kiwi");
        treeSet.add("Grape"); // Duplicate, will be ignored
        System.out.println("TreeSet: " + treeSet);

        // Common Set operations
        System.out.println("\nCommon Set operations:");

        // Contains - Check if a set contains a specific element
        System.out.println("Does HashSet contain 'Apple'? " + hashSet.contains("Apple"));

        // Remove - Remove a specific element from a set
        linkedHashSet.remove("Elephant");
        System.out.println("LinkedHashSet after removing 'Elephant': " + linkedHashSet);

        // Size - Get the number of elements in a set
        System.out.println("Size of TreeSet: " + treeSet.size());

        // Iterating over a set
        System.out.print("Iterating over HashSet: ");
        for (String element : hashSet) {
            System.out.print(element + " ");
        }
        System.out.println();

        // Using an iterator
        Iterator<String> iterator = treeSet.iterator();
        System.out.print("Iterating over TreeSet: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        // Clear - Remove all elements from a set
        treeSet.clear();
        System.out.println("TreeSet after clearing: " + treeSet);
    }
}
