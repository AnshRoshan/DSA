import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

/**
 * LinkedListDemo
 * This class demonstrates various operations using the LinkedList class in
 * Java.
 */
public class LinkedLists {

    public static void main(String[] args) {
        // Using LinkedList as a List
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("LinkedList as List: " + list);

        // Basic List operations
        System.out.println("Element at index 2: " + list.get(2));
        list.set(2, 10);
        System.out.println("LinkedList after setting index 2 to 10: " + list);
        list.remove(2);
        System.out.println("LinkedList after removing element at index 2: " + list);
        System.out.println("Size of LinkedList: " + list.size());

        // Iterating through the LinkedList
        System.out.println("Iterating through the LinkedList:");
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Using LinkedList as a Deque
        Deque<String> deque = new LinkedList<>();
        deque.offerFirst("A");
        deque.offerLast("B");
        deque.offerFirst("C");
        deque.offerLast("D");
        System.out.println("LinkedList as Deque: " + deque);

        // Basic Deque operations
        System.out.println("First element: " + deque.peekFirst());
        System.out.println("Last element: " + deque.peekLast());
        System.out.println("Removed first element: " + deque.pollFirst());
        System.out.println("Removed last element: " + deque.pollLast());
        System.out.println("LinkedList as Deque after removals: " + deque);

        // Adding and removing elements at both ends
        deque.addFirst("X");
        deque.addLast("Y");
        System.out.println("LinkedList as Deque after additions: " + deque);
        deque.removeFirst();
        deque.removeLast();
        System.out.println("LinkedList as Deque after removals: " + deque);

        // Iterating through the deque
        System.out.println("Iterating through the deque:");
        for (String str : deque) {
            System.out.print(str + " ");
        }
        System.out.println();

        // Clearing the LinkedList
        list.clear();
        System.out.println("LinkedList after clearing: " + list);
    }
}
