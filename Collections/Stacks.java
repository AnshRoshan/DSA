import java.util.Stack;

/**
 * Stacks
 * This class demonstrates various stack operations such as pushing elements,
 * reversing the stack,
 * pushing elements at the bottom, checking if an element exists, printing the
 * stack, and sorting the stack.
 */
public class Stacks {

    /**
     * Pushes an element at the bottom of the stack.
     *
     * @param data The element to be pushed at the bottom.
     * @param st   The stack where the element is to be pushed.
     */
    static void pushAtLast(int data, Stack<Integer> st) {
        if (st.isEmpty()) {
            st.push(data);
            return;
        }
        int top = st.pop();
        pushAtLast(data, st);
        st.push(top);
    }

    /**
     * Reverses the elements in the stack.
     *
     * @param st The stack to be reversed.
     */
    static void reverse(Stack<Integer> st) {
        if (st.isEmpty()) {
            return; // Base case: Empty stack, nothing to reverse
        }
        int temp = st.pop(); // Store the top element temporarily
        reverse(st); // Recursively reverse the remaining elements
        pushAtLast(temp, st); // Push the stored element onto the bottom of the reversed stack
    }

    /**
     * Prints all the elements in the stack from top to bottom.
     *
     * @param st The stack to be printed.
     */
    static void printStack(Stack<Integer> st) {
        System.out.println("Stack elements (top to bottom): " + st);
    }

    /**
     * Checks if an element exists in the stack.
     *
     * @param element The element to check.
     * @param st      The stack where the element is to be checked.
     * @return true if the element exists, false otherwise.
     */
    static boolean contains(int element, Stack<Integer> st) {
        return st.contains(element);
    }

    /**
     * Sorts the stack in ascending order.
     *
     * @param st The stack to be sorted.
     */
    static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }
        int temp = st.pop();
        sortStack(st);
        sortedInsert(st, temp);
    }

    /**
     * Helper method to insert an element into a sorted stack.
     *
     * @param st      The sorted stack.
     * @param element The element to be inserted.
     */
    private static void sortedInsert(Stack<Integer> st, int element) {
        if (st.isEmpty() || st.peek() <= element) {
            st.push(element);
            return;
        }
        int temp = st.pop();
        sortedInsert(st, element);
        st.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> disk = new Stack<>();
        disk.push(23);
        disk.push(22);
        disk.push(21);
        disk.push(20);

        System.out.println("Original Stack:");
        printStack(disk);

        System.out.println("\nPush 24 at the bottom:");
        pushAtLast(24, disk);
        printStack(disk);

        System.out.println("\nReverse the Stack:");
        reverse(disk);
        printStack(disk);

        System.out.println("\nCheck if 22 exists in the stack:");
        System.out.println("Contains 22: " + contains(22, disk));

        System.out.println("\nSort the Stack:");
        sortStack(disk);
        printStack(disk);

        System.out.println("\nPop all elements from the stack:");
        while (!disk.isEmpty()) {
            System.out.println("Popped element: " + disk.pop());
        }

    }
}
