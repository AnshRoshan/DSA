package Java.OOPS.Genrics;

import java.util.Arrays;

public class CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    // Constructor
    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Method to add an element to the list
    public void add(E element) {
        if (size == elements.length) {
            // If the current capacity is not enough, resize the array
            resize();
        }
        elements[size++] = element;
    }

    // Method to resize the internal array
    private void resize() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    // Method to get an element from the list by index
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return (E) elements[index];
    }

    // Method to remove an element from the list by index
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        E removedElement = (E) elements[index];
        // Shift elements to the left to fill the gap
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // Set the last element to null and decrement size
        return removedElement;
    }

    // Method to get the size of the list
    public int size() {
        return size;
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to clear the list
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY]; // Reinitialize the array
        size = 0;
    }

    // Method to print the elements of the list
    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.print(); // Output: [1, 2, 3, 4]
        System.out.println("Size: " + list.size()); // Output: Size: 4
        System.out.println("Element at index 2: " + list.get(2)); // Output: Element at index 2: 3
        list.remove(1);
        list.print(); // Output: [1, 3, 4]
        list.clear();
        System.out.println("Size after clearing: " + list.size()); // Output: Size after clearing: 0
    }
}
