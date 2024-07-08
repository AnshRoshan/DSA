import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * DequeInterfaceDemo
 * This class demonstrates various operations using the Deque interface in Java.
 */
public class DequeInterface {

    public static void main(String[] args) {
        // Using ArrayDeque
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.offerFirst(1); // Add to the front
        arrayDeque.offerLast(2); // Add to the rear
        arrayDeque.offerFirst(0); // Add to the front
        arrayDeque.offerLast(3); // Add to the rear
        System.out.println("ArrayDeque: " + arrayDeque);

        // Using LinkedList as a Deque
        Deque<Integer> linkedListDeque = new LinkedList<>();
        linkedListDeque.offerFirst(10); // Add to the front
        linkedListDeque.offerLast(20); // Add to the rear
        linkedListDeque.offerFirst(5); // Add to the front
        linkedListDeque.offerLast(25); // Add to the rear
        System.out.println("LinkedList as Deque: " + linkedListDeque);

        // Common Deque operations
        System.out.println("\nCommon Deque operations:");

        // Peek operations
        System.out.println("Peek First in ArrayDeque: " + arrayDeque.peekFirst());
        System.out.println("Peek Last in ArrayDeque: " + arrayDeque.peekLast());

        // Poll operations
        System.out.println("Poll First in ArrayDeque: " + arrayDeque.pollFirst());
        System.out.println("Poll Last in ArrayDeque: " + arrayDeque.pollLast());
        System.out.println("ArrayDeque after polls: " + arrayDeque);

        // Add and Remove operations
        linkedListDeque.addFirst(15);
        linkedListDeque.addLast(30);
        System.out.println("LinkedListDeque after additions: " + linkedListDeque);

        linkedListDeque.removeFirst();
        linkedListDeque.removeLast();
        System.out.println("LinkedListDeque after removals: " + linkedListDeque);

        // Iterating through a Deque
        System.out.println("Iterating through ArrayDeque:");
        for (Integer num : arrayDeque) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Size of the deque
        System.out.println("Size of ArrayDeque: " + arrayDeque.size());

        // Clearing the deque
        arrayDeque.clear();
        System.out.println("ArrayDeque after clearing: " + arrayDeque);
    }
}
