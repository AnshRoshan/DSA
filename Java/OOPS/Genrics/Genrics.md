# GENRICS 

Generics in Java provide a way to create classes, interfaces, and methods that operate on objects of specified types. They enable you to write reusable code that can work with different types while maintaining type safety. Let's explore the use of generics with an example:

Suppose we want to create a generic class `Box` that can hold objects of any type. We'll define methods to set and get the value of the box.

```java
// Generic class Box
class Box<T> {
    private T value; // Generic type T

    // Constructor
    public Box(T value) {
        this.value = value;
    }

    // Method to set the value
    public void setValue(T value) {
        this.value = value;
    }

    // Method to get the value
    public T getValue() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a Box for Integer
        Box<Integer> intBox = new Box<>(10);
        System.out.println("Integer value: " + intBox.getValue()); // Output: Integer value: 10

        // Creating a Box for String
        Box<String> strBox = new Box<>("Hello");
        System.out.println("String value: " + strBox.getValue()); // Output: String value: Hello

        // Setting a new value for the String Box
        strBox.setValue("World");
        System.out.println("New String value: " + strBox.getValue()); // Output: New String value: World
    }
}
```

In this example:

- `Box<T>` is a generic class with a type parameter `T`. It can hold objects of any type specified during its instantiation.
- The `setValue()` method sets the value of the box to the specified type.
- The `getValue()` method retrieves the value stored in the box, returning it as the specified type.
- In the `Main` class, we create two instances of `Box`: one for `Integer` and one for `String`. We set and retrieve values of different types using these instances.

Generics provide type safety by allowing the compiler to detect and report errors at compile time if you try to use the wrong type. They also promote code reusability by enabling you to write generic algorithms and data structures that can work with any type. Overall, generics are a powerful feature in Java for creating flexible and reusable code.

# Creating A Custom ArrayList

Sure, let's create a custom ArrayList implementation using generics in Java. We'll call it `CustomArrayList`. It will provide essential features such as adding elements, removing elements, accessing elements by index, getting the size of the list, and resizing the internal array dynamically. Here's the implementation along with detailed explanations:

```java
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
```

### Explanation:

- The `CustomArrayList` class is a generic class that can hold elements of any type specified during its instantiation.
- It maintains an internal array of type `Object[]` to store elements and a `size` variable to keep track of the number of elements in the list.
- The default capacity of the internal array is set to `10`, and it is resized dynamically when the number of elements exceeds the current capacity.
- The `add(E element)` method adds an element to the end of the list. If the internal array is full, it calls the `resize()` method to increase its capacity.
- The `resize()` method doubles the capacity of the internal array when called.
- The `get(int index)` method retrieves the element at the specified index from the list.
- The `remove(int index)` method removes the element at the specified index from the list and shifts subsequent elements to the left to fill the gap.
- The `size()` method returns the number of elements in the list.
- The `isEmpty()` method checks if the list is empty.
- The `clear()` method clears the list by reinitializing the internal array and setting the size to `0`.
- The `print()` method prints the elements of the list for demonstration purposes.
- In the `main()` method, we demonstrate the usage of the `CustomArrayList` class by adding elements, getting their size, accessing elements by index, removing elements, and clearing the list.

This custom ArrayList implementation demonstrates the core features of an ArrayList, including adding, removing, accessing elements, resizing the internal array dynamically, and providing methods to get the size, check if the list is empty, and clear the list.