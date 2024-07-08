import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * MapInterfaceDemo
 * This class demonstrates various operations using the Map interface in Java.
 */
public class MapsInterface {

    public static void main(String[] args) {
        // Using HashMap
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Apple");
        hashMap.put(2, "Banana");
        hashMap.put(3, "Cherry");
        hashMap.put(1, "Apricot"); // Overwrites the value for key 1
        System.out.println("HashMap: " + hashMap);

        // Using LinkedHashMap
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "Dog");
        linkedHashMap.put(2, "Elephant");
        linkedHashMap.put(3, "Fox");
        linkedHashMap.put(1, "Dolphin"); // Overwrites the value for key 1
        System.out.println("LinkedHashMap: " + linkedHashMap);

        // Using TreeMap
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Grape");
        treeMap.put(2, "Honeydew");
        treeMap.put(1, "Kiwi");
        treeMap.put(3, "Guava"); // Overwrites the value for key 3
        System.out.println("TreeMap: " + treeMap);

        // Common Map operations
        System.out.println("\nCommon Map operations:");

        // Get - Retrieves the value associated with a specific key
        System.out.println("Value for key 2 in HashMap: " + hashMap.get(2));

        // ContainsKey - Checks if the map contains a specific key
        System.out.println("Does LinkedHashMap contain key 3? " + linkedHashMap.containsKey(3));

        // ContainsValue - Checks if the map contains a specific value
        System.out.println("Does TreeMap contain value 'Kiwi'? " + treeMap.containsValue("Kiwi"));

        // Remove - Removes the entry for a specific key
        linkedHashMap.remove(2);
        System.out.println("LinkedHashMap after removing key 2: " + linkedHashMap);

        // Size - Get the number of key-value pairs in the map
        System.out.println("Size of TreeMap: " + treeMap.size());

        // Iterating over keys
        System.out.print("Keys in HashMap: ");
        for (Integer key : hashMap.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();

        // Iterating over values
        System.out.print("Values in LinkedHashMap: ");
        for (String value : linkedHashMap.values()) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Iterating over key-value pairs
        System.out.println("Entries in TreeMap:");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // Clear - Remove all entries from the map
        treeMap.clear();
        System.out.println("TreeMap after clearing: " + treeMap);
    }
}
