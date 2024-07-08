public class MemoryDemo {

    // This method demonstrates stack usage with local variables
    public static int sum(int a, int b) {
        int result = a + b; // 'result' is a local variable stored on the stack
        return result;
    }

    // This method demonstrates heap usage with object creation
    public static void heapUsage() {
        Person person1 = new Person("Alice", 30); // 'person1' reference is on the stack, but the 'Person' object is on the heap
        Person person2 = new Person("Bob", 25); // 'person2' reference is on the stack, but the 'Person' object is on the heap

        System.out.println(person1);
        System.out.println(person2);
    }

    public static void main(String[] args) {
        int a = 5; // 'a' is a local variable stored on the stack
        int b = 10; // 'b' is a local variable stored on the stack

        // Demonstrate stack usage
        int result = sum(a, b);
        System.out.println("Sum: " + result);

        // Demonstrate heap usage
        heapUsage();
    }
}

// Class to demonstrate heap allocation
class Person {
    String name; // 'name' is a reference stored in the heap, pointing to a String object also in the heap
    int age; // 'age' is a primitive stored directly in the heap as part of the 'Person' object

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}
