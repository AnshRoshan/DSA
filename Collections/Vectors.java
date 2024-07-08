import java.util.Collections;
import java.util.Vector;

/**
 * Vectors
 * This class demonstrates various vector operations such as pushing elements,
 * reversing the vector, pushing elements at the bottom, checking if an element
 * exists,
 * printing the vector, and sorting the vector.
 */
public class Vectors {

    /**
     * Pushes an element at the bottom of the vector.
     * 
     * @param data The element to be pushed at the bottom.
     * @param vec  The vector where the element is to be pushed.
     */
    static void pushAtLast(int data, Vector<Integer> vec) {
        if (vec.isEmpty()) {
            vec.add(data);
            return;
        }
        int top = vec.remove(vec.size() - 1);
        pushAtLast(data, vec);
        vec.add(top);
    }

    /**
     * Reverses the elements in the vector.
     * 
     * @param vec The vector to be reversed.
     */
    static void reverse(Vector<Integer> vec) {
        if (vec.isEmpty()) {
            return; // Base case: Empty vector, nothing to reverse
        }
        int temp = vec.remove(vec.size() - 1); // Store the top element temporarily
        reverse(vec); // Recursively reverse the remaining elements
        pushAtLast(temp, vec); // Push the stored element onto the bottom of the reversed vector
    }

    /**
     * Prints all the elements in the vector from start to end.
     * 
     * @param vec The vector to be printed.
     */
    static void printVector(Vector<Integer> vec) {
        System.out.println("Vector elements (start to end): " + vec);
    }

    /**
     * Checks if an element exists in the vector.
     * 
     * @param element The element to check.
     * @param vec     The vector where the element is to be checked.
     * @return true if the element exists, false otherwise.
     */
    static boolean contains(int element, Vector<Integer> vec) {
        return vec.contains(element);
    }

    /**
     * Sorts the vector in ascending order.
     * 
     * @param vec The vector to be sorted.
     */
    static void sortVector(Vector<Integer> vec) {
        Collections.sort(vec);
    }

    public static void main(String[] args) {
        Vector<Integer> vec = new Vector<>();
        vec.add(23);
        vec.add(22);
        vec.add(21);
        vec.add(20);

        System.out.println("Original Vector:");
        printVector(vec);

        System.out.println("\nPush 24 at the bottom:");
        pushAtLast(24, vec);
        printVector(vec);

        System.out.println("\nReverse the Vector:");
        reverse(vec);
        printVector(vec);

        System.out.println("\nCheck if 22 exists in the vector:");
        System.out.println("Contains 22: " + contains(22, vec));

        System.out.println("\nSort the Vector:");
        sortVector(vec);
        printVector(vec);

        System.out.println("\nRemove all elements from the vector:");
        while (!vec.isEmpty()) {
            System.out.println("Removed element: " + vec.remove(vec.size() - 1));
        }
    }
}
