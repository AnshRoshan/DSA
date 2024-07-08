import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.util.LinkedList;

/**
 * ListInterfaceDemo
 * This class demonstrates various operations using the List interface in Java.
 */
public class ListInterface {

    public static void main(String[] args) {
        // Using ArrayList
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(2);
        System.out.println("ArrayList: " + arrayList);

        // Using LinkedList
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(5);
        System.out.println("LinkedList: " + linkedList);

        // Using Vector
        List<Integer> vector = new Vector<>();
        vector.add(7);
        vector.add(8);
        vector.add(9);
        vector.add(8);
        System.out.println("Vector: " + vector);

        // Using Stack
        List<Integer> stack = new Stack<>();
        stack.add(10);
        stack.add(11);
        stack.add(12);
        stack.add(11);
        System.out.println("Stack: " + stack);

        // Common List operations
        System.out.println("\nCommon List operations:");

        // Accessing elements
        System.out.println("Element at index 2 in ArrayList: " + arrayList.get(2));

        // Modifying elements
        arrayList.set(2, 99);
        System.out.println("ArrayList after modification: " + arrayList);

        // Removing elements
        linkedList.remove(Integer.valueOf(5)); // removes the first occurrence of 5
        System.out.println("LinkedList after removing 5: " + linkedList);

        // Iterating through a list
        System.out.println("Iterating through Vector:");
        for (Integer num : vector) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Sorting a list
        Collections.sort(arrayList);
        System.out.println("Sorted ArrayList: " + arrayList);

        // Checking for an element
        System.out.println("Does ArrayList contain 2? " + arrayList.contains(2));

        // Size of the list
        System.out.println("Size of ArrayList: " + arrayList.size());

        // Clearing the list
        stack.clear();
        System.out.println("Stack after clearing: " + stack);

        // Sublist example
        List<Integer> subList = arrayList.subList(1, 3);
        System.out.println("Sublist of ArrayList (from index 1 to 3): " + subList);
    }
}
