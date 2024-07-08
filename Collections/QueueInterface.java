import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * QueueInterfaceDemo
 * This class demonstrates various operations using the Queue and Deque
 * interfaces in Java.
 */
public class QueueInterface {

    public static void main(String[] args) {
        // Using LinkedList as a Queue
        Queue<Integer> linkedListQueue = new LinkedList<>();
        linkedListQueue.offer(1);
        linkedListQueue.offer(2);
        linkedListQueue.offer(3);
        System.out.println("LinkedList Queue: " + linkedListQueue);

        // Using PriorityQueue -minheap deafult
        // Queue<Integer> priorityQueue = new PriorityQueue<>();
        // Using PriorityQueue - Max heap deafult
        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        // Queue<Integer> priorityQueue = new
        // PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.offer(5);
        priorityQueue.offer(1);

        priorityQueue.offer(3);
        System.out.println("PriorityQueue (Min-Heap): " + priorityQueue);

        // Using ArrayDeque as a Queue
        Queue<Integer> arrayDequeQueue = new ArrayDeque<>();
        arrayDequeQueue.offer(10);
        arrayDequeQueue.offer(20);
        arrayDequeQueue.offer(30);
        arrayDequeQueue.offer(30 + 90);
        System.out.println("ArrayDeque Queue: " + arrayDequeQueue);

        // Using ArrayDeque as a Deque
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.offerFirst(40);
        arrayDeque.offerLast(50);
        arrayDeque.offerFirst(30);
        arrayDeque.offerLast(60);
        System.out.println("ArrayDeque as Deque: " + arrayDeque);

        // Common Queue operations
        System.out.println("\nCommon Queue operations:");

        // Peek - Retrieves, but does not remove, the head of the queue, or returns null
        // if the queue is empty
        System.out.println("Peek LinkedListQueue: " + linkedListQueue.peek());

        // Poll - Retrieves and removes the head of the queue, or returns null if the
        // queue is empty
        System.out.println("Poll LinkedListQueue: " + linkedListQueue.poll());
        System.out.println("LinkedListQueue after poll: " + linkedListQueue);

        // Offer - Inserts the specified element into this queue
        linkedListQueue.offer(4);
        System.out.println("LinkedListQueue after offer: " + linkedListQueue);

        // Remove - Retrieves and removes the head of the queue
        System.out.println("Remove LinkedListQueue: " + linkedListQueue.remove());
        System.out.println("LinkedListQueue after remove: " + linkedListQueue);

        // Size of the queue
        System.out.println("Size of LinkedListQueue: " + linkedListQueue.size());

        // Clear the queue
        linkedListQueue.clear();
        System.out.println("LinkedListQueue after clearing: " + linkedListQueue);

        // Polling in the PriorityQueue
        System.out.println("Poll PriorityQueue: " + priorityQueue.poll());
        System.out.println("PriorityQueue after poll: " + priorityQueue);

        // Peeking in the ArrayDequeQueue
        System.out.println("Peek ArrayDequeQueue: " + arrayDequeQueue.peek());
        System.out.println("ArrayDequeQueue after peek: " + arrayDequeQueue);

        // Deque specific operations
        System.out.println("\nDeque specific operations:");

        // OfferFirst - Inserts the specified element at the front of this deque
        arrayDeque.offerFirst(20);
        System.out.println("ArrayDeque after offerFirst: " + arrayDeque);

        // OfferLast - Inserts the specified element at the end of this deque
        arrayDeque.offerLast(70);
        System.out.println("ArrayDeque after offerLast: " + arrayDeque);

        // PollFirst - Retrieves and removes the first element of this deque, or returns
        // null if this deque is empty
        System.out.println("PollFirst ArrayDeque: " + arrayDeque.pollFirst());
        System.out.println("ArrayDeque after pollFirst: " + arrayDeque);

        // PollLast - Retrieves and removes the last element of this deque, or returns
        // null if this deque is empty
        System.out.println("PollLast ArrayDeque: " + arrayDeque.pollLast());
        System.out.println("ArrayDeque after pollLast: " + arrayDeque);

        // PeekFirst - Retrieves, but does not remove, the first element of this deque,
        // or returns null if this deque is empty
        System.out.println("PeekFirst ArrayDeque: " + arrayDeque.peekFirst());
        System.out.println("ArrayDeque after peekFirst: " + arrayDeque);

        // PeekLast - Retrieves, but does not remove, the last element of this deque, or
        // returns null if this deque is empty
        System.out.println("PeekLast ArrayDeque: " + arrayDeque.peekLast());
        System.out.println("ArrayDeque after peekLast: " + arrayDeque);

        // Size of the deque
        System.out.println("Size of ArrayDeque: " + arrayDeque.size());

        // Clear the deque
        arrayDeque.clear();
        System.out.println("ArrayDeque after clearing: " + arrayDeque);
    }
}
