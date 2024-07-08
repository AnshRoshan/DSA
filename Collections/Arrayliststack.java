import java.util.ArrayList;

/**
 * Arrayliststack
 * This class demonstrates stack operations using ArrayList such as pushing
 * elements,
 * popping elements, peeking the top element, checking if the stack is empty,
 * getting the size of the stack, clearing the stack, and printing the stack.
 */
public class Arrayliststack {

    static class Stack {
        ArrayList<Integer> list = new ArrayList<>();

        /**
         * Checks if the stack is empty.
         * 
         * @return true if the stack is empty, false otherwise.
         */
        boolean isEmpty() {
            return list.isEmpty();
        }

        /**
         * Pushes an element onto the stack.
         * 
         * @param data The element to be pushed onto the stack.
         */
        void push(int data) {
            list.add(data);
        }

        /**
         * Pops an element from the top of the stack.
         * 
         * @return The element popped from the top of the stack, or -1 if the stack is
         *         empty.
         */
        int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty, cannot pop.");
                return -1;
            }
            return list.remove(list.size() - 1);
        }

        /**
         * Peeks at the top element of the stack without removing it.
         * 
         * @return The top element of the stack, or -1 if the stack is empty.
         */
        int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty, cannot peek.");
                return -1;
            }
            return list.get(list.size() - 1);
        }

        /**
         * Gets the size of the stack.
         * 
         * @return The number of elements in the stack.
         */
        int size() {
            return list.size();
        }

        /**
         * Clears all elements from the stack.
         */
        void clear() {
            list.clear();
        }

        /**
         * Prints all the elements in the stack from top to bottom.
         */
        void printStack() {
            System.out.println("Stack elements (top to bottom): " + list);
        }
    }

    public static void main(String[] args) {
        Stack disk = new Stack();
        disk.push(20);
        disk.push(21);
        disk.push(22);
        disk.push(23);

        System.out.println("Original Stack:");
        disk.printStack();

        System.out.println("\nPop elements:");
        System.out.println("Popped element: " + disk.pop());
        System.out.println("Popped element: " + disk.pop());

        System.out.println("\nStack after popping:");
        disk.printStack();

        System.out.println("\nPeek at the top element:");
        System.out.println("Top element: " + disk.peek());

        System.out.println("\nSize of the stack:");
        System.out.println("Size: " + disk.size());

        System.out.println("\nClearing the stack.");
        disk.clear();

        System.out.println("\nStack after clearing:");
        disk.printStack();
    }
}
